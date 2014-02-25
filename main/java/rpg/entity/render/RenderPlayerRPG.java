package rpg.entity.render;

import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import rpg.RPG;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderPlayerRPG extends RenderPlayer {
	private static final ResourceLocation texture = new ResourceLocation("rpg:textures/entity/cyclops.png");
	private float scale;

	public RenderPlayerRPG(float scale) {
		this.scale = scale;
	}

	protected void preRenderScale(EntityPlayer var1, float var2) {
		GL11.glScalef(this.scale, this.scale, this.scale);
	}

	@Override
	protected void preRenderCallback(EntityLivingBase var1, float var2) {
		this.preRenderScale((EntityPlayer) var1, var2);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity) {
		return texture;
	}

	@Override
	public void renderFirstPersonArm(EntityPlayer par1EntityPlayer) {
		if(RPG.race == -1 || RPG.race == 0) {
			super.renderFirstPersonArm(par1EntityPlayer);
		}
	}
}