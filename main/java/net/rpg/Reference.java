package net.rpg;

import java.util.Random;

import net.minecraft.client.Minecraft;

public class Reference {
	public static final String MOD_ID = "rpg";
	public static final String MOD_NAME = "DivineRPG 2";
	public static final String MOD_VERSION = "2.0";
	public static final String CLIENT_PROXY = "net.rpg.ClientProxy";
	public static final String SERVER_PROXY = "net.rpg.ServerProxy";
	public static final String RESOURCE_PREFIX = MOD_ID + ":";
	public static final String PREFIX_PROJECTILE = Reference.RESOURCE_PREFIX + "textures/projectiles/";
	public static final String[] RACES = { "N/A", "Minecraftian", "Villager", "Zombie Pigman", "Cyclops", "Ent", "Catmen", "Galroid", "Boheimite", "Cori", "Glacon", "Frost Archer" };
	public static final Minecraft MC = Minecraft.getMinecraft();
	public static final Random RANDOM = new Random();
	public static final String NBT_TAG = "DivineRPG2";
	////////////////////////////////////////////////////////////
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

	////////////////////////////////////////////////////////////
	public static String translateRace(int race) {
		return RACES[race];
	}

	public static int translateRace(String race) {
		for(int i = 0; i < RACES.length; i++) {
			if(RACES[i].equals(race)) {
				return i;
			}
		}
		return -1;
	}
}