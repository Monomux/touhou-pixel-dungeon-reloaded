package com.touhoupixel.touhoupixeldungeonreloaded.actors.mobs;

import com.touhoupixel.touhoupixeldungeonreloaded.Dungeon;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.Char;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Doublerainbow;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.DoubleSpeed;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Hisou;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.KomachiCurse;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Paralysis;
import com.touhoupixel.touhoupixeldungeonreloaded.items.itemstats.Spellcard;
import com.touhoupixel.touhoupixeldungeonreloaded.items.keys.SkeletonKey;
import com.touhoupixel.touhoupixeldungeonreloaded.items.scrolls.exotic.ScrollOfTeleportation;
import com.touhoupixel.touhoupixeldungeonreloaded.messages.Messages;
import com.touhoupixel.touhoupixeldungeonreloaded.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeonreloaded.sprites.KomachiSprite;
import com.touhoupixel.touhoupixeldungeonreloaded.ui.BossHealthBar;
import com.watabou.utils.Random;

public class BossKomachi extends Mob {

    {
        spriteClass = KomachiSprite.class;

        HP = HT = 1100;
        defenseSkill = 25;
        EXP = 24;
        maxLvl = 99;

        properties.add(Property.BOSS);
        properties.add(Property.GOD);
        properties.add(Property.AQUATIC);

        immunities.add(Paralysis.class);

        loot = new Spellcard();
        lootChance = 1f;
    }

    @Override
    public void die(Object cause) {
        GameScene.bossSlain();
        super.die(cause);
        Dungeon.level.unseal();
        Dungeon.level.drop(new SkeletonKey(25), pos).sprite.drop();
        yell(Messages.get(this, "bossdefeat"));
        Buff.detach(Dungeon.heroine, KomachiCurse.class);
    }

    @Override
    public int damageRoll() {
        return Random.NormalIntRange(83, 127);
    }

    @Override
    public int attackSkill(Char target) {
        return 30;
    }

    @Override
    public int drRoll() {
        return Random.NormalIntRange(16, 24);
    }

    @Override
    public void notice() {
        super.notice();
        if (!BossHealthBar.isAssigned()) {
            BossHealthBar.assignBoss(this);
            yell(Messages.get(this, "boss"));
        }
    }

    @Override
    public int attackProc(Char hero, int damage) {
        damage = super.attackProc(enemy, damage);
        if (enemy == Dungeon.heroine && enemy.alignment != this.alignment) {
            ScrollOfTeleportation.randomTeleportChar(this);
            Buff.prolong(enemy, KomachiCurse.class, KomachiCurse.DURATION);
            if (this.HP < this.HT / 2) {
                Buff.prolong(this, DoubleSpeed.class, DoubleSpeed.DURATION * 1000f);
                Buff.prolong(this, Hisou.class, Hisou.DURATION * 1000f);
                Buff.prolong(this, Doublerainbow.class, Doublerainbow.DURATION * 1000f);
            }
        }
        return damage;
    }
}