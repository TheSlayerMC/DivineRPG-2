package net.rpg.helper;

import net.minecraftforge.common.MinecraftForge;
import net.rpg.handler.EntityEventHandler;
import cpw.mods.fml.common.FMLCommonHandler;
import cpw.mods.fml.common.eventhandler.EventBus;

public class ServerEventHelper {
	public static void init() {
		EventBus funBus = FMLCommonHandler.instance().bus();
		funBus.register(new EntityEventHandler());
	}
}