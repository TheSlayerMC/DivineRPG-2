package net.rpg;

import net.rpg.entity.*;
import net.rpg.handler.*;
import net.rpg.helper.*;
import cpw.mods.fml.common.registry.*;
import cpw.mods.fml.relauncher.*;

public class ClientProxy extends ServerProxy {

	public KeyHelper KEY_HELPER;
	public ClientTickHelper CLIENT_TICK;

	public ClientProxy() {
		Util.info("Starting Client Proxy!");
		KEY_HELPER = new KeyHelper();
		CLIENT_TICK = new ClientTickHelper();
	}
}