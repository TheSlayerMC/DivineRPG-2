package net.rpg;

import net.rpg.helper.ClientTickHelper;
import net.rpg.helper.KeyHelper;

public class ClientProxy extends ServerProxy {
	public KeyHelper KEY_HELPER;
	public ClientTickHelper CLIENT_TICK;

	public ClientProxy() {
		Util.info("Starting Client Proxy!");
		//KEY_HELPER = new KeyHelper();
		//CLIENT_TICK = new ClientTickHelper();
	}
}