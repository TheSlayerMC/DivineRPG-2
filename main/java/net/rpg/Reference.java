package net.rpg;

import java.util.HashMap;
import java.util.Random;

import net.minecraft.client.Minecraft;
import net.minecraft.util.ResourceLocation;

public class Reference {
	public static final String MOD_ID = "rpg";
	public static final String MOD_NAME = "DivineRPG 2";
	public static final String MOD_VERSION = "2.0";
	public static final String CLIENT_PROXY = "net.rpg.ClientProxy";
	public static final String SERVER_PROXY = "net.rpg.ServerProxy";
	public static final String RESOURCE_PREFIX = MOD_ID + ":";
	public static final String PREFIX_PROJECTILE = Reference.RESOURCE_PREFIX + "textures/projectiles/";
	public static final Minecraft MC = Minecraft.getMinecraft();
	public static final Random RANDOM = new Random();
	public static final String NBT_TAG = "DivineRPG2";
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static final String[] RACES = { "N/A", "Minecraftian", "Villager", "Zombie Pigman", "Cyclops", "Ent", "Catmen", "Galroid", "Boheimite", "Cori", "Glacon", "Frost Archer" };
	public static final ResourceLocation[] RACE_TEXTURES = { Util.newResource("textures/entity/na.png"), Util.newResource("textures/entity/minecraftian.png"), Util.newResource("textures/entity/villager.png"), Util.newResource("textures/entity/zombiePigman.png"), Util.newResource("textures/entity/cyclops.png"), Util.newResource("textures/entity/ent.png"), Util.newResource("textures/entity/catmen.png"), Util.newResource("textures/entity/galroid.png"), Util.newResource("textures/entity/boheimite.png"), Util.newResource("textures/entity/cori.png"), Util.newResource("textures/entity/glacon.png"), Util.newResource("textures/entity/frostArcher.png") };
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static final String RACE = "Race";
	public static final String MHP = "MaxHp";
	public static final String DE = "DivineEnergy";
	public static final String MDE = "MaxDivineEnergy";
	public static final String A = "Arcana";
	public static final String MA = "MaxArcana";
	public static final String CREDITS = "Credits";
	public static final String ATTACK = "Attack";
	public static final String DEFENSE = "Defense";
	public static final String DISCOUNT = "Discount";
	public static final String LUCK = "Luck";
	public static final String REFLEX = "Reflex";
	public static final String STAMINA = "Stamina";
	public static final String SPEED = "Speed";
	public static final String CD = "Cooldown";
	public static final String ABILITY = "Ability";
	public static final String[] STATS = { RACE, MHP, DE, MDE, A, MA, CREDITS, ATTACK, DEFENSE, DISCOUNT, LUCK, REFLEX, STAMINA, SPEED, CD, ABILITY };
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static String BLACK = "\u00a70", DARK_BLUE = "\u00a71", DARK_GREEN = "\u00a72", DARK_AQUA = "\u00a73", DARK_RED = "\u00a74";
	public static String DARK_PURPLE = "\u00a75", GOLD = "\u00a76", GRAY = "\u00a77", DARK_GRAY = "\u00a78", BLUE = "\u00a79";
	public static String GREEN = "\u00a7a", AQUA = "\u00a7b", RED = "\u00a7c", LIGHT_PURPLE = "\u00a7d", YELLOW = "\u00a7e";
	public static String WHITE = "\u00a7f";
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static int race = 0, maxHp, de, maxDe, arcana, maxArcana, credits, attack, defense, discount, luck, reflex, stamina, speed, cooldown, ability;
	//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	public static HashMap<String, Integer> playerRaces = new HashMap<String, Integer>();
}