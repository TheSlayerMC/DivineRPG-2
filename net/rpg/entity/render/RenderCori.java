package net.rpg.entity.render;

import org.lwjgl.opengl.GL11;

import net.minecraft.client.entity.AbstractClientPlayer;
import net.minecraft.client.renderer.entity.RenderPlayer;
import net.minecraft.client.renderer.entity.RendererLivingEntity;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.rpg.RPG;
import net.rpg.entity.model.ModelCori;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderCori extends RendererLivingEntity {
	private static final ResourceLocation texture = new ResourceLocation("rpg:textures/entity/cori.png");

	private float scale;
	private ModelCori model;
	public RenderCori(float scale) {
		super(new ModelCori(), 0.5F);
		this.scale = scale;
		this.model = new ModelCori();
	}
	
    protected void preRenderScale(EntityPlayer var1, float var2){
        GL11.glScalef(this.scale, this.scale, this.scale);
    }
	
    /*@Override
    protected void preRenderCallback(EntityLivingBase var1, float var2) {
        this.preRenderScale((EntityPlayer)var1, var2);
    }*/

	
	@Override
	protected ResourceLocation getEntityTexture(Entity par1Entity) {
		return texture;
	}

	/*@Override
	public void renderFirstPersonArm(EntityPlayer par1EntityPlayer) {
		if(RPG.race == -1 || RPG.race == 0) {
			super.renderFirstPersonArm(par1EntityPlayer);
		}
	}*/
}