package com.zapdos26.coordinateshud;

import org.bukkit.Bukkit;
import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.ComponentBuilder;

public class CoordinatesTimer {
	
	public static void run(Plugin plugin) {
	Bukkit.getScheduler().runTaskTimerAsynchronously(plugin, new Runnable() {
    	@Override
    	public void run() {
    		for(Player p : plugin.getServer().getOnlinePlayers()) {
    			if ((Utils.checkPlayerList(p) && !Utils.getDefaultOn()) || (!Utils.checkPlayerList(p) && Utils.getDefaultOn())) {
	    			Location l = p.getLocation();
	    			long gameTime = p.getWorld().getTime();
	    	        long hours = gameTime / 1000 + 6;
	    	        hours %= 24;
	    	        if (hours == 24) hours = 0;
	    	        long minutes = (gameTime % 1000) * 60 / 1000;
	    	        String mm = "0" + minutes;
	    	        mm = mm.substring(mm.length() - 2, mm.length());
	    			p.spigot().sendMessage(ChatMessageType.ACTION_BAR, new ComponentBuilder(ChatColor.GOLD + "XYZ: " + ChatColor.WHITE + l.getBlockX() + " " + l.getBlockY() + " " + l.getBlockZ() + " "  + ChatColor.GOLD + String.format("%-10s",Utils.rpGetPlayerDirection(p)) + hours + ":" + mm ).create());
	    		}
    		}
    	}
    },0L,Utils.getTicks());

	}
}
