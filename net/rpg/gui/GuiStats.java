package net.rpg.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.rpg.RPG;
import net.rpg.Reference;
import net.rpg.container.ContainerStats;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiStats extends GuiContainer {
	private static final ResourceLocation texture = new ResourceLocation("rpg:textures/gui/blank.png");
	private EntityPlayer p;
	public int credits, attack, defense;

	public GuiStats(EntityPlayer p) {
		super(new ContainerStats(p));
		this.p = p;
	}

	@Override
	protected void func_146979_b(int p_146979_1_, int p_146979_2_) {
		String s = "Stats";
		this.field_146289_q.drawString(s, this.field_146999_f / 2 - this.field_146289_q.getStringWidth(s) / 2, 6, 4210752);
		s = "~~~~~~~~~~~~~~~~~~~~~~";
		this.field_146289_q.drawString(s, this.field_146999_f / 2 - this.field_146289_q.getStringWidth(s) / 2, 17, 4210752);
		if(RPG.race == -1) {
			s = EnumChatFormatting.DARK_RED + "Use the Race Stone";
			this.field_146289_q.drawString(s, this.field_146999_f / 2 - this.field_146289_q.getStringWidth(s) / 2, 22, 4210752);
			s = EnumChatFormatting.DARK_RED + "to begin your adventure!";
			this.field_146289_q.drawString(s, this.field_146999_f / 2 - this.field_146289_q.getStringWidth(s) / 2, 32, 4210752);
		} else {
			s = EnumChatFormatting.YELLOW + "Race: " + EnumChatFormatting.WHITE + Reference.translateRace(RPG.race);
			this.field_146289_q.drawString(s, this.field_146999_f / 2 - this.field_146289_q.getStringWidth(s) / 2, 22, 4210752);
			s = EnumChatFormatting.YELLOW + "Max Health: " + EnumChatFormatting.WHITE + RPG.maxHp;
			this.field_146289_q.drawString(s, this.field_146999_f / 2 - this.field_146289_q.getStringWidth(s) / 2, 32, 4210752);
			s = EnumChatFormatting.YELLOW + "Max Divine Energy: " + EnumChatFormatting.WHITE + RPG.maxDe;
			this.field_146289_q.drawString(s, this.field_146999_f / 2 - this.field_146289_q.getStringWidth(s) / 2, 42, 4210752);
			s = EnumChatFormatting.YELLOW + "Credits: " + EnumChatFormatting.WHITE + RPG.credits;
			this.field_146289_q.drawString(s, this.field_146999_f / 2 - this.field_146289_q.getStringWidth(s) / 2, 52, 4210752);
			s = EnumChatFormatting.YELLOW + "Attack: " + EnumChatFormatting.WHITE + RPG.attack;
			this.field_146289_q.drawString(s, this.field_146999_f / 2 - this.field_146289_q.getStringWidth(s) / 2, 62, 4210752);
			s = EnumChatFormatting.YELLOW + "Defense: " + EnumChatFormatting.WHITE + RPG.defense;
			this.field_146289_q.drawString(s, this.field_146999_f / 2 - this.field_146289_q.getStringWidth(s) / 2, 72, 4210752);
		}
	}

	@Override
	protected void func_146976_a(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.field_146297_k.getTextureManager().bindTexture(texture);
		int k = (this.field_146294_l - this.field_146999_f) / 2;
		int l = (this.field_146295_m - this.field_147000_g) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.field_146999_f, this.field_147000_g);
	}
}