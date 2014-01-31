package net.rpg.handler;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.rpg.RPG;
import net.rpg.helper.DataHelper;
import net.rpg.helper.ItemHelper;
import net.rpg.network.PacketRequestStats;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ServerEventHandler {
	@SubscribeEvent
	public void EntityConstructionEvent(EntityConstructing event) {
	}

	@SubscribeEvent
	public void EntityJoinWorldEvent(EntityJoinWorldEvent event) {
		if(event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
			if(!player.worldObj.isRemote) {
				DataHelper.load(player.worldObj);
				DataHelper.loadPlayer(player);
				RPG.packetHandler.sendToServer(new PacketRequestStats());
				if(DataHelper.getRace(player) == -1 && !player.inventory.func_146028_b(ItemHelper.getItem("raceStone"))) {
					int es = player.inventory.getFirstEmptyStack();
					player.inventory.setInventorySlotContents(es, new ItemStack(ItemHelper.getItem("raceStone"), 1));
				}
			}
		}
	}

	@SubscribeEvent
	public void LivingDeathEvent(LivingDeathEvent event) {
	}

	@SubscribeEvent
	public void LivingHurtEvent(LivingHurtEvent event) {
		if(event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entityLiving;
			event.ammount -= (event.ammount * (DataHelper.getDefense(player) / 100));
		} else if(event.source.getSourceOfDamage() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.source.getSourceOfDamage();
			event.ammount += (event.ammount * (DataHelper.getAttack(player) / 100));
		}
	}

	@SubscribeEvent
	public void LivingDropsEvent(LivingDropsEvent event) {
		EntityLivingBase e = event.entityLiving;
		if(e instanceof EntityMob) {
			event.drops.add(new EntityItem(e.worldObj, e.posX, e.posY, e.posZ, new ItemStack(ItemHelper.getItem("credit"), 1 + e.worldObj.rand.nextInt(4))));
		}
	}
}