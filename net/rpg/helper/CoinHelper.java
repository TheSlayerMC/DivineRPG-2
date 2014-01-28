package net.rpg.helper;

import java.io.File;

import net.minecraft.world.World;
import net.minecraftforge.common.config.Configuration;

public class CoinHelper {
	private static Configuration coinData;

	public static void load(World w) {
		coinData = new Configuration(new File("./saves/" + w.getWorldInfo().getWorldName() + "/rpgdata.dat"));
		coinData.load();
		save();
	}

	public static void save() {
		coinData.save();
	}

	public static void setCoins(String n, int amt) {
		coinData.get("Coin Data", n, amt);
		save();
	}

	public static void storePlayer(String n) {
		coinData.get("Coin Data", n, 0);
		save();
	}

	public static int getCoins(String n) {
		save();
		return coinData.get("Coin Data", n, 0).getInt();
	}
}