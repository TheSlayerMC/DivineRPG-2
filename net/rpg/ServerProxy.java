package net.rpg;

import net.rpg.helper.BlockHelper;
import net.rpg.helper.ConfigHelper;
import net.rpg.helper.GuiHelper;
import net.rpg.helper.ItemHelper;
import net.rpg.helper.ServerEventHelper;

public class ServerProxy {
	public void doServer() {
		ConfigHelper.init();
		ConfigHelper.load();
		ItemHelper.init();
		BlockHelper.init();
		ServerEventHelper.init();
		GuiHelper.init();
		ConfigHelper.save();
	}

	public void doClient() {
	}
}