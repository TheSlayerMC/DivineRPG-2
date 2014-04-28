package net.rpg.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.rpg.Reference;
import net.rpg.Util;
import net.rpg.container.ContainerStats;
import net.rpg.helper.AbilityHelper;

import org.lwjgl.opengl.GL11;

public class GuiAbilities extends GuiContainer {
	private static final ResourceLocation texture = new ResourceLocation("rpg:textures/gui/blank.png");

	public GuiAbilities(EntityPlayer p) {
		super(new ContainerStats(p));
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int par1, int par2) {
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		String s = "Abilities";
		this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
		s = "~~~~~~~~~~~~~~~~~~~~~~";
		this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 17, 4210752);
		if(Util.isNewPlayer(player)) {
			s = EnumChatFormatting.DARK_RED + "Use the Race Stone";
			this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 22, 4210752);
			s = EnumChatFormatting.DARK_RED + "to begin your adventure!";
			this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 32, 4210752);
		} else {
			int ability = Reference.ability;
			s = EnumChatFormatting.YELLOW + "Race: " + EnumChatFormatting.WHITE + Util.translateRace(Reference.race);
			this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 22, 4210752);
			s = EnumChatFormatting.YELLOW + "Ability: " + EnumChatFormatting.WHITE + AbilityHelper.getName(ability);
			this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 32, 4210752);
			s = EnumChatFormatting.YELLOW + "Good effect: " + EnumChatFormatting.WHITE + AbilityHelper.isGoodEffect(ability);
			this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 42, 4210752);
			s = EnumChatFormatting.YELLOW + "Denotation: " + EnumChatFormatting.WHITE + AbilityHelper.getDenotation(ability);
			this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 52, 4210752);
			s = EnumChatFormatting.YELLOW + "Cool down: " + EnumChatFormatting.WHITE + Reference.cooldown;
			this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 62, 4210752);
			s = EnumChatFormatting.YELLOW + "Ranged: " + EnumChatFormatting.WHITE + AbilityHelper.isRanged(ability);
			this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 72, 4210752);
		}
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float f, int par1, int par2) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}
}