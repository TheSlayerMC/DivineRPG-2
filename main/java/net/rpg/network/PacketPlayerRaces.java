package net.rpg.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.server.MinecraftServer;
import net.rpg.Reference;
import net.rpg.Util;
import cpw.mods.fml.common.network.ByteBufUtils;

public class PacketPlayerRaces extends AbstractPacket {
	private String[] playerNames;
	private int[] races;

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		buffer.writeInt(playerNames.length);
		for(int i = 0; i < playerNames.length; i++) {
			ByteBufUtils.writeUTF8String(buffer, playerNames[i]);
			buffer.writeInt(races[i]);
		}
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		playerNames = new String[buffer.readInt()];
		races = new int[playerNames.length];
		for(int i = 0; i < playerNames.length; i++) {
			playerNames[i] = ByteBufUtils.readUTF8String(buffer);
			races[i] = buffer.readInt();
		}
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
		Reference.playerRaces.clear();
		for(int i = 0; i < playerNames.length; i++) {
			Reference.playerRaces.put(playerNames[i], races[i]);
		}
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
	}

	public PacketPlayerRaces applyPlayers() {
		MinecraftServer server = MinecraftServer.getServer();
		playerNames = server.getAllUsernames();
		races = new int[playerNames.length];
		for(int i = 0; i < races.length; i++) {
			races[i] = Util.getIntegerStat(server.getConfigurationManager().getPlayerForUsername(playerNames[i]), Reference.RACE);
		}
		return this;
	}
}
