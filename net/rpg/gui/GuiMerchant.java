package net.rpg.gui;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiCommandBlock;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.rpg.RPG;
import net.rpg.container.ContainerStats;

import org.lwjgl.opengl.GL11;

public class GuiMerchant extends GuiContainer{

	private static ResourceLocation texture = new ResourceLocation("rpg:textures/gui/merchant.png");

	private EntityPlayer p = Minecraft.getMinecraft().thePlayer;
	int pageNum, maxPageNums = 2;
	public GuiMerchant(EntityPlayer p) {
		super(new ContainerStats(p));
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int arg1, int arg2) {
		String s = "Merchant";
		this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2 - 20, 6 - 25, 4210752);
		s = "~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~";
		String credits;
		
		if(RPG.credits == 0)
			credits = EnumChatFormatting.YELLOW + "Credits: " + EnumChatFormatting.RED + RPG.credits;
		else if(RPG.credits < 30)
			credits = EnumChatFormatting.YELLOW + "Credits: " + EnumChatFormatting.YELLOW + RPG.credits;
		else
			credits = EnumChatFormatting.YELLOW + "Credits: " + EnumChatFormatting.GREEN + RPG.credits;

		s = credits;
		this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2 + 50, 6 - 25, 4210752);
		s = EnumChatFormatting.YELLOW + "Discount: " + EnumChatFormatting.WHITE + RPG.discount + "%";
		this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2 - 90, 6 - 25, 4210752);
		
		s = EnumChatFormatting.YELLOW + "Page: " + EnumChatFormatting.WHITE + pageNum + "/" + maxPageNums;
		this.fontRendererObj.drawString(s, this.xSize / 2 - this.fontRendererObj.getStringWidth(s) / 2 - 25, 1 + 145, 4210752);
	}

	@Override
	public void initGui() {
		super.initGui();
		page1();
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_, int p_146976_2_, int p_146976_3_) {
		GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
		this.mc.getTextureManager().bindTexture(texture);
		this.xSize = 220;
		this.ySize = 220;
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}

	@Override
	protected void actionPerformed(GuiButton button) {
		switch(button.id) {
		case 1: 
			buy(Items.arrow, 1, 7);
			return;
		case 2:
			buy(Items.diamond, 1, 100);
			return;
		case 3:
			buy(Items.gold_ingot, 1, 50);
			return;
		case 4:
			buy(Items.iron_ingot, 1, 70);
			return;
		case 5:
			buy(Items.golden_apple, 1, 100);
			return;
		case 6:
			buy(Items.golden_apple, 1, 300);
			return;
		case 7:
			buy(Items.string, 1, 3);
			return;
		case 8:
			buy(Items.bow, 1, 80);
			return;
		case 9:
			buy(Items.diamond_sword, 1, 200);
			return;
		case 10:
			buy(Items.golden_sword, 1, 100);
			return;
		case 11:
			buy(Item.getItemFromBlock(Blocks.diamond_block), 1, 800);
			return;
		case 12:
			buy(Item.getItemFromBlock(Blocks.beacon), 1, 900);
			return;
		case 13:
			buy(Item.getItemFromBlock(Blocks.dragon_egg), 1, 1500);
			return;
		case 14:
			buy(Items.ender_pearl, 1, 50);
			return;
		case 15:
			buy(Items.ender_eye, 1, 200);
			return;
		case 16:
			buy(Items.blaze_rod, 1, 250);
			return;
		case 17:
			buy(Items.blaze_powder, 1, 125);
			return;
		case 18:
			buy(Items.slime_ball, 1, 50);
			return;
		case 19:
			buy(Items.lead, 1, 75);
			return;
		case 20:
			buy(Items.golden_horse_armor, 1, 200);
			return;
		case 21:
			buy(Items.stick, 1, 5);
			return;
		case 22:
			buy(Items.nether_star, 1, 500);
			return;
		case 23:
			buy(Items.iron_sword, 1, 100);
			return;
		case 24:
			buy(Items.wooden_sword, 1, 50);
			return;
		case 25:
			buy(Items.diamond_helmet, 1, 500);
			return;
		case 26:
			buy(Items.diamond_chestplate, 1, 800);
			return;
		case 27:
			buy(Items.diamond_leggings, 1, 700);
			return;
		case 28:
			buy(Items.diamond_boots, 1, 400);
			return;
		case 30:
			page2();
			return;
		/*case 30:
			page3();
			return;*/
		case 31:
			page1();
			return;
		/*case 32:
			page4();
			return;
		case 33:
			page2();
			return;
		case 34:
			page3();
			return;*/
		}
	}

	public void buy(Item i, int amount, int cost){
		if(RPG.credits > 0)
			p.inventory.addItemStackToInventory(new ItemStack(i, amount));
		useCredits(cost);
	}
	
	public int useCredits(int howMany){
		if(RPG.credits >= 0)
			return RPG.credits -= howMany;
		else if(-1 > RPG.credits)
			return RPG.credits = 0;
		return RPG.credits;
	}

	private void page1() {
		this.buttonList.clear();
		final int x = this.width / 2 - 100;
		final int z = this.height / 2 - 175;
		final int w = 96;
		final int h = 20;
		addButton(new GuiButton(1, x, z + 86, w, h, "Arrow"));
		addButton(new GuiButton(2, x, z + 107, w, h, "Diamond"));
		addButton(new GuiButton(3, x, z + 128, w, h, "Gold Ingot"));
		addButton(new GuiButton(4, x, z + 149, w, h, "Iron Ingot"));
		addButton(new GuiButton(5, x, z + 170, w, h, "Golden Apple"));
		addButton(new GuiButton(6, x, z + 191, w, h, "OP Apple"));
		addButton(new GuiButton(7, x, z + 212, w, h, "String"));
		addButton(new GuiButton(8, x + 103, z + 86, w, h, "Bow"));
		addButton(new GuiButton(9, x + 103, z + 107, w, h, "Diamond Sword"));
		addButton(new GuiButton(10, x + 103, z + 128, w, h, "Golden Sword"));
		addButton(new GuiButton(11, x + 103, z + 149, w, h, "Diamond Block"));
		addButton(new GuiButton(12, x + 103, z + 170, w, h, "Beacon"));
		addButton(new GuiButton(13, x + 103, z + 191, w, h, "Dragon Egg"));
		addButton(new GuiButton(14, x + 103, z + 212, w, h, "Ender Pearl"));
		addMoveButtons();
		pageNum = 1;
	}

	private void page2() {
		this.buttonList.clear();
		final int x = this.width / 2 - 100;
		final int z = this.height / 2 - 175;
		final int w = 96;
		final int h = 20;
		addButton(new GuiButton(15, x, z + 86, w, h, "Ender Eye"));
		addButton(new GuiButton(16, x, z + 107, w, h, "Blaze Rod"));
		addButton(new GuiButton(17, x, z + 128, w, h, "Blaze Powder"));
		addButton(new GuiButton(18, x, z + 149, w, h, "Slime Ball"));
		addButton(new GuiButton(19, x, z + 170, w, h, "Lead"));
		addButton(new GuiButton(20, x, z + 191, w, h, "Gold Horse Armor"));
		addButton(new GuiButton(21, x, z + 212, w, h, "Stick"));
		addButton(new GuiButton(22, x + 103, z + 86, w, h, "Nether Star"));
		addButton(new GuiButton(23, x + 103, z + 107, w, h, "Iron Sword"));
		addButton(new GuiButton(24, x + 103, z + 128, w, h, "Wood Sword"));
		addButton(new GuiButton(25, x + 103, z + 149, w, h, "Diamond Helmet"));
		addButton(new GuiButton(26, x + 103, z + 170, w, h, "Diamond Chestplate"));
		addButton(new GuiButton(27, x + 103, z + 191, w, h, "Diamond Leggings"));
		addButton(new GuiButton(28, x + 103, z + 212, w, h, "Diamond Boots"));
		addMoveButtons();
		pageNum = 2;
	}
	
	/*private void page3(){
		this.buttonList.clear();
		final int x = this.width / 2 - 100;
		final int w = 96;
		final int h = 20;
		addButton(new GuiButton(1, x, 86, w, h, "SWAGZ"));
		addMoveButtons2();
	}
	
	private void page4(){
		this.buttonList.clear();
		final int x = this.width / 2 - 100;
		final int w = 96;
		final int h = 20;
		addButton(new GuiButton(1, x, 86, w, h, "#YOLO"));
		addMoveButtons3();
	}*/

	/*private void addMoveButton() {
		final int x = this.width / 2 - 100;
		addButton(new GuiButton(29, x, 255, 192, 20, ">>>"));
	}*/
	
	private void addMoveButtons() {
		final int x = this.width / 2 - 100;
		final int z = this.height / 2 - 175;
		addButton(new GuiButton(30, x + 103, z + 255, 96, 20, ">>>"));
		addButton(new GuiButton(31, x, z + 255, 96, 20, "<<<"));
	}
	
	/*private void addMoveButtons2() {
		final int x = this.width / 2 - 100;
		addButton(new GuiButton(32, x + 103, 255, 96, 20, ">>>"));
		addButton(new GuiButton(33, x, 255, 96, 20, "<<<"));
	}
	
	private void addMoveButtons3() {
		final int x = this.width / 2 - 100;
		addButton(new GuiButton(34, x, 255, 192, 20, "<<<"));
	}*/

	private void addButton(GuiButton b) {
		this.buttonList.add(b);
	}
}