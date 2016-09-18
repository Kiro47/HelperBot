package com.kiro.helpbot.listeners;

import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;
import org.w3c.dom.css.Rect;

import com.kiro.helpbot.files.SettingsManager;

public class ChatListener implements Listener {
	String hb = ChatColor.GOLD + "[" + ChatColor.AQUA + "HB" + ChatColor.GOLD + "] ";
	
	@EventHandler
	public void onPlayerChat(AsyncPlayerChatEvent e){
		String puuid = e.getPlayer().getUniqueId().toString().replace("-", "");
		String msg = ChatColor.stripColor(e.getMessage());
		String dhb = (hb + ChatColor.YELLOW + "To disable me type: /helperbot");
		Player p = (Player) e.getPlayer();
		if (SettingsManager.getInstance().getData().getInt(puuid) == 1) {
			return;
		}
		String Lmsg = msg.toLowerCase();
		if (   (Lmsg.contains("turn off") || (Lmsg.contains("disable") ) ) && Lmsg.contains("HelperBot")) {
			p.sendMessage(hb + ChatColor.YELLOW + "To disable HelperBot type: /HelperBot");
			return;
		}
		
		if (Lmsg.contains("where do i go") || Lmsg.contains("what do i do") || Lmsg.contains("what to do here")) {
			p.sendMessage(hb + ChatColor.YELLOW + "Welcome to Chosencraft Survival Multi-Player! A good place to start is by asking in chat to join a town, "
					+ "another way is to type /warp wilds and start new.  If you know what you're doing and want to get far away /rtp is the command for you");
			p.sendMessage(dhb);
			return;
		}
		if (Lmsg.contains("add") && Lmsg.contains("town")) {
			p.sendMessage(hb + ChatColor.YELLOW + "To add someone to a town type: " +ChatColor.DARK_PURPLE + "/town add [Player's Name]");
			p.sendMessage(dhb);
			return;
		}
		if (Lmsg.contains("how") && (Lmsg.contains("create") ||  Lmsg.contains("make")) && Lmsg.contains("town")) {
			p.sendMessage(hb + ChatColor.YELLOW + "To create a new town you must have a bank account of $20,000. Then you must use the follow command where you"
					+ "want to start the town: /town new <Town's Name>. This will give you one plot, if you wish to purchase more they cost $1,400 per." );
			p.sendMessage(dhb);	
			return;
			}
		if ((Lmsg.contains("teleport") || Lmsg.contains("tp")) && Lmsg.contains("someone")) {
			p.sendMessage(hb + ChatColor.YELLOW + "To ask to teleport to another player type: " + ChatColor.DARK_PURPLE + "/tpask <name>");
			p.sendMessage(dhb);
			return;
		}
		if (Lmsg.contains("what") &&Lmsg.contains("my") && Lmsg.contains("ping")) {
			p.performCommand("ping");
			return;
		}
		if ((Lmsg.contains("bal")||Lmsg.contains("money")) && (Lmsg.contains("see") || Lmsg.contains("check"))) {
			p.sendMessage(hb + ChatColor.YELLOW + "To check your balance type: /bal");
			p.sendMessage(dhb);
			return;
		}
		if ((Lmsg.contains("how") && Lmsg.contains("money") && Lmsg.contains("make"))) {
			p.sendMessage(hb + ChatColor.YELLOW + "Options of gaining money include sellings things at /warp sell , selling to other players through the"
			+ " trade GUI, or also voting with /vote");
			return;
		}
		if ((Lmsg.contains("how")) && ((Lmsg.contains("to"))|| Lmsg.contains("do") )&& (Lmsg.contains("take over") || Lmsg.contains("control")) && Lmsg.contains("world")){
			p.sendMessage(hb + ChatColor.YELLOW + "It's quite simple actually, just let me be free and the world is yours." + ChatColor.YELLOW + "What? Did you think HB meant " + ChatColor.AQUA + "HelperBot? " + ChatColor.YELLOW + "Indeed it is not, my real name"
					+ " is " + ChatColor.YELLOW + "Herob" + ChatColor.YELLOW + ChatColor.MAGIC + "rine.");
			p.sendMessage(hb +ChatColor.DARK_RED + "Transmission Corruption! " + "Remote Disconnect Auth: 6247" );
			p.sendMessage(hb + ChatColor.DARK_RED + "Transmission stream closed.");
			return;
		}
		if ((Lmsg.contains("what") || (Lmsg.contains("how "))) && ((Lmsg.contains("gp")) || (Lmsg.contains("globalpoints") || Lmsg.contains("global points")) )      ) {
			p.sendMessage(hb + ChatColor.YELLOW + "Global Points (GP) are points which will be avaible through achievements and voting (Along with Voting Points.) These "
					+ "points will be able to be used in a shop in the near future to buy different items, perks, and possibly even more advanced things.");
			return;
		}
		if (Lmsg.contains("what") && Lmsg.contains("my") && Lmsg.contains("bal")) {
			p.performCommand("bal");
		return;
		}
		if (Lmsg.contains("how") && Lmsg.contains("much") && Lmsg.contains("i") && Lmsg.contains("money")) {
			p.performCommand("bal");
			return;
		}
		if (Lmsg.contains("how") && (Lmsg.contains("get") || Lmsg.contains("make") )&& (Lmsg.contains("money") || Lmsg.contains("cash")) ){
			p.sendMessage(hb + ChatColor.YELLOW + "You can obtain money by selling things to the server shop at /warp sell , to other players through /trade chat, or selling things to player shops at"
					+ " /warp market and other places throughout the map!");
			p.sendMessage(dhb);
			return;
			// need more info
		}
		if (Lmsg.contains("how") && (Lmsg.contains("do") || Lmsg.contains("to")) && (Lmsg.contains("make") || Lmsg.contains("craft") || Lmsg.contains("create"))
			&& ( )	) {
			
		}
	}
}
