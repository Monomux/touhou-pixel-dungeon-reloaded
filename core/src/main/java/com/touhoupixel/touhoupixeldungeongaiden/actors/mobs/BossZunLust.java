package com.touhoupixel.touhoupixeldungeongaiden.actors.mobs;

import com.touhoupixel.touhoupixeldungeongaiden.Dungeon;
import com.touhoupixel.touhoupixeldungeongaiden.actors.Char;
import com.touhoupixel.touhoupixeldungeongaiden.actors.blobs.Fire;
import com.touhoupixel.touhoupixeldungeongaiden.actors.buffs.Paralysis;
import com.touhoupixel.touhoupixeldungeongaiden.sprites.ZUNLustSprite;
import com.watabou.utils.Random;

public class BossZunLust extends Mob {

    {
        spriteClass = ZUNLustSprite.class;

        HP = HT = 2000;
        defenseSkill = 99;

        properties.add(Property.HUMAN);
        properties.add(Property.MINIBOSS);

        properties.add(Property.FUMO);
        //used for fumo lover buff

        immunities.add(Paralysis.class);
        immunities.add(Fire.class);

        EXP = 0;
        maxLvl = 99;
    }

    @Override
    public int damageRoll() {
        return Random.NormalIntRange(50, 70);
    }

    @Override
    public int attackSkill(Char target) {
        return 99;
    }

    @Override
    public int drRoll() {
        return Random.NormalIntRange(0, 10);
    }

    @Override
    protected boolean act() {
        if (Dungeon.level.heroFOV[pos] && this.state != SLEEPING && this.state != FLEEING) {

        }
        return super.act();
    }
}