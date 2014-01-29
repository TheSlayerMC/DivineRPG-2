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
			String n = p.getDisplayName();
			ps.race = DataHelper.getRace(n);
			ps.credits = DataHelper.getCredits(n);
			ps.attack = DataHelper.getAttack(n);
			ps.defense = DataHelper.getDefense(n);
			RPG.packetHandler.sendTo(ps, mp);
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer p) {
		return true;
	}
}
