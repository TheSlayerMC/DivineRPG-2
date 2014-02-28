package net.rpg.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerRaceSelection extends Container {
	public ContainerRaceSelection(EntityPlayer p) {
	}

	@Override
	public boolean canInteractWith(EntityPlayer p) {
		return true;
	}
}