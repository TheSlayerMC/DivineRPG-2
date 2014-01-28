package net.rpg.helper;

import net.rpg.RPG;
import net.rpg.handler.GuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GuiHelper {
	public static void init() {
		NetworkRegistry.INSTANCE.registerGuiHandler(RPG.instance, new GuiHandler());
	}
}
