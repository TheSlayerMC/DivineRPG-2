package net.rpg;

import net.rpg.entity.EntityCredit;
import net.rpg.entity.projectile.EntityBouncingProjectile;
import net.rpg.helper.BlockHelper;
import net.rpg.helper.ConfigHelper;
import net.rpg.helper.ItemHelper;
import net.rpg.helper.NetworkHelper;
import net.rpg.helper.ServerEventHelper;
import cpw.mods.fml.common.registry.EntityRegistry;

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
		EntityRegistry.registerModEntity(EntityCredit.class, "Credit", 22, RPG.instance, 250, 110, true);
	}

	public void doClient() { }
}