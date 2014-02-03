package net.rpg;

import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;

public class Util {
	public static final void severe(String text) {
		System.out.println(text);
	}

	public static final void warn(String text) {
		System.out.println(text);
	}

	public static final void fine(String text) {
		System.out.println(text);
	}

	public static final void finer(String text) {
		System.out.println(text);
	}

	public static final void finest(String text) {
		System.out.println(text);
	}

	public static final void info(String text) {
		System.out.println(text);
	}

	public static ChatComponentTranslation addChatMessage(EnumChatFormatting color, String str, Object... args) {
		ChatComponentTranslation ret = new ChatComponentTranslation(str, args);
		ret.func_150256_b().func_150238_a(color);
		return ret;
	}

	public static ChatComponentTranslation addChatMessage(String str, Object... args) {
		ChatComponentTranslation ret = new ChatComponentTranslation(str, args);
		ret.func_150256_b().func_150238_a(EnumChatFormatting.WHITE);
		return ret;
	}
	
	public static String BLACK = "\u00a70", DARK_BLUE = "\u00a71", DARK_GREEN = "\u00a72", DARK_AQUA = "\u00a73", DARK_RED = "\u00a74";
	public static String DARK_PURPLE = "\u00a75", GOLD = "\u00a76", GRAY = "\u00a77", DARK_GRAY = "\u00a78", BLUE = "\u00a79";
	public static String GREEN = "\u00a7a", AQUA = "\u00a7b", RED = "\u00a7c", LIGHT_PURPLE = "\u00a7d", YELLOW = "\u00a7e";
	public static String WHITE = "\u00a7f";
}