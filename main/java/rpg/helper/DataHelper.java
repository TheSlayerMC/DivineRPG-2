package rpg.helper;

import java.io.File;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import net.minecraftforge.common.config.Configuration;
import rpg.RPG;

public class DataHelper {
	private static Configuration data;

	public static void load(World w) {
		if(Minecraft.getMinecraft().isSingleplayer()) {
			data = new Configuration(new File("./saves/" + w.getWorldInfo().getWorldName() + "/rpgdata.dat"), true);
		} else {
			data = new Configuration(new File("./" + w.getWorldInfo().getWorldName() + "/rpgdata.dat"), true);
		}
		data.load();
	}

	public static void save() {
		data.save();
	}

	public static void loadPlayer(EntityPlayer player) {
		String n = player.getDisplayName();
		data.get(n, "Race", -1);
		data.get(n, "Max Health", 10);
		data.get(n, "Divine Energy", 0);
		data.get(n, "Max Divine Energy", 20);
		data.get(n, "Credits", 0);
		data.get(n, "Attack", 0);
		data.get(n, "Defense", 0);
		data.get(n, "Arcana", 0);
		data.get(n, "Max Arcana", 20);
		data.get(n, "Discount", 0);
		data.get(n, "Luck", 0);
		data.get(n, "Reflex", 0);
		data.get(n, "Stamina", 0);
		data.get(n, "Speed", 0);
		data.get(n, "Cooldown", 0);
		data.get(n, "Ability", 0);
	}

	public static void setRace(EntityPlayer player, int race) {
		data.get(player.getDisplayName(), "Race", -1).set(race);
		save();
		RPG.sendStats(player);
	}

	public static int getRace(EntityPlayer player) {
		return data.get(player.getDisplayName(), "Race", -1).getInt();
	}

	public static void setMaxHp(EntityPlayer player, int maxHp) {
		data.get(player.getDisplayName(), "Max Health", 10).set(maxHp);
		save();
		RPG.sendStats(player);
	}

	public static int getMaxHp(EntityPlayer player) {
		return data.get(player.getDisplayName(), "Max Health", 10).getInt();
	}

	public static void setDe(EntityPlayer player, int de) {
		data.get(player.getDisplayName(), "Divine Energy", 0).set(de);
		save();
		RPG.sendStats(player);
	}

	public static int getDe(EntityPlayer player) {
		return data.get(player.getDisplayName(), "Divine Energy", 0).getInt();
	}

	public static void setMaxDe(EntityPlayer player, int maxDe) {
		data.get(player.getDisplayName(), "Max Divine Energy", 20).set(maxDe);
		save();
		RPG.sendStats(player);
	}

	public static int getMaxDe(EntityPlayer player) {
		return data.get(player.getDisplayName(), "Max Divine Energy", 20).getInt();
	}

	public static void setCredits(EntityPlayer player, int amt) {
		data.get(player.getDisplayName(), "Credits", 0).set(amt);
		save();
		RPG.sendStats(player);
	}

	public static int getCredits(EntityPlayer player) {
		return data.get(player.getDisplayName(), "Credits", 0).getInt();
	}

	public static void setAttack(EntityPlayer player, int amt) {
		data.get(player.getDisplayName(), "Attack", 0).set(amt);
		save();
		RPG.sendStats(player);
	}

	public static int getAttack(EntityPlayer player) {
		return data.get(player.getDisplayName(), "Attack", 0).getInt();
	}

	public static void setDefense(EntityPlayer player, int amt) {
		data.get(player.getDisplayName(), "Defense", 0).set(amt);
		save();
		RPG.sendStats(player);
	}

	public static int getDefense(EntityPlayer player) {
		return data.get(player.getDisplayName(), "Defense", 0).getInt();
	}

	public static void setMaxArcana(EntityPlayer player, int amt) {
		data.get(player.getDisplayName(), "Max Arcana", 0).set(amt);
		save();
		RPG.sendStats(player);
	}

	public static void setArcana(EntityPlayer player, int amt) {
		data.get(player.getDisplayName(), "Arcana", 0).set(amt);
		save();
		RPG.sendStats(player);
	}

	public static int getArcana(EntityPlayer player) {
		return data.get(player.getDisplayName(), "Arcana", 0).getInt();
	}

	public static int getMaxArcana(EntityPlayer player) {
		return data.get(player.getDisplayName(), "Max Arcana", 0).getInt();
	}

	public static void setDiscount(EntityPlayer player, int amt) {
		data.get(player.getDisplayName(), "Discount", 0).set(amt);
		save();
		RPG.sendStats(player);
	}

	public static int getDiscount(EntityPlayer player) {
		return data.get(player.getDisplayName(), "Discount", 0).getInt();
	}

	public static void setLuck(EntityPlayer player, int amt) {
		data.get(player.getDisplayName(), "Luck", 0).set(amt);
		save();
		RPG.sendStats(player);
	}

	public static int getLuck(EntityPlayer player) {
		return data.get(player.getDisplayName(), "Luck", 0).getInt();
	}

	public static void setReflex(EntityPlayer player, int amt) {
		data.get(player.getDisplayName(), "Reflex", 0).set(amt);
		save();
		RPG.sendStats(player);
	}

	public static int getReflex(EntityPlayer player) {
		return data.get(player.getDisplayName(), "Reflex", 0).getInt();
	}

	public static void setStamina(EntityPlayer player, int amt) {
		data.get(player.getDisplayName(), "Stamina", 0).set(amt);
		save();
		RPG.sendStats(player);
	}

	public static int getStamina(EntityPlayer player) {
		return data.get(player.getDisplayName(), "Stamina", 0).getInt();
	}

	public static void setSpeed(EntityPlayer player, int amt) {
		data.get(player.getDisplayName(), "Speed", 0).set(amt);
		save();
		RPG.sendStats(player);
	}

	public static int getSpeed(EntityPlayer player) {
		return data.get(player.getDisplayName(), "Speed", 0).getInt();
	}

	public static void setCooldown(EntityPlayer player, int amt) {
		data.get(player.getDisplayName(), "Cooldown", 0).set(amt);
		save();
		RPG.sendStats(player);
	}

	public static int getCooldown(EntityPlayer player) {
		return data.get(player.getDisplayName(), "Cooldown", 0).getInt();
	}

	public static void setAbility(EntityPlayer player, int amt) {
		data.get(player.getDisplayName(), "Ability", 0).set(amt);
		save();
		RPG.sendStats(player);
	}

	public static int getAbility(EntityPlayer player) {
		return data.get(player.getDisplayName(), "Ability", 0).getInt();
	}
}