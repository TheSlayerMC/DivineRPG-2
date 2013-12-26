package net.rpg.helper;

import net.rpg.handler.BossTickHandler;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class ClientTickHelper {

	public void init(){
		TickRegistry.registerTickHandler(new BossTickHandler(), Side.CLIENT);
	}
	
}
