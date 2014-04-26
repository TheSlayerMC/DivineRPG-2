package net.rpg.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.rpg.RPG;
import net.rpg.Reference;
import net.rpg.Util;

public class PacketStats extends AbstractPacket {
	private int[] stats = new int[Reference.STATS.length];

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		for(int i = 0; i < stats.length; i++) {
			buffer.writeInt(stats[i]);
		}
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		for(int i = 0; i < stats.length; i++) {
			stats[i] = buffer.readInt();
		}
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		RPG.race = stats[0];
		RPG.maxHp = stats[1];
		RPG.de = stats[2];
		RPG.maxDe = stats[3];
		RPG.arcana = stats[4];
		RPG.maxArcana = stats[5];
		RPG.credits = stats[6];
		RPG.attack = stats[7];
		RPG.defense = stats[8];
		RPG.discount = stats[9];
		RPG.luck = stats[10];
		RPG.reflex = stats[11];
		RPG.stamina = stats[12];
		RPG.speed = stats[13];
		RPG.cooldown = stats[14];
		RPG.ability = stats[15];
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
	}

	public PacketStats applyStats(EntityPlayer player) {
		for(int i = 0; i < stats.length; i++) {
			stats[i] = Util.getIntegerStat(player, Reference.STATS[i]);
		}
		return this;
	}
}
