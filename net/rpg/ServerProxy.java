package net.rpg;

import net.rpg.helper.EventHelper;
import net.rpg.helper.GuiHelper;
import net.rpg.helper.KeyHelper;
import net.rpg.helper.TickHelper;

public class ServerProxy
{
	
	public static GuiHelper GUI_HELPER;
	public static EventHelper EVENT_HELPER;
	public static TickHelper TICK_HELPER;
	public static KeyHelper KEY_HELPER;
	
	public ServerProxy()
	{
		
		Util.print("Starting Server Proxy!");
		
		GUI_HELPER = new GuiHelper();
		EVENT_HELPER = new EventHelper();
		TICK_HELPER = new TickHelper();
		KEY_HELPER = new KeyHelper();
		
	}
	
}