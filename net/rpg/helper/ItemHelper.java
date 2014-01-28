package net.rpg.helper;

import java.util.HashMap;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.rpg.item.ItemCoin;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemHelper {
	private static HashMap<String, Item> itemMap = new HashMap<String, Item>();

	public static void init() {
		addItem("coin", new ItemCoin());
	}

	public static void addItem(String n, Item i) {
		i.setCreativeTab(tabItem);
		i.setUnlocalizedName(n);
		itemMap.put(n, i);
		GameRegistry.registerItem(i, n);
	}

	public static Item getItem(String n) {
		return itemMap.get(n);
	}

	public static final CreativeTabs tabItem = new CreativeTabs("rpg.items") {
		@Override
		public Item getTabIconItem() {
			return Items.iron_ingot;
		}
	};
}
