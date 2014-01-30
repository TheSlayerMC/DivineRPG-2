package net.rpg.handler;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.rpg.gui.GuiDeBar;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ClientEventHandler {
	private static final GuiDeBar DE_BAR = new GuiDeBar();

	@SubscribeEvent
	public void RenderGameOverlayEvent(RenderGameOverlayEvent event) {
		if(event.isCancelable() || event.type != ElementType.EXPERIENCE) {
			return;
		}
		DE_BAR.draw();
	}
}