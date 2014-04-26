package net.rpg.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.rpg.RPG;

public class GuiDeBar {
	public static ResourceLocation texture = new ResourceLocation("rpg:textures/gui/deSheet.png");

	public static void draw() {
		Minecraft mc = Minecraft.getMinecraft();
		EntityPlayer player = mc.thePlayer;
		GuiIngame gig = mc.ingameGUI;
		int var29, var26;
		ScaledResolution scaledresolution = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
		int i = scaledresolution.getScaledWidth();
		int k = scaledresolution.getScaledHeight();
		mc.getTextureManager().bindTexture(texture);
		var26 = k - 18;
		var29 = i - 660;
		int w = (int) (121 * ((float) RPG.de / RPG.maxDe));
		gig.drawTexturedModalRect(var29, var26, 0, 0, 200, 17);
		gig.drawTexturedModalRect(var29, var26, 0, 17, (int) (12.5 * w), 34);
	}
}