package net.rpg.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.rpg.helper.DataHelper;
import net.rpg.helper.ItemHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ServerEventHandler {
	@SubscribeEvent
	public void EntityConstructionEvent(EntityConstructing event) {
		if(event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
			if(!player.worldObj.isRemote) {
			}
		}
	}

	@SubscribeEvent
	public void EntityJoinEvent(EntityJoinWorldEvent event) {
		if(event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
			if(!player.worldObj.isRemote) {
				DataHelper.load(player.worldObj);
				if(DataHelper.getRace(player.getDisplayName()) == -1 && !player.inventory.func_146028_b(ItemHelper.getItem("raceStone"))) {
					int es = player.inventory.getFirstEmptyStack();
					player.inventory.setInventorySlotContents(es, new ItemStack(ItemHelper.getItem("raceStone"), 1));
				}
			}
		}
	}

	@SubscribeEvent
	public void EntityDeathEvent(LivingDeathEvent event) {
		if(event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
		}
	}

	@SubscribeEvent
	public void EntityHurtEvent(LivingHurtEvent event) {
		if(event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
			player.heal(DataHelper.getDefense(player.getDisplayName()) / 4);
		}
	}

	@SubscribeEvent
	public void EntityAttackEvent(LivingAttackEvent event) {
		if(event.source.getSourceOfDamage() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.source.getSourceOfDamage();
			event.entity.attackEntityFrom(event.source, DataHelper.getAttack(player.getDisplayName()) / 4);
		}
	}
}