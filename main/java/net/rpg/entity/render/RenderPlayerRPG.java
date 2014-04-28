package net.rpg.entity.render;

import net.minecraft.client.model.ModelBiped;
import net.minecraft.client.renderer.entity.Render;
import net.minecraft.client.renderer.entity.RenderManager;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.rpg.Reference;
import net.rpg.Util;
import net.rpg.entity.EntityPseudoPlayer;

import org.lwjgl.opengl.GL11;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;

@SideOnly(Side.CLIENT)
public class RenderPlayerRPG extends Render {
	private static final ResourceLocation steveTextures = new ResourceLocation("textures/entity/steve.png");
	public static final RenderPlayerRPG INSTANCE = new RenderPlayerRPG();
	public static final EntityPseudoPlayer player = new EntityPseudoPlayer(Reference.MC.theWorld);
	public static final ModelBiped BIPED = new ModelBiped();

	public RenderPlayerRPG() {
		setRenderManager(RenderManager.instance);
	}

	@Override
	protected ResourceLocation getEntityTexture(Entity entity) {
		return getEntityTexture((EntityPlayer) entity);
	}

	protected ResourceLocation getEntityTexture(EntityPlayer player) {
		if(player.getDisplayName().equals(Reference.MC.thePlayer.getDisplayName())) {
			System.err.println("RESOURCE PLAYER: " + Util.getRaceTexture(Reference.race).getResourceDomain());
			return Util.getRaceTexture(Reference.race);
		}
		return Util.getRaceTexture(Reference.playerRaces.get(player.getDisplayName()));
	}

	@Override
	public void doRender(Entity entity, double x, double y, double z, float yaw, float partialTick) {
		doRenderThirdPerson((EntityPlayer) entity, x, y, z, yaw, partialTick);
	}

	public void doRenderThirdPerson(EntityPlayer realPlayer, double x, double y, double z, float yaw, float partialTick) {
		preparePseudoPlayer(realPlayer);
		float scale = 1F;
		GL11.glScalef(scale, scale, scale);
		GL11.glRotatef(yaw, 0, 1, 0);
		bindTexture(getEntityTexture(realPlayer));
		BIPED.render(player, (float) x, (float) y, (float) z, player.rotationYaw, player.rotationPitch, 0.0625F);
	}

	public void preparePseudoPlayer(EntityPlayer realPlayer) {
		player.setLocationAndAngles(realPlayer.posX, realPlayer.posY, realPlayer.posZ, realPlayer.rotationYaw, realPlayer.rotationPitch);
		player.setRotationYawHead(realPlayer.rotationYawHead);
	}
}