package net.rpg.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.EnumChatFormatting;
import net.rpg.RPG;
import net.rpg.Reference;

public class GuiVersion extends Gui{

	public static void init(){
		String text = Reference.MOD_NAME + " " + Reference.MOD_VERSION;
		Minecraft.getMinecraft().fontRenderer.drawString(EnumChatFormatting.AQUA + text, 0, 0, 4210752);
		/*String race = Reference.translateRace(RPG.race);
		Minecraft.getMinecraft().fontRenderer.drawString(EnumChatFormatting.RED + race, 10, 0, 4210752);*/
	}
}