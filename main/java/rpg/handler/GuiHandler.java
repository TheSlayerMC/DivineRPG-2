package rpg.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import rpg.container.ContainerRaceSelection;
import rpg.container.ContainerStats;
import rpg.gui.GuiAbilitys;
import rpg.gui.GuiMerchant;
import rpg.gui.GuiRaceSelection;
import rpg.gui.GuiStats;
import cpw.mods.fml.common.network.IGuiHandler;

public class GuiHandler implements IGuiHandler {
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world, int x, int y, int z) {
		switch(ID) {
		case (0):
			return new ContainerRaceSelection(player);
		case (1):
			return new ContainerStats(player);
		case (2):
			return new ContainerRaceSelection(player);
		case (3):
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
		case (2):
			return new GuiAbilitys(player);
		case (3):
			return new GuiMerchant(player);
		}
		return null;
	}
}