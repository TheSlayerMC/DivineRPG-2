package net.rpg.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.gui.inventory.GuiFurnace;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.rpg.container.ContainerStats;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiStats extends GuiContainer {
	private static final ResourceLocation texture = new ResourceLocation("rpg:textures/gui/stats.png");
	private EntityPlayer p;
	private GuiFurnace f;

	public GuiStats(EntityPlayer p) {
		super(new ContainerStats(p));
		this.p = p;
	}

	@Override
	protected void func_146979_b(int p_146979_1_, int p_146979_2_) {
		String s = "Stats";
		this.field_146289_q.drawString(s, this.field_146999_f / 2 - this.field_146289_q.getStringWidth(s) / 2, 6, 4210752);
		s = EnumChatFormatting.YELLOW + "Coins: " + EnumChatFormatting.WHITE + ((ContainerStats) this.field_147002_h).coins;
		this.field_146289_q.drawString(s, this.field_146999_f / 2 - this.field_146289_q.getStringWidth(s) / 2, 22, 4210752);
		s = EnumChatFormatting.DARK_RED + "Attack: " + EnumChatFormatting.WHITE + ((ContainerStats) this.field_147002_h).attack;
		this.field_146289_q.drawString(s, this.field_146999_f / 2 - this.field_146289_q.getStringWidth(s) / 2, 32, 4210752);
		s = EnumChatFormatting.DARK_BLUE + "Defense: " + EnumChatFormatting.WHITE + ((ContainerStats) this.field_147002_h).defense;
		this.field_146289_q.drawString(s, this.field_146999_f / 2 - this.field_146289_q.getStringWidth(s) / 2, 42, 4210752);
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