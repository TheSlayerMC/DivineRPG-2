package net.rpg.entity;

import net.minecraft.world.World;
import net.rpg.helper.boss.IModBossDisplayData;

public class EntityRPGBoss extends EntityRPG implements IModBossDisplayData{

	public EntityRPGBoss(World par1World) {
		super(par1World);
	}

	@Override
	public String getEntityName() {
		return "Test Boss";
	}

	@Override
	protected void applyEntityAttributes() {
		this.setHealth(1000.0D);
	}

	@Override
	public void onUpdate() {
		super.onUpdate();
	}

	@Override
	public float maxHealth() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public float Health() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public String getName() {
		// TODO Auto-generated method stub
		return null;
	}
}
