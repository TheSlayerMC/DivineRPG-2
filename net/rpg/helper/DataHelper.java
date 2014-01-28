package net.rpg.helper;

import java.io.File;

import net.minecraft.world.World;
import net.minecraftforge.common.config.Configuration;

public class DataHelper {
	private static Configuration data;

	public static void load(World w) {
		data = new Configuration(new File("./saves/" + w.getWorldInfo().getWorldName() + "/rpgdata.dat"));
		data.load();
	}

	public static void save() {
		data.save();
	}

	public static void setCoins(String n, int amt) {
		data.get(n, "Coins", 0).set(amt);
		save();
	}

	public static int getCoins(String n) {
		return data.get(n, "Coins", 0).getInt();
	}
}