package net.rpg.helper;

import java.util.HashMap;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.rpg.item.ItemCredit;
import net.rpg.item.ItemEnergyStaff;
import net.rpg.item.ItemRaceStone;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemHelper {
	private static HashMap<String, Item> itemMap = new HashMap<String, Item>();

	public static ToolMaterial cyclopsianSword = EnumHelper.addToolMaterial("cyclops", 0, -1, 0, 3, 30);
	
	public static void init() {
		addItem("raceStone", new ItemRaceStone());
		addItem("credit", new ItemCredit());
		addItem("eStaff", new ItemEnergyStaff());
		addItem("cyclopsianSword", new ItemSword(cyclopsianSword));
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
