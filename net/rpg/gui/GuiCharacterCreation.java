package net.rpg.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.rpg.Reference;
import net.rpg.Util;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiCharacterCreation extends GuiScreen {
	
    protected int xSize = 176;
    protected int ySize = 166;
	
	private static final ResourceLocation texture = new ResourceLocation(Reference.RESOURCE_PREFIX + "/new_player");
	
	public GuiCharacterCreation() {
		Util.info("Whats up?");
	}
	
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {	
		this.fontRenderer.drawString(EnumChatFormatting.BOLD + "Choose your race:", 8, 6, 4210752);
	}
	
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3) {
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
	    int k = (this.width - this.xSize) / 2;
	    int l = (this.height - this.ySize) / 2;
	    this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}	
}