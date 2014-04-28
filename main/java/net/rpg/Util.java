package net.rpg;

import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.attributes.AttributeModifier;
import net.minecraft.entity.ai.attributes.IAttributeInstance;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.ChatComponentTranslation;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.rpg.network.PacketPlayerRaces;
import net.rpg.network.PacketRequestPlayerRaces;
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

	public static ResourceLocation newResource(String dir) {
		return new ResourceLocation(Reference.RESOURCE_PREFIX + dir);
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
		return player.worldObj.isRemote ? (player.getDisplayName().equals(Reference.MC.thePlayer.getDisplayName()) ? Reference.race == 0 : Reference.playerRaces.get(player.getDisplayName()) == 0) : !getRPGNBT(player).hasKey("Race") || getIntegerStat(player, "Race") == 0;
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

	public static void sendPlayerRaces(EntityPlayer player) {
		RPG.packetHandler.sendTo(new PacketPlayerRaces().applyPlayers(), (EntityPlayerMP) player);
	}

	public static void sendPlayerRacesToAll() {
		RPG.packetHandler.sendToAll(new PacketPlayerRaces().applyPlayers());
	}

	public static void requestPlayerRaces() {
		RPG.packetHandler.sendToServer(new PacketRequestPlayerRaces());
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

	public static String translateRace(int race) {
		return Reference.RACES[race];
	}

	public static int translateRace(String race) {
		for(int i = 0; i < Reference.RACES.length; i++) {
			if(Reference.RACES[i].equals(race)) {
				return i;
			}
		}
		return -1;
	}

	public static ResourceLocation getRaceTexture(int race) {
		return Reference.RACE_TEXTURES[race];
	}
}