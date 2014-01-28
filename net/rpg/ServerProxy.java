package net.rpg;

import net.rpg.helper.BlockHelper;
import net.rpg.helper.ConfigHelper;
import net.rpg.helper.EventHelper;
import net.rpg.helper.ItemHelper;

public class ServerProxy {
	public void doServer() {
		ConfigHelper.init();
		ConfigHelper.load();
		ItemHelper.init();
		BlockHelper.init();
		EventHelper.init();
		ConfigHelper.save();
	}

	public void doClient() {
	}
}