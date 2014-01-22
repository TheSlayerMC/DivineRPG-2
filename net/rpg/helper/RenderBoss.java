package net.rpg.helper;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.util.ResourceLocation;

public class RenderBoss extends RenderLiving {
	public RenderBoss(ModelBiped par1ModelBiped) {
		super(par1ModelBiped, 0.5F);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation("");
	}
}
