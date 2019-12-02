package com.zapdos26.coordinateshud;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

public class Coordinates implements CommandExecutor, TabCompleter {
    private static final List<String> COMMANDS = Arrays.asList("toggle");
	
	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		if (sender instanceof Player) {
			Player player = (Player) sender;
			if ( args.length == 0 || !args[0].toLowerCase().equals("toggle")) {
				Utils.sendMsg(player, "/coordinates toggle");
				return true;
			}
			if (!Utils.checkPlayerList(player)) {
				Utils.savePlayer(player);
			}
			else {
				Utils.removePlayer(player);
			}
			Utils.sendMsg(player, "Coordinates HUD is now " + (((Utils.checkPlayerList(player) && !Utils.getDefaultOn()) || (!Utils.checkPlayerList(player) && Utils.getDefaultOn()))? "enabled" : "disabled")+ ".");
			return true;
			}
		return false;
	}
	
	@Override
    public List<String> onTabComplete(CommandSender sender, Command command, String alias, String[] args) {
        return (args.length > 0) ? StringUtil.copyPartialMatches(args[0], COMMANDS, new ArrayList<String>()) : null;

    }
}
		


