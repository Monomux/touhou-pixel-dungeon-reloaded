package com.touhoupixel.touhoupixeldungeonreloaded.actors.mobs;

import com.touhoupixel.touhoupixeldungeonreloaded.Dungeon;
import com.touhoupixel.touhoupixeldungeonreloaded.Statistics;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.Char;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.HerbDegrade;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Hex;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.RegenBlock;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Weakness;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.hero.HeroClass;
import com.touhoupixel.touhoupixeldungeonreloaded.items.potions.PotionOfDoublespeed;
import com.touhoupixel.touhoupixeldungeonreloaded.sprites.AyaSprite;
import com.watabou.utils.Random;

public class Aya extends Mob {

    {
        spriteClass = AyaSprite.class;

        HP = HT = 62;
        defenseSkill = 17;
        EXP = 11;
        maxLvl = 25;

        baseSpeed = 5f;

        properties.add(Property.YOKAI);

        flying = true;

        loot = new PotionOfDoublespeed();
        lootChance = 0.1f;
    }

    @Override
    public int damageRoll() {
        return Random.NormalIntRange(6, 10);
    }

    @Override
    public int attackSkill(Char target) {
        return 22;
    }

    @Override
    public int drRoll() {
        return Random.NormalIntRange(0, 2);
    }

    @Override
    public int attackProc(Char hero, int damage) {
        damage = super.attackProc(enemy, damage);
        if (enemy == Dungeon.hero && enemy.alignment != this.alignment && Random.Int(5) == 0){
            if (Statistics.difficulty > 2) {
                Buff.prolong(enemy, HerbDegrade.class, HerbDegrade.DURATION);
            }
            if (Statistics.difficulty > 4) {
                Buff.prolong(enemy, Hex.class, Hex.DURATION);
            }
        }
        return damage;
    }
}