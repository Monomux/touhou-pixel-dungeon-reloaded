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

package com.touhoupixel.touhoupixeldungeonreloaded.sprites;

import com.touhoupixel.touhoupixeldungeonreloaded.Assets;
import com.watabou.noosa.TextureFilm;

public class ItemSpriteSheet {

	private static final int WIDTH = 16;
	public static final int SIZE = 16;

	public static TextureFilm film = new TextureFilm( Assets.Sprites.ITEMS, SIZE, SIZE );

	private static int xy(int x, int y){
		x -= 1; y -= 1;
		return x + WIDTH*y;
	}

	private static void assignItemRect( int item, int width, int height ){
		int x = (item % WIDTH) * SIZE;
		int y = (item / WIDTH) * SIZE;
		film.add( item, x, y, x+width, y+height);
	}

	private static final int PLACEHOLDERS   =                               xy(1, 1);   //16 slots
	//SOMETHING is the default item sprite at position 0. May show up ingame if there are bugs.
	public static final int SOMETHING       = PLACEHOLDERS+0;
	public static final int WEAPON_HOLDER   = PLACEHOLDERS+1;
	public static final int ARMOR_HOLDER    = PLACEHOLDERS+2;
	public static final int MISSILE_HOLDER  = PLACEHOLDERS+3;
	public static final int WAND_HOLDER     = PLACEHOLDERS+4;
	public static final int BRACELET_HOLDER = PLACEHOLDERS+5;
	public static final int ARTIFACT_HOLDER = PLACEHOLDERS+6;
	public static final int FOOD_HOLDER     = PLACEHOLDERS+7;
	public static final int BOMB_HOLDER     = PLACEHOLDERS+8;
	public static final int POTION_HOLDER   = PLACEHOLDERS+9;
	public static final int SCROLL_HOLDER   = PLACEHOLDERS+11;
	public static final int SEED_HOLDER     = PLACEHOLDERS+10;
	public static final int STONE_HOLDER    = PLACEHOLDERS+12;
	public static final int CATA_HOLDER     = PLACEHOLDERS+13;
	public static final int ELIXIR_HOLDER   = PLACEHOLDERS+14;
	public static final int SPELL_HOLDER    = PLACEHOLDERS+15;

	static{
		assignItemRect(SOMETHING,       8,  13);
		assignItemRect(WEAPON_HOLDER,   14, 14);
		assignItemRect(ARMOR_HOLDER,    14, 12);
		assignItemRect(MISSILE_HOLDER,  15, 15);
		assignItemRect(WAND_HOLDER,     14, 14);
		assignItemRect(BRACELET_HOLDER,     16,  16);
		assignItemRect(ARTIFACT_HOLDER, 15, 15);
		assignItemRect(FOOD_HOLDER,     15, 11);
		assignItemRect(BOMB_HOLDER,     10, 13);
		assignItemRect(POTION_HOLDER,   10, 15);
		assignItemRect(SEED_HOLDER,     10, 10);
		assignItemRect(SCROLL_HOLDER,   11, 15);
		assignItemRect(STONE_HOLDER,    14, 12);
		assignItemRect(CATA_HOLDER,     6,  15);
		assignItemRect(ELIXIR_HOLDER,   12, 14);
		assignItemRect(SPELL_HOLDER,    8,  16);
	}

	private static final int UNCOLLECTIBLE  =                               xy(1, 2);   //16 slots
	public static final int GOLD            = UNCOLLECTIBLE+0;
	public static final int DEWDROP         = UNCOLLECTIBLE+1;
	public static final int HOURGLASS_UP    = UNCOLLECTIBLE+2;
	public static final int MIRACLE_ARROW   = UNCOLLECTIBLE+3;
	public static final int ENERGY          = UNCOLLECTIBLE+4;
	public static final int GUIDE_PAGE      = UNCOLLECTIBLE+5;
	public static final int ALCH_PAGE       = UNCOLLECTIBLE+6;
	public static final int ALCH_COLLECTION = UNCOLLECTIBLE+7;
	public static final int BRACELET        = UNCOLLECTIBLE+10;
	public static final int POT             = UNCOLLECTIBLE+11;

	static{
		assignItemRect(GOLD,         12, 12);
		assignItemRect(DEWDROP,      10, 10);
		assignItemRect(HOURGLASS_UP, 16, 16);
		assignItemRect(MIRACLE_ARROW,16, 15);
		assignItemRect(ENERGY,       16, 16);
		assignItemRect(GUIDE_PAGE,   10, 10);
		assignItemRect(ALCH_PAGE,    10, 10);
		assignItemRect(ALCH_COLLECTION,   12, 11);
		assignItemRect(BRACELET,          16, 16);
		assignItemRect(POT,               13, 13);
	}

	private static final int CONTAINERS     =                               xy(1, 3);   //16 slots
	public static final int BONES           = CONTAINERS+0;
	public static final int REMAINS         = CONTAINERS+1;
	public static final int TOMB            = CONTAINERS+2;
	public static final int GRAVE           = CONTAINERS+3;
	public static final int CHEST           = CONTAINERS+4;
	public static final int LOCKED_CHEST    = CONTAINERS+5;
	public static final int CRYSTAL_CHEST   = CONTAINERS+6;
	public static final int EBONY_CHEST     = CONTAINERS+7;
	public static final int SMALL_POWER     = CONTAINERS+8;
	public static final int VALUE     = CONTAINERS+9;
	public static final int BIG_POWER     = CONTAINERS+10;
	public static final int MAX_POWER     = CONTAINERS+11;
	public static final int LIFE_FRAGMENT     = CONTAINERS+12;
	public static final int SPELLCARD_FRAGMENT     = CONTAINERS+13;
	public static final int LIFE     = CONTAINERS+14;
	public static final int SPELLCARD     = CONTAINERS+15;

	static{
		assignItemRect(BONES,           15, 14);
		assignItemRect(REMAINS,         15, 14);
		assignItemRect(TOMB,            15, 14);
		assignItemRect(GRAVE,           15, 14);
		assignItemRect(CHEST,           15, 14);
		assignItemRect(LOCKED_CHEST,    15, 14);
		assignItemRect(CRYSTAL_CHEST,   15, 14);
		assignItemRect(EBONY_CHEST,     15, 14);
		assignItemRect(SMALL_POWER,     12, 12);
		assignItemRect(VALUE,     12, 12);
		assignItemRect(BIG_POWER,     16, 16);
		assignItemRect(MAX_POWER,     16, 16);
		assignItemRect(LIFE_FRAGMENT,     16, 15);
		assignItemRect(SPELLCARD_FRAGMENT,     16, 15);
		assignItemRect(LIFE,     16, 15);
		assignItemRect(SPELLCARD,     16, 15);
	}

	private static final int MISC_AND_DANMAKU =                              xy(1, 4);   //16 slots
	public static final int TORCH           = MISC_AND_DANMAKU +0;
	public static final int GLASS_BOTTLE          = MISC_AND_DANMAKU +1;
	public static final int HONEYPOT        = MISC_AND_DANMAKU +2;
	public static final int SHATTPOT        = MISC_AND_DANMAKU +3;
	public static final int IRON_KEY        = MISC_AND_DANMAKU +4;
	public static final int GOLDEN_KEY      = MISC_AND_DANMAKU +5;
	public static final int CRYSTAL_KEY     = MISC_AND_DANMAKU +6;
	public static final int SKELETON_KEY    = MISC_AND_DANMAKU +7;
	public static final int AMULET            = MISC_AND_DANMAKU +8;
	public static final int MASTERY           = MISC_AND_DANMAKU +9;
	public static final int MERLIN_DANMAKU    = MISC_AND_DANMAKU +10;
	public static final int AYA_DANMAKU       = MISC_AND_DANMAKU +11;
	public static final int MEDICINE_DANMAKU  = MISC_AND_DANMAKU +12;
	public static final int SCROLL          = MISC_AND_DANMAKU +14;

	static{
		assignItemRect(TORCH,           12, 15);
		assignItemRect(GLASS_BOTTLE,    12, 14);
		assignItemRect(HONEYPOT,        14, 12);
		assignItemRect(SHATTPOT,        14, 12);
		assignItemRect(IRON_KEY,        8,  14);
		assignItemRect(GOLDEN_KEY,      8,  14);
		assignItemRect(CRYSTAL_KEY,     8,  14);
		assignItemRect(SKELETON_KEY,    8,  14);
		assignItemRect(AMULET,          12,  12);
		assignItemRect(MASTERY,         13,  16);
		assignItemRect(MERLIN_DANMAKU,  9, 16);
		assignItemRect(AYA_DANMAKU,     16, 12);
		assignItemRect(MEDICINE_DANMAKU,11, 11);
		assignItemRect(SCROLL,        11, 15);
	}

