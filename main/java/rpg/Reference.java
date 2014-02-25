package rpg;

import java.util.Random;

public class Reference {
	public static final String MOD_ID = "rpg";
	public static final String MOD_NAME = "DivineRPG 2";
	public static final String MOD_VERSION = "2.0";
	public static final String CLIENT_PROXY = "rpg.ClientProxy";
	public static final String SERVER_PROXY = "rpg.ServerProxy";
	public static final String RESOURCE_PREFIX = "rpg:";
	public static final String PREFIX_PROJECTILE = Reference.RESOURCE_PREFIX + "textures/projectiles/";
	public static final String[] RACES = { "Minecraftian", "Villager", "Zombie Pigman", "Cyclops", "Ent", "Catmen", "Galroid", "Boheimite", "Cori", "Glacon", "Frost Archer" };
	public static final Random RANDOM = new Random();

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