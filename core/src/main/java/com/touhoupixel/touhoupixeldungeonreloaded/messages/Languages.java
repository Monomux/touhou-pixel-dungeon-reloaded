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

package com.touhoupixel.touhoupixeldungeonreloaded.messages;

import java.util.Locale;

public enum Languages {
	ENGLISH("english",       "",   Status.REVIEWED, new String[]{"Nuke Hashigawa(1.1)"}, new String[]{"Nuke Hashigawa(1.1)"}),
	KOREAN("한국어",          "ko", Status.REVIEWED, null, null),
	JAPANESE("日本語",        "ja", Status.INCOMPLETE, null, null),
	VIETNAMESE("vietnamese", "vi", Status.INCOMPLETE, new String[]{"MinecraftGuy(1.1)"}, new String[]{"MinecraftGuy(1.1)"}),
	FILIPINO("filipino",     "fi", Status.INCOMPLETE, new String[]{"zero [bug-finder](1.1)"}, new String[]{"zero [bug-finder](1.1)"}),
	CHINESE("中文",          "zh", Status.INCOMPLETE, new String[]{"yoritaru thpd team and zqiao114"}, new String[]{"yoritaru thpd teamand zqiao114"});

	public enum Status{
		//below 80% complete languages are not added.
		INCOMPLETE, //80-99% complete
		UNREVIEWED, //100% complete
		REVIEWED    //100% reviewed
	}

	private String name;
	private String code;
	private Status status;
	private String[] reviewers;
	private String[] translators;

	Languages(String name, String code, Status status, String[] reviewers, String[] translators){
		this.name = name;
		this.code = code;
		this.status = status;
		this.reviewers = reviewers;
		this.translators = translators;
	}

	public String nativeName(){
		return name;
	}

	public String code(){
		return code;
	}

	public Status status(){
		return status;
	}

	public String[] reviewers() {
		if (reviewers == null) return new String[]{};
		else return reviewers.clone();
	}

	public String[] translators() {
		if (translators == null) return new String[]{};
		else return translators.clone();
	}

	public static Languages matchLocale(Locale locale){
		return matchCode(locale.getLanguage());
	}

	public static Languages matchCode(String code){
		for (Languages lang : Languages.values()){
			if (lang.code().equals(code))
				return lang;
		}
		return ENGLISH;
	}

}
