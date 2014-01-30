package net.rpg.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.util.ResourceLocation;
import net.rpg.RPG;

import org.lwjgl.opengl.GL11;

public class GuiDeBar extends Gui {
	private static final ResourceLocation texture = new ResourceLocation("rpg:textures/gui/deSheet.png");

	public void draw() {
		if(RPG.maxDe == 0) {
			return;
		}
		Minecraft mc = Minecraft.getMinecraft();
		if(!mc.playerController.shouldDrawHUD()) {
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			mc.getTextureManager().bindTexture(texture);
			drawTexturedModalRect(0, 0, 0, 0, 128, 16);
			drawTexturedModalRect(2, 2, 0, 16, 121 * (RPG.de / RPG.maxDe), 9);
		}
	}
}