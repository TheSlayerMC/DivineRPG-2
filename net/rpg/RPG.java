package net.rpg;

import net.rpg.handler.PacketHandler;
import net.rpg.network.PacketOpenGui;
import net.rpg.network.PacketRace;
import net.rpg.network.PacketRequestStats;
import net.rpg.network.PacketStatsToClient;
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
	public static final PacketHandler packetHandler = new PacketHandler();

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		proxy.doServer();
		proxy.doClient();
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		packetHandler.init();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		packetHandler.registerPacket(PacketStatsToClient.class);
		packetHandler.registerPacket(PacketRequestStats.class);
		packetHandler.registerPacket(PacketRace.class);
		packetHandler.registerPacket(PacketOpenGui.class);
		packetHandler.postInit();
	}

	public static int race = -1, credits, attack, defense;
}