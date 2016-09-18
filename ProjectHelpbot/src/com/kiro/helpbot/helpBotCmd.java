package com.kiro.helpbot;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.kiro.helpbot.files.SettingsManager;

public class helpBotCmd implements CommandExecutor {

	@Override
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		
		if (!(sender instanceof Player)) return true;
		
		else {
			Player p = (Player) sender;
			String puuid = p.getUniqueId().toString().replace("-", "");
			
			if (SettingsManager.getInstance().getData().get(puuid) == null) {
				SettingsManager.getInstance().getData().set(puuid, 0);
				p.sendMessage(ChatColor.GREEN + "You have enabled HelperBot");
				SettingsManager.getInstance().saveData();
				return true;
			}
			if (SettingsManager.getInstance().getData().getInt(puuid) == 0){
				SettingsManager.getInstance().getData().set(puuid, 1);
				SettingsManager.getInstance().saveData();
				p.sendMessage(ChatColor.RED + "HelperBot has been disabled for you, to reenable retype this command.");
				return true;
			}
			else {
				SettingsManager.getInstance().getData().set(puuid, 0);
				p.sendMessage(ChatColor.GREEN + "You have enabled HelperBot");
				SettingsManager.getInstance().saveData();
				return true;
			}
			
		}
	}

}
