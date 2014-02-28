package net.rpg.helper;
public class AbilityHelper {
	private static final String[] NAMES = { "TEST" };
	private static final boolean[] EFFECT_TYPES = { true };
	private static final String[] DENOTATIONS = { "TEST ABILITY" };
	private static final boolean[] RANGED = { true };

	public static String getName(int ability) {
		return NAMES[ability];
	}

	public static String isGoodEffect(int ability) {
		return EFFECT_TYPES[ability] ? "True" : "False";
	}

	public static String getDenotation(int ability) {
		return DENOTATIONS[ability];
	}

	public static String isRanged(int ability) {
		return RANGED[ability] ? "True" : "False";
	}
}