	private static final int CUBES_AND_CARDS =                               xy(1, 5);   //16 slots
	public static final int CLEAR_CUBE_FRAGMENT            = CUBES_AND_CARDS +0;
	public static final int BLACK_CUBE_FRAGMENT        = CUBES_AND_CARDS +1;
	public static final int WHITE_CUBE_FRAGMENT       = CUBES_AND_CARDS +2;
	public static final int RED_CUBE_FRAGMENT      = CUBES_AND_CARDS +3;
	public static final int BLUE_CUBE_FRAGMENT   = CUBES_AND_CARDS +4;
	public static final int THREE_STAR_TICKET     = CUBES_AND_CARDS +5;
	public static final int TENSHI_CARD     = CUBES_AND_CARDS +6;
	public static final int PATCHOULI_CARD     = CUBES_AND_CARDS +7;
	public static final int STRENGTH_CARD     = CUBES_AND_CARDS +8;
	public static final int UPGRADE_CARD     = CUBES_AND_CARDS +9;
	public static final int DOREMY     = CUBES_AND_CARDS +10;
	public static final int SUIKA = CUBES_AND_CARDS +11;
	public static final int HOURAI = CUBES_AND_CARDS +12;
	public static final int YUUMA     = CUBES_AND_CARDS +13;

	static{
		assignItemRect(CLEAR_CUBE_FRAGMENT,            11, 12);
		assignItemRect(BLACK_CUBE_FRAGMENT,        11, 12);
		assignItemRect(WHITE_CUBE_FRAGMENT,       11, 12);
		assignItemRect(RED_CUBE_FRAGMENT,      11, 12);
		assignItemRect(BLUE_CUBE_FRAGMENT,   11, 12);
		assignItemRect(THREE_STAR_TICKET,   15, 11);
		assignItemRect(TENSHI_CARD,   15, 11);
		assignItemRect(PATCHOULI_CARD,   15, 11);
		assignItemRect(STRENGTH_CARD,   15, 11);
		assignItemRect(UPGRADE_CARD,   15, 11);
		assignItemRect(DOREMY,   12, 14);
		assignItemRect(SUIKA,   12, 14);
		assignItemRect(HOURAI,   12, 14);
		assignItemRect(YUUMA,   12, 14);
	}

	private static final int TALISMANS =                               xy(1, 6);   //16 slots
	public static final int BACKDOOR = TALISMANS +0;
	public static final int BINDING        = TALISMANS +1;
	public static final int CIRNO       = TALISMANS +2;
	public static final int CUTTER      = TALISMANS +3;
	public static final int DEBILITATION = TALISMANS +4;
	public static final int INACCURATE = TALISMANS +5;
	public static final int DISORIENTATION      = TALISMANS +6;
	public static final int ENRAGING       = TALISMANS +7;
	public static final int FLANDRE      = TALISMANS +8;
	public static final int KAME = TALISMANS +9;
	public static final int KNOCKBACK      = TALISMANS +10;
	public static final int NIGHTINGALE = TALISMANS +11;
	public static final int RESET      = TALISMANS +12;
	public static final int SEVEN_DAYS = TALISMANS +13;
	public static final int SWAP      = TALISMANS +14;
	public static final int TRANSIENT = TALISMANS +15;

	static {
		for (int i = TALISMANS; i < TALISMANS +16; i++)
			assignItemRect(i, 12, 14);
	}

	private static final int WEP_CATEGORY1 =                               xy(1, 7);   //8 slots
	public static final int REIMU_GOHEI = WEP_CATEGORY1 +0;
	public static final int KYOUKO_BROOM     = WEP_CATEGORY1 +1;
	public static final int SANAE_EXORCISM_ROD = WEP_CATEGORY1 +2;
	public static final int MARISA_STAFF = WEP_CATEGORY1 +3;
	public static final int ROUKANKEN = WEP_CATEGORY1 +4;
	public static final int NITORI_ROD = WEP_CATEGORY1 +5;
	public static final int JEWELED_PAGODA   = WEP_CATEGORY1 +6;
	public static final int VENTORA_STICK = WEP_CATEGORY1 +7;
	public static final int TENGU_SHORTSWORD = WEP_CATEGORY1 +8;
	public static final int KOGASA_UMBRELLA = WEP_CATEGORY1 +9;
	public static final int RADIO = WEP_CATEGORY1 +10;
	public static final int MYSTIA_WING = WEP_CATEGORY1 +11;
	public static final int KOAKUMA_WING = WEP_CATEGORY1 +12;
	public static final int RINGO_DANGO = WEP_CATEGORY1 +13;
	public static final int SILKY_HAIR = WEP_CATEGORY1 +14;
	public static final int NAZRIN_ROD = WEP_CATEGORY1 +15;

	static{
		assignItemRect(REIMU_GOHEI, 13, 13);
		assignItemRect(KYOUKO_BROOM,    13, 13);
		assignItemRect(SANAE_EXORCISM_ROD, 13, 13);
		assignItemRect(MARISA_STAFF,     13, 13);
		assignItemRect(ROUKANKEN,     13, 13);
		assignItemRect(NITORI_ROD,      13, 13);
		assignItemRect(JEWELED_PAGODA,  11, 15);
		assignItemRect(VENTORA_STICK,      11, 14);
		assignItemRect(TENGU_SHORTSWORD,      11, 13);
		assignItemRect(KOGASA_UMBRELLA,        7, 13);
		assignItemRect(RADIO,           6, 9);
		assignItemRect(MYSTIA_WING,    13, 13);
		assignItemRect(KOAKUMA_WING,            12, 13);
		assignItemRect(RINGO_DANGO,      13, 13);
		assignItemRect(SILKY_HAIR,       13, 13);
		assignItemRect(NAZRIN_ROD,       13, 13);
	}

	private static final int WEP_CATEGOTY2 =                               xy(1, 8);   //8 slots
	public static final int SMALL_YING_YANG_ORB = WEP_CATEGOTY2 +0;
	public static final int EIKIROD = WEP_CATEGOTY2 +1;
	public static final int PALESWORD = WEP_CATEGOTY2 +2;
	public static final int YOUMU_HALF_PHANTOM = WEP_CATEGOTY2 +3;
	public static final int SKYSWORD = WEP_CATEGOTY2 +4;
	public static final int SHINMYOMARU_NEEDLE = WEP_CATEGOTY2 +5;
	public static final int AKYUU_BRUSH = WEP_CATEGOTY2 +6;
	public static final int GREEN_BAMBOO = WEP_CATEGOTY2 +7;
	public static final int MEDIUM_YING_YANG_ORB = WEP_CATEGOTY2+8;
	public static final int UTSUHOROD = WEP_CATEGOTY2+9;
	public static final int CIRNOWING = WEP_CATEGOTY2+10;
	public static final int REMILIA_WING = WEP_CATEGOTY2+11;
	public static final int RANTAIL = WEP_CATEGOTY2+12;
	public static final int YUKARI_UMBRELLA = WEP_CATEGOTY2+13;
	public static final int YUYUKO_FOLDING_FAN = WEP_CATEGOTY2+14;
	public static final int MURASA_DIPPER = WEP_CATEGOTY2+15;

	static{
		assignItemRect(SMALL_YING_YANG_ORB,           9, 9);
		assignItemRect(EIKIROD,            13, 13);
		assignItemRect(PALESWORD,        13, 13);
		assignItemRect(YOUMU_HALF_PHANTOM,    14, 13);
		assignItemRect(SKYSWORD,             13, 13);
		assignItemRect(SHINMYOMARU_NEEDLE,            13, 13);
		assignItemRect(AKYUU_BRUSH,      13, 13);
		assignItemRect(GREEN_BAMBOO, 13, 13);
		assignItemRect(MEDIUM_YING_YANG_ORB,     12, 12);
		assignItemRect(UTSUHOROD,      13, 13);
		assignItemRect(CIRNOWING,           13, 13);
		assignItemRect(REMILIA_WING,       13, 13);
		assignItemRect(RANTAIL, 9, 9);
		assignItemRect(YUKARI_UMBRELLA,        13, 13);
		assignItemRect(YUYUKO_FOLDING_FAN,10, 10);
		assignItemRect(MURASA_DIPPER,    13, 13);
	}

