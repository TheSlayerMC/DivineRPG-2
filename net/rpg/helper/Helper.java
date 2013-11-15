package net.rpg.helper;

import net.minecraft.util.ResourceLocation;
import net.rpg.Reference;

public class Helper {

	public String prefix = Reference.MOD_ID + ":";
	
	public ResourceLocation addGUI(String texture){
		return new ResourceLocation(prefix + "textures/gui" + texture + ".png");
	}
}
