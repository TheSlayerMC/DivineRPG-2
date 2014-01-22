package net.rpg.gui;

import java.util.Iterator;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.rpg.Reference;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.registry.LanguageRegistry;

public class GuiStats extends GuiScreen {
	private int coolDown;
	private int xSize = 176;
	private int ySize = 166;
	private EntityPlayer player;
	GuiButton guibutton;
	private static final ResourceLocation texture = new ResourceLocation(Reference.RESOURCE_PREFIX + "/stats");

	public GuiStats(EntityPlayer player) {
		this.player = player;
	}

	@Override
	public void initGui() {
		this.field_146292_n.clear();
		if(this.field_146297_k.theWorld.getWorldInfo().isHardcoreModeEnabled()) {
			if(this.field_146297_k.isIntegratedServerRunning()) {
				this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 96, LanguageRegistry.instance().getStringLocalization("deathScreen.deleteWorld")));
			} else {
				this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 96, LanguageRegistry.instance().getStringLocalization("deathScreen.leaveServer")));
			}
		} else {
			this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 72, LanguageRegistry.instance().getStringLocalization("deathScreen.respawn")));
			this.field_146292_n.add(new GuiButton(2, this.field_146294_l / 2 - 100, this.field_146295_m / 4 + 96, LanguageRegistry.instance().getStringLocalization("deathScreen.titleScreen")));
			if(this.field_146297_k.getSession() == null) {
				((GuiButton) this.field_146292_n.get(1)).field_146125_m = false;
			}
		}
		for(Iterator iterator = this.field_146292_n.iterator(); iterator.hasNext(); guibutton.field_146125_m = false) {
			guibutton = (GuiButton) iterator.next();
		}
	}

	@Override
	protected void keyTyped(char par1, int par2) {
	}

	@Override
	public void drawScreen(int par1, int par2, float par3) {
		this.drawGradientRect(0, 0, this.field_146294_l, this.field_146295_m, 1615855616, -1602211792);
		GL11.glPushMatrix();
		GL11.glScalef(2.0F, 2.0F, 2.0F);
		this.drawCenteredString(this.field_146289_q, EnumChatFormatting.YELLOW + "Race: ", this.field_146294_l / 2 / 2, 30, 16777215);
		GL11.glPopMatrix();
		//this.drawCenteredString(this.field_146289_q, LanguageRegistry.instance().getStringLocalization("deathScreen.hardcoreInfo"), this.field_146294_l / 2, 144, 16777215);
		//this.drawCenteredString(this.field_146289_q, LanguageRegistry.instance().getStringLocalization("deathScreen.score") + ": " + EnumChatFormatting.YELLOW + this.field_146297_k.thePlayer.getScore(), this.field_146294_l / 2, 100, 16777215);
		super.drawScreen(par1, par2, par3);
	}

	@Override
	public void updateScreen() {
		super.updateScreen();
		this.coolDown++;
		if(this.coolDown == 20) {
			for(Iterator iterator = this.field_146292_n.iterator(); iterator.hasNext(); guibutton.field_146125_m = true) {
				guibutton = (GuiButton) iterator.next();
			}
		}
	}

	@Override
	public boolean doesGuiPauseGame() {
		return true;
	}
}