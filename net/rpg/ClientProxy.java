package net.rpg;

import net.minecraft.client.entity.EntityClientPlayerMP;
import net.rpg.entity.render.RenderPlayerRPG;
import net.rpg.gui.GuiArcanaBar;
import net.rpg.helper.ClientEventHelper;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy {
	@Override
	public void doClient() {
		ClientEventHelper.init();
		RenderingRegistry.registerEntityRenderingHandler(EntityClientPlayerMP.class, new RenderPlayerRPG(3.0F));
		//GuiArcanaBar.init();
	}
}