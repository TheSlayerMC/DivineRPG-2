package net.rpg;

import net.rpg.proxy.CommonProxy;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Utils.Mod_ID, name = Utils.Mod_Name, version = Utils.Mod_Version)
@NetworkMod(clientSideRequired = true, serverSideRequired = true)
public class RPG {

	@Instance
	public static RPG instance;
	
	@SidedProxy(clientSide = "net.rpg.proxy.ClientProxy", serverSide = "net.rpg.proxy.CommonProxy")
	public static CommonProxy proxy;
	
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event){
		proxy.preInit(event);
	}
	
	@EventHandler
	public static void init(FMLInitializationEvent event){
		proxy.init(event);
	}
	
	@EventHandler
	public static void postInit(FMLPostInitializationEvent event){
		proxy.postInit(event);
	}
	
	
}
