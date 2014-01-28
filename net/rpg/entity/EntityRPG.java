package net.rpg.entity;

import net.minecraft.client.Minecraft;
import net.minecraft.entity.EntityCreature;
import net.minecraft.entity.SharedMonsterAttributes;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.DamageSource;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.world.World;
import net.rpg.Util;

public abstract class EntityRPG extends EntityCreature {
	public EntityRPG(World par1World) {
		super(par1World);
		this.tasks.addTask(1, new EntityAISwimming(this));
		this.tasks.addTask(4, new EntityAIAttackOnCollide(this, 1.0D, false));
		this.tasks.addTask(5, new EntityAIWander(this, 0.8D));
		this.tasks.addTask(6, new EntityAIWatchClosest(this, EntityPlayer.class, 8.0F));
		this.tasks.addTask(7, new EntityAILookIdle(this));
	}

	public void setHealth(double health) {
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).setAttribute(health);
	}

	public void setStrength(double strength) {
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).setAttribute(strength);
	}

	public void setFollowRange(double range) {
		this.getEntityAttribute(SharedMonsterAttributes.followRange).setAttribute(range);
	}

	public void setKnockbackResistance(double knock) {
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).setAttribute(knock);
	}

	public void setMoveSpeed(double speed) {
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).setAttribute(speed);
	}

	public void getHP() {
		this.getEntityAttribute(SharedMonsterAttributes.maxHealth).getAttributeValue();
	}

	public void getStrength() {
		this.getEntityAttribute(SharedMonsterAttributes.attackDamage).getAttributeValue();
	}

	public void getFollowRange() {
		this.getEntityAttribute(SharedMonsterAttributes.followRange).getAttributeValue();
	}

	public void getKnockbackResistance() {
		this.getEntityAttribute(SharedMonsterAttributes.knockbackResistance).getAttributeValue();
	}

	public void getMoveSpeed() {
		this.getEntityAttribute(SharedMonsterAttributes.movementSpeed).getAttributeValue();
	}

	public abstract String getName();

	public void onDeath(DamageSource d) {
		super.onDeath(d);
		EntityPlayer p = Minecraft.getMinecraft().thePlayer;
		p.func_145747_a(Util.addChatMessage(EnumChatFormatting.DARK_AQUA, p.getDisplayName() + " has slain a " + getName() + "."));
	}

	@Override
	protected boolean isAIEnabled() {
		return true;
	}
}
