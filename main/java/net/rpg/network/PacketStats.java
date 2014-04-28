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
		Reference.race = stats[0];
		Reference.maxHp = stats[1];
		Reference.de = stats[2];
		Reference.maxDe = stats[3];
		Reference.arcana = stats[4];
		Reference.maxArcana = stats[5];
		Reference.credits = stats[6];
		Reference.attack = stats[7];
		Reference.defense = stats[8];
		Reference.discount = stats[9];
		Reference.luck = stats[10];
		Reference.reflex = stats[11];
		Reference.stamina = stats[12];
		Reference.speed = stats[13];
		Reference.cooldown = stats[14];
		Reference.ability = stats[15];
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
