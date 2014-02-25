package rpg.entity.render;

import net.minecraft.client.Minecraft;
import net.minecraft.client.model.ModelBase;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.entity.RenderLiving;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLiving;
import net.minecraft.util.ResourceLocation;

import org.lwjgl.opengl.GL11;

import rpg.entity.EntityRPG;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderRPGMob extends RenderLiving {
	private String res = "";

	public RenderRPGMob(ModelBase var1, String res) {
		super(var1, 0.5F);
		this.res = res;
	}

	public void renderEntity(EntityRPG var1, double var2, double var4, double var6, float var8, float var9) {
		drawHealthBar((EntityRPG) var1, var2, var4, var6, var8, var9, true);
		super.doRender(var1, var2, var4, var6, var8, var9);
	}

	@Override
	public void doRender(EntityLiving var1, double var2, double var4, double var6, float var8, float var9) {
		this.renderEntity((EntityRPG) var1, var2, var4, var6, var8, var9);
	}

	@Override
	public void doRender(Entity var1, double var2, double var4, double var6, float var8, float var9) {
		this.renderEntity((EntityRPG) var1, var2, var4, var6, var8, var9);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return new ResourceLocation(res);
	}

	public void drawHealthBar(EntityLiving entityLiving, double d, double d1, double d2, float f, float f1, boolean owned) {
		float f2 = 1.6F;
		float f3 = 0.01666667F * f2;
		if(Minecraft.isGuiEnabled()) {
			GL11.glPushMatrix();
			float scaleFactor = 1.3F;
			GL11.glTranslatef((float) d + 0.0F, (float) d1 + entityLiving.height * scaleFactor, (float) d2);
			GL11.glNormal3f(0.0F, 1.0F, 0.0F);
			GL11.glRotatef(-renderManager.playerViewY, 0.0F, 1.0F, 0.0F);
			GL11.glRotatef(renderManager.playerViewX, 1.0F, 0.0F, 0.0F);
			GL11.glScalef(-f3, -f3, f3);
			GL11.glDisable(2896 /* GL_LIGHTING */);
			GL11.glDepthMask(false);
			if(owned)
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
			if(f5 <= (f6 / 5))
				tessellator.setColorRGBA_F(0.8F, 0.0F, 0.0F, 1.0F);
			else if(f5 <= (f6 / 2))
				tessellator.setColorRGBA_F(1.0F, 1.0F, 0.2F, 1.0F);
			else
				tessellator.setColorRGBA_F(0.2F, 1F, 0.2F, 1.0F);
			tessellator.addVertex(-25D, -7 + byte0, 0.0D);
			tessellator.addVertex(-25D, -6 + byte0, 0.0D);
			tessellator.addVertex(f8 - 25F, -6 + byte0, 0.0D);
			tessellator.addVertex(f8 - 25F, -7 + byte0, 0.0D);
			tessellator.draw();
			GL11.glEnable(3553 /* GL_TEXTURE_2D */);
			if(owned)
				GL11.glEnable(2929 /* GL_DEPTH_TEST */);
			GL11.glDepthMask(true);
			GL11.glEnable(2896 /* GL_LIGHTING */);
			GL11.glDisable(3042 /* GL_BLEND */);
			GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
			GL11.glPopMatrix();
		}
	}
}
