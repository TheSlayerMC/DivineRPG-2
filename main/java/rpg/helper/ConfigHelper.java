package rpg.helper;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import rpg.Reference;

public class ConfigHelper {
	public static Configuration config;

	public static void init() {
		ConfigHelper.config = new Configuration(new File("./" + Reference.MOD_NAME + "/configuration.cfg"));
	}

	public static void load() {
		ConfigHelper.config.load();
	}

	public static void save() {
		ConfigHelper.config.save();
	}
}