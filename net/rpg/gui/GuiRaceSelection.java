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
import net.rpg.network.PacketRequestStats;

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
		this.field_146292_n.add(new GuiButton(0, this.field_146294_l / 2 - 75, 65, 150, 20, "Steve"));
		this.field_146292_n.add(new GuiButton(1, this.field_146294_l / 2 - 75, 86, 150, 20, "Vilager"));
		this.field_146292_n.add(new GuiButton(2, this.field_146294_l / 2 - 75, 107, 150, 20, "Zombie Pigman"));
		this.field_146292_n.add(new GuiButton(3, this.field_146294_l / 2 - 75, 128, 150, 20, "Cyclops"));
		this.field_146292_n.add(new GuiButton(4, this.field_146294_l / 2 - 75, 149, 150, 20, "Plankling"));
	}

	@Override
	protected void func_146284_a(GuiButton p_146284_1_) {
		switch(p_146284_1_.field_146127_k) {
		case 0:
			sendPacket(0);
			break;
		case 1:
			sendPacket(1);
			break;
		case 2:
			sendPacket(2);
			break;
		case 3:
			sendPacket(3);
			break;
		case 4:
			sendPacket(4);
			break;
		}
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