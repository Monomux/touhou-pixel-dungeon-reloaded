package com.touhoupixel.touhoupixeldungeongaiden.actors.mobs;

import com.touhoupixel.touhoupixeldungeongaiden.Dungeon;
import com.touhoupixel.touhoupixeldungeongaiden.actors.Char;
import com.touhoupixel.touhoupixeldungeongaiden.actors.blobs.Blob;
import com.touhoupixel.touhoupixeldungeongaiden.actors.blobs.Fire;
import com.touhoupixel.touhoupixeldungeongaiden.actors.buffs.Inversion;
import com.touhoupixel.touhoupixeldungeongaiden.actors.buffs.ZeroDexterity;
import com.touhoupixel.touhoupixeldungeongaiden.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeongaiden.items.itemstats.Spellcard;
import com.touhoupixel.touhoupixeldungeongaiden.items.keys.SkeletonKey;
import com.touhoupixel.touhoupixeldungeongaiden.levels.Terrain;
import com.touhoupixel.touhoupixeldungeongaiden.messages.Messages;
import com.touhoupixel.touhoupixeldungeongaiden.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeongaiden.sprites.KosuzuSprite;
import com.touhoupixel.touhoupixeldungeongaiden.ui.BossHealthBar;
import com.watabou.utils.PathFinder;
import com.watabou.utils.Random;

public class BossKosuzu extends Mob {

    {
        spriteClass = KosuzuSprite.class;

        HP = HT = 100;
        defenseSkill = 5;
        EXP = 13;
        maxLvl = 99;

        properties.add(Property.BOSS);
        properties.add(Property.HUMAN);

        immunities.add(Fire.class);

        loot = new Spellcard();
        lootChance = 1f;
    }

    @Override
    public void die(Object cause) {
        GameScene.bossSlain();
        super.die(cause);
        Dungeon.level.unseal();
        Dungeon.level.drop(new SkeletonKey(5), pos ).sprite.drop();
        yell(Messages.get(this, "bossdefeat"));
    }

    @Override
    public int damageRoll() {
        return Random.NormalIntRange(2, 5);
    }

    @Override
    public int attackSkill(Char target) {
        return 10;
    }

    @Override
    public int drRoll() {
        return Random.NormalIntRange(0, 2);
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
            for (int offset : PathFinder.NEIGHBOURS9) {
                GameScene.add(Blob.seed(enemy.pos + offset, 1, Fire.class));
            }
            if (Dungeon.level.map[enemy.pos] == Terrain.EMBERS) {
                Buff.prolong(enemy, Inversion.class, Inversion.DURATION / 3f);
                yell(Messages.get(this, "nobookshelf"));
            }
            if (this.HP < this.HT / 2) {
                Buff.prolong(enemy, ZeroDexterity.class, ZeroDexterity.DURATION / 2f);
            }
        }
        return damage;
    }
}