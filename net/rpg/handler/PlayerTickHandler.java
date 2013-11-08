package net.rpg.handler;

import java.util.EnumSet;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.player.EntityPlayer;
import net.rpg.RPG;
import cpw.mods.fml.common.ITickHandler;
import cpw.mods.fml.common.TickType;

public class PlayerTickHandler implements ITickHandler
{
	
	private final EnumSet<TickType> ticksToGet;

	public PlayerTickHandler(EnumSet<TickType> ticksToGet)
	{

		this.ticksToGet = ticksToGet;

	}

	@Override
	public void tickStart(EnumSet<TickType> type, Object... tickData)
	{

		playerTick((EntityPlayer) tickData[0]);

	}

	@Override
	public void tickEnd(EnumSet<TickType> type, Object... tickData)
	{

	}

	@Override
	public EnumSet<TickType> ticks()
	{

		return ticksToGet;

	}

	@Override
	public String getLabel()
	{

		return "N/A";

	}

	public void playerTick(EntityPlayer player)
	{
		
		if(Minecraft.getMinecraft().currentScreen != null)
		{
			
			StatsKeyHandler.pressed = false;
			
		}
		
		if(StatsKeyHandler.pressed)
		{
			
			player.openGui(RPG.instance, 0, player.worldObj, (int) player.posX, (int) player.posY, (int) player.posZ);
			
			StatsKeyHandler.pressed = false;

		}
		
	}
	
}