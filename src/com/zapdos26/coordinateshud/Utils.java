package com.zapdos26.coordinateshud;


import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.Plugin;

import net.md_5.bungee.api.ChatColor;

import java.util.ArrayList;
import java.util.List;

public class Utils {

    private static List<String> Players;

    private static FileConfiguration cfg;
    private static Plugin plugin;
    private static String ticks;
    private static boolean defaulton;

    public static void readConfig(FileConfiguration cfg, Plugin plugin) {
        Utils.cfg = cfg;
        Utils.plugin = plugin;
		ticks = cfg.getString("ticks");
		defaulton = (boolean) cfg.get("default-on");
        Players = cfg.getStringList("Players");
    }

    public static int getTicks() {
		return Integer.parseInt(ticks);
    }
    
    public static boolean getDefaultOn() {
    	return defaulton;
    }
    
    private static List<String> getPlayers() {
        if (Players == null)
            return new ArrayList<String>();
        else
            return Players;
    }

    public static boolean checkPlayerList(Player player) {
        return getPlayers().contains(player.getName());
    }

    public static void savePlayer(Player player) {
        if (!Players.contains(player.getName()))
            Players.add(player.getName());

        cfg.set("Players", Players);
        plugin.saveConfig();
    }

    public static void removePlayer(Player player) {
        Players.remove(player.getName());
        cfg.set("Players", Players);
        plugin.saveConfig();
    }
    
    public static void sendMsg(CommandSender player, String msg) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', msg));
    }
    public static String rpGetPlayerDirection(Player playerSelf){
        String dir = "";
        float y = playerSelf.getLocation().getYaw();
        if( y < 0 ){y += 360;}
        y %= 360;
        int i = (int)((y+8) / 22.5);
        if(i == 4){dir = "W";}
        else if(i == 5){dir = "WNW";}
        else if(i == 6){dir = "NW";}
        else if(i == 7){dir = "NNW";}
        else if(i == 8){dir = "N";}
        else if(i == 9){dir = "NNE";}
        else if(i == 10){dir = "NE";}
        else if(i == 11){dir = "ENE";}
        else if(i == 12){dir = "E";}
        else if(i == 13){dir = "ESE";}
        else if(i == 14){dir = "SE";}
        else if(i == 15){dir = "SSE";}
        else if(i == 0){dir = "S";}
        else if(i == 1){dir = "SSW";}
        else if(i == 2){dir = "SW";}
        else if(i == 3){dir = "WSW";}
        else {dir = "S";}
        return dir;
   }
}
