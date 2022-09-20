/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2022 Evan Debenham
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>
 */

package com.touhoupixel.touhoupixeldungeonreloaded.actors.mobs;

import com.touhoupixel.touhoupixeldungeonreloaded.Dungeon;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.Actor;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.Char;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.AllyBuff;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeonreloaded.effects.Pushing;
import com.touhoupixel.touhoupixeldungeonreloaded.items.itemstats.SpellcardFragement;
import com.touhoupixel.touhoupixeldungeonreloaded.levels.features.Chasm;
import com.touhoupixel.touhoupixeldungeonreloaded.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeonreloaded.sprites.AunnSprite;
import com.watabou.utils.Bundle;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Random;

import java.util.ArrayList;

public class Aunn extends Mob {

    {
        spriteClass = AunnSprite.class;

        HP = HT = 9;
        defenseSkill = 2;
        EXP = 1;
        maxLvl = 10;

        SLEEPING = new Sleeping();
        WANDERING = new Wandering();
        state = SLEEPING;

        loot = SpellcardFragement.class;
        lootChance = 0.1f;
    }

    @Override
    public int damageRoll() {
        return Random.NormalIntRange( 1, 3 );
    }

    @Override
    public int attackSkill( Char target ) {
        return 7;
    }

    @Override
    public int drRoll() {
        return Random.NormalIntRange(0, 2);
    }

    @Override
    public float spawningWeight() {
        return 0.5f;
    }

    private int timesDowned = 0;
    protected int partnerID = -1;

    private static final String PARTNER_ID = "partner_id";
    private static final String TIMES_DOWNED = "times_downed";

    @Override
    public void storeInBundle( Bundle bundle ) {
        super.storeInBundle( bundle );
        bundle.put( PARTNER_ID, partnerID );
        bundle.put( TIMES_DOWNED, timesDowned );
    }

    @Override
    public void restoreFromBundle( Bundle bundle ) {
        super.restoreFromBundle( bundle );
        partnerID = bundle.getInt( PARTNER_ID );
        timesDowned = bundle.getInt( TIMES_DOWNED );
    }

    @Override
    protected boolean act() {
        //create a child
        if (partnerID == -1){

            ArrayList<Integer> candidates = new ArrayList<>();

            int[] neighbours = {pos + 1, pos - 1, pos + Dungeon.level.width(), pos - Dungeon.level.width()};
            for (int n : neighbours) {
                if (Dungeon.level.passable[n]
                        && Actor.findChar( n ) == null
                        && (!Char.hasProp(this, Property.ELIXIR) || Dungeon.level.openSpace[n])) {
                    candidates.add( n );
                }
            }

            if (!candidates.isEmpty()){
                Aunn child = new Aunn();
                child.partnerID = this.id();
                this.partnerID = child.id();
                if (state != SLEEPING) {
                    child.state = child.WANDERING;
                }

                child.pos = Random.element( candidates );

                GameScene.add( child );
                Dungeon.level.occupyCell(child);

                if (sprite.visible) {
                    Actor.addDelayed( new Pushing( child, pos, child.pos ), -1 );
                }
            }

        }
        return super.act();
    }

    private boolean beingLifeLinked = false;

    @Override
    public void die(Object cause) {
        if (cause != Chasm.class && cause != GhoulLifeLink.class && !Dungeon.level.pit[pos]){
            Aunn nearby = GhoulLifeLink.searchForHost(this);
            if (nearby != null){
                beingLifeLinked = true;
                Actor.remove(this);
                Dungeon.level.mobs.remove( this );
                timesDowned++;
                Buff.append(nearby, GhoulLifeLink.class).set(timesDowned*5, this);
                ((AunnSprite)sprite).crumple();
                beingLifeLinked = false;
                return;
            }
        }

        super.die(cause);
    }

    private class Sleeping extends Mob.Sleeping {
        @Override
        public boolean act( boolean enemyInFOV, boolean justAlerted ) {
            Aunn partner = (Aunn) Actor.findById( partnerID );
            if (partner != null && partner.state != partner.SLEEPING){
                state = WANDERING;
                target = partner.pos;
                return true;
            } else {
                return super.act( enemyInFOV, justAlerted );
            }
        }
    }

    private class Wandering extends Mob.Wandering {