	private static final int WEP_CATEGORY3 =                               xy(1, 9);   //8 slots
	public static final int BIG_YING_YANG_ORB = WEP_CATEGORY3 +0;
	public static final int GOLDEN_EXORCISM_ROD = WEP_CATEGORY3 +1;
	public static final int TENGUSMARTPHONE = WEP_CATEGORY3 +2;
	public static final int SEIRANHAMMER = WEP_CATEGORY3 +3;
	public static final int JUNKOSWORD = WEP_CATEGORY3 +4;
	public static final int AYAFAN = WEP_CATEGORY3 +5;
	public static final int SWORDOFHISOU    = WEP_CATEGORY3 +6;
	public static final int IDOL_STICK = WEP_CATEGORY3 +7;
	public static final int KOMACHISCYTHE   = WEP_CATEGORY3 +8;
	public static final int FULL_MOON_SCYTHE = WEP_CATEGORY3 +9;
	public static final int JEWELEDBRANCH   = WEP_CATEGORY3 +10;
	public static final int DOREMY_DREAM    = WEP_CATEGORY3 +11;
	public static final int KOKOROFAN       = WEP_CATEGORY3 +12;
	public static final int LOG             = WEP_CATEGORY3 +13;
	public static final int TOYOHIME_FAN    = WEP_CATEGORY3 +14;
	public static final int YORIHIME_SWORD  = WEP_CATEGORY3 +15;

	static{
		assignItemRect(BIG_YING_YANG_ORB,   13, 13);
		assignItemRect(GOLDEN_EXORCISM_ROD,   13, 13);
		assignItemRect(TENGUSMARTPHONE,       8, 12);
		assignItemRect(SEIRANHAMMER,     12, 13);
		assignItemRect(JUNKOSWORD,  13, 13);
		assignItemRect(AYAFAN,    13, 13);
		assignItemRect(SWORDOFHISOU, 13, 13);
		assignItemRect(IDOL_STICK,   13, 13);
		assignItemRect(KOMACHISCYTHE,16, 13);
		assignItemRect(FULL_MOON_SCYTHE,    16, 13);
		assignItemRect(JEWELEDBRANCH, 13, 13);
		assignItemRect(DOREMY_DREAM,  14, 13);
		assignItemRect(KOKOROFAN,     10, 10);
		assignItemRect(LOG,           13, 13);
		assignItemRect(TOYOHIME_FAN,  10, 10);
		assignItemRect(YORIHIME_SWORD,13, 13);
	}

	private static final int DANMAKU_WEP =                               xy(1, 10);  //16 slots. 3 per tier + boomerang
	public static final int SCALE_DANMAKU = DANMAKU_WEP +0;
	public static final int REIMU_TALISMAN = DANMAKU_WEP +1;
	public static final int FLAME_DANMAKU = DANMAKU_WEP +2;
	public static final int RICE_DANMAKU = DANMAKU_WEP +3;
	public static final int KUNAI_DANMAKU = DANMAKU_WEP +4;
	public static final int SHARD_DANMAKU = DANMAKU_WEP +5;
	public static final int BULLET_DANMAKU = DANMAKU_WEP +6;
	public static final int INVERT_DANMAKU = DANMAKU_WEP +7;
	public static final int STAR_DANMAKU = DANMAKU_WEP +8;
	public static final int CIRNO_DANMAKU = DANMAKU_WEP +9;
	public static final int LUNATIC_DANMAKU = DANMAKU_WEP +10;
	public static final int EIKI_DANMAKU = DANMAKU_WEP +11;
	public static final int YUUKA_DANMAKU = DANMAKU_WEP +12;
	public static final int YOUMU_DANMAKU = DANMAKU_WEP +13;
	public static final int TEWI_DANMAKU = DANMAKU_WEP +14;
	public static final int REISEN_DANMAKU = DANMAKU_WEP +15;

	static{
		assignItemRect(SCALE_DANMAKU,   12, 14);
		assignItemRect(REIMU_TALISMAN,        12, 14);
		assignItemRect(FLAME_DANMAKU,   16, 16);
		assignItemRect(RICE_DANMAKU,  8, 14);
		assignItemRect(KUNAI_DANMAKU,           10, 16);
		assignItemRect(SHARD_DANMAKU,           10, 16);
		assignItemRect(BULLET_DANMAKU,         8, 16);
		assignItemRect(INVERT_DANMAKU,        8, 16);
		assignItemRect(STAR_DANMAKU,       16, 15);
		assignItemRect(CIRNO_DANMAKU,         16, 7);
		assignItemRect(LUNATIC_DANMAKU, 16, 16);
		assignItemRect(EIKI_DANMAKU,      16, 13);
		assignItemRect(YUUKA_DANMAKU,       16, 16);
		assignItemRect(YOUMU_DANMAKU,         14, 13);
		assignItemRect(TEWI_DANMAKU, 16, 6);
		assignItemRect(REISEN_DANMAKU,      16, 9);
	}

	public static final int TIPPED_DARTS_AND_KNIFE =                               xy(1, 11);  //16 slots

	public static final int DART   = TIPPED_DARTS_AND_KNIFE +0;
	public static final int ROT_DART        = TIPPED_DARTS_AND_KNIFE +1;
	public static final int INCENDIARY_DART = TIPPED_DARTS_AND_KNIFE +2;
	public static final int ADRENALINE_DART = TIPPED_DARTS_AND_KNIFE +3;
	public static final int HEALING_DART    = TIPPED_DARTS_AND_KNIFE +4;
	public static final int CHILLING_DART   = TIPPED_DARTS_AND_KNIFE +5;
	public static final int SHOCKING_DART   = TIPPED_DARTS_AND_KNIFE +6;
	public static final int POISON_DART     = TIPPED_DARTS_AND_KNIFE +7;
	public static final int CLEANSING_DAST      = TIPPED_DARTS_AND_KNIFE +8;
	public static final int PARALYTIC_DART  = TIPPED_DARTS_AND_KNIFE +9;
	public static final int HOLY_DART       = TIPPED_DARTS_AND_KNIFE +10;
	public static final int DISPLACING_DART = TIPPED_DARTS_AND_KNIFE +11;
	public static final int BLINDING_DART   = TIPPED_DARTS_AND_KNIFE +12;
	public static final int RED_KNIFE = TIPPED_DARTS_AND_KNIFE +13;
	public static final int GREEN_KNIFE = TIPPED_DARTS_AND_KNIFE +14;
	public static final int BLUE_KNIFE = TIPPED_DARTS_AND_KNIFE +15;
	static {
		for (int i = TIPPED_DARTS_AND_KNIFE; i < TIPPED_DARTS_AND_KNIFE +13; i++) {
			assignItemRect(i, 15, 15); // Tipped darts
		}
		for (int i = TIPPED_DARTS_AND_KNIFE + 13; i < TIPPED_DARTS_AND_KNIFE + 3; i++){
			assignItemRect(i, 13, 13);// Knives
		}
	}

	private static final int ARMOR_CATEGORY1 =                               xy(1, 12);  //16 slots
	public static final int ARMOR_CLOTH     = ARMOR_CATEGORY1 +0;
	public static final int ARMOR_LEATHER   = ARMOR_CATEGORY1 +1;
	public static final int ARMOR_MAIL      = ARMOR_CATEGORY1 +2;
	public static final int ARMOR_SCALE     = ARMOR_CATEGORY1 +3;
	public static final int ARMOR_PLATE     = ARMOR_CATEGORY1 +4;
	public static final int ARMOR_PC98REIMU   = ARMOR_CATEGORY1 +5;
	public static final int ARMOR_PC98MARISA      = ARMOR_CATEGORY1 +6;
	public static final int ARMOR_YORIHIME    = ARMOR_CATEGORY1 +7;
	public static final int ARMOR_TOYOHIME  = ARMOR_CATEGORY1 +8;
	public static final int ARMOR_RUMIA    = ARMOR_CATEGORY1 +9;
	public static final int ARMOR_HANASAKIGAWA    = ARMOR_CATEGORY1 +10;
	public static final int ARMOR_YUYUKO    = ARMOR_CATEGORY1 +11;
	public static final int ARMOR_HECATIA    = ARMOR_CATEGORY1 +12;
	public static final int ARMOR_POPPINPARTY    = ARMOR_CATEGORY1 +13;
	public static final int ARMOR_MAXWELL    = ARMOR_CATEGORY1 +14;
	public static final int ARMOR_GOLDENDRAGON    = ARMOR_CATEGORY1 +15;
	static{
		assignItemRect(ARMOR_CLOTH,     9, 13);
		assignItemRect(ARMOR_LEATHER,   9, 13);
		assignItemRect(ARMOR_MAIL,      9, 13);
		assignItemRect(ARMOR_SCALE,     9, 13);
		assignItemRect(ARMOR_PLATE,     9, 13);
		assignItemRect(ARMOR_PC98REIMU,   9, 13);
		assignItemRect(ARMOR_PC98MARISA,      9, 13);
		assignItemRect(ARMOR_YORIHIME,     9, 13);
		assignItemRect(ARMOR_TOYOHIME,  9, 13);
		assignItemRect(ARMOR_RUMIA,    9, 13);
		assignItemRect(ARMOR_HANASAKIGAWA,    9, 13);
		assignItemRect(ARMOR_YUYUKO,    9, 13);
		assignItemRect(ARMOR_HECATIA,    9, 13);
		assignItemRect(ARMOR_POPPINPARTY,    9, 13);
		assignItemRect(ARMOR_MAXWELL,    9, 13);
		assignItemRect(ARMOR_GOLDENDRAGON,    9, 13);
	}

