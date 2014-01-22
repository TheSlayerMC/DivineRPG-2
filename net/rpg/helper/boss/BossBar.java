package net.rpg.helper.boss;
public class BossBar {
	public int health;

	public BossBar(int health) {
		this.health = health;
	}

	public float getBarValue() {
		return this.health;
	}

	public void setHealth(int par1) {
		this.health = par1;
	}

	public static float healthScale;
	public static int statusBarLength;
	public static boolean show;
	public static String bossName;

	public static void setBossStatus(IModBossDisplayData par0IBossDisplayData, boolean par1) {
		healthScale = par0IBossDisplayData.Health() / par0IBossDisplayData.maxHealth();
		statusBarLength = 100;
		bossName = par0IBossDisplayData.getName();
		show = par1;
	}
}