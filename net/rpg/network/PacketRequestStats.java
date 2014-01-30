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
		packet.race = DataHelper.getRace(player);
		packet.maxHp = DataHelper.getMaxHp(player);
		packet.de = DataHelper.getDe(player);
		packet.maxDe = DataHelper.getMaxDe(player);
		packet.credits = DataHelper.getCredits(player);
		packet.attack = DataHelper.getAttack(player);
		packet.defense = DataHelper.getDefense(player);
		RPG.packetHandler.sendTo(packet, (EntityPlayerMP) player);
	}
}