	private static final int WEP_CATEGORY4 =                               xy(1, 13);   //8 slots
	public static final int SUPER_MIRACLE_MALLET    = WEP_CATEGORY4 +0;
	public static final int KOGASA_ROD    = WEP_CATEGORY4 +1;
	public static final int TORAMARU_SPEAR    = WEP_CATEGORY4 +2;
	public static final int ENMA_SHAKU    = WEP_CATEGORY4 +3;
	public static final int SEVEN_STAR_SWORD    = WEP_CATEGORY4 +4;
	public static final int WATERMELON_SWORD    = WEP_CATEGORY4 +5;
	public static final int FLINTLOCK   = WEP_CATEGORY4 +6;
	public static final int MOMOYO_SHOVEL    = WEP_CATEGORY4 +7;
	public static final int WINDGOD_FAN    = WEP_CATEGORY4 +8;
	public static final int SAGUME_WING    = WEP_CATEGORY4 +9;
	public static final int HISOUTEN_MANKIND    = WEP_CATEGORY4 +10;
	public static final int KOISHI_SWORD    = WEP_CATEGORY4 +11;
	public static final int HECATIA_STAR    = WEP_CATEGORY4 +12;
	public static final int YUUKA_UMBRELLA  = WEP_CATEGORY4 +13;
	public static final int PHOENIX_TAIL    = WEP_CATEGORY4 +14;
	public static final int LEVATEIN        = WEP_CATEGORY4 +15;

	static{
		assignItemRect(SUPER_MIRACLE_MALLET,      12, 13);
		assignItemRect(KOGASA_ROD,      13, 13);
		assignItemRect(TORAMARU_SPEAR,      13, 13);
		assignItemRect(ENMA_SHAKU,      13, 13);
		assignItemRect(SEVEN_STAR_SWORD,      13, 13);
		assignItemRect(WATERMELON_SWORD,      13, 13);
		assignItemRect(FLINTLOCK,      13, 13);
		assignItemRect(MOMOYO_SHOVEL,      13, 13);
		assignItemRect(WINDGOD_FAN,      13, 13);
		assignItemRect(SAGUME_WING,      13, 13);
		assignItemRect(HISOUTEN_MANKIND,      13, 13);
		assignItemRect(KOISHI_SWORD,      13, 13);
		assignItemRect(HECATIA_STAR,  14, 15);
		assignItemRect(YUUKA_UMBRELLA,14, 14);
		assignItemRect(PHOENIX_TAIL,  12, 13);
		assignItemRect(LEVATEIN,      13, 13);
	}

	private static final int ARTIFACTS          =                            xy(1, 14);  //32 slots
	public static final int ARTIFACT_CLOAK      = ARTIFACTS+0;
	public static final int ARTIFACT_ARMBAND    = ARTIFACTS+1;
	public static final int ARTIFACT_CAPE       = ARTIFACTS+2;
	public static final int ARTIFACT_TALISMAN   = ARTIFACTS+3;
	public static final int ARTIFACT_HOURGLASS  = ARTIFACTS+4;
	public static final int ARTIFACT_TOOLKIT    = ARTIFACTS+5;
	public static final int ARTIFACT_SPELLBOOK  = ARTIFACTS+6;
	public static final int ARTIFACT_BEACON     = ARTIFACTS+7;
	public static final int ARTIFACT_CHAINS     = ARTIFACTS+8;
	public static final int ARTIFACT_HORN1      = ARTIFACTS+9;
	public static final int ARTIFACT_HORN2      = ARTIFACTS+10;
	public static final int ARTIFACT_HORN3      = ARTIFACTS+11;
	public static final int ARTIFACT_HORN4      = ARTIFACTS+12;
	public static final int ARTIFACT_CHALICE1   = ARTIFACTS+13;
	public static final int ARTIFACT_CHALICE2   = ARTIFACTS+14;
	public static final int ARTIFACT_CHALICE3   = ARTIFACTS+15;
	public static final int ARTIFACT_SANDALS    = ARTIFACTS+16;
	public static final int ARTIFACT_SHOES      = ARTIFACTS+17;
	public static final int ARTIFACT_BOOTS      = ARTIFACTS+18;
	public static final int ARTIFACT_GREAVES    = ARTIFACTS+19;

	static {
		assignItemRect(ARTIFACT_CLOAK, 9, 15);
		assignItemRect(ARTIFACT_ARMBAND, 16, 13);
		assignItemRect(ARTIFACT_CAPE, 16, 14);
		assignItemRect(ARTIFACT_TALISMAN, 15, 13);
		assignItemRect(ARTIFACT_HOURGLASS, 13, 16);
		assignItemRect(ARTIFACT_TOOLKIT, 15, 13);
		assignItemRect(ARTIFACT_SPELLBOOK, 13, 16);
		assignItemRect(ARTIFACT_BEACON, 16, 16);
		assignItemRect(ARTIFACT_CHAINS, 16, 16);
		assignItemRect(ARTIFACT_HORN1, 15, 15);
		assignItemRect(ARTIFACT_HORN2, 15, 15);
		assignItemRect(ARTIFACT_HORN3, 15, 15);
		assignItemRect(ARTIFACT_HORN4, 15, 15);
		assignItemRect(ARTIFACT_CHALICE1, 12, 15);
		assignItemRect(ARTIFACT_CHALICE2, 12, 15);
		assignItemRect(ARTIFACT_CHALICE3, 12, 15);
		assignItemRect(ARTIFACT_SANDALS, 16, 6);
		assignItemRect(ARTIFACT_SHOES, 16, 6);
		assignItemRect(ARTIFACT_BOOTS, 16, 9);
		assignItemRect(ARTIFACT_GREAVES, 16, 14);
	}

	private static final int ARMOR_CATEGORY2 =                            xy(1, 15);  //16 slots
	public static final int NITORI_ARMOR      = ARMOR_CATEGORY2+4;
	public static final int SHARK_ARMOR      = ARMOR_CATEGORY2+5;
	public static final int MORFONICA_ARMOR      = ARMOR_CATEGORY2+6;
	public static final int NARUMI_ARMOR      = ARMOR_CATEGORY2+7;
	public static final int OKINA_ARMOR      = ARMOR_CATEGORY2+8;
	public static final int KEIKI_ARMOR      = ARMOR_CATEGORY2+9;
	public static final int SATONO_ARMOR      = ARMOR_CATEGORY2+10;
	public static final int MAI_ARMOR      = ARMOR_CATEGORY2+11;
	public static final int SHION_FAN      = ARMOR_CATEGORY2+12;
	public static final int JOON_FAN      = ARMOR_CATEGORY2+13;
	public static final int DAY_ARMOR      = ARMOR_CATEGORY2+14;
	public static final int NIGHT_ARMOR      = ARMOR_CATEGORY2+15;

	static {
		assignItemRect(NITORI_ARMOR, 9, 13);
		assignItemRect(SHARK_ARMOR, 9, 13);
		assignItemRect(MORFONICA_ARMOR, 9, 13);
		assignItemRect(NARUMI_ARMOR, 9, 13);
		assignItemRect(OKINA_ARMOR, 9, 13);
		assignItemRect(KEIKI_ARMOR, 9, 13);
		assignItemRect(SATONO_ARMOR, 9, 13);
		assignItemRect(MAI_ARMOR, 9, 13);
		assignItemRect(SHION_FAN,      11, 15);
		assignItemRect(JOON_FAN,      11, 15);
		assignItemRect(DAY_ARMOR, 9, 13);
		assignItemRect(NIGHT_ARMOR, 9, 13);
	}

