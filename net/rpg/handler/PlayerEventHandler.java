package net.rpg.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingAttackEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.rpg.helper.DataHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PlayerEventHandler {
	@SubscribeEvent
	public void PlayerConstructionEvent(EntityConstructing event) {
		if(event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
		}
	}

	@SubscribeEvent
	public void PlayerJoinEvent(EntityJoinWorldEvent event) {
		if(event.entity instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
		}
	}

	@SubscribeEvent
	public void PlayerSpawnEvent(LivingSpawnEvent event) {
		if(event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
		}
	}

	@SubscribeEvent
	public void PlayerDeathEvent(LivingDeathEvent event) {
		if(event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
			player.heal(DataHelper.getDefense(player.getDisplayName()) / 4);
		}
	}

	@SubscribeEvent
	public void PlayerAttackevent(LivingAttackEvent event) {
		if(event.entityLiving instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.entity;
		}
		if(event.source.getSourceOfDamage() instanceof EntityPlayer) {
			EntityPlayer player = (EntityPlayer) event.source.getSourceOfDamage();
			event.entityLiving.attackEntityFrom(event.source, DataHelper.getAttack(player.getDisplayName()) / 4);
		}
	}
}