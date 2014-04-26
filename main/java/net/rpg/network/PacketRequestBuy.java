package net.rpg.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.rpg.Reference;
import net.rpg.Util;
import cpw.mods.fml.common.network.ByteBufUtils;
import cpw.mods.fml.common.registry.GameData;

public class PacketRequestBuy extends AbstractPacket {
	public boolean item;
	public String name;
	public int amount, cost;

	@Override
	public void encodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		buffer.writeBoolean(item);
		ByteBufUtils.writeUTF8String(buffer, name);
		buffer.writeInt(amount);
		buffer.writeInt(cost);
	}

	@Override
	public void decodeInto(ChannelHandlerContext ctx, ByteBuf buffer) {
		item = buffer.readBoolean();
		name = ByteBufUtils.readUTF8String(buffer);
		amount = buffer.readInt();
		cost = buffer.readInt();
	}

	@Override
	public void handleClientSide(EntityPlayer player) {
	}

	@Override
	public void handleServerSide(EntityPlayer player) {
		ItemStack is = null;
		int credits = Util.getIntegerStat(player, Reference.CREDITS);
		if(item) {
			is = new ItemStack(GameData.getItemRegistry().getObject(name));
		} else {
			is = new ItemStack(GameData.getBlockRegistry().getObject(name));
		}
		if(player.capabilities.isCreativeMode) {
			player.inventory.addItemStackToInventory(is);
		} else if(credits >= cost) {
			player.inventory.addItemStackToInventory(is);
			useCredits(player, cost);
		} else {
			int more = cost - credits;
			player.addChatMessage(Util.addChatMessage(EnumChatFormatting.RED + "You need " + EnumChatFormatting.GOLD + more + EnumChatFormatting.RED + " more credits!"));
		}
	}

	public static int useCredits(EntityPlayer player, int credits) {
		int playerCredits = Util.getIntegerStat(player, Reference.CREDITS);
		if(playerCredits > 0) {
			Util.setIntegerStat(player, Reference.CREDITS, playerCredits - credits);
			return Util.getIntegerStat(player, Reference.CREDITS);
		} else if(-1 > playerCredits) {
			Util.setIntegerStat(player, Reference.CREDITS, 0);
			return 0;
		}
		return playerCredits;
	}
}