	private static final int MISC_AND_ARMOR_CATEGORY3 =                            xy(1, 16);  //16 slots
	public static final int SCROLL_CATALYST = MISC_AND_ARMOR_CATEGORY3 +0;
	public static final int ARCANE_RESIN    = MISC_AND_ARMOR_CATEGORY3 +1;
	public static final int POTION_CATALYST = MISC_AND_ARMOR_CATEGORY3 +2;
	public static final int LIQUID_METAL    = MISC_AND_ARMOR_CATEGORY3 +3;
	public static final int DEFENSE_YINGYANGORB = MISC_AND_ARMOR_CATEGORY3 +5;
	public static final int TRICK_CLOAK = MISC_AND_ARMOR_CATEGORY3 +7;
	public static final int ARMOR_KOGASA = MISC_AND_ARMOR_CATEGORY3 +8;
	public static final int ARMOR_MURASA = MISC_AND_ARMOR_CATEGORY3 +9;
	public static final int WATER_CUTTER = MISC_AND_ARMOR_CATEGORY3 +10;
	public static final int HELLBANE = MISC_AND_ARMOR_CATEGORY3 +11;
	public static final int ANTI_TENSAI_SWORD = MISC_AND_ARMOR_CATEGORY3 +12;
	public static final int ANTI_HARASSMENT_DAGGER = MISC_AND_ARMOR_CATEGORY3 +13;
	public static final int POPULAR_STICK = MISC_AND_ARMOR_CATEGORY3 +14;

	static {
		for (int i = MISC_AND_ARMOR_CATEGORY3; i < MISC_AND_ARMOR_CATEGORY3 + 16; i++)
			assignItemRect(i, 11, 15);
		assignItemRect(SCROLL_CATALYST, 12, 11);
		assignItemRect(ARCANE_RESIN, 12, 11);
		assignItemRect(POTION_CATALYST, 10, 15);
		assignItemRect(LIQUID_METAL, 10, 15);
		assignItemRect(DEFENSE_YINGYANGORB, 12, 12);
		assignItemRect(TRICK_CLOAK, 14, 14);
		assignItemRect(ARMOR_KOGASA, 9, 13);
		assignItemRect(ARMOR_MURASA, 9, 13);
		assignItemRect(WATER_CUTTER, 13, 15);
		assignItemRect(HELLBANE, 13, 15);
		assignItemRect(ANTI_TENSAI_SWORD, 15, 16);
		assignItemRect(ANTI_HARASSMENT_DAGGER, 13, 13);
		assignItemRect(POPULAR_STICK, 7, 14);
	}

	private static final int POTIONS        =                               xy(1, 17);  //17 slots
	public static final int POTION_CRIMSON  = POTIONS+0;
	public static final int POTION_AMBER    = POTIONS+1;
	public static final int POTION_GOLDEN   = POTIONS+2;
	public static final int POTION_JADE     = POTIONS+3;
	public static final int POTION_TURQUOISE= POTIONS+4;
	public static final int POTION_AZURE    = POTIONS+5;
	public static final int POTION_INDIGO   = POTIONS+6;
	public static final int POTION_MAGENTA  = POTIONS+7;
	public static final int POTION_BISTRE   = POTIONS+8;
	public static final int POTION_CHARCOAL = POTIONS+9;
	public static final int POTION_SILVER   = POTIONS+10;
	public static final int POTION_IVORY    = POTIONS+11;
	public static final int POTION_PINK     = POTIONS+12;
	public static final int POTION_YELLOW   = POTIONS+13;
	public static final int POTION_SPECTRAL = POTIONS+14;
	public static final int POTION_GREEN    = POTIONS+15;

	static {
		for (int i = POTIONS; i < POTIONS+16; i++)
			assignItemRect(i, 10, 15);
	}

	private static final int EXOTIC_POTIONS =                               xy(1, 18);  //17 slots
	public static final int EXOTIC_CRIMSON  = EXOTIC_POTIONS+0;
	public static final int EXOTIC_AMBER    = EXOTIC_POTIONS+1;
	public static final int EXOTIC_GOLDEN   = EXOTIC_POTIONS+2;
	public static final int EXOTIC_JADE     = EXOTIC_POTIONS+3;
	public static final int EXOTIC_TURQUOISE= EXOTIC_POTIONS+4;
	public static final int EXOTIC_AZURE    = EXOTIC_POTIONS+5;
	public static final int EXOTIC_INDIGO   = EXOTIC_POTIONS+6;
	public static final int EXOTIC_MAGENTA  = EXOTIC_POTIONS+7;
	public static final int EXOTIC_BISTRE   = EXOTIC_POTIONS+8;
	public static final int EXOTIC_CHARCOAL = EXOTIC_POTIONS+9;
	public static final int EXOTIC_SILVER   = EXOTIC_POTIONS+10;
	public static final int EXOTIC_IVORY    = EXOTIC_POTIONS+11;
	public static final int EXOTIC_PINK     = EXOTIC_POTIONS+12;
	public static final int EXOTIC_YELLOW   = EXOTIC_POTIONS+13;
	public static final int EXOTIC_SPECTRAL = EXOTIC_POTIONS+14;
	public static final int EXOTIC_GREEN    = EXOTIC_POTIONS+15;

	static {
		for (int i = EXOTIC_POTIONS; i < EXOTIC_POTIONS+16; i++)
			assignItemRect(i, 10, 15);
	}

	private static final int STONES             =                           xy(1, 21);  //16 slots
	public static final int STONE_AGGRESSION    = STONES+0;
	public static final int STONE_AUGMENTATION  = STONES+1;
	public static final int STONE_FEAR          = STONES+2;
	public static final int STONE_MADNESS = STONES+3;
	public static final int STONE_BLINK         = STONES+4;
	public static final int STONE_CLAIRVOYANCE  = STONES+5;
	public static final int STONE_SLEEP         = STONES+6;
	public static final int STONE_DISARM        = STONES+7;
	public static final int STONE_ENCHANT       = STONES+8;
	public static final int STONE_FLOCK         = STONES+9;
	public static final int STONE_INTUITION     = STONES+10;
	public static final int STONE_SHOCK         = STONES+11;
	public static final int STONE_NIXER         = STONES+12;

	static {
		for (int i = STONES; i < STONES+16; i++)
			assignItemRect(i, 14, 12);
	}

	private static final int SEEDS              =                           xy(1, 22);  //17 slots
	public static final int SEED_ROTBERRY       = SEEDS+0;
	public static final int SEED_FIREBLOOM      = SEEDS+1;
	public static final int SEED_SWIFTTHISTLE   = SEEDS+2;
	public static final int SEED_SUNGRASS       = SEEDS+3;
	public static final int SEED_ICECAP         = SEEDS+4;
	public static final int SEED_STORMVINE      = SEEDS+5;
	public static final int SEED_SORROWMOSS     = SEEDS+6;
	public static final int SEED_DREAMFOIL      = SEEDS+7;
	public static final int SEED_EARTHROOT      = SEEDS+8;
	public static final int SEED_STARFLOWER     = SEEDS+9;
	public static final int SEED_FADELEAF       = SEEDS+10;
	public static final int SEED_BLINDWEED      = SEEDS+11;
	public static final int SEED_MIGHTSEED      = SEEDS+12;

	static{
		for (int i = SEEDS; i < SEEDS+16; i++)
			assignItemRect(i, 10, 10);
	}

	private static final int BREWS_AND_ELIXIR =                               xy(1, 24);  //8 slots
	public static final int BREW_INFERNAL   = BREWS_AND_ELIXIR +0;
	public static final int BREW_BLIZZARD   = BREWS_AND_ELIXIR +1;
	public static final int BREW_SHOCKING   = BREWS_AND_ELIXIR +2;
	public static final int ELIXIR_BOSS_KILLER = BREWS_AND_ELIXIR+4;
	public static final int ELIXIR_HONEY    = BREWS_AND_ELIXIR+5;
	public static final int ELIXIR_AQUA     = BREWS_AND_ELIXIR+6;
	public static final int ELIXIR_MIGHT    = BREWS_AND_ELIXIR+7;
	public static final int ELIXIR_DRAGON   = BREWS_AND_ELIXIR+8;
	public static final int ELIXIR_TOXIC    = BREWS_AND_ELIXIR+9;
	public static final int ELIXIR_ICY      = BREWS_AND_ELIXIR+10;
	public static final int ELIXIR_ARCANE   = BREWS_AND_ELIXIR+11;
	public static final int ELIXIR_ZEN   = BREWS_AND_ELIXIR+12;
	public static final int ELIXIR_NULL1   = BREWS_AND_ELIXIR+13;
	public static final int ELIXIR_NULL2   = BREWS_AND_ELIXIR+14;
	public static final int ELIXIR_NULL3   = BREWS_AND_ELIXIR+15;
	static{
		for (int i = BREWS_AND_ELIXIR; i < BREWS_AND_ELIXIR +16; i++)
			assignItemRect(i, 12, 14);
	}

