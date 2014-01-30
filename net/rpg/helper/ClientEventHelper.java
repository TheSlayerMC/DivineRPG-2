package net.rpg.helper;

import net.minecraftforge.common.MinecraftForge;
import net.rpg.handler.ClientEventHandler;
import net.rpg.handler.KeyHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.EventBus;

public class ClientEventHelper {
	public static void init() {
		EventBus funBus = FMLCommonHandler.instance().bus();
		funBus.register(new KeyHandler());
		funBus = MinecraftForge.EVENT_BUS;
		funBus.register(new ClientEventHandler());
	}
}