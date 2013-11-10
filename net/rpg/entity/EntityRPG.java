package net.rpg.entity;

import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.world.World;

public class EntityRPG extends EntityLiving{

	public EntityRPG(World par1World) {
		super(par1World);
	}
	
	public void setHealth(double health){
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(health);
	}
	
	public void setStrength(double strength){
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(strength);
	}
	
	public void setFollowRange(double range){
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(range);	
	}
	
	public void setKnockbackResistance(double knock){
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setAttribute(knock);
	}
	
	public void setMoveSpeed(double speed){
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(speed);
	}
	
	public void getHP(){
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue();
	}
	
	public void getStrength(){
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
	}
	
	public void getFollowRange(){
		this.getEntityAttribute(SharedMonsterAttributes.followRange).getAttributeValue();	
	}
	
	public void getKnockbackResistance(){
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).getAttributeValue();
	}
	
	public void getMoveSpeed(){
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue();
	}

}
