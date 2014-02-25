package rpg;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import rpg.handler.PacketHandler;
import rpg.helper.DataHelper;
import rpg.network.PacketOpenGui;
import rpg.network.PacketRace;
import rpg.network.PacketRefreshStats;
import rpg.network.PacketRequestBuy;
import rpg.network.PacketRequestStats;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.MOD_VERSION)
public class RPG {
	@Instance(Reference.MOD_ID)
	public static RPG instance;
	@SidedProxy(clientSide = Reference.CLIENT_PROXY, serverSide = Reference.SERVER_PROXY)
	public static ServerProxy proxy;
	public static final PacketHandler packetHandler = new PacketHandler();

	@EventHandler
	public void preInit(FMLPreInitializationEvent e) {
		proxy.doServer();
		proxy.doClient();
	}

	@EventHandler
	public void init(FMLInitializationEvent e) {
		packetHandler.init();
	}

	@EventHandler
	public void postInit(FMLPostInitializationEvent e) {
		packetHandler.registerPacket(PacketRefreshStats.class);
		packetHandler.registerPacket(PacketRequestStats.class);
		packetHandler.registerPacket(PacketRace.class);
		packetHandler.registerPacket(PacketOpenGui.class);
		packetHandler.registerPacket(PacketRequestBuy.class);
		packetHandler.postInit();
	}

	@SideOnly(Side.CLIENT)
	public static int race = -1, maxHp, de, maxDe, credits, attack, defense, discount, luck, reflex, stamina, speed, arcana, maxAr, coolDown, ability;

	//public static String ability, goodEfect, denotation, ranged;
	public static void applyStats(EntityPlayer player) {
		final AttributeModifier health = new AttributeModifier(player.getPersistentID(), "rpg_health", (((double) DataHelper.getMaxHp(player)) / 10) - 1, 1);
		IAttributeInstance iaiHealth = player.getEntityAttribute(SharedMonsterAttributes.maxHealth);
		if(iaiHealth.getModifier(health.getID()) == null) {
			iaiHealth.applyModifier(health);
		} else {
			iaiHealth.removeModifier(health);
			iaiHealth.applyModifier(health);
		}
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		final AttributeModifier speed = new AttributeModifier(player.getPersistentID(), "rpg_speed", (((double) DataHelper.getSpeed(player)) / 10), 1);
		IAttributeInstance iaiSpeed = player.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
		if(iaiSpeed.getModifier(speed.getID()) == null) {
			iaiSpeed.applyModifier(speed);
		} else {
			iaiSpeed.removeModifier(speed);
			iaiSpeed.applyModifier(speed);
		}
	}

	public static void sendStats(EntityPlayer player) {
		PacketRefreshStats ps = new PacketRefreshStats();
		ps.race = DataHelper.getRace(player);
		ps.maxHp = DataHelper.getMaxHp(player);
		ps.de = DataHelper.getDe(player);
		ps.maxDe = DataHelper.getMaxDe(player);
		ps.credits = DataHelper.getCredits(player);
		ps.attack = DataHelper.getAttack(player);
		ps.defense = DataHelper.getDefense(player);
		ps.discount = DataHelper.getDiscount(player);
		ps.luck = DataHelper.getLuck(player);
		ps.reflex = DataHelper.getReflex(player);
		ps.stamina = DataHelper.getStamina(player);
		ps.speed = DataHelper.getSpeed(player);
		ps.ar = DataHelper.getArcana(player);
		ps.maxAr = DataHelper.getMaxArcana(player);
		ps.coolDown = DataHelper.getCooldown(player);
		ps.ability = DataHelper.getAbility(player);
		RPG.packetHandler.sendTo(ps, (EntityPlayerMP) player);
		RPG.applyStats(player);
	}
}