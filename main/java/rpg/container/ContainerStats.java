package rpg.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import rpg.RPG;
import rpg.helper.DataHelper;
import rpg.network.PacketStatsToClient;

public class ContainerStats extends Container {
	public ContainerStats(EntityPlayer p) {
		if(!p.worldObj.isRemote) {
			RPG.sendStats(p);
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer p) {
		return true;
	}
}