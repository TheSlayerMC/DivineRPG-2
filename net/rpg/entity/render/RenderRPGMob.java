package net.rpg.entity.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.rpg.entity.EntityRPG;

import org.lwjgl.opengl.GL11;

public class RenderRPGMob extends RenderLiving{

	static ResourceLocation Texture;
	
	public RenderRPGMob(ModelBase par1ModelBase, float par2, ResourceLocation texture) {
		super(par1ModelBase, par2);
		Texture = texture;
	}

	//static String playerUsername = Minecraft.getMinecraft().thePlayer.username;

	@Override
	public void doRender(Entity entity, double d0, double d1, double d2, float f, float f1) {

	}
	
	public void doRenderLiving(EntityLiving entityLiving, double d, double d1, double d2, float f, float f1) {
		drawHealthBar((EntityRPG)entityLiving, d, d1, d2, f, f1, true);
	}

	public void drawHealthBar(EntityLiving entityLiving, double d, double d1, double d2, float f, float f1, boolean owned) {
		float f2 = 1.6F;
		float f3 = 0.01666667F * f2;
		if (Minecraft.isGuiEnabled()) {
			GL11.glPushMatrix();
			float scaleFactor = 1.3F;
			GL11.glTranslatef((float) d + 0.0F, (float) d1 + entityLiving.height * scaleFactor, (float) d2);
			GL11.glNormal3f(0.0F, 1.0F, 0.0F);
			GL11.glRotatef(-renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
			GL11.glScalef(-f3, -f3, f3);
			GL11.glDisable(2896 /* GL_LIGHTING */);
			GL11.glDepthMask(false);
			if (owned)
				GL11.glDisable(2929 /* GL_DEPTH_TEST */);
			GL11.glEnable(3042 /* GL_BLEND */);
			GL11.glBlendFunc(770, 771);
			Tessellator tessellator = Tessellator.instance;
			byte byte0 = -25;
			GL11.glDisable(3553 /* GL_TEXTURE_2D */);
			tessellator.startDrawingQuads();
			float f5 = ((EntityRPG) entityLiving).getHealth();
			float f6 = ((EntityRPG) entityLiving).getMaxHealth();
			float f8 = 50F * (f5 / f6);

			tessellator.setColorRGBA_F(0.5F, 0.5F, 0.5F, 1.0F);
			tessellator.addVertex(-25F + f8, -7 + byte0, 0.0D);
			tessellator.addVertex(-25F + f8, -6 + byte0, 0.0D);
			tessellator.addVertex(25D, -6 + byte0, 0.0D);
			tessellator.addVertex(25D, -7 + byte0, 0.0D);

			if (f5 <= (f6 / 5))
				tessellator.setColorRGBA_F(0.8F, 0.0F, 0.0F, 1.0F);
			else if (f5 <= (f6 / 2))
				tessellator.setColorRGBA_F(1.0F, 1.0F, 0.2F, 1.0F);
			else
				tessellator.setColorRGBA_F(0.2F, 1F, 0.2F, 1.0F);

			tessellator.addVertex(-25D, -7 + byte0, 0.0D);
			tessellator.addVertex(-25D, -6 + byte0, 0.0D);
			tessellator.addVertex(f8 - 25F, -6 + byte0, 0.0D);
			tessellator.addVertex(f8 - 25F, -7 + byte0, 0.0D);
			tessellator.draw();
			GL11.glEnable(3553 /* GL_TEXTURE_2D */);
			if (owned)
				GL11.glEnable(2929 /* GL_DEPTH_TEST */);
			GL11.glDepthMask(true);
			GL11.glEnable(2896 /* GL_LIGHTING */);
			GL11.glDisable(3042 /* GL_BLEND */);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glPopMatrix();
		}
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return Texture;
	}

}
