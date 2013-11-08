package net.rpg.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.rpg.RPG;

public class PlayerEventHandler
{
	
	@ForgeSubscribe
	public void PlayerConstructingEvent(EntityConstructing event)
	{
		
		if(event.entity instanceof EntityPlayer)
		{
			
			EntityPlayer player = (EntityPlayer)event.entity;
			
			if(ExtendedPlayerHandler.get(player) == null)
			{
				
				ExtendedPlayerHandler.register(player);
				
			}
			
			if(player.getExtendedProperties(ExtendedPlayerHandler.EXT_PROP_NAME) == null)
			{
				
				player.registerExtendedProperties(ExtendedPlayerHandler.EXT_PROP_NAME, new ExtendedPlayerHandler(player));
				
			}
			
		}
		
	}
	
	@ForgeSubscribe
	public void PlayerJoinEvent(EntityJoinWorldEvent event)
	{
		
		if(event.entity instanceof EntityPlayer)
		{
			
			EntityPlayer player = (EntityPlayer)event.entity;
			
			if(!player.worldObj.isRemote)
			{
				
				player.addChatMessage("Thanks " + player.username + " for downloading DivineRPG: Reloaded!");
				
			}
			
			player.openGui(RPG.instance, 0, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
			
		}
		
	}
	
}