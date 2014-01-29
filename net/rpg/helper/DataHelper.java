package net.rpg.helper;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.world.World;
import net.minecraftforge.common.config.Configuration;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.relauncher.Side;

public class DataHelper {
	private static Configuration data;

	public static void load(World w) {
		if(Minecraft.getMinecraft().isSingleplayer()) {
			data = new Configuration(new File("./saves/" + w.getWorldInfo().getWorldName() + "/rpgdata.dat"));
		} else {
			data = new Configuration(new File("./" + w.getWorldInfo().getWorldName() + "/rpgdata.dat"));
		}
		data.load();
	}

	public static void save() {
		data.save();
	}

	public static void setRace(String n, int race) {
		data.get(n.toLowerCase(), "Race", 0).set(race);
		save();
	}

	public static int getRace(String n) {
		return data.get(n.toLowerCase(), "Race", 0).getInt();
	}

	public static void setCredits(String n, int amt) {
		data.get(n.toLowerCase(), "Credits", 0).set(amt);
		save();
	}

	public static int getCredits(String n) {
		return data.get(n.toLowerCase(), "Credits", 0).getInt();
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