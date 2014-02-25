package rpg.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import rpg.helper.DataHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEnergyStaff extends Item {
	private final int COST = 1;

	@Override
	public ItemStack onItemRightClick(ItemStack is, World world, EntityPlayer player) {
		if(!world.isRemote) {
			if(DataHelper.getDe(player) >= COST) {
				DataHelper.setDe(player, DataHelper.getDe(player) - COST);
				world.spawnEntityInWorld(new EntityArrow(world, player, 1));
			}
		}
		return is;
	}

	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack is) {
		return true;
	}

	@Override
	public EnumRarity getRarity(ItemStack is) {
		return EnumRarity.epic;
	}
}