package net.rpg.helper;

import java.util.HashMap;

import net.minecraft.block.Block;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Blocks;
import net.minecraft.item.Item;
import cpw.mods.fml.common.registry.GameRegistry;

public class BlockHelper {
	private static HashMap<String, Block> blockMap = new HashMap<String, Block>();

	public static void init() {
	}

	public static void addBlock(String n, Block b) {
		b.func_149647_a(tabBlock);
		b.func_149663_c(n);
		b.func_149658_d("rpg:" + n);
		blockMap.put(n, b);
		GameRegistry.registerBlock(b, n);
	}

	public static Block getBlock(String n) {
		return blockMap.get(n);
	}

	public static final CreativeTabs tabBlock = new CreativeTabs("rpg.blocks") {
		@Override
		public Item getTabIconItem() {
			return Item.func_150898_a(Blocks.diamond_block);
		}
	};
}