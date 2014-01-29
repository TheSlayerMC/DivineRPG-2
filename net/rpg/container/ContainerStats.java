package net.rpg.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.inventory.Container;
import net.rpg.RPG;
import net.rpg.helper.DataHelper;
import net.rpg.network.PacketStats;

public class ContainerStats extends Container {
	public int coins, attack, defense;

	public ContainerStats(EntityPlayer p) {
		if(!p.worldObj.isRemote) {
			EntityPlayerMP mp = (EntityPlayerMP) p;
			PacketStats ps = new PacketStats();
			ps.coins = DataHelper.getCoins(p.getDisplayName());
			ps.attack = DataHelper.getAttack(p.getDisplayName());
			ps.defense = DataHelper.getDefense(p.getDisplayName());
			RPG.packetHandler.sendTo(ps, mp);
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer p) {
		return true;
	}
}
