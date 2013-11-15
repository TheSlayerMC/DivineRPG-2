package net.rpg.handler;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;
import net.minecraft.client.gui.GuiIngame;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.util.ResourceLocation;
import net.rpg.helper.Helper;
import net.rpg.helper.boss.BossBar;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class BossTickHandler extends Helper implements ITickHandler {

	Minecraft mc = Minecraft.getMinecraft();
	ResourceLocation bar = addGUI("BossBar");	

	@Override
	public void tickStart(EnumSet type, Object... tickData) {

	}

	@Override
	public void tickEnd(EnumSet type, Object... tickData) {
		if (type.equals(EnumSet.of(TickType.RENDER))){
			onBossTick();
		}
	}

	public void onBossTick(){
		GuiIngame gig = mc.ingameGUI;

		if (BossBar.bossName != null && BossBar.statusBarLength > 0)
		{
			--BossBar.statusBarLength;
			FontRenderer fontrenderer = this.mc.fontRenderer;
			ScaledResolution scaledresolution = new ScaledResolution(this.mc.gameSettings, this.mc.displayWidth, this.mc.displayHeight);
			int i = scaledresolution.getScaledWidth();
			short short1 = 182;
			int j = i / 2 - short1 / 2;
			int k = (int)(BossBar.healthScale * (float)(short1 + 1));
			byte b0 = 12;
			gig.drawTexturedModalRect(j, b0, 0, 0, short1, 10);
			gig.drawTexturedModalRect(j, b0, 0, 10, short1, 10);

			if (k > 0){

				gig.drawTexturedModalRect(j, b0, 0, 0, k, 10);
			}

			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			this.mc.getTextureManager().bindTexture(bar);
		}
	}

	@Override
	public EnumSet ticks() {
		return EnumSet.of(TickType.RENDER, TickType.CLIENT, TickType.PLAYER);
	}

	@Override
	public String getLabel() {
		return "RPG Boss Health Bar Tick Handler";
	}

}
