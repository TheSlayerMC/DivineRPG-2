package net.rpg.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.rpg.container.ContainerRaceSelection;
import net.rpg.container.ContainerStats;
import net.rpg.gui.GuiRaceSelection;
import net.rpg.gui.GuiStats;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID) {
		case (0):
			return new ContainerRaceSelection(player);
		case (1):
			return new ContainerStats(player);
		}
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID) {
		case (0):
			return new GuiRaceSelection(player);
		case (1):
			return new GuiStats(player);
		}
		return null;
	}
}