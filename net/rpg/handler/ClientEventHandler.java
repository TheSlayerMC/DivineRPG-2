package net.rpg.handler;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.client.event.RenderGameOverlayEvent.ElementType;
import net.rpg.RPG;
import net.rpg.Reference;
import net.rpg.gui.GuiArcanaBar;
import net.rpg.gui.GuiDeBar;
import net.rpg.gui.GuiVersion;
import cpw.mods.fml.common.eventhandler.SubscribeEvent;

public class ClientEventHandler {
	private static EntityPlayer p = Minecraft.getMinecraft().thePlayer;
	
	private static final GuiDeBar DE_BAR = new GuiDeBar();
	private static final GuiArcanaBar AR_BAR = new GuiArcanaBar();
	private static final GuiVersion VERSION = new GuiVersion();
	
	@SubscribeEvent
	public void RenderGameOverlayEvent(RenderGameOverlayEvent event) {
		if(event.isCancelable() || event.type != ElementType.EXPERIENCE)
			return;
		
		VERSION.init();
		DE_BAR.draw();
		AR_BAR.init();
	}
}