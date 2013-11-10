package net.rpg;

import net.rpg.helper.TickHelper;
import net.rpg.helper.KeyHelper;

public class ClientProxy extends ServerProxy
{
	
	public KeyHelper KEY_HELPER;
	
	public ClientProxy()
	{
		
		Util.info("Starting Client Proxy!");
		
		KEY_HELPER = new KeyHelper();
		
	}
	
}