	private static final int SPELLS         =                               xy(1, 25);  //16 slots
	public static final int MAGIC_PORTER    = SPELLS+0;
	public static final int PHASE_SHIFT     = SPELLS+1;
	public static final int TELE_GRAB       = SPELLS+2;
	public static final int WILD_ENERGY     = SPELLS+3;
	public static final int RETURN_BEACON   = SPELLS+4;
	public static final int SUMMON_ELE      = SPELLS+5;
	public static final int KOGASA_HAMMER   = SPELLS+6;
	public static final int AQUA_BLAST      = SPELLS+7;
	public static final int RECLAIM_TRAP    = SPELLS+8;
	public static final int FEATHER_FALL    = SPELLS+9;
	public static final int CURSE_INFUSE    = SPELLS+10;
	public static final int MAGIC_INFUSE    = SPELLS+11;
	public static final int ALCHEMIZE       = SPELLS+12;
	public static final int RECYCLE         = SPELLS+13;
	public static final int THROWING_KNIFE   = SPELLS +14;
	public static final int SPYGLASS   = SPELLS +15;
	static{
		assignItemRect(MAGIC_PORTER,    12, 11);
		assignItemRect(PHASE_SHIFT,     12, 11);
		assignItemRect(TELE_GRAB,       12, 11);
		assignItemRect(WILD_ENERGY,     8, 16);
		assignItemRect(RETURN_BEACON,   8, 16);
		assignItemRect(SUMMON_ELE,      8, 16);
		assignItemRect(KOGASA_HAMMER,   16, 16);
		assignItemRect(AQUA_BLAST,      11, 11);
		assignItemRect(RECLAIM_TRAP,    11, 11);
		assignItemRect(FEATHER_FALL,    11, 11);
		assignItemRect(CURSE_INFUSE,    10, 15);
		assignItemRect(MAGIC_INFUSE,    10, 15);
		assignItemRect(ALCHEMIZE,       10, 15);
		assignItemRect(RECYCLE,         10, 15);
		assignItemRect(THROWING_KNIFE,  13, 13);
		assignItemRect(SPYGLASS,        15, 7);
	}

	private static final int FOOD       =                                   xy(1, 26);  //16 slots
	public static final int MEAT        = FOOD+0;
	public static final int STEAK       = FOOD+1;
	public static final int STEWED      = FOOD+2;
	public static final int OVERPRICED  = FOOD+3;
	public static final int CARPACCIO   = FOOD+4;
	public static final int RATION      = FOOD+5;
	public static final int PASTY       = FOOD+6;
	public static final int GRILLED_RATION = FOOD+7;
	public static final int ROTTEN_RATION = FOOD+8;
	public static final int MEAT_PIE    = FOOD+9;
	public static final int BLANDFRUIT  = FOOD+10;
	public static final int BLAND_CHUNKS= FOOD+11;
	public static final int BERRY =       FOOD+12;
	public static final int WAFFLE =       FOOD+13;
	public static final int MIRACLE_FRUIT =       FOOD+14;
	public static final int PANCAKE =       FOOD+15;
	static{
		assignItemRect(MEAT,        15, 11);
		assignItemRect(STEAK,       15, 11);
		assignItemRect(STEWED,      15, 11);
		assignItemRect(OVERPRICED,  14, 11);
		assignItemRect(CARPACCIO,   15, 11);
		assignItemRect(RATION,      16, 12);
		assignItemRect(PASTY,       16, 11);
		assignItemRect(GRILLED_RATION, 16, 12);
		assignItemRect(ROTTEN_RATION,  16, 12);
		assignItemRect(MEAT_PIE,    16, 12);
		assignItemRect(BLANDFRUIT,  9,  12);
		assignItemRect(BLAND_CHUNKS,14, 6);
		assignItemRect(BERRY,       9,  11);
		assignItemRect(WAFFLE,    16, 12);
		assignItemRect(MIRACLE_FRUIT,    16, 12);
		assignItemRect(PANCAKE,    16, 12);
	}

	private static final int BAGS_AND_MISC =                                   xy(1, 27);  //16 slots
	public static final int POUCH       = BAGS_AND_MISC +0;
	public static final int HOLDER      = BAGS_AND_MISC +1;
	public static final int BANDOLIER   = BAGS_AND_MISC +2;
	public static final int HOLSTER     = BAGS_AND_MISC +3;
	public static final int VIAL        = BAGS_AND_MISC +4;
	public static final int PRAYER       = BAGS_AND_MISC +5;
	public static final int FOOD_HOLD = BAGS_AND_MISC +6;
	public static final int ARTI_HOLD = BAGS_AND_MISC +7;
	public static final int HAKUREI_HOLD = BAGS_AND_MISC +8;
	public static final int OMINOUS_GAP  = BAGS_AND_MISC +9;
	public static final int KAGUYA_HD_CHEST = BAGS_AND_MISC +10;
	public static final int KANAKO_CRYSTAL = BAGS_AND_MISC +11;
	public static final int SUWAKO_RELIC = BAGS_AND_MISC +12;

	static{
		assignItemRect(POUCH,       14, 15);
		assignItemRect(HOLDER,      16, 16);
		assignItemRect(BANDOLIER,   15, 16);
		assignItemRect(HOLSTER,     15, 16);
		assignItemRect(VIAL,        12, 12);
		assignItemRect(PRAYER,       13, 13);
		assignItemRect(FOOD_HOLD,       14, 15);
		assignItemRect(ARTI_HOLD,       14, 15);
		assignItemRect(HAKUREI_HOLD,       14, 15);
		assignItemRect(OMINOUS_GAP,       16, 9);
		assignItemRect(KAGUYA_HD_CHEST,       15, 14);
		assignItemRect(KANAKO_CRYSTAL,         10, 15);
		assignItemRect(SUWAKO_RELIC,         16, 10);
	}

	private static final int WEP_CATEGORY5 =                                   xy(1, 28);
	public static final int OLD_FIREBRAND        = WEP_CATEGORY5 +0;
	public static final int OLD_FROSTBRAND        = WEP_CATEGORY5 +1;
	public static final int BLAZING_STAR        = WEP_CATEGORY5 +2;
	public static final int WOODEN_BAT        = WEP_CATEGORY5 +3;
	public static final int HOSHIGUMA_HORN        = WEP_CATEGORY5 +4;
	public static final int PLAY_MAT        = WEP_CATEGORY5 +5;
	public static final int TURNABOUT_CLOAK        = WEP_CATEGORY5 +6;
	public static final int BAMBOO_SWORD        = WEP_CATEGORY5 +7;
	public static final int YACHIE_HORN        = WEP_CATEGORY5 +8;
	public static final int AUTUMN_KATANA        = WEP_CATEGORY5 +9;
	public static final int GRAYSWANDIR        = WEP_CATEGORY5 +10;
	public static final int BUTTERFLY_FAN        = WEP_CATEGORY5 +11;
	public static final int YUKINA_MIC        = WEP_CATEGORY5 +12;
	public static final int RUSTY_ROUKANKEN        = WEP_CATEGORY5 +13;

	static {
		assignItemRect(OLD_FIREBRAND, 13, 13);
		assignItemRect(OLD_FROSTBRAND, 13, 13);
		assignItemRect(BLAZING_STAR, 13, 13);
		assignItemRect(WOODEN_BAT, 13, 13);
		assignItemRect(HOSHIGUMA_HORN, 13, 13);
		assignItemRect(PLAY_MAT, 13, 13);
		assignItemRect(TURNABOUT_CLOAK, 14, 14);
		assignItemRect(BAMBOO_SWORD, 13, 13);
		assignItemRect(YACHIE_HORN, 13, 13);
		assignItemRect(AUTUMN_KATANA, 13, 13);
		assignItemRect(GRAYSWANDIR, 13, 13);
		assignItemRect(BUTTERFLY_FAN, 13, 13);
		assignItemRect(YUKINA_MIC, 13, 13);
		assignItemRect(RUSTY_ROUKANKEN, 13, 13);
	}

	private static final int WANDS              =                           xy(1, 29);  //16 slots
	public static final int WAND_FIREBOLT  = WANDS+0;
	public static final int WAND_CORROSION  = WANDS+1;
	public static final int WAND_LIGHTNING          = WANDS+2;
	public static final int WAND_REGROWTH       = WANDS+3;
	public static final int WAND_FROST = WANDS+4;
	public static final int WAND_PRISMATIC_LIGHT= WANDS+5;
	public static final int WAND_MAGIC_MISSILE      = WANDS+6;
	public static final int WAND_LIVING_EARTH   = WANDS+7;
	public static final int WAND_BLAST_WAVE     = WANDS+8;
	public static final int WAND_CORRUPTION     = WANDS+9;
	public static final int WAND_WARDING        = WANDS+10;
	public static final int WAND_DISINTEGRATION      = WANDS+11;
	public static final int WAND_ANTI_DOOR    = WANDS+13;
	public static final int WAND_MIND_BURST = WANDS+16;
	public static final int WAND_HEAL_WOUNDS = WANDS+17;
	public static final int WAND_SETSUNA_TRIP = WANDS+21;
	static {
		for (int i = WANDS; i < WANDS+312; i++)
			assignItemRect(i, 14, 14);
	}

