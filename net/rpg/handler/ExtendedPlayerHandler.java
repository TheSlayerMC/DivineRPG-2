package net.rpg.handler;

import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.world.World;
import net.minecraftforge.common.IExtendedEntityProperties;
import net.rpg.Util;

public class ExtendedPlayerHandler implements IExtendedEntityProperties
{
	
	public final static String EXT_PROP_NAME = "ExtendedPlayer";
	
	private final EntityPlayer player;
	
	private String race;
	
	public ExtendedPlayerHandler(EntityPlayer player)
	{
		
		this.player = player;
		
		this.race = "fgt";
		
	}
	
	public static final void register(EntityPlayer player)
	{
		
		player.registerExtendedProperties(ExtendedPlayerHandler.EXT_PROP_NAME, new ExtendedPlayerHandler(player));
		
	}
	
	public static final ExtendedPlayerHandler get(EntityPlayer player)
	{
		
		return (ExtendedPlayerHandler)player.getExtendedProperties(EXT_PROP_NAME);
		
	}
	
	@Override
	public void saveNBTData(NBTTagCompound compound)
	{
		
		NBTTagCompound properties = new NBTTagCompound();
		
		properties.setString("Race", this.race);
		
		compound.setTag(EXT_PROP_NAME, properties);
		
	}
	
	@Override
	public void loadNBTData(NBTTagCompound compound)
	{
		
		NBTTagCompound properties = (NBTTagCompound) compound.getTag(EXT_PROP_NAME);
		
		this.race = properties.getString("Race");
		
		Util.print("Race loaded from NBT: " + this.race);
		
	}
	
	//TODO Get a use for this
	@Override
	public void init(Entity entity, World world)
	{
		
		
		
		
	}
	
	public void setRace(String race)
	{
		
		this.race = race;
		
	}
	
	public String getRace()
	{
		
		return this.race;
		
	}
	
}