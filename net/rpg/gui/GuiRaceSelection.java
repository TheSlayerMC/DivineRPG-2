package net.rpg.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.rpg.RPG;
import net.rpg.container.ContainerRaceSelection;
import net.rpg.helper.ItemHelper;
import net.rpg.network.PacketRace;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiRaceSelection extends GuiContainer {
	private static final ResourceLocation texture = new ResourceLocation("rpg:textures/gui/blank.png");
	private EntityPlayer p;

	public GuiRaceSelection(EntityPlayer p) {
		super(new ContainerRaceSelection(p));
		this.p = p;
	}

	@Override
	protected void func_146979_b(int p_146979_1_, int p_146979_2_) {
		String s = "Race Selection";
		this.field_146289_q.drawString(s, this.field_146999_f / 2 - this.field_146289_q.getStringWidth(s) / 2, 6, 4210752);
		s = "~~~~~~~~~~~~~~~~~~~~~~";
		this.field_146289_q.drawString(s, this.field_146999_f / 2 - this.field_146289_q.getStringWidth(s) / 2, 17, 4210752);
	}

	@Override
	protected void func_146976_a(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.field_146297_k.getTextureManager().bindTexture(texture);
		int k = (this.field_146294_l - this.field_146999_f) / 2;
		int l = (this.field_146295_m - this.field_147000_g) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.field_146999_f, this.field_147000_g);
	}

	@Override
	public void initGui() {
		super.initGui();
		page1();
	}

	@Override
	protected void func_146284_a(GuiButton p_146284_1_) {
		switch(p_146284_1_.field_146127_k) {
		case 0:
			sendPacket(0);
			return;
		case 1:
			sendPacket(1);
			return;
		case 2:
			sendPacket(2);
			return;
		case 3:
			sendPacket(3);
			return;
		case 4:
			sendPacket(4);
			return;
		case 7:
			sendPacket(6);
			return;
		case 8:
			sendPacket(7);
			return;
		case 9:
			sendPacket(8);
			return;
		case 10:
			sendPacket(9);
			return;
		case 11:
			sendPacket(10);
			return;
		case 5:
			page2();
			return;
		case 6:
			page1();
			return;
		}
	}

	private void page1() {
		this.field_146292_n.clear();
		final int x = this.field_146294_l / 2 - 75;
		final int w = 150;
		final int h = 20;
		addButton(new GuiButton(0, x, 65, w, h, "Steve"));
		addButton(new GuiButton(1, x, 86, w, h, "Villager"));
		addButton(new GuiButton(2, x, 107, w, h, "Zombie Pigman"));
		addButton(new GuiButton(3, x, 128, w, h, "Cyclops"));
		addButton(new GuiButton(4, x, 149, w, h, "Plankling"));
		addMoveButtons();
	}

	private void page2() {
		this.field_146292_n.clear();
		final int x = this.field_146294_l / 2 - 75;
		final int w = 150;
		final int h = 20;
		addButton(new GuiButton(7, x, 65, w, h, "Galroid"));
		addButton(new GuiButton(8, x, 86, w, h, "Boheimite"));
		//addButton(new GuiButton(8, x, 107, w, h, ""));
		//addButton(new GuiButton(9, x, 128, w, h, ""));
		//addButton(new GuiButton(10, x, 149, w, h, ""));
		addMoveButtons();
	}

	private void addMoveButtons() {
		addButton(new GuiButton(5, this.field_146294_l / 2, 175, 76, 20, ">>>"));
		addButton(new GuiButton(6, this.field_146294_l / 2 - 75, 175, 76, 20, "<<<"));
	}

	private void addButton(GuiButton b) {
		this.field_146292_n.add(b);
	}

	private void sendPacket(int race) {
		PacketRace packet = new PacketRace();
		packet.race = race;
		RPG.packetHandler.sendToServer(packet);
		if(p.inventory.func_146028_b(ItemHelper.getItem("raceStone"))) {
			p.inventory.func_146026_a(ItemHelper.getItem("raceStone"));
		}
		this.field_146297_k.func_147108_a((GuiScreen) null);
	}
}