package net.rpg.helper;

import java.util.HashMap;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.Item.ToolMaterial;
import net.minecraft.item.ItemSword;
import net.minecraftforge.common.util.EnumHelper;
import net.rpg.item.ItemRaceStone;
import net.rpg.item.ItemStaff;
import cpw.mods.fml.common.registry.GameRegistry;

public class ItemHelper {
	private static HashMap<String, Item> itemMap = new HashMap<String, Item>();
	public static ToolMaterial cyclopsianSword = EnumHelper.addToolMaterial("cyclops", 0, -1, 0, 3, 30);
	public static ToolMaterial cermileMat = EnumHelper.addToolMaterial("cermileBack", 0, -1, 0, 8, 20);

	public static void init() {
		addItem("raceStone", new ItemRaceStone());
		addItem("cyclopsianSword", new ItemSword(cyclopsianSword));
		addItem("cermileBacksword", new ItemSword(cermileMat));
		addItem("teakerStaff", new ItemStaff(3, 10));
		addItem("amthrimisStaff", new ItemStaff(5, 10));
		addItem("darvenStaff", new ItemStaff(8, 10));
		addItem("cermileStaff", new ItemStaff(12, 10));
		addItem("pardimalStaff", new ItemStaff(15, 10));
		addItem("quadroticStaff", new ItemStaff(19, 10));
		addItem("karosStaff", new ItemStaff(21, 10));
		addItem("heliosisStaff", new ItemStaff(28, 10));
		addItem("arksianeStaff", new ItemStaff(36, 10));
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
