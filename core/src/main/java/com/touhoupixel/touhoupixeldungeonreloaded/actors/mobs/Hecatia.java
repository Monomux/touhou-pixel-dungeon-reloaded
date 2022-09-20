/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2021 Evan Debenham
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

import com.touhoupixel.touhoupixeldungeonreloaded.Assets;
import com.touhoupixel.touhoupixeldungeonreloaded.Dungeon;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.Char;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Doublespeed;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Might;
import com.touhoupixel.touhoupixeldungeonreloaded.effects.CellEmitter;
import com.touhoupixel.touhoupixeldungeonreloaded.effects.particles.ShadowParticle;
import com.touhoupixel.touhoupixeldungeonreloaded.items.armor.HecatiaArmor;
import com.touhoupixel.touhoupixeldungeonreloaded.items.scrolls.exotic.ScrollOfChallenge;
import com.touhoupixel.touhoupixeldungeonreloaded.sprites.HecatiaSprite;
import com.watabou.noosa.audio.Sample;
import com.watabou.utils.Random;

public class Hecatia extends Mob {

	{
		spriteClass = HecatiaSprite.class;

		HP = HT = Dungeon.depth*5;
		defenseSkill = Dungeon.depth;

		EXP = 0;
		maxLvl = 99;

		loot = new ScrollOfChallenge();
		lootChance = 0.01f;

		properties.add(Property.GOD);
		properties.add(Property.WARP);
	}

	@Override
	public int damageRoll() {
		return Random.NormalIntRange(Dungeon.depth, Dungeon.depth+1);
	}

	@Override
	public int attackSkill(Char target) {
		return Dungeon.depth+5;
	}

	@Override
	public int drRoll() {
		return Random.NormalIntRange(0, 2);
	}

	@Override
	public int attackProc(Char hero, int damage) {
		damage = super.attackProc(enemy, damage);
		if (!(Dungeon.hero.belongings.armor() instanceof HecatiaArmor)) {
			if (Random.Int(3) == 0) {
				Sample.INSTANCE.play(Assets.Sounds.READ);
				CellEmitter.get(pos).burst(ShadowParticle.UP, 5);
				for (Mob mob : Dungeon.level.mobs.toArray(new Mob[0])) {
					mob.beckon(enemy.pos);
					Buff.prolong(mob, Doublespeed.class, Doublespeed.DURATION * 1000f);
					Buff.prolong(mob, Might.class, Might.DURATION * 1000f);
				}
			}
		}
		return damage;
	}
}