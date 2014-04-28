package net.rpg.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderPlayerEvent;
import net.rpg.Util;
import net.rpg.entity.render.RenderPlayerRPG;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class PlayerRenderHandler {
	@SubscribeEvent
	public void renderPrePlayer(RenderPlayerEvent.Pre event) {
		EntityPlayer player = event.entityPlayer;
		if(!Util.isNewPlayer(player)) {
			event.setCanceled(true);
			System.err.println("RENDERING");
			RenderPlayerRPG.INSTANCE.doRender(player, player.posX, player.posY, player.posZ, player.rotationYawHead, event.partialRenderTick);
		}
	}
}