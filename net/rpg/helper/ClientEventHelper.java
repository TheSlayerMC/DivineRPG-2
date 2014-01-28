package net.rpg.helper;

import net.minecraftforge.common.MinecraftForge;
import net.rpg.handler.ClientEventHandler;
import cpw.mods.fml.common.eventhandler.EventBus;

public class ClientEventHelper {
	public static void init() {
		EventBus funBus = MinecraftForge.EVENT_BUS;
		funBus.register(new ClientEventHandler());
	}
}
