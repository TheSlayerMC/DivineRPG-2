package net.rpg.handler;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.rpg.RPG;
import net.rpg.Util;

public class PlayerTickHandler implements ITickHandler {
	private final EnumSet<TickType> ticksToGet;

	public PlayerTickHandler(EnumSet<TickType> ticksToGet) {
		this.ticksToGet = ticksToGet;
	}

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData) {
		playerTick((EntityPlayer) tickData[0]);
	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData) {
	}

	@Override
	public EnumSet<TickType> ticks() {
		return ticksToGet;
	}

	@Override
	public String getLabel() {
		return "N/A";
	}

	public void playerTick(EntityPlayer player) {
		if(Minecraft.getMinecraft().currentScreen != null) {
			//StatsKeyHandler.pressed = false;
		}
		if(StatsKeyHandler.pressed) {
			if(player.worldObj.isRemote) {
				player.openGui(RPG.instance, 0, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
			}
			NBTTagCompound nbt = player.getEntityData();
			if(player.isSneaking()) {
				//nbt.setString("Race", "ur mom");
				Util.finest("WEEEEEEEEEEEEEEEEEEEEEEEEEEE");
				Packet250CustomPayload packet = new Packet250CustomPayload();
				ByteArrayOutputStream bos = new ByteArrayOutputStream(8);
				DataOutputStream output = new DataOutputStream(bos);
				try {
					output.writeInt(1);
				} catch(Exception e) {
					Util.severe("Couldn't write to packet! Aborting...");
					return;
				}
				packet.channel = "RPG";
				packet.data = bos.toByteArray();
				packet.length = bos.size();
				PacketDispatcher.sendPacketToServer(packet);
			} else {
				//player.addChatMessage("Race: " + nbt.getString("Race"));
			}
			StatsKeyHandler.pressed = false;
		}
	}
}