package rpg.item;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import rpg.helper.DataHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemCredit extends Item {
	public ItemCredit() {
		this.setMaxStackSize(1);
	}

	@Override
	public void onUpdate(ItemStack is, World w, Entity e, int par4, boolean par5) {
		if(!w.isRemote) {
			if(e instanceof EntityPlayer) {
				EntityPlayer p = (EntityPlayer) e;
				DataHelper.setCredits(p, DataHelper.getCredits(p) + is.stackSize);
				p.inventory.setInventorySlotContents(par4, null);
			} else {
				is = null;
			}
		} else {
			if(e instanceof EntityPlayer) {
				EntityPlayer p = (EntityPlayer) e;
				p.inventory.setInventorySlotContents(par4, null);
			} else {
				is = null;
			}
		}
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean shouldRotateAroundWhenRendering() {
		return true;
	}
}