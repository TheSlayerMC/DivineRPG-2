package rpg.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.client.settings.KeyBinding;

import org.lwjgl.input.Keyboard;

import rpg.RPG;
import rpg.network.PacketOpenGui;
import cpw.mods.fml.client.registry.ClientRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;
import cpw.mods.fml.common.gameevent.InputEvent.KeyInputEvent;

public class KeyHandler {
	private KeyBinding stats = new KeyBinding("Stats", Keyboard.KEY_F, "RPG");
	private KeyBinding abilitys = new KeyBinding("Abilitys", Keyboard.KEY_G, "RPG");
	private KeyBinding merchant = new KeyBinding("Merchant", Keyboard.KEY_M, "RPG");

	public KeyHandler() {
		ClientRegistry.registerKeyBinding(stats);
		ClientRegistry.registerKeyBinding(abilitys);
		ClientRegistry.registerKeyBinding(merchant);
	}

	@SubscribeEvent
	public void KeyInputEvent(KeyInputEvent event) {
		if(stats.isPressed()) {
			if(Minecraft.getMinecraft().currentScreen == null) {
				RPG.packetHandler.sendToServer(new PacketOpenGui().setID(1));
			}
		}
		if(abilitys.isPressed()) {
			if(Minecraft.getMinecraft().currentScreen == null) {
				RPG.packetHandler.sendToServer(new PacketOpenGui().setID(2));
			}
		}
		if(merchant.isPressed()) {
			if(Minecraft.getMinecraft().currentScreen == null) {
				RPG.packetHandler.sendToServer(new PacketOpenGui().setID(3));
			}
		}
	}
}