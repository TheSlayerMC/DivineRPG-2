package net.rpg.helper;

import net.rpg.RPG;
import net.rpg.handler.GuiHandler;
import net.rpg.handler.PacketHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class NetworkHelper {
	public static void init() {
		NetworkRegistry nr = NetworkRegistry.INSTANCE;
		nr.registerGuiHandler(RPG.instance, new GuiHandler());
		nr.newChannel("RPG", new PacketHandler());
	}
}