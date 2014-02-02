package net.rpg.handler;

import net.minecraft.client.Minecraft;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.rpg.RPG;
import net.rpg.gui.GuiArcanaBar;
import net.rpg.gui.GuiDeBar;
import net.rpg.gui.GuiVersion;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ClientEventHandler {
	@SubscribeEvent
	public void RenderGameOverlayEvent(RenderGameOverlayEvent event) {
		if(!Minecraft.getMinecraft().playerController.shouldDrawHUD() || event.isCancelable() || event.type != ElementType.EXPERIENCE) {
			return;
		}
		GuiVersion.draw();
		if(RPG.race == -1) {
			GuiDeBar.draw();
			GuiArcanaBar.draw();
		}
	}
}