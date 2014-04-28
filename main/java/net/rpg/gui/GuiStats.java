package net.rpg.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.rpg.Reference;
import net.rpg.Util;
import net.rpg.container.ContainerStats;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiStats extends GuiContainer {
	private static final ResourceLocation texture = new ResourceLocation("rpg:textures/gui/blank.png");
	public int credits, attack, defense;

	public GuiStats(EntityPlayer p) {
		super(new ContainerStats(p));
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
		EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		String s = "Stats";
		this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
		s = "~~~~~~~~~~~~~~~~~~~~~~";
		this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 17, 4210752);
		if(Util.isNewPlayer(player)) {
			s = EnumChatFormatting.DARK_RED + "Use the Race Stone";
			this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 22, 4210752);
			s = EnumChatFormatting.DARK_RED + "to begin your adventure!";
			this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 32, 4210752);
		} else {
			s = EnumChatFormatting.YELLOW + "Race: " + EnumChatFormatting.WHITE + Util.translateRace(Reference.race);
			this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 22, 4210752);
			s = EnumChatFormatting.YELLOW + "Max Health: " + EnumChatFormatting.WHITE + Reference.maxHp;
			this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 32, 4210752);
			s = EnumChatFormatting.YELLOW + "Max Divine Energy: " + EnumChatFormatting.WHITE + Reference.maxDe;
			this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 42, 4210752);
			s = EnumChatFormatting.YELLOW + "Credits: " + EnumChatFormatting.WHITE + Reference.credits;
			this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 52, 4210752);
			s = EnumChatFormatting.YELLOW + "Attack: " + EnumChatFormatting.WHITE + Reference.attack;
			this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 62, 4210752);
			s = EnumChatFormatting.YELLOW + "Defense: " + EnumChatFormatting.WHITE + Reference.defense;
			this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 72, 4210752);
			s = EnumChatFormatting.YELLOW + "Max Arcana: " + EnumChatFormatting.WHITE + Reference.maxArcana;
			this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 82, 4210752);
			s = EnumChatFormatting.YELLOW + "Discount: " + EnumChatFormatting.WHITE + Reference.discount + "%";
			this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 92, 4210752);
			s = EnumChatFormatting.YELLOW + "Luck: " + EnumChatFormatting.WHITE + Reference.luck;
			this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 102, 4210752);
			s = EnumChatFormatting.YELLOW + "Reflex: " + EnumChatFormatting.WHITE + Reference.reflex;
			this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 112, 4210752);
			s = EnumChatFormatting.YELLOW + "Stamina: " + EnumChatFormatting.WHITE + Reference.stamina;
			this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 122, 4210752);
			s = EnumChatFormatting.YELLOW + "Speed: " + EnumChatFormatting.WHITE + Reference.speed;
			this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 132, 4210752);
		}
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}
}