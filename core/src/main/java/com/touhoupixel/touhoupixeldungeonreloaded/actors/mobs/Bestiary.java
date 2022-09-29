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

package com.touhoupixel.touhoupixeldungeonreloaded.actors.mobs;

import com.watabou.utils.Random;

import java.util.ArrayList;
import java.util.Arrays;

public class Bestiary {

	public static ArrayList<Class<? extends Mob>> getMobRotation( int depth ){
		ArrayList<Class<? extends Mob>> mobs = standardMobRotation( depth );
		Random.shuffle(mobs);
		return mobs;
	}

	private static ArrayList<Class<? extends Mob>> standardMobRotation( int depth ){
		switch(depth){
			case 1: case 2: case 3: case 4: default:
				return new ArrayList<>(Arrays.asList(
						Wriggle.class, Nazrin.class, Aunn.class, Mike.class, Larva.class));
			case 6: case 7: case 8: case 9:
				return new ArrayList<>(Arrays.asList(
						Kokoro.class, Ringo.class, Kogasa.class, Akyuu.class, Kosuzu.class));
			case 11: case 12: case 13: case 14:
				return new ArrayList<>(Arrays.asList(
						Sunny.class, Luna.class, Star.class, Lily.class, Cirno.class));
			case 16: case 17: case 18: case 19:
				return new ArrayList<>(Arrays.asList(
						Alice.class, Mystia.class, Chen.class, Eika.class, Marisa.class));
			case 21: case 22: case 23: case 24:
				return new ArrayList<>(Arrays.asList(
						Reisen.class, Tewi.class, Keine.class, Mokou.class, Kagerou.class));
			case 26: case 27: case 28: case 29:
				return new ArrayList<>(Arrays.asList(
						Koakuma.class, Meiling.class, Patchouli.class, Sakuya.class, Remilia.class));
			case 31: case 32: case 33: case 34:
				return new ArrayList<>(Arrays.asList(
						Nitori.class, Takane.class, Momiji.class, Hatate.class, Aya.class));
			case 36: case 37: case 38: case 39:
				return new ArrayList<>(Arrays.asList(
						Yuuka.class, Nemuno.class, Joon.class, Shion.class, Kasen.class));
			case 41: case 42: case 43: case 44:
				return new ArrayList<>(Arrays.asList(
						Kyouko.class, Ichirin.class, Shou.class, Miko.class, Hijiri.class));
			case 46: case 47: case 48: case 49:
				return new ArrayList<>(Arrays.asList(
						Kisume.class, Kutaka.class, Saki.class, Tojiko.class, Mamizou.class));
			case 51: case 52: case 53: case 54:
				return new ArrayList<>(Arrays.asList(
						Hecatia.class, Shizuha.class, Minoriko.class, Sanae.class, Suwako.class, Kanako.class));
			case 56: case 57: case 58: case 59:
				return new ArrayList<>(Arrays.asList(
						Hecatia.class, Benben.class, Yatsuhashi.class, Hina.class, Shinmyomaru.class, Seija.class));
			case 61: case 62: case 63: case 64:
				return new ArrayList<>(Arrays.asList(
						Hecatia.class, Tsukasa.class, Momoyo.class, Sannyo.class, Megumu.class, Misumaru.class));
			case 66: case 67: case 68: case 69:
				return new ArrayList<>(Arrays.asList(
						Hecatia.class, Miyoi.class, Parsee.class, Satono.class, Mai.class, Okina.class));
			case 71: case 72: case 73: case 74:
				return new ArrayList<>(Arrays.asList(
						Hecatia.class, Yamame.class, Kaguya.class, Ran.class, Youmu.class, Yuyuko.class));
			case 76: case 77: case 78: case 79:
				return new ArrayList<>(Arrays.asList(
						Hecatia.class, Yuugi.class, Clownpiece.class, Chimata.class, Iku.class, Tenshi.class));
			case 81: case 82: case 83: case 84:
				return new ArrayList<>(Arrays.asList(
						Hecatia.class, Seiran.class, Eirin.class, Doremy.class, Sagume.class, Junko.class));
			case 86: case 87: case 88: case 89:
				return new ArrayList<>(Arrays.asList(
						Hecatia.class, Utsuho.class, Sumireko.class, Hearn.class, Renko.class, Keiki.class));
			case 91: case 92: case 93: case 95: case 96: case 97:
				return new ArrayList<>(Arrays.asList(
						Hecatia.class, Toyohime.class, Yorihime.class, Yuuma.class, Komachi.class, Eiki.class));
		}
	}
}