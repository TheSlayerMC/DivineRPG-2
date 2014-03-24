package net.rpg.helper;

import net.minecraft.entity.player.EntityPlayer;

public class DataHelper {
	public static boolean isNewPlayer(EntityPlayer player) {
		return !player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).hasKey("Race");
	}

	public static void setRace(EntityPlayer player, int race) {
		player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).setInteger("Race", race);
	}

	public static int getRace(EntityPlayer player) {
		return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Race");
	}

	public static void setMaxHp(EntityPlayer player, int maxHp) {
		player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).setInteger("Max Health", maxHp);
	}

	public static int getMaxHp(EntityPlayer player) {
		return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Max Health");
	}

	public static void setDe(EntityPlayer player, int de) {
		player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).setInteger("Divine Energy", de);
	}

	public static int getDe(EntityPlayer player) {
		return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Divine Energy");
	}

	public static void setMaxDe(EntityPlayer player, int maxDe) {
		player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).setInteger("Max Divine Energy", maxDe);
	}

	public static int getMaxDe(EntityPlayer player) {
		return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Max Divine Energy");
	}

	public static void setCredits(EntityPlayer player, int amt) {
		player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).setInteger("Credits", amt);
	}

	public static int getCredits(EntityPlayer player) {
		return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Credits");
	}

	public static void setAttack(EntityPlayer player, int amt) {
		player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).setInteger("Attack", amt);
	}

	public static int getAttack(EntityPlayer player) {
		return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Attack");
	}

	public static void setDefense(EntityPlayer player, int amt) {
		player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).setInteger("Defense", amt);
	}

	public static int getDefense(EntityPlayer player) {
		return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Defense");
	}

	public static void setMaxArcana(EntityPlayer player, int amt) {
		player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).setInteger("Max Arcana", amt);
	}

	public static void setArcana(EntityPlayer player, int amt) {
		player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Arcana");
	}

	public static int getArcana(EntityPlayer player) {
		return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Arcana");
	}

	public static int getMaxArcana(EntityPlayer player) {
		return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Max Arcana");
	}

	public static void setDiscount(EntityPlayer player, int amt) {
		player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).setInteger("Discount", amt);
	}

	public static int getDiscount(EntityPlayer player) {
		return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Discount");
	}

	public static void setLuck(EntityPlayer player, int amt) {
		player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).setInteger("Luck", amt);
	}

	public static int getLuck(EntityPlayer player) {
		return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Luck");
	}

	public static void setReflex(EntityPlayer player, int amt) {
		player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).setInteger("Reflex", amt);
	}

	public static int getReflex(EntityPlayer player) {
		return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Reflex");
	}

	public static void setStamina(EntityPlayer player, int amt) {
		player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).setInteger("Stamina", amt);
	}

	public static int getStamina(EntityPlayer player) {
		return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Stamina");
	}

	public static void setSpeed(EntityPlayer player, int amt) {
		player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).setInteger("Speed", amt);
	}

	public static int getSpeed(EntityPlayer player) {
		return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Speed");
	}

	public static void setCooldown(EntityPlayer player, int amt) {
		player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).setInteger("Cooldown", amt);
	}

	public static int getCooldown(EntityPlayer player) {
		return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Cooldown");
	}

	public static void setAbility(EntityPlayer player, int amt) {
		player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).setInteger("Ability", amt);
	}

	public static int getAbility(EntityPlayer player) {
		return player.getEntityData().getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG).getInteger("Ability");
	}
}