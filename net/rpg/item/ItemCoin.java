package net.rpg.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemAppleGold;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import net.rpg.helper.DataHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCoin extends Item {
	@Override
	public void onUpdate(ItemStack is, World w, Entity e, int par4, boolean par5) {
		if(!w.isRemote) {
			new ItemAppleGold(par4, par4, par5);
			if(e instanceof EntityPlayer) {
				EntityPlayer p = (EntityPlayer) e;
				if(is.stackSize == 0) {
					p.inventory.setInventorySlotContents(par4, null);
				} else {
					is.stackSize--;
					DataHelper.setCoins(p.getDisplayName(), DataHelper.getCoins(p.getDisplayName()) + 1);
				}
			} else {
				is.stackSize--;
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldRotateAroundWhenRendering() {
		return true;
	}
}