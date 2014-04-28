package net.rpg.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.entity.player.EntityPlayer;
import net.rpg.Reference;

public class GuiVersion {
	public static void draw() {
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		FontRenderer fontRenderer = Minecraft.getMinecraft().fontRenderer;
		String name = Reference.AQUA + Reference.MOD_NAME;
		String version = Reference.DARK_PURPLE + "Version: " + Reference.MOD_VERSION;
		String credits;
		int current = Reference.credits;
		if(current == 0)
			credits = Reference.DARK_RED + "Credits: " + Reference.DARK_RED + current;
		else if(current < 50)
			credits = Reference.DARK_RED + "Credits: " + Reference.RED + current;
		else if(current < 100)
			credits = Reference.DARK_RED + "Credits: " + Reference.GOLD + current;
		else if(current < 500)
			credits = Reference.DARK_RED + "Credits: " + Reference.YELLOW + current;
		else if(current < 1000)
			credits = Reference.DARK_RED + "Credits: " + Reference.AQUA + current;
		else
			credits = Reference.DARK_RED + "Credits: " + Reference.GREEN + current;
		String s = credits;
		fontRenderer.drawString(name, 2, 2, 4210752);
		fontRenderer.drawString(version, 2, 12, 4210752);
		fontRenderer.drawString(s, 2, 22, 0xFFFFFF);
	}
}