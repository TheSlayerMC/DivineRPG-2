package net.rpg;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.rpg.network.PacketRequestStats;
import net.rpg.network.PacketStats;

public class Util {
	public static final void severe(String text) {
		System.out.println(text);
	}

	public static final void warn(String text) {
		System.out.println(text);
	}

	public static final void fine(String text) {
		System.out.println(text);
	}

	public static final void finer(String text) {
		System.out.println(text);
	}

	public static final void finest(String text) {
		System.out.println(text);
	}

	public static final void info(String text) {
		System.out.println(text);
	}

	public static ChatComponentTranslation addChatMessage(EnumChatFormatting color, String str, Object... args) {
		ChatComponentTranslation ret = new ChatComponentTranslation(str, args);
		ret.getChatStyle().setColor(color);
		return ret;
	}

	public static ChatComponentTranslation addChatMessage(String str, Object... args) {
		ChatComponentTranslation ret = new ChatComponentTranslation(str, args);
		ret.getChatStyle().setColor(EnumChatFormatting.WHITE);
		return ret;
	}

	public static NBTTagCompound getRPGNBT(EntityPlayer player) {
		NBTTagCompound nbt = player.getEntityData();
		if(!nbt.hasKey(EntityPlayer.PERSISTED_NBT_TAG)) {
			nbt.setTag(EntityPlayer.PERSISTED_NBT_TAG, new NBTTagCompound());
		}
		nbt = nbt.getCompoundTag(EntityPlayer.PERSISTED_NBT_TAG);
		if(!nbt.hasKey(Reference.NBT_TAG)) {
			nbt.setTag(Reference.NBT_TAG, new NBTTagCompound());
		}
		nbt = nbt.getCompoundTag(Reference.NBT_TAG);
		return nbt;
	}

	public static boolean isNewPlayer(EntityPlayer player) {
		return player.worldObj.isRemote ? RPG.race == 0 : !getRPGNBT(player).hasKey("Race") || getIntegerStat(player, "Race") == 0;
	}

	public static int getIntegerStat(EntityPlayer player, String name) {
		NBTTagCompound nbt = getRPGNBT(player);
		if(!nbt.hasKey(name)) {
			nbt.setInteger(name, 0);
		}
		return nbt.getInteger(name);
	}

	public static void setIntegerStat(EntityPlayer player, String name, int amt) {
		getRPGNBT(player).setInteger(name, amt);
		sendStats(player);
	}

	public static void sendStats(EntityPlayer player) {
		RPG.packetHandler.sendTo(new PacketStats().applyStats(player), (EntityPlayerMP) player);
	}

	public static void requestStats() {
		RPG.packetHandler.sendToServer(new PacketRequestStats());
	}

	public static void applyStats(EntityPlayer player) {
		final AttributeModifier health = new AttributeModifier(player.getPersistentID(), "rpg_health", (((double) Util.getIntegerStat(player, Reference.MHP)) / 10) - 1, 1);
		float current = player.getHealth();
		IAttributeInstance iaiHealth = player.getEntityAttribute(SharedMonsterAttributes.maxHealth);
		if(iaiHealth.getModifier(health.getID()) == null) {
			iaiHealth.applyModifier(health);
		} else {
			iaiHealth.removeModifier(health);
			iaiHealth.applyModifier(health);
		}
		if(current > 0 || !player.capabilities.isCreativeMode)
			player.setHealth(current);
		///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
		final AttributeModifier speed = new AttributeModifier(player.getPersistentID(), "rpg_speed", (((double) Util.getIntegerStat(player, Reference.SPEED)) / 10), 1);
		IAttributeInstance iaiSpeed = player.getEntityAttribute(SharedMonsterAttributes.movementSpeed);
		if(iaiSpeed.getModifier(speed.getID()) == null) {
			iaiSpeed.applyModifier(speed);
		} else {
			iaiSpeed.removeModifier(speed);
			iaiSpeed.applyModifier(speed);
		}
	}

	public static String BLACK = "\u00a70", DARK_BLUE = "\u00a71", DARK_GREEN = "\u00a72", DARK_AQUA = "\u00a73", DARK_RED = "\u00a74";
	public static String DARK_PURPLE = "\u00a75", GOLD = "\u00a76", GRAY = "\u00a77", DARK_GRAY = "\u00a78", BLUE = "\u00a79";
	public static String GREEN = "\u00a7a", AQUA = "\u00a7b", RED = "\u00a7c", LIGHT_PURPLE = "\u00a7d", YELLOW = "\u00a7e";
	public static String WHITE = "\u00a7f";
}