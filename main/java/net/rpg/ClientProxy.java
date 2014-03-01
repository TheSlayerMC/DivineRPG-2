package net.rpg;

import net.minecraft.util.ResourceLocation;
import net.rpg.entity.EntityCredit;
import net.rpg.entity.projectile.EntityBouncingProjectile;
import net.rpg.entity.render.RenderCredit;
import net.rpg.entity.render.RenderProjectile;
import net.rpg.helper.ClientEventHelper;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy {
	public static ResourceLocation staffProjectile = new ResourceLocation(Reference.PREFIX_PROJECTILE + "bouncingProjectile.png");

	@Override
	public void doClient() {
		ClientEventHelper.init();
		RenderingRegistry.registerEntityRenderingHandler(EntityBouncingProjectile.class, new RenderProjectile(staffProjectile));
		RenderingRegistry.registerEntityRenderingHandler(EntityCredit.class, new RenderCredit());
	}
}