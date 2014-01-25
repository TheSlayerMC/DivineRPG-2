package net.rpg.core;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;

public class RPGTabs {
	public static final CreativeTabs tabBlock = new CreativeTabs("rpg.blocks") {
		@Override
		public Item getTabIconItem() {
			return Item.func_150898_a(Blocks.diamond_block);
		}
	};
	public static final CreativeTabs tabItem = new CreativeTabs("rpg.items") {
		@Override
		public Item getTabIconItem() {
			return Items.diamond;
		}
	};
}
