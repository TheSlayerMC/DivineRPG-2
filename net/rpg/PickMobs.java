package net.rpg;

import net.minecraft.item.Item;

public class PickMobs {

	public boolean isCyclops = false;
	public boolean isArcher = false;
	public boolean isScorcher = false;
	public boolean isCori = false;
	public boolean isClacide = false;

	/**
	 * when we call the mob, it will return true, so if we want a mob to drop a different item, it will be:
	 * 
	 * protected int getDropItemId() {
    	if(PickMobs.isCyclops){
        return Item.gunpowder.itemID;
        }else{
        return Item.diamond.itemID;
    	}
	 * */
}
