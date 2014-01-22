package net.rpg;

import java.util.ArrayList;

import net.minecraft.block.Block;
import net.minecraft.item.Item;
import net.rpg.helper.ConfigHelper;
import net.rpg.helper.EventHelper;

public class ServerProxy {
	private static ArrayList<Block> blockMap = new ArrayList<Block>();
	private static ArrayList<Item> itemMap = new ArrayList<Item>();

	public ServerProxy() {
		Util.info("Starting Server Proxy!");
		ConfigHelper.init();
		ConfigHelper.load();
		EventHelper.init();
		ConfigHelper.save();
	}

	public static void addBlock(Block b) {
		blockMap.add(b);
	}

	public static void addItem(Item i) {
		itemMap.add(i);
	}

	public static Block getBlock(String name) {
		for(Block b : blockMap) {
			if(b.func_149739_a().equals(name)) {
				return b;
			}
		}
		return null;
	}

	public static Item getItem(String name) {
		for(Item i : itemMap) {
			if(i.getUnlocalizedName().equals(name)) {
				return i;
			}
		}
		return null;
	}
}