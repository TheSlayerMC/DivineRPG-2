package net.rpg;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class RPG {
	@Instance(Reference.MOD_ID)
	public static RPG instance;
	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
	public static ServerProxy proxy;

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		proxy.doClient();
		proxy.doServer();
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
	}
}