package net.rpg.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.rpg.RPG;

public class ItemTest extends Item {
	@Override
	public ItemStack onItemRightClick(ItemStack is, World w, EntityPlayer p) {
		if(!w.isRemote) {
			p.openGui(RPG.instance, 0, w, p.serverPosX, p.serverPosY, p.serverPosZ);
		}
		return is;
	}
}