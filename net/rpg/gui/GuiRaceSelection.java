package net.rpg.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.entity.EntityClientPlayerMP;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.rpg.RPG;
import net.rpg.Reference;
import net.rpg.Util;
import net.rpg.container.ContainerRaceSelection;
import net.rpg.entity.render.RenderPlayerRPG;
import net.rpg.handler.WelcomeHandler;
import net.rpg.helper.ItemHelper;
import net.rpg.network.PacketRace;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class GuiRaceSelection extends GuiContainer {
	private static final ResourceLocation texture = new ResourceLocation("rpg:textures/gui/blank.png");
	private EntityPlayer p;
	Minecraft mc = Minecraft.getMinecraft();
	ScaledResolution scaledresolution = new ScaledResolution(mc.gameSettings, mc.displayWidth, mc.displayHeight);
	int i = scaledresolution.getScaledHeight();
	int height = i;

	public GuiRaceSelection(EntityPlayer p) {
		super(new ContainerRaceSelection(p));
		this.p = p;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int p_146979_1_, int p_146979_2_) {
		String s = "Race Selection";
		this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 6, 4210752);
		s = "~~~~~~~~~~~~~~~~~~~~~~";
		this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2, 17, 4210752);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}

	@Override
	public void initGui() {
		super.initGui();
		page1();
	}

	@Override
	protected void actionPerformed(GuiButton button) {
		switch(button.id) {
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
			p.inventory.addItemStackToInventory(new ItemStack(ItemHelper.getItem("cyclopsianSword")));
			RenderingRegistry.registerEntityRenderingHandler(EntityClientPlayerMP.class, new RenderPlayerRPG(3.0F));
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
		this.buttonList.clear();
		final int x = this.width / 2 - 75;
		final int z = this.height / 2 - 125;
		final int w = 150;
		final int h = 20;
		addButton(new GuiButton(0, x, z + 65, w, h, "Minecraftian"));
		addButton(new GuiButton(1, x, z + 86, w, h, "Villager"));
		addButton(new GuiButton(2, x, z + 107, w, h, "Zombie Pigman"));
		addButton(new GuiButton(3, x, z + 128, w, h, "Cyclops"));
		addButton(new GuiButton(4, x, z + 149, w, h, "Ent")); 
		addMoveButtons();
	}

	private void page2() {
		this.buttonList.clear();
		final int x = this.width / 2 - 75;
		final int z = this.height / 2 - 125;
		final int w = 150;
		final int h = 20;
		addButton(new GuiButton(7, x, z + 65, w, h, "Galroid"));
		addButton(new GuiButton(8, x, z + 86, w, h, "Boheimite"));
		addButton(new GuiButton(9, x, z + 107, w, h, "Cori"));
		addButton(new GuiButton(10, x, z + 128, w, h, "Glacon"));
		addButton(new GuiButton(11, x, z + 149, w, h, "Frost Archer"));
		addMoveButtons();
	}

	/*
	 * private void page3(){
	 * this.buttonList.clear();
	 * final int x = this.width / 2 - 75;
	 * final int w = 150;
	 * final int h = 20;
	 * addButton(new GuiButton(12, x, 65, w, h, "Enderman"));
	 * addButton(new GuiButton(13, x, 86, w, h, "Spider"));
	 * addButton(new GuiButton(14, x, 107, w, h, "Creeper"));
	 * addButton(new GuiButton(15, x, 128, w, h, "Slime"));
	 * addMoveButtons();
	 * }
	 */
	private void addMoveButtons() {
		final int z = this.height / 2;
		addButton(new GuiButton(5, this.width / 2, z + 55, 76, 20, ">>>"));
		addButton(new GuiButton(6, this.width / 2 - 75, z + 55, 76, 20, "<<<"));
	}

	private void addButton(GuiButton b) {
		this.buttonList.add(b);
	}

	private void sendPacket(int race) {
		PacketRace packet = new PacketRace();
		packet.race = race;
		RPG.packetHandler.sendToServer(packet);
		if(p.inventory.hasItem(ItemHelper.getItem("raceStone"))) {
			p.inventory.consumeInventoryItem(ItemHelper.getItem("raceStone"));
		}
		this.mc.displayGuiScreen((GuiScreen)null);
		WelcomeHandler.wm(p);
	}
}