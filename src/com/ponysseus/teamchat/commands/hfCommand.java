package com.ponysseus.teamchat.commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.entity.Player;

import com.ponysseus.teamchat.Main;

import net.md_5.bungee.api.ChatColor;

public class hfCommand implements CommandExecutor{
	Main plugin;
	
	
	public hfCommand(Main main) {
		plugin = main;
	}
	
	public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
		Player player = (Player) sender;
		player.chat("have fun :)");
	return true;
	}
}
