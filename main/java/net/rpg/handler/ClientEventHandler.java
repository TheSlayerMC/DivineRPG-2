package net.rpg.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.rpg.RPG;
import net.rpg.gui.GuiArcanaBar;
import net.rpg.gui.GuiDeBar;
import net.rpg.gui.GuiVersion;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ClientEventHandler {
	private EntityPlayer p = Minecraft.getMinecraft().thePlayer;

	@SubscribeEvent
	public void RenderGameOverlayEvent(RenderGameOverlayEvent event) {
		GuiVersion.draw();
		if(!Minecraft.getMinecraft().playerController.shouldDrawHUD() || event.isCancelable() || event.type != ElementType.EXPERIENCE)
			return;
		if(RPG.race == -1 && canUseMana()) {
			GuiDeBar.draw();
			GuiArcanaBar.draw();
		}
	}

	public boolean canUseMana() {// for later use
		return true;
	}

	@SubscribeEvent
	public void RenderHandEvent(net.minecraftforge.client.event.RenderHandEvent event) {
	}
}