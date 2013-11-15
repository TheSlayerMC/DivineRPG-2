package net.rpg.helper;

import net.minecraft.entity.EntityEggInfo;
import net.minecraft.entity.EntityList;
import net.rpg.RPG;
import cpw.mods.fml.common.registry.EntityRegistry;
import cpw.mods.fml.common.registry.LanguageRegistry;

public class RPGMobRegistry {
	static int eggID = 25;
	static int projectileID = 350;

	public static void registerEntity(Class entityClass, String entityName) {
		int ID = getUniqueID();
		int entityID = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, ID);
		LanguageRegistry.instance().addStringLocalization("entity." + entityName + ".name", entityName);
		EntityList.IDtoClassMapping.put(ID, entityClass);
		EntityList.entityEggs .put(ID, new EntityEggInfo(ID, 0x000000, 0xFFFFFF));
		EntityRegistry.registerModEntity(entityClass, entityName, ID, RPG.instance, 250, 5, false);
	}

	public static void registerProjectile(Class entityClass, String entityName) {
		int ID = getProjectileID();
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, ID);
		EntityRegistry.registerModEntity(entityClass, entityName, ID, RPG.instance, 250, 5, true);
		LanguageRegistry.instance().addStringLocalization("entity." + entityName + ".name", entityName);
	}

	private static int getUniqueID() {
		return EntityRegistry.findGlobalUniqueEntityId();
	}

	private static int getProjectileID() {
		return projectileID++;
	}
}