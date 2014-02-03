package net.rpg.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.EnumChatFormatting;
import net.rpg.RPG;
import net.rpg.Reference;
import net.rpg.Util;

public class GuiVersion extends Gui{

	public static void init(){
		Minecraft mc = Minecraft.getMinecraft();
		if(mc.currentScreen == null) {
			String name = Util.DARK_GREEN + Reference.MOD_NAME;
			String version = Util.GREEN + "Version: " + Reference.MOD_VERSION;
			Minecraft.getMinecraft().fontRenderer.drawString(name, 2, 2, 4210752);
			Minecraft.getMinecraft().fontRenderer.drawString(version, 2, 15, 4210752);
			
			String credits;
			if(RPG.credits == 0)
				credits = Util.BLUE + "Credits: " + Util.WHITE + RPG.credits;
			else if(RPG.credits < 30)
				credits = Util.BLUE + "Credits: " + Util.WHITE + RPG.credits;
			else
				credits = Util.BLUE + "Credits: " + Util.WHITE + RPG.credits;
			String s = credits;
			Minecraft.getMinecraft().fontRenderer.drawString(s, 2, 30, 0xFFFFFF);
		}
	}
}