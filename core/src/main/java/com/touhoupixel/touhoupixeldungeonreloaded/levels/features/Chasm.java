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

package com.touhoupixel.touhoupixeldungeonreloaded.levels.features;

import com.touhoupixel.touhoupixeldungeonreloaded.Assets;
import com.touhoupixel.touhoupixeldungeonreloaded.Dungeon;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.BalanceBreak;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Bleeding;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Cripple;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.mobs.Mob;
import com.touhoupixel.touhoupixeldungeonreloaded.effects.Speck;
import com.touhoupixel.touhoupixeldungeonreloaded.items.artifacts.TimekeepersHourglass;
import com.touhoupixel.touhoupixeldungeonreloaded.items.scrolls.exotic.ScrollOfTeleportation;
import com.touhoupixel.touhoupixeldungeonreloaded.items.spells.FeatherFall;
import com.touhoupixel.touhoupixeldungeonreloaded.levels.RegularLevel;
import com.touhoupixel.touhoupixeldungeonreloaded.messages.Messages;
import com.touhoupixel.touhoupixeldungeonreloaded.plants.Swiftthistle;
import com.touhoupixel.touhoupixeldungeonreloaded.scenes.GameScene;
import com.touhoupixel.touhoupixeldungeonreloaded.scenes.InterlevelScene;
import com.touhoupixel.touhoupixeldungeonreloaded.sprites.MobSprite;
import com.touhoupixel.touhoupixeldungeonreloaded.utils.GLog;
import com.touhoupixel.touhoupixeldungeonreloaded.windows.WndOptions;
import com.watabou.noosa.Camera;
import com.watabou.noosa.Game;
import com.watabou.noosa.Image;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Callback;
import com.watabou.utils.Random;

public class Chasm implements Hero.Doom {

	public static boolean jumpConfirmed = false;
	private static int heroPos;

	public static void heroJump( final Hero heroine) {
		heroPos = heroine.pos;
		Game.runOnRenderThread(new Callback() {
			@Override
			public void call() {
				if (Dungeon.heroine.buff(BalanceBreak.class) == null) {
					GameScene.show(
							new WndOptions(new Image(Dungeon.level.tilesTex(), 48, 48, 16, 16),
									Messages.get(Chasm.class, "chasm"),
									Messages.get(Chasm.class, "jump"),
									Messages.get(Chasm.class, "yes"),
									Messages.get(Chasm.class, "no")) {
								@Override
								protected void onSelect(int index) {
									if (index == 0) {
										if (Dungeon.heroine.pos == heroPos) {
											if (Dungeon.floor == 1){
												ScrollOfTeleportation.randomTeleportChar(heroine);
												GLog.n( Messages.get(Chasm.class, "floor_one_fall") );
											} else {
												jumpConfirmed = true;
												heroine.resume();
											}
										}
									}
								}
							}
					);
				} else if (Dungeon.heroine.pos == heroPos) {
					if (Dungeon.floor == 1){
						ScrollOfTeleportation.randomTeleportChar(heroine);
						GLog.n( Messages.get(Chasm.class, "floor_one_fall") );
					} else {
						jumpConfirmed = true;
						heroine.resume();
					}
				}
			}
		});
	}

	public static void heroFall( int pos ) {

		jumpConfirmed = false;

		Sample.INSTANCE.play( Assets.Sounds.FALLING );

		TimekeepersHourglass.timeFreeze timeFreeze = Dungeon.heroine.buff(TimekeepersHourglass.timeFreeze.class);
		if (timeFreeze != null) timeFreeze.disarmPressedTraps();
		Swiftthistle.TimeBubble timeBubble = Dungeon.heroine.buff(Swiftthistle.TimeBubble.class);
		if (timeBubble != null) timeBubble.disarmPressedTraps();

		if (Dungeon.heroine.isAlive()) {
			InterlevelScene.mode = InterlevelScene.Mode.FALL;
			if (Dungeon.level instanceof RegularLevel) {
				InterlevelScene.fallIntoPit = false;
			}
			if (Dungeon.floor == 1) {
				ScrollOfTeleportation.randomTeleportChar(Dungeon.heroine);
				GLog.n(Messages.get(Chasm.class, "floor_one_fall"));
			} else {
				Dungeon.heroine.interrupt();
				Game.switchScene(InterlevelScene.class);
			}
		} else {
			Dungeon.heroine.sprite.visible = false;
		}
	}

	@Override
	public void onDeath() {
		Dungeon.fail( Chasm.class );
		GLog.n( Messages.get(Chasm.class, "ondeath") );
	}

	public static void heroLand() {

		Hero heroine = Dungeon.heroine;

		FeatherFall.FeatherBuff b = heroine.buff(FeatherFall.FeatherBuff.class);

		if (b != null){
			heroine.sprite.emitter().burst( Speck.factory( Speck.JET ), 20);
			b.detach();
			return;
		}

		Camera.main.shake( 4, 1f );

		Dungeon.level.occupyCell(heroine );
		Buff.prolong( heroine, Cripple.class, Cripple.DURATION );

		//The lower the hero's HP, the more bleed and the less upfront damage.
		//Hero has a 50% chance to bleed out at 66% HP, and begins to risk instant-death at 25%
		Buff.affect( heroine, Bleeding.class).set( Math.round(heroine.HT / (6f + (6f*(heroine.HP/(float)heroine.HT)))), Chasm.class);
		heroine.damage( Math.max( heroine.HP / 2, Random.NormalIntRange( heroine.HP / 2, heroine.HT / 4 )), new Chasm() );
	}

	public static void mobFall( Mob mob ) {
		if (mob.isAlive()) mob.die( Chasm.class );

		if (mob.sprite != null) ((MobSprite)mob.sprite).fall();
	}

	public static class Falling extends Buff {

		{
			actPriority = VFX_PRIO;
		}

		@Override
		public boolean act() {
			heroLand();
			detach();
			return true;
		}
	}
}