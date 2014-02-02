package net.rpg.gui;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.rpg.RPG;
import net.rpg.Reference;
import net.rpg.container.ContainerRaceSelection;

public class GuiAbilitys extends GuiContainer{

	private EntityPlayer p;
	
	public GuiAbilitys(EntityPlayer p) {
		super(new ContainerRaceSelection(p));
		this.p = p; 
	}

	@Override
	protected void func_146976_a(float arg0, int arg1, int arg2) {
		String s = "Abilitys";
		this.field_146289_q.drawString(s, this.field_146999_f / 2 - this.field_146289_q.getStringWidth(s) / 2, 6, 4210752);
		s = "~~~~~~~~~~~~~~~~~~~~~~";
		this.field_146289_q.drawString(s, this.field_146999_f / 2 - this.field_146289_q.getStringWidth(s) / 2, 17, 4210752);
		if(RPG.race == -1) {
			s = EnumChatFormatting.DARK_RED + "Use the Race Stone";
			this.field_146289_q.drawString(s, this.field_146999_f / 2 - this.field_146289_q.getStringWidth(s) / 2, 22, 4210752);
			s = EnumChatFormatting.DARK_RED + "to begin your adventure!";
			this.field_146289_q.drawString(s, this.field_146999_f / 2 - this.field_146289_q.getStringWidth(s) / 2, 32, 4210752);
		} else {
			s = EnumChatFormatting.YELLOW + "Race: " + EnumChatFormatting.WHITE + Reference.translateRace(RPG.race);
			this.field_146289_q.drawString(s, this.field_146999_f / 2 - this.field_146289_q.getStringWidth(s) / 2, 22, 4210752);
			s = EnumChatFormatting.YELLOW + "Ability: " + EnumChatFormatting.WHITE + RPG.ability;
			this.field_146289_q.drawString(s, this.field_146999_f / 2 - this.field_146289_q.getStringWidth(s) / 2, 32, 4210752);
			s = EnumChatFormatting.YELLOW + "Good effect: " + EnumChatFormatting.WHITE + RPG.goodEfect;
			this.field_146289_q.drawString(s, this.field_146999_f / 2 - this.field_146289_q.getStringWidth(s) / 2, 42, 4210752);
			s = EnumChatFormatting.YELLOW + "Denotation: " + EnumChatFormatting.WHITE + RPG.denotation;
			this.field_146289_q.drawString(s, this.field_146999_f / 2 - this.field_146289_q.getStringWidth(s) / 2, 52, 4210752);
			s = EnumChatFormatting.YELLOW + "Cool down: " + EnumChatFormatting.WHITE + RPG.coolDown;
			this.field_146289_q.drawString(s, this.field_146999_f / 2 - this.field_146289_q.getStringWidth(s) / 2, 62, 4210752);
		}
	}

}
