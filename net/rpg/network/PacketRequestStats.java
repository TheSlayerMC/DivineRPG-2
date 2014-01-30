package net.rpg.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.EntityPlayerMP;
import net.rpg.RPG;
import net.rpg.helper.DataHelper;

public class PacketRequestStats extends AbstractPacket {
	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		PacketStatsToClient packet = new PacketStatsToClient();
		String n = player.getDisplayName();
		packet.race = DataHelper.getRace(n);
		packet.credits = DataHelper.getCredits(n);
		packet.attack = DataHelper.getAttack(n);
		packet.defense = DataHelper.getDefense(n);
		RPG.packetHandler.sendTo(packet, (EntityPlayerMP) player);
	}
}