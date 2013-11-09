package net.rpg.proxy;

import cpw.mods.fml.common.event.*;

public abstract class CommonProxy {

	public abstract void registerRenderThings();

	public void preInit(FMLPreInitializationEvent event){
		//Too add the gui, look at GuiIngame for the code for the gui screens that
		//show when you play (like your hotbar and stuff)
		
	}
	
	public void init(FMLInitializationEvent event){
		
	}
	
	public void postInit(FMLPostInitializationEvent event){
		
	}
	
}
