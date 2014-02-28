package net.rpg.network;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.EnumChatFormatting;
import net.rpg.RPG;
import net.rpg.Util;
import net.rpg.helper.DataHelper;
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
		if(item) {
			is = new ItemStack(GameData.itemRegistry.get(name));
		} else {
			is = new ItemStack(GameData.blockRegistry.get(name));
		}
		if(player.capabilities.isCreativeMode) {
			player.inventory.addItemStackToInventory(is);
		} else if(RPG.credits >= cost) {
			player.inventory.addItemStackToInventory(is);
			useCredits(player, cost);
		} else {
			int more = cost - DataHelper.getCredits(player);
			player.addChatMessage(Util.addChatMessage(EnumChatFormatting.RED + "You need " + EnumChatFormatting.GOLD + more + EnumChatFormatting.RED + " more credits!"));
		}
	}

	public static int useCredits(EntityPlayer player, int credits) {
		int playerCredits = DataHelper.getCredits(player);
		if(playerCredits > 0) {
			DataHelper.setCredits(player, playerCredits - credits);
			return DataHelper.getCredits(player);
		} else if(-1 > playerCredits) {
			DataHelper.setCredits(player, 0);
			return 0;
		}
		return playerCredits;
	}
}