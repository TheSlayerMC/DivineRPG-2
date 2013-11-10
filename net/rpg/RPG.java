package net.rpg;

import net.rpg.handler.PacketHandler;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.network.NetworkMod;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false, channels = {"RPG"}, packetHandler = PacketHandler.class)

public class RPG
{
	
	@Instance(Reference.MOD_ID)
	public static RPG instance;

	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
	public static ServerProxy proxy;

	/**
	 * In the assets, there is a GUITextureSheet, The blue XP looking one is for
	 * your 'Mana Bar' (if you class has mana) The Red one is for the bosses
	 * health bar, and the player item looking one is for extra accesories...
	 **/
	
}