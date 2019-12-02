package com.zapdos26.coordinateshud;

import org.bukkit.plugin.java.JavaPlugin;



public class Main extends JavaPlugin {

	@Override
	public void onEnable() {
		getLogger().info("CoordinatesHUD Enabled");
        saveDefaultConfig();
        Utils.readConfig(getConfig(), this);
		this.getCommand("coordinates").setExecutor(new Coordinates());
		CoordinatesTimer.run(this);
		
	}
	
	@Override
	public void onDisable() {
		getLogger().info("CoordinatesHUD Disabled");
	}
	

}

