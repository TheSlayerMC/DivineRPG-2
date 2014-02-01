package net.rpg.entity.render;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.rpg.RPG;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderPlayerRPG extends RenderPlayer {
	private static final ResourceLocation texture = new ResourceLocation("rpg:textures/entity/chicken");

	@Override
	protected ResourceLocation getEntityTexture(AbstractClientPlayer par1AbstractClientPlayer) {
		return texture;
	}

	@Override
	public void renderFirstPersonArm(EntityPlayer par1EntityPlayer) {
		if(RPG.race == -1 || RPG.race == 0) {
			super.renderFirstPersonArm(par1EntityPlayer);
		}
	}
}