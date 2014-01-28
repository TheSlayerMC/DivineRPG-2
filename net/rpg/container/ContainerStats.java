package net.rpg.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;

public class ContainerStats extends Container {
	public int coins = 0;
	public int attack = 0;
	public int defense = 0;

	public ContainerStats(EntityPlayer p) {
	}

	@Override
	public boolean canInteractWith(EntityPlayer p) {
		return true;
	}
}
