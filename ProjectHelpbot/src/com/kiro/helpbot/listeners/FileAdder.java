package com.kiro.helpbot.listeners;

import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerLoginEvent;

import com.kiro.helpbot.files.SettingsManager;

public class FileAdder implements Listener{

	
	@EventHandler
	public void onPlayerJoin(PlayerLoginEvent e) {
		if (e.getPlayer().hasPlayedBefore()) return;
		else {
			String puuid = e.getPlayer().getUniqueId().toString().replace("-", "");
			SettingsManager.getInstance().getData().createSection(puuid);
			SettingsManager.getInstance().getData().set(puuid, 0);
			SettingsManager.getInstance().saveData();
		}
	}
}
