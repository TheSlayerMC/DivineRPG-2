package net.rpg;

import java.util.HashMap;

import net.rpg.helper.ConfigHelper;
import net.rpg.helper.EventHelper;
import net.rpg.helper.GuiHelper;
import net.rpg.helper.TickHelper;

public class ServerProxy {
	public ConfigHelper CONFIG_HELPER;
	public GuiHelper GUI_HELPER;
	public EventHelper EVENT_HELPER;
	public TickHelper TICK_HELPER;

	public ServerProxy() {
		Util.info("Starting Server Proxy!");
		CONFIG_HELPER = new ConfigHelper();
		CONFIG_HELPER.load();
		//GUI_HELPER = new GuiHelper();
		EVENT_HELPER = new EventHelper();
		//TICK_HELPER = new TickHelper();
		CONFIG_HELPER.save();
	}

	public HashMap<String, Object> data = new HashMap<String, Object>();

	public void storeData(String name, Object obj) {
		this.data.put(name, obj);
	}

	public Object getData(String name) {
		if(this.data.get(name) == null) {
			return null;
		} else {
			return this.data.get(name);
		}
	}
}