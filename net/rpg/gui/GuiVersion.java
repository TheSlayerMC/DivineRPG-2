package net.rpg.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.rpg.RPG;
import net.rpg.Reference;
import net.rpg.Util;

public class GuiVersion {
	public static void draw() {
		FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
		String name = Util.DARK_GREEN + Reference.MOD_NAME;
		String version = Util.GREEN + "Version: " + Reference.MOD_VERSION;
		fontRenderer.drawString(name, 2, 2, 4210752);
		fontRenderer.drawString(version, 2, 15, 4210752);
		String credits;
		if(RPG.credits == 0)
			credits = Util.BLUE + "Credits: " + Util.WHITE + RPG.credits;
		else if(RPG.credits < 30)
			credits = Util.BLUE + "Credits: " + Util.WHITE + RPG.credits;
		else
			credits = Util.BLUE + "Credits: " + Util.WHITE + RPG.credits;
		String s = credits;
		fontRenderer.drawString(s, 2, 30, 0xFFFFFF);
	}
}