package com.touhoupixel.touhoupixeldungeonreloaded.actors.mobs;

import com.touhoupixel.touhoupixeldungeonreloaded.Assets;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.Char;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Blindness;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.RemiliaFate;
import com.touhoupixel.touhoupixeldungeonreloaded.effects.CellEmitter;
import com.touhoupixel.touhoupixeldungeonreloaded.effects.particles.ShadowParticle;
import com.touhoupixel.touhoupixeldungeonreloaded.items.itemstats.LifeFragement;
import com.touhoupixel.touhoupixeldungeonreloaded.sprites.AyaSprite;
import com.touhoupixel.touhoupixeldungeonreloaded.sprites.RemiliaSprite;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Random;

public class Remilia extends Mob {

    {
        spriteClass = RemiliaSprite.class;

        HP = HT = 89;
        defenseSkill = 27;
        EXP = 6;
        maxLvl = 35;

        loot = new LifeFragement();
        lootChance = 0.04f;
    }

    @Override
    public int damageRoll() {
        return Random.NormalIntRange(7, 10);
    }

    @Override
    public int attackSkill(Char target) {
        return 32;
    }

    @Override
    public int drRoll() {
        return Random.NormalIntRange(0, 2);
    }

    @Override
    public int attackProc(Char hero, int damage) {
        damage = super.attackProc(enemy, damage);
        if (Random.Int(3) == 0) {
            Buff.prolong(enemy, RemiliaFate.class, RemiliaFate.DURATION);
        }
        return damage;
    }
}