package net.rpg.handler;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.EntityDragon;
import net.minecraft.entity.boss.EntityWither;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntityEnderman;
import net.minecraft.entity.monster.EntityMob;
import net.minecraft.entity.monster.EntitySlime;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingDropsEvent;
import net.minecraftforge.event.entity.living.LivingHurtEvent;
import net.rpg.Util;
import net.rpg.helper.ItemHelper;
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
				if(Util.isNewPlayer(player)) {
					int es = player.inventory.getFirstEmptyStack();
					player.inventory.setInventorySlotContents(es, new ItemStack(ItemHelper.getItem("raceStone"), 1));
				} else {
					Util.applyStats(player);
				}
				Util.sendPlayerRaces(player);
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
			int d = Util.getIntegerStat(player, "Defense");
			event.ammount -= (event.ammount * (d / 100));
		} else if(event.source.getSourceOfDamage() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.source.getSourceOfDamage();
			int a = Util.getIntegerStat(player, "Attack");
			event.ammount += (event.ammount * (a / 100));
		}
	}

	@SubscribeEvent
	public void LivingDropsEvent(LivingDropsEvent event) {
		EntityLivingBase e = event.entityLiving;
		if(e instanceof EntityMob && !(e instanceof EntityCreeper) && !(e instanceof EntityEnderman)) {
			for(int i = 0; i < 1 + e.worldObj.rand.nextInt(100); i++)
				event.drops.add(new EntityItem(e.worldObj, e.posX, e.posY, e.posZ, new ItemStack(ItemHelper.getItem("credit"), 1)));
		}
		if(e instanceof EntityAnimal) {
			for(int i = 0; i < 1 + e.worldObj.rand.nextInt(20); i++)
				event.drops.add(new EntityItem(e.worldObj, e.posX, e.posY, e.posZ, new ItemStack(ItemHelper.getItem("credit"), 1)));
		}
		if(e instanceof EntityCreeper || e instanceof EntityEnderman) {
			for(int i = 0; i < 1 + e.worldObj.rand.nextInt(150); i++)
				event.drops.add(new EntityItem(e.worldObj, e.posX, e.posY, e.posZ, new ItemStack(ItemHelper.getItem("credit"), 1)));
		}
		if(e instanceof EntityVillager) {
			for(int i = 0; i < 1 + e.worldObj.rand.nextInt(60); i++)
				event.drops.add(new EntityItem(e.worldObj, e.posX, e.posY, e.posZ, new ItemStack(ItemHelper.getItem("credit"), 1)));
		}
		if(e instanceof EntitySlime) {
			for(int i = 0; i < 1 + e.worldObj.rand.nextInt(10); i++)
				event.drops.add(new EntityItem(e.worldObj, e.posX, e.posY, e.posZ, new ItemStack(ItemHelper.getItem("credit"), 1)));
		}
		if(e instanceof EntityDragon || e instanceof EntityWither) {
			for(int i = 0; i < 1 + e.worldObj.rand.nextInt(1000); i++)
				event.drops.add(new EntityItem(e.worldObj, e.posX, e.posY, e.posZ, new ItemStack(ItemHelper.getItem("credit"), 1)));
		}
	}
}