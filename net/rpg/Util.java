package net.rpg;

import java.util.logging.Level;
import java.util.logging.Logger;

import cpw.mods.fml.common.FMLLog;

public class Util
{
	
	private static Logger log = Logger.getLogger(Reference.MOD_ID);
	
	private static boolean initialized = false;
	
	public static void init()
	{
		
		log.setParent(FMLLog.getLogger());
		
		initialized = true;
		
	}
	
	public static final void severe(String text)
	{
		
		if(!initialized)
		{
			
			init();
			
		}
		
		log.log(Level.SEVERE, text);
		
	}
	
	public static final void warn(String text)
	{
		
		if(!initialized)
		{
			
			init();
			
		}
		
		log.log(Level.WARNING, text);
		
	}
	
	public static final void fine(String text)
	{
		
		if(!initialized)
		{
			
			init();
			
		}
		
		log.log(Level.FINE, text);
		
	}
	
	public static final void finer(String text)
	{
		
		if(!initialized)
		{
			
			init();
			
		}
		
		log.log(Level.FINER, text);
		
	}
	
	public static final void finest(String text)
	{
		
		if(!initialized)
		{
			
			init();
			
		}
		
		log.log(Level.FINEST, text);
		
	}
	
	public static final void info(String text)
	{
		
		if(!initialized)
		{
			
			init();
			
		}
		
		log.log(Level.INFO, text);
		
	}
	
}