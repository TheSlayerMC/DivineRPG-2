package net.rpg.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.EnumChatFormatting;
import net.rpg.RPG;
import net.rpg.Reference;

public class GuiVersion extends Gui{

	public static void init(){
		Minecraft mc = Minecraft.getMinecraft();
		if(mc.currentScreen == null) {
			String name = EnumChatFormatting.WHITE + Reference.MOD_NAME;
			String version = EnumChatFormatting.WHITE + "Version: " + Reference.MOD_VERSION;
			Minecraft.getMinecraft().fontRenderer.drawString(name, 2, 2, 4210752);
			Minecraft.getMinecraft().fontRenderer.drawString(version, 2, 15, 4210752);
			
			String credits;
			/*if(RPG.credits == 0)
				credits = "Credits: " + EnumChatFormatting.RED + RPG.credits;
			else if(RPG.credits < 30)
				credits = "Credits: " + EnumChatFormatting.YELLOW + RPG.credits;
			else*/
				credits = EnumChatFormatting.WHITE + "Credits: " + RPG.credits;
			String s = credits;
			Minecraft.getMinecraft().fontRenderer.drawString(s, 2, 30, 0xFFFFFF);
		}
	}
}