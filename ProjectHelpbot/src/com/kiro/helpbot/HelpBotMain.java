package com.kiro.helpbot;

import org.bukkit.Bukkit;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.plugin.PluginManager;
import org.bukkit.plugin.java.JavaPlugin;

import com.kiro.helpbot.files.SettingsManager;
import com.kiro.helpbot.listeners.ChatListener;
import com.kiro.helpbot.listeners.FileAdder;

public class HelpBotMain extends JavaPlugin {
	
	FileConfiguration config;
	
	public void onEnable() {
	
		SettingsManager.getInstance().setup(this);
		PluginManager rl = Bukkit.getServer().getPluginManager();
		
		rl.registerEvents(new FileAdder() , this);
		rl.registerEvents(new ChatListener(), this);
		getCommand("helperbot").setExecutor(new helpBotCmd() );
	}
	
		

}
