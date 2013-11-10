package net.rpg.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraftforge.event.ForgeSubscribe;
import net.minecraftforge.event.entity.EntityEvent.EntityConstructing;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.living.LivingSpawnEvent;
import net.rpg.RPG;
import net.rpg.Reference;
import net.rpg.Util;

public class PlayerEventHandler
{
	
	@ForgeSubscribe
	public void PlayerConstructionEvent(EntityConstructing event)
	{
		
		
		
	}
	
	@ForgeSubscribe
	public void PlayerJoinEvent(EntityJoinWorldEvent event)
	{
		
		if(event.entity instanceof EntityPlayer)
		{
			
			EntityPlayer player = (EntityPlayer)event.entity;
			NBTTagCompound nbt = player.getEntityData();
			
			if(!player.worldObj.isRemote && (nbt.getString("Race") == null || RPG.instance.proxy.getData(player.username + "Race") == null))
			{
				
				Util.info(player.username + " is a newbie, initiating character creation GUI.");
				
				player.openGui(RPG.instance, 1, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
				
				player.addChatMessage("Thanks " + player.username + " for downloading " + Reference.MOD_NAME);
				
			}
			
		}
		
	}
	
	@ForgeSubscribe
	public void PlayerSpawnEvent(LivingSpawnEvent event)
	{
		
		if(!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer)
		{
			
			EntityPlayer player = (EntityPlayer)event.entity;
			NBTTagCompound nbt = player.getEntityData();
			
			Util.info("Setting race!");
			
			nbt.setString("Race", (String)RPG.instance.proxy.getData(player.username + "Race"));
			
		}
		
	}
	
	@ForgeSubscribe
	public void PlayerDeathEvent(LivingDeathEvent event)
	{
		
		if(!event.entity.worldObj.isRemote && event.entity instanceof EntityPlayer)
		{
			
			Util.info("?/////////////////////////////////////////HELLO");
			
			EntityPlayer player = (EntityPlayer)event.entity;
			NBTTagCompound nbt = player.getEntityData();
			
			if(nbt.getString("Race") != null)
			{
				
				Util.info("Saving race!");
				
				RPG.proxy.storeData(player.username + "Race", nbt.getString("Race"));
				
			}
			
		}
		
	}
	
}