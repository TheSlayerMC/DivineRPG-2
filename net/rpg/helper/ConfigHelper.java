package net.rpg.helper;

import java.io.File;

import net.minecraftforge.common.Configuration;
import net.rpg.Reference;

public class ConfigHelper
{
	
	public static Configuration config;
	
	public ConfigHelper()
	{
		
		this.config = new Configuration(new File("./" + Reference.MOD_NAME + "/Configuration.cfg"));
		
	}
	
	public void load()
	{
		
		this.config.load();
		
	}
	
	public void save()
	{
		
		this.config.save();
		
	}
	
}