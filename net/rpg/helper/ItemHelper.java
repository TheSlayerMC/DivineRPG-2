package net.rpg.helper;

import java.util.HashMap;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.rpg.item.ItemCredit;
import net.rpg.item.ItemEnergyStaff;
import net.rpg.item.ItemRaceStone;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemHelper {
	private static HashMap<String, Item> itemMap = new HashMap<String, Item>();

	public static void init() {
		addItem("raceStone", new ItemRaceStone());
		addItem("credit", new ItemCredit());
		addItem("eStaff", new ItemEnergyStaff());
	}

	public static void addItem(String n, Item i) {
		i.setCreativeTab(tabItem);
		i.setUnlocalizedName(n);
		i.setTextureName("rpg:" + n);
		itemMap.put(n, i);
		GameRegistry.registerItem(i, n);
	}

	public static Item getItem(String n) {
		return itemMap.get(n);
	}

	public static final CreativeTabs tabItem = new CreativeTabs("rpg.items") {
		@Override
		public Item getTabIconItem() {
			return getItem("raceStone");
		}
	};
}
