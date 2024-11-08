package com.touhoupixel.touhoupixeldungeonreloaded.items.talismans;

import com.touhoupixel.touhoupixeldungeonreloaded.Assets;
import com.touhoupixel.touhoupixeldungeonreloaded.Dungeon;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.Actor;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.Char;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Doom;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Drowsy;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Poison;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Slow;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Vertigo;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.mobs.Seiran;
import com.touhoupixel.touhoupixeldungeonreloaded.items.potions.PotionOfLightHealing;
import com.touhoupixel.touhoupixeldungeonreloaded.items.potions.exotic.PotionOfPhilosopher;
import com.touhoupixel.touhoupixeldungeonreloaded.items.scrolls.exotic.ScrollOfTeleportation;
import com.touhoupixel.touhoupixeldungeonreloaded.messages.Messages;
import com.touhoupixel.touhoupixeldungeonreloaded.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeonreloaded.sprites.ItemSpriteSheet;
import com.touhoupixel.touhoupixeldungeonreloaded.utils.GLog;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Random;

public class SevenDaysTalisman extends Talisman {
    {
        image = ItemSpriteSheet.SEVEN_DAYS;
    }

    @Override
    protected void onThrow(int cell) {

        Char ch = Actor.findChar(cell);

        if (ch != null && !ch.properties().contains(Char.Property.MINIBOSS) && !ch.properties().contains(Char.Property.BOSS)) {
            if (ch instanceof Seiran && Random.Int(3) == 0) {
                switch (Random.Int(7)) {
                    case 0:
                    default:
                        Buff.affect(curUser, Poison.class).set(Dungeon.floor/2f);
                        break;
                    case 1:
                        Buff.prolong(curUser, Vertigo.class, Vertigo.DURATION);
                        break;
                    case 2:
                        Buff.prolong(curUser, Slow.class, Slow.DURATION);
                        break;
                    case 3:
                        Buff.affect(curUser, Drowsy.class);
                        break;
                    case 4:
                        Buff.affect(curUser, Doom.class);
                        break;
                    case 5:
                        ScrollOfTeleportation.randomTeleportChar(curUser);
                        break;
                    case 6:
                        GameScene.flash(0x80FFFFFF);
                        Sample.INSTANCE.play(Assets.Sounds.BLAST);
                        curUser.die(Seiran.class);
                        Dungeon.level.drop(new PotionOfLightHealing(), curUser.pos).sprite.drop();
                        break;
                }
                GLog.w(Messages.get(Seiran.class, "tool_reflect"));
            } else {
                switch (Random.Int(7)) {
                    case 0:
                    default:
                        Buff.affect(ch, Poison.class).set(Dungeon.floor/2f);
                        break;
                    case 1:
                        Buff.prolong(ch, Vertigo.class, Vertigo.DURATION);
                        break;
                    case 2:
                        Buff.prolong(ch, Slow.class, Slow.DURATION);
                        break;
                    case 3:
                        Buff.affect(ch, Drowsy.class);
                        break;
                    case 4:
                        Buff.affect(ch, Doom.class);
                        break;
                    case 5:
                        ScrollOfTeleportation.randomTeleportChar(ch);
                        break;
                    case 6:
                        GameScene.flash(0x80FFFFFF);
                        Sample.INSTANCE.play(Assets.Sounds.BLAST);
                        ch.die(null);
                        if (ch.properties().contains(Char.Property.ELIXIR)) {
                            Dungeon.level.drop(new PotionOfPhilosopher(), ch.pos).sprite.drop();
                        } else {
                            Dungeon.level.drop(new PotionOfLightHealing(), ch.pos).sprite.drop();
                        }
                        break;
                }
            }
        }
    }
}