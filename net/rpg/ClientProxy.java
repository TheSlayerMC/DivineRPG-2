package net.rpg;

import net.rpg.helper.ClientEventHelper;

public class ClientProxy extends ServerProxy {
	@Override
	public void doClient() {
		ClientEventHelper.init();
	}
}