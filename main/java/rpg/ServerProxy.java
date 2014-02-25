package rpg;

import rpg.helper.BlockHelper;
import rpg.helper.ConfigHelper;
import rpg.helper.ItemHelper;
import rpg.helper.NetworkHelper;
import rpg.helper.ServerEventHelper;

public class ServerProxy {
	public void doServer() {
		ConfigHelper.init();
		ConfigHelper.load();
		ItemHelper.init();
		BlockHelper.init();
		ServerEventHelper.init();
		NetworkHelper.init();
		ConfigHelper.save();
	}

	public void doClient() {
	}
}