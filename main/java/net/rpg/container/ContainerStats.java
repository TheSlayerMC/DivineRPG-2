package net.rpg.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.rpg.RPG;
import net.rpg.Util;

public class ContainerStats extends Container {
	public ContainerStats(EntityPlayer p) {
		if(!p.worldObj.isRemote)
			Util.sendStats(p);
	}

	@Override
	public boolean canInteractWith(EntityPlayer p) {
		return true;
	}
}