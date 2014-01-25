package net.rpg.core;

import java.util.ArrayList;

import net.rpg.core.item.ItemRPG;
import net.rpg.helper.ConfigHelper;
import net.rpg.helper.EventHelper;
import tlhpoe.bonanzas.block.BlockMod;

public class ServerProxy {
	private ArrayList<BlockMod> blockMap = new ArrayList<BlockMod>();
	private ArrayList<ItemRPG> itemMap = new ArrayList<ItemRPG>();

	public void preInit() {
		ConfigHelper.init();
		ConfigHelper.load();
		EventHelper.init();
		ConfigHelper.save();
	}

	public void init() {
	}

	public void postInit() {
	}

	public void addBlock(BlockMod b) {
		blockMap.add(b);
	}

	public void addItem(ItemRPG i) {
		itemMap.add(i);
	}

	public BlockMod getBlock(String name) {
		for(BlockMod b : blockMap) {
			if(b.func_149739_a().equals(name)) {
				return b;
			}
		}
		return null;
	}

	public ItemRPG getItem(String name) {
		for(ItemRPG i : itemMap) {
			if(i.getUnlocalizedName().equals(name)) {
				return i;
			}
		}
		return null;
	}

	public void doClientStuff() {
	}
}