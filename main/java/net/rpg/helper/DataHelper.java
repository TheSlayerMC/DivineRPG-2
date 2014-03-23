package net.rpg.helper;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.rpg.RPG;

public class DataHelper {
	public static void loadPlayer(EntityPlayer player) {
		NBTTagCompound nbt = player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
		nbt.setInteger("Race", -1);
		nbt.setInteger("Max Health", 10);
		nbt.setInteger("Divine Energy", 0);
		nbt.setInteger("Max Divine Energy", 20);
		nbt.setInteger("Credits", 0);
		nbt.setInteger("Attack", 0);
		nbt.setInteger("Defense", 0);
		nbt.setInteger("Arcana", 0);
		nbt.setInteger("Max Arcana", 20);
		nbt.setInteger("Discount", 0);
		nbt.setInteger("Luck", 0);
		nbt.setInteger("Reflex", 0);
		nbt.setInteger("Stamina", 0);
		nbt.setInteger("Speed", 0);
		nbt.setInteger("Cooldown", 0);
		nbt.setInteger("Ability", 0);
	}

	public static void setRace(EntityPlayer player, int race) {
		player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).setInteger("Race", race);
		RPG.sendStats(player);
	}

	public static int getRace(EntityPlayer player) {
		return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Race");
	}

	public static void setMaxHp(EntityPlayer player, int maxHp) {
		player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).setInteger("Max Health", maxHp);
		RPG.sendStats(player);
	}

	public static int getMaxHp(EntityPlayer player) {
		return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Max Health");
	}

	public static void setDe(EntityPlayer player, int de) {
		player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).setInteger("Divine Energy", de);
		RPG.sendStats(player);
	}

	public static int getDe(EntityPlayer player) {
		return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Divine Energy");
	}

	public static void setMaxDe(EntityPlayer player, int maxDe) {
		player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).setInteger("Max Divine Energy", maxDe);
		RPG.sendStats(player);
	}

	public static int getMaxDe(EntityPlayer player) {
		return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Max Divine Energy");
	}

	public static void setCredits(EntityPlayer player, int amt) {
		player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).setInteger("Credits", amt);
		RPG.sendStats(player);
	}

	public static int getCredits(EntityPlayer player) {
		return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Credits");
	}

	public static void setAttack(EntityPlayer player, int amt) {
		player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).setInteger("Attack", amt);
		RPG.sendStats(player);
	}

	public static int getAttack(EntityPlayer player) {
		return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Attack");
	}

	public static void setDefense(EntityPlayer player, int amt) {
		player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).setInteger("Defense", amt);
		RPG.sendStats(player);
	}

	public static int getDefense(EntityPlayer player) {
		return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Defense");
	}

	public static void setMaxArcana(EntityPlayer player, int amt) {
		player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).setInteger("Max Arcana", amt);
		RPG.sendStats(player);
	}

	public static void setArcana(EntityPlayer player, int amt) {
		player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Arcana");
		RPG.sendStats(player);
	}

	public static int getArcana(EntityPlayer player) {
		return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Arcana");
	}

	public static int getMaxArcana(EntityPlayer player) {
		return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Max Arcana");
	}

	public static void setDiscount(EntityPlayer player, int amt) {
		player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).setInteger("Discount", amt);
		RPG.sendStats(player);
	}

	public static int getDiscount(EntityPlayer player) {
		return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Discount");
	}

	public static void setLuck(EntityPlayer player, int amt) {
		player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).setInteger("Luck", amt);
		RPG.sendStats(player);
	}

	public static int getLuck(EntityPlayer player) {
		return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Luck");
	}

	public static void setReflex(EntityPlayer player, int amt) {
		player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).setInteger("Reflex", amt);
		RPG.sendStats(player);
	}

	public static int getReflex(EntityPlayer player) {
		return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Reflex");
	}

	public static void setStamina(EntityPlayer player, int amt) {
		player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).setInteger("Stamina", amt);
		RPG.sendStats(player);
	}

	public static int getStamina(EntityPlayer player) {
		return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Stamina");
	}

	public static void setSpeed(EntityPlayer player, int amt) {
		player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).setInteger("Speed", amt);
		RPG.sendStats(player);
	}

	public static int getSpeed(EntityPlayer player) {
		return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Speed");
	}

	public static void setCooldown(EntityPlayer player, int amt) {
		player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).setInteger("Cooldown", amt);
		RPG.sendStats(player);
	}

	public static int getCooldown(EntityPlayer player) {
		return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Cooldown");
	}

	public static void setAbility(EntityPlayer player, int amt) {
		player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).setInteger("Ability", amt);
		RPG.sendStats(player);
	}

	public static int getAbility(EntityPlayer player) {
		return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Ability");
	}
}