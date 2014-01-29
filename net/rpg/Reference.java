package net.rpg;
public class Reference {
	public static final String MOD_ID = "rpg";
	public static final String MOD_NAME = "RPG";
	public static final String MOD_VERSION = "1.0";
	public static final String CLIENT_PROXY = "net.rpg.ClientProxy";
	public static final String SERVER_PROXY = "net.rpg.ServerProxy";
	public static final String RESOURCE_PREFIX = "RPG:";
	public static final String[] RACES = { "Steve", "Villager", "Zombie Pigman", "Cyclops", "Plankling", "Catmen", "Galroid", "Boheimite" };

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