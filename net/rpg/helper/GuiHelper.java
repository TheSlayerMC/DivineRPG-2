package net.rpg.helper;

import net.rpg.RPG;
import net.rpg.handler.GuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHelper
{
	
	public GuiHelper()
	{
		
		NetworkRegistry.instance().registerGuiHandler(RPG.instance, new GuiHandler());
		
	}
	
}