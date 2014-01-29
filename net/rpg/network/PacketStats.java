package net.rpg.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.rpg.RPG;

public class PacketStats extends AbstractPacket {
	public int credits, attack, defense;

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		buffer.writeInt(credits);
		buffer.writeInt(attack);
		buffer.writeInt(defense);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		credits = buffer.readInt();
		attack = buffer.readInt();
		defense = buffer.readInt();
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		RPG.credits = credits;
		RPG.attack = attack;
		RPG.defense = defense;
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
	}
}