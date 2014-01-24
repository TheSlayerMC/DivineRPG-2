package net.rpg;

import net.rpg.handler.GuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class ClientProxy extends ServerProxy {
	public ClientProxy() {
		Util.info("Starting Client Proxy!");
	}
}