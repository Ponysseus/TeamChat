package com.ponysseus.teamchat;
import java.util.Set;

import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.plugin.Plugin;

import com.ponysseus.teamchat.Main;



public class EventListener implements Listener {

	
	Plugin pl;
	
	public EventListener(Main main) {
		pl = main;
	}
	    	
	



@EventHandler
public void onPlayerJoin(PlayerJoinEvent e){
	Player p = e.getPlayer();
	//pl.setScoreboardPlayer(p);
	p.sendMessage("Bienvenue");
	
	
}

	

}
