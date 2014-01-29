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
		data.get(n.toLowerCase(), "Coins", 0).set(amt);
		save();
	}

	public static int getCoins(String n) {
		return data.get(n.toLowerCase(), "Coins", 0).getInt();
	}

	public static void setAttack(String n, int amt) {
		data.get(n.toLowerCase(), "Attack", 0).set(amt);
		save();
	}

	public static int getAttack(String n) {
		return data.get(n.toLowerCase(), "Attack", 0).getInt();
	}

	public static void setDefense(String n, int amt) {
		data.get(n.toLowerCase(), "Defense", 0).set(amt);
		save();
	}

	public static int getDefense(String n) {
		return data.get(n.toLowerCase(), "Defense", 0).getInt();
	}
}