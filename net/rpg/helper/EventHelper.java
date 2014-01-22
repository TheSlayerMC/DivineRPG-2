package net.rpg.helper;

import net.minecraftforge.common.MinecraftForge;
import net.rpg.handler.PlayerEventHandler;
import cpw.mods.fml.common.eventhandler.EventBus;

public class EventHelper {
	public EventHelper() {
		EventBus funBus = MinecraftForge.EVENT_BUS;
		funBus.register(new PlayerEventHandler());
	}
}