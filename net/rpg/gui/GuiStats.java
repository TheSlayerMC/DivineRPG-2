package net.rpg.gui;

import java.util.Iterator;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.GuiMainMenu;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.multiplayer.WorldClient;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.minecraft.util.ResourceLocation;
import net.rpg.Reference;
import net.rpg.handler.ExtendedPlayerHandler;

import org.lwjgl.opengl.GL11;

public class GuiStats extends GuiScreen
{
	
	private int coolDown;
    private int xSize = 176;
    private int ySize = 166;
	
    private EntityPlayer player;
    private ExtendedPlayerHandler extendedPlayer;
    
	private static final ResourceLocation texture = new ResourceLocation(Reference.RESOURCE_PREFIX + "/stats");
	
	public GuiStats(EntityPlayer player)
	{
		
		this.player = player;
		
		try
		{
			
			this.extendedPlayer = (ExtendedPlayerHandler)player.getExtendedProperties(ExtendedPlayerHandler.EXT_PROP_NAME);
			
		}
		catch(Exception e)
		{
			
			//Util.print("Couldn't get stats for " + player.username + "!!!");
			
		}
		
	}
	
	@Override
    public void initGui()
    {
		
        this.buttonList.clear();
        
        if (this.mc.theWorld.getWorldInfo().isHardcoreModeEnabled())
        {
        	
            if (this.mc.isIntegratedServerRunning())
            {
            	
                this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 96, I18n.getString("deathScreen.deleteWorld")));
                
            }
            else
            {
            	
                this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 96, I18n.getString("deathScreen.leaveServer")));
                
            }
            
        }
        else
        {
        	
            this.buttonList.add(new GuiButton(1, this.width / 2 - 100, this.height / 4 + 72, I18n.getString("deathScreen.respawn")));
            this.buttonList.add(new GuiButton(2, this.width / 2 - 100, this.height / 4 + 96, I18n.getString("deathScreen.titleScreen")));

            if (this.mc.getSession() == null)
            {
            	
                ((GuiButton)this.buttonList.get(1)).enabled = false;
                
            }
            
        }

        GuiButton guibutton;

        for (Iterator iterator = this.buttonList.iterator(); iterator.hasNext(); guibutton.enabled = false)
        {
        	
            guibutton = (GuiButton)iterator.next();
            
        }
        
    }
	
	@Override
	protected void keyTyped(char par1, int par2)
	{
		
		
		
	}
	
    @Override
    public void drawScreen(int par1, int par2, float par3)
    {
    	
        this.drawGradientRect(0, 0, this.width, this.height, 1615855616, -1602211792);
        GL11.glPushMatrix();
        GL11.glScalef(2.0F, 2.0F, 2.0F);
        this.drawCenteredString(this.fontRenderer, EnumChatFormatting.YELLOW + "Race: ", this.width / 2 / 2, 30, 16777215);
        GL11.glPopMatrix();
        
        //this.drawCenteredString(this.fontRenderer, I18n.getString("deathScreen.hardcoreInfo"), this.width / 2, 144, 16777215);
        //this.drawCenteredString(this.fontRenderer, I18n.getString("deathScreen.score") + ": " + EnumChatFormatting.YELLOW + this.mc.thePlayer.getScore(), this.width / 2, 100, 16777215);
        
        super.drawScreen(par1, par2, par3);
        
    }
	
    @Override
    protected void actionPerformed(GuiButton button)
    {
    	
        switch(button.id)
        {
        
        case(1):
        {
        	
        	this.mc.thePlayer.respawnPlayer();
            this.mc.displayGuiScreen((GuiScreen)null);
            break;
        	
        }
        case(2):
        {
        	
        	this.mc.theWorld.sendQuittingDisconnectingPacket();
            this.mc.loadWorld((WorldClient)null);
            this.mc.displayGuiScreen(new GuiMainMenu());
        	
        }
        
        }
        
    }
    
    @Override
    public void updateScreen()
    {
        super.updateScreen();
        
        this.coolDown++;
        GuiButton guibutton;

        if (this.coolDown == 20)
        {
        	
            for (Iterator iterator = this.buttonList.iterator(); iterator.hasNext(); guibutton.enabled = true)
            {
            	
                guibutton = (GuiButton)iterator.next();
                
            }
            
        }
        
    }
	
    @Override
    public boolean doesGuiPauseGame()
    {
    	
        return true;
        
    }
    
}