package net.rpg.helper;

import java.io.File;

import net.minecraftforge.common.config.Configuration;
import net.rpg.Reference;

public class ConfigHelper {
	public static Configuration config;

	public ConfigHelper() {
		ConfigHelper.config = new Configuration(new File("./" + Reference.MOD_NAME + "/configuration.cfg"));
	}

	public void load() {
		ConfigHelper.config.load();
	}

	public void save() {
		ConfigHelper.config.save();
	}
}