package net.rpg.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemBow;
import net.rpg.Reference;
import net.rpg.Util;
import net.rpg.helper.ItemHelper;

public class PacketRace extends AbstractPacket {
	public int race;

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		buffer.writeInt(race);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		race = buffer.readInt();
		new ItemBow();
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		Util.setIntegerStat(player, Reference.RACE, race);
		if(player.inventory.hasItem(ItemHelper.getItem("raceStone"))) {
			player.inventory.consumeInventoryItem(ItemHelper.getItem("raceStone"));
		}
		Util.sendStats(player);
		Util.sendPlayerRacesToAll();
	}
}