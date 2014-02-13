package net.rpg.handler;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.boss.*;
import net.minecraft.entity.item.*;
import net.minecraft.entity.monster.*;
import net.minecraft.entity.passive.*;
import net.minecraft.entity.player.*;
import net.minecraft.item.ItemStack;
import net.minecraftforge.event.entity.EntityEvent.*;
import net.minecraftforge.event.entity.*;
import net.minecraftforge.event.entity.living.*;
import net.rpg.*;
import net.rpg.helper.*;
import net.rpg.network.*;
import cpw.mods.fml.common.eventhandler.*;

public class ServerEventHandler {

	@SubscribeEvent
	public void EntityConstructionEvent(EntityConstructing event) { }

	@SubscribeEvent
	public void EntityJoinWorldEvent(EntityJoinWorldEvent event) {
		if(event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
			if(!player.worldObj.isRemote) {
				DataHelper.load(player.worldObj);
				DataHelper.loadPlayer(player);
				RPG.packetHandler.sendToServer(new PacketRequestStats());
				if(DataHelper.getRace(player) == -1 && !player.inventory.hasItem(ItemHelper.getItem("raceStone"))) {
					int es = player.inventory.getFirstEmptyStack();
					player.inventory.setInventorySlotContents(es, new ItemStack(ItemHelper.getItem("raceStone"), 1));
				} else {
					RPG.applyStats(player);
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