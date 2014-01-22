package net.rpg;

import net.minecraft.client.model.ModelBiped;
import net.rpg.api.entity.EntityTestBoss;
import net.rpg.helper.RPGMobRegistry;
import net.rpg.helper.RenderBoss;
import cpw.mods.fml.client.registry.RenderingRegistry;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class RPG {
	@Instance(Reference.MOD_ID)
	public static RPG instance;
	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
	public static ServerProxy proxy;

	/**
	 * In the assets, there is a GUITextureSheet, The blue XP looking one is for
	 * your 'Mana Bar' (if you class has mana) The Red one is for the bosses
	 * health bar, and the player item looking one is for extra accesories...
	 **/
	@EventHandler
	public static void preInit(FMLPreInitializationEvent event) {
		RPGMobRegistry.registerEntity(EntityTestBoss.class, "Test");
		RenderingRegistry.registerEntityRenderingHandler(EntityTestBoss.class, new RenderBoss(new ModelBiped()));
	}

	@EventHandler
	public static void init(FMLInitializationEvent event) {
		//TickRegistry.registerTickHandler(new BossTickHandler(), Side.CLIENT);
	}
}