package net.rpg.helper;

import net.minecraft.client.settings.KeyBinding;
import net.rpg.handler.StatsKeyHandler;

import org.lwjgl.input.Keyboard;

import cpw.mods.fml.client.registry.KeyBindingRegistry;

public class KeyHelper
{
	
	public KeyHelper()
	{
		
		KeyBinding[] statsKey = {new KeyBinding("Stats", Keyboard.KEY_P)};
		boolean[] dunno = {false};
		
		KeyBindingRegistry.registerKeyBinding(new StatsKeyHandler(statsKey, dunno));
		
	}
	
}