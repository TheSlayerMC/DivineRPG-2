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
		if(mc.playerController.shouldDrawHUD()) {
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glDisable(GL11.GL_LIGHTING);
			mc.getTextureManager().bindTexture(texture);
			drawTexturedModalRect(0, 0, 0, 0, 128, 16);
			int w = (int) (121 * ((float) RPG.de / RPG.maxDe));
			drawTexturedModalRect(2, 2, 0, 16, w, 9);
			GL11.glEnable(GL11.GL_LIGHTING);
			GL11.glPopMatrix();
		}
	}
}