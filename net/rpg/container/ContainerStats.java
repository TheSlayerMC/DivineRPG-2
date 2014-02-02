package net.rpg.container;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.inventory.Container;
import net.rpg.helper.DataHelper;
import net.rpg.network.PacketStatsToClient;

public class ContainerStats extends Container {
	public int coins, attack, defense;

	public ContainerStats(EntityPlayer p) {
		if(!p.worldObj.isRemote) {
			PacketStatsToClient ps = new PacketStatsToClient();
			ps.race = DataHelper.getRace(p);
			ps.maxHp = DataHelper.getMaxHp(p);
			ps.de = DataHelper.getDe(p);
			ps.maxDe = DataHelper.getMaxDe(p);
			ps.credits = DataHelper.getCredits(p);
			ps.attack = DataHelper.getAttack(p);
			ps.defense = DataHelper.getDefense(p);
			/*ps.maxAr = DataHelper.getMaxArcana(p);
			ps.ar = DataHelper.getArcana(p);
			ps.discount = DataHelper.getDiscount(p);
			ps.luck = DataHelper.getLuck(p);
			ps.reflex = DataHelper.getReflex(p);
			ps.stamina = DataHelper.getStamina(p);
			ps.speed = DataHelper.getSpeed(p);*/
		}
	}

	@Override
	public boolean canInteractWith(EntityPlayer p) {
		return true;
	}
}
