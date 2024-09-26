package com.touhoupixel.touhoupixeldungeonreloaded.actors.mobs;

import com.touhoupixel.touhoupixeldungeonreloaded.Assets;
import com.touhoupixel.touhoupixeldungeonreloaded.Dungeon;
import com.touhoupixel.touhoupixeldungeonreloaded.Statistics;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.Char;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Cripple;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Doublerainbow;
import com.touhoupixel.touhoupixeldungeonreloaded.items.Generator;
import com.touhoupixel.touhoupixeldungeonreloaded.items.KindofMisc;
import com.touhoupixel.touhoupixeldungeonreloaded.items.armor.Armor;
import com.touhoupixel.touhoupixeldungeonreloaded.items.bracelets.AntiParryBracelet;
import com.touhoupixel.touhoupixeldungeonreloaded.items.bracelets.Bracelet;
import com.touhoupixel.touhoupixeldungeonreloaded.items.bracelets.RustproofBracelet;
import com.touhoupixel.touhoupixeldungeonreloaded.items.weapon.melee.MeleeWeapon;
import com.touhoupixel.touhoupixeldungeonreloaded.messages.Messages;
import com.touhoupixel.touhoupixeldungeonreloaded.sprites.ChimataSprite;
import com.touhoupixel.touhoupixeldungeonreloaded.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Random;

public class Chimata extends Mob {

    {
        spriteClass = ChimataSprite.class;

        HP = HT = 341;
        defenseSkill = 35;
        EXP = 17;
        maxLvl = 47;

        properties.add(Property.GOD);

        loot = Generator.Category.SCROLL;
        lootChance = 0.1f;
    }

    @Override
    public int damageRoll() {
        return Random.NormalIntRange(120, 182);
    }

    @Override
    public int attackSkill(Char target) {
        return 45;
    }

    @Override
    public int drRoll() {
        return Random.NormalIntRange(41, 59);
    }

    @Override
    public int attackProc(Char hero, int damage) {
        damage = super.attackProc(enemy, damage);

        KindofMisc misc = Dungeon.heroine.belongings.misc;
        Bracelet bracelet = Dungeon.heroine.belongings.bracelet;

        if (enemy == Dungeon.heroine && enemy.alignment != this.alignment && Random.Int(5) == 0) {
            MeleeWeapon meleeweapon = Dungeon.heroine.belongings.getItem(MeleeWeapon.class);
            Armor armor = Dungeon.heroine.belongings.getItem(Armor.class);
            if (misc instanceof RustproofBracelet || bracelet instanceof RustproofBracelet) {
                //do nothing
            } else {
                if (meleeweapon != null) {
                    meleeweapon.downgrade();
                    meleeweapon.enchantment = null;
                    Sample.INSTANCE.play(Assets.Sounds.CURSED);
                    GLog.w(Messages.get(this, "weapon_downgrade"));
                }
                if (armor != null) {
                    armor.downgrade();
                    armor.glyph = null;
                    Sample.INSTANCE.play(Assets.Sounds.CURSED);
                    GLog.w(Messages.get(this, "armor_downgrade"));
                }
            }
            if (Statistics.difficulty > 2) {
                Buff.prolong(this, Doublerainbow.class, Doublerainbow.DURATION);
            }
            if (Statistics.difficulty > 4) {
                Buff.prolong(enemy, Cripple.class, Cripple.DURATION);
            }
        }
        return damage;
    }
}