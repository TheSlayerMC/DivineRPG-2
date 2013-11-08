package net.rpg.handler;

import java.util.EnumSet;

import net.minecraft.client.settings.KeyBinding;
import cpw.mods.fml.client.registry.KeyBindingRegistry.KeyHandler;
import cpw.mods.fml.common.TickType;

public class StatsKeyHandler extends KeyHandler
{
	
	private EnumSet tickTypes = EnumSet.of(TickType.CLIENT);

	public static boolean keyPressed = false;

	public static boolean pressed = false;

	public StatsKeyHandler(KeyBinding[] keyBindings, boolean[] repeatings)
	{

		super(keyBindings, repeatings);

	}

	@Override
	public String getLabel()
	{

		return "N/A";

	}

	@Override
	public void keyDown(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd, boolean isRepeat)
	{

		keyPressed = true;

	}

	@Override
	public void keyUp(EnumSet<TickType> types, KeyBinding kb, boolean tickEnd)
	{

		if (keyPressed)
		{

			keyPressed = false;
			pressed = true;

		}

	}

	@Override
	public EnumSet<TickType> ticks()
	{

		return tickTypes;

	}
	
}