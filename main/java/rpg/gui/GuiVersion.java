package net.rpg.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.util.EnumChatFormatting;
import net.rpg.RPG;
import net.rpg.Reference;
import net.rpg.Util;
import net.rpg.helper.DataHelper;

public class GuiVersion {
	
	public static void draw() {
		FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
		String name = Util.AQUA + Reference.MOD_NAME;
		String version = Util.DARK_PURPLE + "Version: " + Reference.MOD_VERSION;
		String credits;
		if(RPG.credits == 0)
			credits = Util.DARK_RED + "Credits: " + Util.DARK_RED + RPG.credits;
		else if(RPG.credits < 50)
			credits = Util.DARK_RED + "Credits: " + Util.RED + RPG.credits;
		else if(RPG.credits < 100)
			credits = Util.DARK_RED + "Credits: " + Util.GOLD + RPG.credits;
		else if (RPG.credits < 500)
			credits = Util.DARK_RED + "Credits: " + Util.YELLOW + RPG.credits;
		else if (RPG.credits < 1000)
			credits = Util.DARK_RED + "Credits: " + Util.AQUA + RPG.credits;
		else
			credits = Util.DARK_RED + "Credits: " + Util.GREEN + RPG.credits;
		String s = credits;
		
		fontRenderer.drawString(name, 2, 2, 4210752);
		fontRenderer.drawString(version, 2, 12, 4210752);
		fontRenderer.drawString(s, 2, 22, 0xFFFFFF);
	}
}