	private static final int CARDSA       =                               xy(1, 33);  //16 slots
	public static final int CARDS_NAZRIN_GOLD_MONEY = CARDSA+0;
	public static final int CARDS_NAZRIN_ALCHEMY_MONEY = CARDSA+1;
	public static final int CARDS_LIFE_CARD = CARDSA+2;
	public static final int CARDS_KEIKI_CREATION = CARDSA+3;
	public static final int CARDS_SHION_UCHIWA = CARDSA+4;
	public static final int CARDS_DOREMY_SHEEP = CARDSA+5;
	public static final int CARDS_YING_YANG_ORB = CARDSA+6;
	public static final int CARDS_YING_YANG_ORB_NEEDLE = CARDSA+7;
	public static final int CARDS_MINI_HAKKERO = CARDSA+8;
	public static final int CARDS_MINI_HAKKERO_MISSILE = CARDSA+9;
	public static final int CARDS_MAID_KNIFE = CARDSA+10;
	public static final int CARDS_MAID_KNIFE_RICOCHET = CARDSA+11;
	public static final int CARDS_SANAE_AMULET = CARDSA+12;
	public static final int CARDS_SANAE_AMULET_ALT = CARDSA+13;
	public static final int CARDS_HALF_GHOST = CARDSA+14;
	public static final int CARDS_HALF_GHOST_SPARE = CARDSA+15;

	static {
		for (int i = CARDSA; i < CARDSA+16; i++)
			assignItemRect(i, 12, 16);
	}

	private static final int CARDSB       =                               xy(1, 34);  //16 slots
	public static final int CARDS_SHANGHAI_DOLL = CARDSB+0;
	public static final int CARDS_ICE_FAIRY = CARDSB+1;
	public static final int CARDS_STAR_CARD = CARDSB+2;
	public static final int CARDS_LUNA_CARD = CARDSB+3;
	public static final int CARDS_SUNNY_CARD = CARDSB+4;
	public static final int CARDS_LARVA_SCALE = CARDSB+5;
	public static final int CARDS_NEMUNO_KNIFE = CARDSB+6;
	public static final int CARDS_SEIRAN_BLEEDING_HAMMER = CARDSB+7;
	public static final int CARDS_OKINA_BACKDOOR = CARDSB+8;
	public static final int CARDS_ANNOYING_UFO = CARDSB+9;
	public static final int CARDS_ANCIENT_MAGATAMA = CARDSB+10;
	public static final int CARDS_SHOU_PAGODA = CARDSB+11;
	public static final int CARDS_SEKIBANKI_HEAD = CARDSB+12;
	public static final int CARDS_TEACUP_REIMU = CARDSB+13;
	public static final int CARDS_TEACUP_MARISA = CARDSB+14;
	public static final int CARDS_BLANK_CARD = CARDSB+15;

	static {
		for (int i = CARDSB; i < CARDSB+16; i++)
			assignItemRect(i, 12, 16);
	}

	private static final int CARDSC       =                               xy(1, 35);  //16 slots
	public static final int CARDS_NITORI_DILEMMA = CARDSC+0;
	public static final int CARDS_RINGO_BRAND_DANGO = CARDSC+1;
	public static final int CARDS_HIJIRI_SUTRA = CARDSC+2;
	public static final int CARDS_FLANDRE_DESTRUCTION = CARDSC+3;
	public static final int CARDS_DRAGON_PASSAGE = CARDSC+4;
	public static final int CARDS_AUNN_HOUNDS = CARDSC+5;
	public static final int CARDS_GALE_GETA = CARDSC+6;
	public static final int CARDS_EIRIN_ELIXIR = CARDSC+7;
	public static final int CARDS_MINORIKO_CROP = CARDSC+8;
	public static final int CARDS_PHOENIX_TAIL = CARDSC+9;
	public static final int CARDS_EIKI_MONEY = CARDSC+10;
	public static final int CARDS_MISER_ADVICE = CARDSC+11;
	public static final int CARDS_KANAKO_OFFERING = CARDSC+12;
	public static final int CARDS_YACHIE_THREAT = CARDSC+13;
	public static final int CARDS_KAGUYA_STASH = CARDSC+14;
	public static final int CARDS_TEWI_FOOT = CARDSC+15;
	static {
		for (int i = CARDSC; i < CARDSC+16; i++)
			assignItemRect(i, 12, 16);
	}

	private static final int CARDSD       =                               xy(1, 36);  //16 slots
	public static final int CARDS_PEBBLE_HAT = CARDSD+0;
	public static final int CARDS_DANMAKU_GHOST = CARDSD+1;
	public static final int CARDS_SUWAKO_FROG = CARDSD+2;
	public static final int CARDS_DRAGON_PIPE = CARDSD+3;
	public static final int CARDS_MOMOYO_CENTIPEDE = CARDSD+4;
	public static final int CARDS_SUIKA_GOURD = CARDSD+5;
	public static final int CARDS_LIFE_BURNING_TORCH = CARDSD+6;
	public static final int CARDS_IRRESISTIBLE_FAN = CARDSD+7;
	public static final int CARDS_PRISTINE_CONFIDENCE = CARDSD+8;
	public static final int CARDS_SCREEN_BORDER = CARDSD+9;
	public static final int CARDS_MIRACLE_MALLET = CARDSD+10;
	public static final int CARDS_TENSHI_KEYSTONE = CARDSD+11;
	public static final int CARDS_CLOWNPIECE_MOON = CARDSD+12;
	public static final int CARDS_MIKO_AUTHORITY = CARDSD+13;
	public static final int CARDS_VAMPIRE_FANG = CARDSD+14;
	public static final int CARDS_UNDERGROUND_SUN = CARDSD+15;

	static {
		for (int i = CARDSD; i < CARDSD+16; i++)
			assignItemRect(i, 12, 16);
	}

	private static final int CARDSE       =                               xy(1, 37);  //17 slots
	public static final int CARDS_ITEM_SEASON = CARDSE+0;
	public static final int CARDS_SPIRIT_BOTTLE = CARDSE+1;
	public static final int CARDS_MEGUMU_BARLEY_RICE = CARDSE+2;
	public static final int CARDS_SMELT_SCALE = CARDSE+3;
	public static final int CARDS_TOO_HONEST_SIGNPOST = CARDSE+4;
	public static final int CARDS_Komachi_Detour = CARDSE+5;
	public static final int CARDS71       = CARDSE+6;
	public static final int CARDS72       = CARDSE+7;
	public static final int CARDS73       = CARDSE+8;
	public static final int CARDS74       = CARDSE+9;
	public static final int CARDS75       = CARDSE+10;
	public static final int CARDS76       = CARDSE+11;
	public static final int CARDS77       = CARDSE+12;
	public static final int CARDS78       = CARDSE+13;

	static {
		for (int i = CARDSE; i < CARDSE+16; i++)
			assignItemRect(i, 12, 16);
	}

	//for smaller 8x8 icons that often accompany an item sprite
	public static class Icons {

		private static final int WIDTH = 16;
		public static final int SIZE = 8;

		public static TextureFilm film = new TextureFilm( Assets.Sprites.ITEM_ICONS, SIZE, SIZE );

		private static int xy(int x, int y){
			x -= 1; y -= 1;
			return x + WIDTH*y;
		}

		private static void assignIconRect( int item, int width, int height ){
			int x = (item % WIDTH) * SIZE;
			int y = (item / WIDTH) * SIZE;
			film.add( item, x, y, x+width, y+height);
		}

		private static final int SCROLLS        =                            xy(1, 3);  //16 slots
		public static final int SCROLL_ANCHOR = SCROLLS+0;
		public static final int SCROLL_EARTH = SCROLLS+1;
		public static final int SCROLL_EXORCISM = SCROLLS+2;
		public static final int SCROLL_FATE = SCROLLS+3;
		public static final int SCROLL_IDENTIFY = SCROLLS+4;
		public static final int SCROLL_LULLABY = SCROLLS+5;
		public static final int SCROLL_MIRRORIMG = SCROLLS+6;
		public static final int SCROLL_FIXER = SCROLLS+7;
		public static final int SCROLL_NS = SCROLLS+8;
		public static final int SCROLL_RAGE = SCROLLS+9;
		public static final int SCROLL_RECHARGE = SCROLLS+10;
		public static final int SCROLL_RETRIB = SCROLLS+11;
		public static final int SCROLL_TERROR = SCROLLS+12;
		public static final int SCROLL_TRANSMUTE = SCROLLS+13;
		static {
			assignIconRect(SCROLL_ANCHOR,   5, 7 );
			assignIconRect(SCROLL_EARTH,    6, 6 );
			assignIconRect(SCROLL_EXORCISM, 7, 7 );
			assignIconRect(SCROLL_FATE,     5, 6 );
			assignIconRect(SCROLL_IDENTIFY, 4, 7 );
			assignIconRect(SCROLL_LULLABY,  7, 6 );
			assignIconRect(SCROLL_MIRRORIMG,7, 5 );
			assignIconRect(SCROLL_FIXER,  5, 5 );
			assignIconRect(SCROLL_NS,   7, 6 );
			assignIconRect(SCROLL_RAGE,     6, 6 );
			assignIconRect(SCROLL_RECHARGE, 7, 5 );
			assignIconRect(SCROLL_RETRIB,   5, 6 );
			assignIconRect(SCROLL_TERROR,   5, 7 );
			assignIconRect(SCROLL_TRANSMUTE,7, 7 );
		}

