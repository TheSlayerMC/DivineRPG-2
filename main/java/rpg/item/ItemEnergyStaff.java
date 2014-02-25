package rpg.item;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityArrow;
import net.minecraft.item.EnumRarity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import rpg.RPG;
import rpg.helper.DataHelper;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

public class ItemEnergyStaff extends Item {
	private final int COST = 1;

	@Override
	public ItemStack onItemRightClick(ItemStack par1ItemStack, World par2World, EntityPlayer par3EntityPlayer) {
		if(!par2World.isRemote) {
			par3EntityPlayer.openGui(RPG.instance, 3, par2World, (int) par3EntityPlayer.posX, (int) par3EntityPlayer.posY, (int) par3EntityPlayer.posZ);
		}
		return par1ItemStack;
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