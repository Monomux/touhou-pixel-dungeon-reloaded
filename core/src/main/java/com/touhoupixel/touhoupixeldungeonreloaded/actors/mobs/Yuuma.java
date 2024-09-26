package com.touhoupixel.touhoupixeldungeonreloaded.actors.mobs;

import com.touhoupixel.touhoupixeldungeonreloaded.Dungeon;
import com.touhoupixel.touhoupixeldungeonreloaded.Statistics;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.Char;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.DoubleSpeed;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Doublerainbow;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Might;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.YuumaAbsorb;
import com.touhoupixel.touhoupixeldungeonreloaded.effects.Speck;
import com.touhoupixel.touhoupixeldungeonreloaded.items.itemstats.LifeFragment;
import com.touhoupixel.touhoupixeldungeonreloaded.messages.Messages;
import com.touhoupixel.touhoupixeldungeonreloaded.sprites.YuumaSprite;
import com.touhoupixel.touhoupixeldungeonreloaded.utils.BArray;
import com.touhoupixel.touhoupixeldungeonreloaded.utils.GLog;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Random;

public class Yuuma extends Mob {

    {
        spriteClass = YuumaSprite.class;

        HP = HT = 300;
        defenseSkill = 40;
        EXP = 25;
        maxLvl = 99;

        properties.add(Property.YOKAI);
        properties.add(Property.AQUATIC);
        properties.add(Property.HARASSMENT);

        loot = new LifeFragment();
        lootChance = 0.05f;
    }

    @Override
    protected boolean act() {

            boolean result = super.act();
                for (Buff b : this.buffs()) {
                    if (b.type == Buff.buffType.NEGATIVE) {
                        b.detach();
                        this.HP = this.HT;
                        this.sprite.emitter().burst(Speck.factory(Speck.HEALING), 6);
                        Buff.prolong(this, YuumaAbsorb.class, YuumaAbsorb.DURATION);
                        Buff.prolong(this, DoubleSpeed.class, DoubleSpeed.DURATION * 100f);
                        if (Statistics.difficulty > 2) {
                            Buff.prolong(this, Might.class, Might.DURATION);
                        }
                        if (Statistics.difficulty > 4) {
                            Buff.prolong(this, Doublerainbow.class, Doublerainbow.DURATION);
                        }
                        GLog.w(Messages.get(this, "absorb"));
                    }
                }
        PathFinder.buildDistanceMap( pos, BArray.not( Dungeon.level.solid, null ), 2 );
                for (int i = 0; i < PathFinder.distance.length; i++) {
                    if (PathFinder.distance[i] < Integer.MAX_VALUE) {
                    for (Buff c : Dungeon.heroine.buffs()) {
                        if (c.type == Buff.buffType.POSITIVE && Dungeon.heroine.pos == i) {
                            c.detach();
                            this.HP = this.HT;
                            this.sprite.emitter().burst(Speck.factory(Speck.HEALING), 6);
                            Buff.prolong(this, YuumaAbsorb.class, YuumaAbsorb.DURATION);
                            Buff.prolong(this, DoubleSpeed.class, DoubleSpeed.DURATION * 100f);
                            if (Statistics.difficulty > 2) {
                                Buff.prolong(this, Might.class, Might.DURATION);
                            }
                            if (Statistics.difficulty > 4) {
                                Buff.prolong(this, Doublerainbow.class, Doublerainbow.DURATION);
                            }
                            GLog.w(Messages.get(this, "absorb"));
                        }
                    }
                }
            }
            return result;
        }

    @Override
    public int damageRoll() {
        return Random.NormalIntRange(111, 169);
    }

    @Override
    public int attackSkill(Char target) {
        return 75;
    }

    @Override
    public int drRoll() {
        return Random.NormalIntRange(28, 41);
    }
}