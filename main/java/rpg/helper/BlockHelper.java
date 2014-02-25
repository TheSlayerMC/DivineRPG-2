package rpg.helper;

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
		b.setCreativeTab(tabBlock);
		b.setBlockName(n);
		b.setBlockTextureName("rpg:" + n);
		blockMap.put(n, b);
		GameRegistry.registerBlock(b, n);
	}

	public static Block getBlock(String n) {
		return blockMap.get(n);
	}

	public static final CreativeTabs tabBlock = new CreativeTabs("rpg.blocks") {
		@Override
		public Item getTabIconItem() {
			return Item.getItemFromBlock(Blocks.diamond_block);
		}
	};
}