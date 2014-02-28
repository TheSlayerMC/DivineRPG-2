package net.rpg.handler;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumChatFormatting;
import net.rpg.Reference;
import net.rpg.Util;

public class WelcomeHandler {
	public static void wm(EntityPlayer p) {
		try {
			if(!InternetHandler.isOnline()) {
				if(p.getDisplayName().equals("sheenrox82")) {
					p.addChatMessage(Util.addChatMessage(EnumChatFormatting.DARK_PURPLE, "Wait, your actually playing DivineRPG?!"));
					p.addChatMessage(Util.addChatMessage(EnumChatFormatting.LIGHT_PURPLE, "Turn your internets on noob."));
				} else if(p.getDisplayName().equals("deathman12e3") || p.getDisplayName().equals("The_SlayerMC") || p.getDisplayName().equals("Mazetar") || p.getDisplayName().equals("itzakillshot") || p.getDisplayName().equals("geekclb") || p.getDisplayName().equals("Instanity414all")) {
					p.addChatMessage(Util.addChatMessage(EnumChatFormatting.DARK_PURPLE, "Oh hey! A DivineRPG 2 Developer!"));
					p.addChatMessage(Util.addChatMessage(EnumChatFormatting.LIGHT_PURPLE, "Your internet crashed from how awesome you are."));
				} else {
					p.addChatMessage(Util.addChatMessage(EnumChatFormatting.AQUA, "Thank you " + p.getDisplayName() + ", for downloading and playing" + Util.GREEN + " DivineRPG 2!"));
					p.addChatMessage(Util.addChatMessage(EnumChatFormatting.AQUA, "[Version: " + Reference.MOD_VERSION + "]"));
					p.addChatMessage(Util.addChatMessage(EnumChatFormatting.LIGHT_PURPLE, "Unable to check for latest version, you may want to check your internet connection!"));
				}
			}
			if(InternetHandler.isUpdateAvailable() && InternetHandler.isOnline()) {
				if(p.getDisplayName().equals("sheenrox82")) {
					p.addChatMessage(Util.addChatMessage(EnumChatFormatting.DARK_PURPLE, "Wait, your actually playing DivineRPG 2?!"));
					p.addChatMessage(Util.addChatMessage(EnumChatFormatting.YELLOW, "By the way your using a outdated version."));
				} else if(p.getDisplayName().equals("deathman12e3") || p.getDisplayName().equals("The_SlayerMC") || p.getDisplayName().equals("Mazetar") || p.getDisplayName().equals("itzakillshot") || p.getDisplayName().equals("geekclb") || p.getDisplayName().equals("Instanity414all")) {
					p.addChatMessage(Util.addChatMessage(EnumChatFormatting.DARK_PURPLE, "Oh hey! A DivineRPG 2 Developer!"));
					p.addChatMessage(Util.addChatMessage(EnumChatFormatting.YELLOW, "Wow, you don't even have the newest version of your own mod."));
				} else {
					BufferedReader versionFile = new BufferedReader(new InputStreamReader(new URL("https://raw.github.com/TheSlayerMC/RPG/master/Version").openStream()));
					String curVersion = versionFile.readLine();
					p.addChatMessage(Util.addChatMessage(EnumChatFormatting.AQUA, "Thank you " + p.getDisplayName() + ", for downloading and playing" + Util.GREEN + " DivineRPG 2!"));
					p.addChatMessage(Util.addChatMessage(EnumChatFormatting.RED, "[Version: " + Reference.MOD_VERSION + "]"));
					p.addChatMessage(Util.addChatMessage(EnumChatFormatting.YELLOW, "A DivineRPG update is avaliable."));
					p.addChatMessage(Util.addChatMessage(EnumChatFormatting.YELLOW, "[New Version: " + curVersion + "]"));
				}
			}
			if((!InternetHandler.isUpdateAvailable()) && InternetHandler.isOnline()) {
				if(p.getDisplayName().contains("sheenrox82")) {
					p.addChatMessage(Util.addChatMessage(EnumChatFormatting.DARK_PURPLE, "Wait, your actually playing DivineRPG 2?!"));
				} else if(p.getDisplayName().equals("deathman12e3") || p.getDisplayName().equals("The_SlayerMC") || p.getDisplayName().equals("Mazetar") || p.getDisplayName().equals("itzakillshot") || p.getDisplayName().equals("geekclb") || p.getDisplayName().equals("Instanity414all")) {
					p.addChatMessage(Util.addChatMessage(EnumChatFormatting.DARK_PURPLE, "Oh hey! A DivineRPG 2 Developer!"));
				} else {
					p.addChatMessage(Util.addChatMessage(EnumChatFormatting.AQUA, "Thank you " + p.getDisplayName() + ", for downloading and playing" + Util.GREEN + " DivineRPG 2!"));
					p.addChatMessage(Util.addChatMessage(EnumChatFormatting.AQUA, "[Version: " + Reference.MOD_VERSION + "]"));
					p.addChatMessage(Util.addChatMessage(EnumChatFormatting.GREEN, "DivineRPG is up to date."));
				}
			}
		} catch(MalformedURLException e1) {
			e1.printStackTrace();
		} catch(IOException e1) {
			e1.printStackTrace();
		}
	}
}