		private static final int EXOTIC_SCROLLS =                            xy(1, 4);  //16 slots
		public static final int SCROLL_ATTACK_UP = EXOTIC_SCROLLS+0;
		public static final int SCROLL_CRIT = EXOTIC_SCROLLS+1;
		public static final int SCROLL_CHALLENGE = EXOTIC_SCROLLS+2;
		public static final int SCROLL_DEFENSE_UP  = EXOTIC_SCROLLS+3;
		public static final int SCROLL_DESPAIR = EXOTIC_SCROLLS+4;
		public static final int SCROLL_DREAD = EXOTIC_SCROLLS+5;
		public static final int SCROLL_HEAT_RISER = EXOTIC_SCROLLS+6;
		public static final int SCROLL_MAGIC_MAPPING = EXOTIC_SCROLLS+7;
		public static final int SCROLL_MYSTENRG = EXOTIC_SCROLLS+8;
		public static final int SCROLL_PRISIMG = EXOTIC_SCROLLS+9;
		public static final int SCROLL_PSIBLAST = EXOTIC_SCROLLS+10;
		public static final int SCROLL_SIREN = EXOTIC_SCROLLS+11;
		public static final int SCROLL_SUBMERGE = EXOTIC_SCROLLS+12;
		public static final int SCROLL_TELEPORTATION = EXOTIC_SCROLLS+13;
		static {
			assignIconRect(SCROLL_ATTACK_UP,    7, 7 );
			assignIconRect(SCROLL_CRIT,   6, 7 );
			assignIconRect(SCROLL_CHALLENGE,    7, 7 );
			assignIconRect(SCROLL_DEFENSE_UP,   7, 7 );
			assignIconRect(SCROLL_DESPAIR,      7, 5 );
			assignIconRect(SCROLL_DREAD,        5, 7 );
			assignIconRect(SCROLL_HEAT_RISER,   7, 7 );
			assignIconRect(SCROLL_MAGIC_MAPPING,7, 7 );
			assignIconRect(SCROLL_MYSTENRG,     7, 5 );
			assignIconRect(SCROLL_PRISIMG,      5, 7 );
			assignIconRect(SCROLL_PSIBLAST,     5, 6 );
			assignIconRect(SCROLL_SIREN,        7, 6 );
			assignIconRect(SCROLL_SUBMERGE,     5, 7 );
			assignIconRect(SCROLL_TELEPORTATION,7, 7 );
		}

		//16 free slots

		private static final int POTIONS        =                            xy(1, 6);  //16 slots
		public static final int POTION_YINGYANG = POTIONS+0;
		public static final int POTION_HEALING  = POTIONS+1;
		public static final int POTION_MINDVIS  = POTIONS+2;
		public static final int POTION_FROST    = POTIONS+3;
		public static final int POTION_LIQFLAME = POTIONS+4;
		public static final int POTION_TOXICGAS = POTIONS+5;
		public static final int POTION_HASTE    = POTIONS+6;
		public static final int POTION_INVIS    = POTIONS+7;
		public static final int POTION_LEVITATE = POTIONS+8;
		public static final int POTION_PARAGAS  = POTIONS+9;
		public static final int POTION_PURITY   = POTIONS+10;
		public static final int POTION_EXP      = POTIONS+11;
		public static final int POTION_DANGO = POTIONS+12;
		public static final int POTION_MIGHT    = POTIONS+13;
		public static final int POTION_DOUBLESPEED = POTIONS+14;
		public static final int POTION_LIGHTHEALING = POTIONS+15;
		public static final int POTION_DANMAKU = POTIONS+16;
		public static final int POTION_MAGIC = POTIONS+17;
		static {
			assignIconRect( POTION_YINGYANG,    7, 7 );
			assignIconRect( POTION_HEALING,     6, 7 );
			assignIconRect( POTION_MINDVIS,     7, 5 );
			assignIconRect( POTION_FROST,       7, 7 );
			assignIconRect( POTION_LIQFLAME,    5, 7 );
			assignIconRect( POTION_TOXICGAS,    7, 7 );
			assignIconRect( POTION_HASTE,       6, 6 );
			assignIconRect( POTION_INVIS,       5, 7 );
			assignIconRect( POTION_LEVITATE,    6, 7 );
			assignIconRect( POTION_PARAGAS,     7, 7 );
			assignIconRect( POTION_PURITY,      5, 7 );
			assignIconRect( POTION_EXP,         7, 7 );
			assignIconRect( POTION_DANGO,       3, 7 );
			assignIconRect( POTION_MIGHT,       7, 7 );
			assignIconRect( POTION_DOUBLESPEED, 6, 6 );
			assignIconRect( POTION_LIGHTHEALING,6, 7 );
			assignIconRect( POTION_DANMAKU,     7, 5 );
			assignIconRect( POTION_MAGIC,       7, 6 );
		}

		private static final int EXOTIC_POTIONS =                            xy(1, 8);  //16 slots
		public static final int POTION_REVERSE_YINGYANG   = EXOTIC_POTIONS+0;
		public static final int POTION_CORROGAS   = EXOTIC_POTIONS+1;
		public static final int POTION_SNAPFREEZ   = EXOTIC_POTIONS+2;
		public static final int POTION_STAMINA= EXOTIC_POTIONS+3;
		public static final int POTION_LUMINOUS_FIRE = EXOTIC_POTIONS+4;
		public static final int POTION_SHROUDFOG= EXOTIC_POTIONS+5;
		public static final int POTION_MAGISIGHT= EXOTIC_POTIONS+6;
		public static final int POTION_STRMCLOUD = EXOTIC_POTIONS+7;
		public static final int POTION_ATTRACTION = EXOTIC_POTIONS+8;
		public static final int POTION_CLEANSE= EXOTIC_POTIONS+9;
		public static final int POTION_EARTHARMR= EXOTIC_POTIONS+10;
		public static final int POTION_HEXCANCEL= EXOTIC_POTIONS+11;
		public static final int POTION_LIGHTREVERSE  = EXOTIC_POTIONS+12;
		public static final int POTION_PHILOSOPHER   = EXOTIC_POTIONS+13;
		public static final int POTION_ENLIGHTMENT = EXOTIC_POTIONS+14;
		public static final int POTION_SHIELDING = EXOTIC_POTIONS+15;
		public static final int POTION_HISOU = EXOTIC_POTIONS+16;
		public static final int POTION_EXORCISM_ROD = EXOTIC_POTIONS+17;
		static {
			assignIconRect( POTION_REVERSE_YINGYANG,     5, 5 );
			assignIconRect( POTION_CORROGAS,   7, 7 );
			assignIconRect( POTION_SNAPFREEZ,   7, 7 );
			assignIconRect( POTION_STAMINA,   6, 6 );
			assignIconRect(POTION_LUMINOUS_FIRE,   7, 7 );
			assignIconRect( POTION_SHROUDFOG,    7, 7 );
			assignIconRect( POTION_MAGISIGHT,     7, 5 );
			assignIconRect( POTION_STRMCLOUD,   7, 7 );
			assignIconRect(POTION_ATTRACTION,   4, 7 );
			assignIconRect( POTION_CLEANSE,   7, 7 );
			assignIconRect( POTION_EARTHARMR,     6, 6 );
			assignIconRect( POTION_HEXCANCEL,      5, 7 );
			assignIconRect( POTION_LIGHTREVERSE,   7, 7 );
			assignIconRect( POTION_PHILOSOPHER,   5, 7 );
			assignIconRect( POTION_ENLIGHTMENT,   7, 7 );
			assignIconRect( POTION_SHIELDING,   6, 6 );
			assignIconRect( POTION_HISOU,   7, 7 );
			assignIconRect( POTION_EXORCISM_ROD,   3, 7 );
		}
	}
}