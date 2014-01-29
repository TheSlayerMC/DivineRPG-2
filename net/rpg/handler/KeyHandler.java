package net.rpg.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;
import net.rpg.RPG;
import net.rpg.network.PacketOpenStats;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;

public class KeyHandler {
	private KeyBinding stats = new KeyBinding("Stats", Keyboard.KEY_F, "RPG");

	public KeyHandler() {
		ClientRegistry.registerKeyBinding(stats);
	}

	@SubscribeEvent
	public void KeyInputEvent(KeyInputEvent event) {
		if(stats.func_151468_f()) {
			if(Minecraft.getMinecraft().currentScreen == null) {
				RPG.instance.packetHandler.sendToServer(new PacketOpenStats());
			}
		}
	}
}