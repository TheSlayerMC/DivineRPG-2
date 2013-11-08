package net.rpg.helper;

import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.event.EventBus;
import net.rpg.handler.PlayerEventHandler;

public class EventHelper
{
	
	public EventHelper()
	{
		
		EventBus funBus = MinecraftForge.EVENT_BUS;
		
		funBus.register(new PlayerEventHandler());
		
	}
	
}