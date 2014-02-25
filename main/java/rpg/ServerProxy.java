package rpg;

import cpw.mods.fml.common.registry.EntityRegistry;
import rpg.entity.projectile.EntityBouncingProjectile;
import rpg.helper.BlockHelper;
import rpg.helper.ConfigHelper;
import rpg.helper.ItemHelper;
import rpg.helper.NetworkHelper;
import rpg.helper.ServerEventHelper;

public class ServerProxy {
	public void doServer() {
		ConfigHelper.init();
		ConfigHelper.load();
		ItemHelper.init();
		BlockHelper.init();
		ServerEventHelper.init();
		NetworkHelper.init();
		ConfigHelper.save();
		EntityRegistry.registerModEntity(EntityBouncingProjectile.class, "Bouncing", 22, RPG.instance, 250, 110, true);
	}

	public void doClient() { }
}