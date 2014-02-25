package rpg;

import net.minecraft.util.ResourceLocation;
import rpg.entity.projectile.EntityBouncingProjectile;
import rpg.entity.render.RenderProjectile;
import rpg.helper.ClientEventHelper;
import cpw.mods.fml.client.registry.RenderingRegistry;

public class ClientProxy extends ServerProxy {
	public static ResourceLocation staffProjectile = new ResourceLocation(Reference.PREFIX_PROJECTILE + "bouncingProjectile.png");

	@Override
	public void doClient() {
		ClientEventHelper.init();
		RenderingRegistry.registerEntityRenderingHandler(EntityBouncingProjectile.class, new RenderProjectile(staffProjectile));
	}
}