/*
 * Pixel Dungeon
 * Copyright (C) 2012-2015 Oleg Dolya
 *
 * Shattered Pixel Dungeon
 * Copyright (C) 2014-2024 Evan Debenham
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

package com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs;

import com.touhoupixel.touhoupixeldungeonreloaded.Dungeon;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.Buff;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.buffs.LockedFloor;
import com.touhoupixel.touhoupixeldungeonreloaded.actors.hero.Hero;
import com.touhoupixel.touhoupixeldungeonreloaded.items.artifacts.ChaliceOfBlood;
import com.touhoupixel.touhoupixeldungeonreloaded.items.rings.RingOfEnergy;

public class Regeneration extends Buff {

	{
		//unlike other buffs, this one acts after the hero and takes priority against other effects
		//healing is much more useful if you get some of it off before taking damage
		actPriority = HERO_PRIO - 1;
	}

	private static final float REGENERATION_DELAY = 1;

	@Override
	public boolean act() {
		if (target.isAlive()) {

			if (target.HP < regencap() && !((Hero)target).isStarving()) {
				if (regenOn()) {
					target.HP += 1;
					if (target.HP == regencap()) {
						((Hero) target).resting = false;
					}
				}
			}

			float delay = REGENERATION_DELAY;
			spend( delay );

		} else {

			diactivate();

		}

		return true;
	}

	public int regencap(){
		return target.HT;
	}

	public static boolean regenOn(){
		LockedFloor lock = Dungeon.heroine.buff(LockedFloor.class);
		if (lock != null && !lock.regenOn()){
			return false;
		}
		return true;
	}
}
