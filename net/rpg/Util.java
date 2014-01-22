package net.rpg;

import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;

public class Util {
	private static boolean initialized = false;

	public static void init() {
		initialized = true;
	}

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
}