package net.rpg.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.rpg.RPG;
import net.rpg.Reference;
import net.rpg.Util;

public class GuiVersion {
	public static void draw() {
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
		String name = Util.AQUA + Reference.MOD_NAME;
		String version = Util.DARK_PURPLE + "Version: " + Reference.MOD_VERSION;
		String credits;
		int current = RPG.credits;
		if(current == 0)
			credits = Util.DARK_RED + "Credits: " + Util.DARK_RED + current;
		else if(current < 50)
			credits = Util.DARK_RED + "Credits: " + Util.RED + current;
		else if(current < 100)
			credits = Util.DARK_RED + "Credits: " + Util.GOLD + current;
		else if(current < 500)
			credits = Util.DARK_RED + "Credits: " + Util.YELLOW + current;
		else if(current < 1000)
			credits = Util.DARK_RED + "Credits: " + Util.AQUA + current;
		else
			credits = Util.DARK_RED + "Credits: " + Util.GREEN + current;
		String s = credits;
		fontRenderer.drawString(name, 2, 2, 4210752);
		fontRenderer.drawString(version, 2, 12, 4210752);
		fontRenderer.drawString(s, 2, 22, 0xFFFFFF);
	}
}