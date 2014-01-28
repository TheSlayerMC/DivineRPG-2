package net.rpg.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.rpg.helper.DataHelper;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class WorldEventHandler {
	@SubscribeEvent
	public void EntityJoinWorldEvent(EntityJoinWorldEvent event) {
		if(!event.world.isRemote && event.entity instanceof EntityPlayer) {
			EntityPlayer p = (EntityPlayer) event.entity;
			DataHelper.load(event.world);
		}
	}
}
