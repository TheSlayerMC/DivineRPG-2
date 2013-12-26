package net.rpg.helper;

import java.util.EnumSet;

import net.rpg.handler.BossTickHandler;
import net.rpg.handler.PlayerTickHandler;
import cpw.mods.fml.common.TickType;
import cpw.mods.fml.common.registry.TickRegistry;
import cpw.mods.fml.relauncher.Side;

public class TickHelper
{
	
	public TickHelper()
	{
		
		TickRegistry.registerTickHandler(new PlayerTickHandler(EnumSet.of(TickType.PLAYER)), Side.SERVER);

	}
	
}