        @Override
        protected boolean continueWandering() {
            enemySeen = false;

            Aunn partner = (Aunn) Actor.findById( partnerID );
            if (partner != null && (partner.state != partner.WANDERING || Dungeon.level.distance( pos,  partner.target) > 1)){
                target = partner.pos;
                int oldPos = pos;
                if (getCloser( target )){
                    spend( 1 / speed() );
                    return moveSprite( oldPos, pos );
                } else {
                    spend( TICK );
                    return true;
                }
            } else {
                return super.continueWandering();
            }
        }
    }

    public static class GhoulLifeLink extends Buff{

        private Aunn ghoul;
        private int turnsToRevive;

        @Override
        public boolean act() {
            ghoul.sprite.visible = Dungeon.level.heroFOV[ghoul.pos];

            if (target.alignment != ghoul.alignment){
                detach();
                return true;
            }

            if (target.fieldOfView == null){
                target.fieldOfView = new boolean[Dungeon.level.length()];
                Dungeon.level.updateFieldOfView( target, target.fieldOfView );
            }

            if (!target.fieldOfView[ghoul.pos] && Dungeon.level.distance(ghoul.pos, target.pos) >= 4){
                detach();
                return true;
            }

            if (Dungeon.level.pit[ghoul.pos]){
                super.detach();
                ghoul.die(this);
                return true;
            }

            turnsToRevive--;
            if (turnsToRevive <= 0){
                if (Actor.findChar( ghoul.pos ) != null) {
                    ArrayList<Integer> candidates = new ArrayList<>();
                    for (int n : PathFinder.NEIGHBOURS8) {
                        int cell = ghoul.pos + n;
                        if (Dungeon.level.passable[cell]
                                && Actor.findChar( cell ) == null
                                && (!Char.hasProp(ghoul, Property.ELIXIR) || Dungeon.level.openSpace[cell])) {
                            candidates.add( cell );
                        }
                    }
                    if (candidates.size() > 0) {
                        int newPos = Random.element( candidates );
                        Actor.addDelayed( new Pushing( ghoul, ghoul.pos, newPos ), -1 );
                        ghoul.pos = newPos;

                    } else {
                        spend(TICK);
                        return true;
                    }
                }
                ghoul.HP = Math.round(ghoul.HT/10f);
                Actor.add(ghoul);
                ghoul.timeToNow();
                Dungeon.level.mobs.add(ghoul);
                Dungeon.level.occupyCell( ghoul );
                ghoul.sprite.idle();
                super.detach();
                return true;
            }

            spend(TICK);
            return true;
        }

        public void set(int turns, Aunn ghoul){
            this.ghoul = ghoul;
            turnsToRevive = turns;
        }

        @Override
        public void fx(boolean on) {
            if (on && ghoul != null && ghoul.sprite == null){
                GameScene.addSprite(ghoul);
                ((AunnSprite)ghoul.sprite).crumple();
            }
        }

        @Override
        public void detach() {
            super.detach();
            Aunn newHost = searchForHost(ghoul);
            if (newHost != null){
                attachTo(newHost);
                timeToNow();
            } else {
                ghoul.die(this);
            }
        }

        private static final String GHOUL = "ghoul";
        private static final String LEFT  = "left";

        @Override
        public void storeInBundle(Bundle bundle) {
            super.storeInBundle(bundle);
            bundle.put(GHOUL, ghoul);
            bundle.put(LEFT, turnsToRevive);
        }

        @Override
        public void restoreFromBundle(Bundle bundle) {
            super.restoreFromBundle(bundle);
            ghoul = (Aunn) bundle.get(GHOUL);
            turnsToRevive = bundle.getInt(LEFT);
        }

        public static Aunn searchForHost(Aunn dieing){

            for (Char ch : Actor.chars()){
                if (ch != dieing && ch instanceof Aunn && ch.alignment == dieing.alignment){
                    if (ch.fieldOfView == null){
                        ch.fieldOfView = new boolean[Dungeon.level.length()];
                        Dungeon.level.updateFieldOfView( ch, ch.fieldOfView );
                    }
                    if (ch.fieldOfView[dieing.pos] || Dungeon.level.distance(ch.pos, dieing.pos) < 4){
                        return (Aunn) ch;
                    }
                }
            }
            return null;
        }
    }
}