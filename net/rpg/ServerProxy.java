package net.rpg;

import net.rpg.helper.ConfigHelper;
import net.rpg.helper.EventHelper;

public class ServerProxy {
	public ServerProxy() {
		Util.info("Starting Server Proxy!");
		ConfigHelper.init();
		ConfigHelper.load();
		EventHelper.init();
		ConfigHelper.save();
	}
}