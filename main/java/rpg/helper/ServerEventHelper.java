package rpg.helper;

import net.minecraftforge.common.MinecraftForge;
import rpg.handler.ServerEventHandler;
import cpw.mods.fml.common.eventhandler.EventBus;

public class ServerEventHelper {
	public static void init() {
		EventBus funBus = MinecraftForge.EVENT_BUS;
		funBus.register(new ServerEventHandler());
	}
}