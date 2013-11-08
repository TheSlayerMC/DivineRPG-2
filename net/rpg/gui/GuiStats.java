package net.rpg.gui;

import net.minecraft.client.gui.GuiScreen;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.rpg.Util;
import net.rpg.handler.ExtendedPlayerHandler;

import org.lwjgl.opengl.GL11;

public class GuiStats extends GuiScreen
{
	
    protected int xSize = 176;
    protected int ySize = 166;
	
    protected EntityPlayer player;
    protected ExtendedPlayerHandler extendedPlayer;
    
	private static final ResourceLocation texture = new ResourceLocation(Util.RESOURCE_START + "/stats");
	
	public GuiStats(EntityPlayer player)
	{
		
		this.player = player;
		
		try
		{
			
			this.extendedPlayer = (ExtendedPlayerHandler)player.getExtendedProperties(ExtendedPlayerHandler.EXT_PROP_NAME);
			
		}
		catch(Exception e)
		{
			
			Util.print("Couldn't get stats for " + player.username + "!!!");
			
		}
		
	}
	
	protected void drawGuiContainerForegroundLayer(int par1, int par2)
	{
		
		this.fontRenderer.drawString("Race: " + extendedPlayer.getRace(), 8, 6, 4210752);
		
	}
	
	protected void drawGuiContainerBackgroundLayer(float par1, int par2, int par3)
	{
		
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.getTextureManager().bindTexture(texture);
	    int k = (this.width - this.xSize) / 2;
	    int l = (this.height - this.ySize) / 2;
	    this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        
	}
	
}