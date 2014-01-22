package net.rpg.api.entity.render;

import net.minecraft.client.model.ModelBase;
import net.rpg.api.entity.EntityRPG;
import net.rpg.api.entity.EntityRPGBoss;
import net.rpg.helper.boss.BossBar;

public class RenderRPGBoss extends RenderRPGMob {
	public RenderRPGBoss(ModelBase var1, String res) {
		super(var1, res);
	}

	@Override
	public void renderEntity(EntityRPG var1, double var2, double var4, double var6, float var8, float var9) {
		BossBar.setBossStatus((EntityRPGBoss) var1, true);
		drawHealthBar((EntityRPG) var1, var2, var4, var6, var8, var9, true);
		super.doRender(var1, var2, var4, var6, var8, var9);
	}
}
