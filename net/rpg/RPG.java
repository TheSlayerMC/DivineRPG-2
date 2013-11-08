package net.rpg;

import net.rpg.helper.EventHelper;
import net.rpg.helper.GuiHelper;
import net.rpg.helper.KeyHelper;
import net.rpg.helper.TickHelper;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Util.MOD_ID, name = Util.MOD_NAME, version = Util.MOD_VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class RPG
{
	
	@Instance(Util.MOD_ID)
	public static RPG instance;
	
	@SidedProxy(clientSide = Util.CLIENT_PROXY, serverSide = Util.SERVER_PROXY)
	public static ServerProxy proxy;
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event)
	{
		

		
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		
		
		
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event)
	{
		
		
		
	}
	
}