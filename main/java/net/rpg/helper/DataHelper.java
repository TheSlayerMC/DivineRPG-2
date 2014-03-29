package net.rpg.helper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.rpg.RPG;

public class DataHelper {
	public static boolean isNewPlayer(EntityPlayer player) {
		return player.worldObj.isRemote ? !(RPG.race != -1) : !getNBT(player).hasKey("Race");
	}

	public static void setRace(EntityPlayer player, int race) {
		getNBT(player).setInteger("Race", race);
		RPG.sendStats(player);
	}

	public static int getRace(EntityPlayer player) {
		return player.worldObj.isRemote ? RPG.race : getNBT(player).getInteger("Race");
	}

	public static void setMaxHp(EntityPlayer player, int maxHp) {
		getNBT(player).setInteger("Max Health", maxHp);
		RPG.sendStats(player);
	}

	public static int getMaxHp(EntityPlayer player) {
		return player.worldObj.isRemote ? RPG.maxHp : getNBT(player).getInteger("Max Health");
	}

	public static void setDe(EntityPlayer player, int de) {
		getNBT(player).setInteger("Divine Energy", de);
		RPG.sendStats(player);
	}

	public static int getDe(EntityPlayer player) {
		return player.worldObj.isRemote ? RPG.de : getNBT(player).getInteger("Divine Energy");
	}

	public static void setMaxDe(EntityPlayer player, int maxDe) {
		getNBT(player).setInteger("Max Divine Energy", maxDe);
		RPG.sendStats(player);
	}

	public static int getMaxDe(EntityPlayer player) {
		return player.worldObj.isRemote ? RPG.maxDe : getNBT(player).getInteger("Max Divine Energy");
	}

	public static void setCredits(EntityPlayer player, int amt) {
		getNBT(player).setInteger("Credits", amt);
		RPG.sendStats(player);
	}

	public static int getCredits(EntityPlayer player) {
		return player.worldObj.isRemote ? RPG.credits : getNBT(player).getInteger("Credits");
	}

	public static void setAttack(EntityPlayer player, int amt) {
		getNBT(player).setInteger("Attack", amt);
		RPG.sendStats(player);
	}

	public static int getAttack(EntityPlayer player) {
		return player.worldObj.isRemote ? RPG.attack : getNBT(player).getInteger("Attack");
	}

	public static void setDefense(EntityPlayer player, int amt) {
		getNBT(player).setInteger("Defense", amt);
		RPG.sendStats(player);
	}

	public static int getDefense(EntityPlayer player) {
		return player.worldObj.isRemote ? RPG.defense : getNBT(player).getInteger("Defense");
	}

	public static void setMaxArcana(EntityPlayer player, int amt) {
		getNBT(player).setInteger("Max Arcana", amt);
		RPG.sendStats(player);
	}

	public static void setArcana(EntityPlayer player, int amt) {
		getNBT(player).getInteger("Arcana");
		RPG.sendStats(player);
	}

	public static int getArcana(EntityPlayer player) {
		return player.worldObj.isRemote ? RPG.arcana : getNBT(player).getInteger("Arcana");
	}

	public static int getMaxArcana(EntityPlayer player) {
		return player.worldObj.isRemote ? RPG.maxArcana : getNBT(player).getInteger("Max Arcana");
	}

	public static void setDiscount(EntityPlayer player, int amt) {
		getNBT(player).setInteger("Discount", amt);
		RPG.sendStats(player);
	}

	public static int getDiscount(EntityPlayer player) {
		return player.worldObj.isRemote ? RPG.discount : getNBT(player).getInteger("Discount");
	}

	public static void setLuck(EntityPlayer player, int amt) {
		getNBT(player).setInteger("Luck", amt);
		RPG.sendStats(player);
	}

	public static int getLuck(EntityPlayer player) {
		return player.worldObj.isRemote ? RPG.luck : getNBT(player).getInteger("Luck");
	}

	public static void setReflex(EntityPlayer player, int amt) {
		getNBT(player).setInteger("Reflex", amt);
		RPG.sendStats(player);
	}

	public static int getReflex(EntityPlayer player) {
		return player.worldObj.isRemote ? RPG.reflex : getNBT(player).getInteger("Reflex");
	}

	public static void setStamina(EntityPlayer player, int amt) {
		getNBT(player).setInteger("Stamina", amt);
		RPG.sendStats(player);
	}

	public static int getStamina(EntityPlayer player) {
		return player.worldObj.isRemote ? RPG.stamina : getNBT(player).getInteger("Stamina");
	}

	public static void setSpeed(EntityPlayer player, int amt) {
		getNBT(player).setInteger("Speed", amt);
		RPG.sendStats(player);
	}

	public static int getSpeed(EntityPlayer player) {
		return player.worldObj.isRemote ? RPG.speed : getNBT(player).getInteger("Speed");
	}

	public static void setCooldown(EntityPlayer player, int amt) {
		getNBT(player).setInteger("Cooldown", amt);
		RPG.sendStats(player);
	}

	public static int getCooldown(EntityPlayer player) {
		return player.worldObj.isRemote ? RPG.cooldown : getNBT(player).getInteger("Cooldown");
	}

	public static void setAbility(EntityPlayer player, int amt) {
		getNBT(player).setInteger("Ability", amt);
		RPG.sendStats(player);
	}

	public static int getAbility(EntityPlayer player) {
		return player.worldObj.isRemote ? RPG.ability : getNBT(player).getInteger("Ability");
	}

	public static NBTTagCompound getNBT(EntityPlayer player) {
		return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
	}
}