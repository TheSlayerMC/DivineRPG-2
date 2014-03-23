package net.rpg.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.rpg.Reference;
import net.rpg.Util;
import net.rpg.helper.DataHelper;

public class GuiVersion {
	public static void draw() {
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
		String name = Util.AQUA + Reference.MOD_NAME;
		String version = Util.DARK_PURPLE + "Version: " + Reference.MOD_VERSION;
		String credits;
		if(DataHelper.getCredits(player) == 0)
			credits = Util.DARK_RED + "Credits: " + Util.DARK_RED + DataHelper.getCredits(player);
		else if(DataHelper.getCredits(player) < 50)
			credits = Util.DARK_RED + "Credits: " + Util.RED + DataHelper.getCredits(player);
		else if(DataHelper.getCredits(player) < 100)
			credits = Util.DARK_RED + "Credits: " + Util.GOLD + DataHelper.getCredits(player);
		else if(DataHelper.getCredits(player) < 500)
			credits = Util.DARK_RED + "Credits: " + Util.YELLOW + DataHelper.getCredits(player);
		else if(DataHelper.getCredits(player) < 1000)
			credits = Util.DARK_RED + "Credits: " + Util.AQUA + DataHelper.getCredits(player);
		else
			credits = Util.DARK_RED + "Credits: " + Util.GREEN + DataHelper.getCredits(player);
		String s = credits;
		fontRenderer.drawString(name, 2, 2, 4210752);
		fontRenderer.drawString(version, 2, 12, 4210752);
		fontRenderer.drawString(s, 2, 22, 0xFFFFFF);
	}
}