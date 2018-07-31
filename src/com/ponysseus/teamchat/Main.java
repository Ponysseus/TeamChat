package com.ponysseus.teamchat;


import java.io.File;
import java.io.IOException;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.command.ConsoleCommandSender;
import org.bukkit.configuration.InvalidConfigurationException;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;
import org.bukkit.scoreboard.Team;
import org.bukkit.plugin.PluginManager;
import com.ponysseus.teamchat.EventListener;

import com.ponysseus.teamchat.commands.*;

public class Main extends JavaPlugin{
	ConsoleCommandSender console = Bukkit.getServer().getConsoleSender();
	ScoreboardManager manager = Bukkit.getScoreboardManager();
	Scoreboard board = manager.getNewScoreboard();
	
	Team Red = board.registerNewTeam("Red");
	Team Blue = board.registerNewTeam("Blue");
	@Override
	public void onEnable() {	



		this.getCommand("gg").setExecutor(new ggCommand(this));
		this.getCommand("hf").setExecutor(new hfCommand(this));
		this.getCommand("gl").setExecutor(new glCommand(this));
		this.getCommand("m").setExecutor(new medicCommand(this));
		this.getCommand("d").setExecutor(new defenseCommand(this));
		this.getCommand("a").setExecutor(new attackCommand(this));
		this.getCommand("g").setExecutor(new globalCommand(this));
		PluginManager pm = getServer().getPluginManager();
		pm.registerEvents(new EventListener(this), this);
		setupScoreboard();
		console.sendMessage("[TeamChat] plugin enabled");
	}
	@Override
	public void onDisable() {
		console.sendMessage("[TeamChat] plugin disabled");
	}

	public ConsoleCommandSender getConsole() {
		return console;
	}

	public void setupScoreboard(){

	 	Team Red = board.registerNewTeam("Red");
		Team Blue = board.registerNewTeam("Blue");
		Red.setPrefix(ChatColor.RED+"");
		Blue.setPrefix(ChatColor.BLUE+"");
		Red.setDisplayName(ChatColor.RED+"");
		Blue.setDisplayName(ChatColor.BLUE+"");
		Red.addEntry("Ponysseus");
		Blue.addEntry("Gay");
		Red.setDisplayName("Red");
		Blue.setDisplayName("Blue");
		
		for(Player online : Bukkit.getOnlinePlayers()){
			Team team = board.getPlayerTeam(online);
			online.sendMessage(board.getEntryTeam("Red").toString());
		//	online.sendMessage(team.getDisplayName());
			online.setScoreboard(board);
		}

	}
   public String getTeamName(Player player)	{
	Team team =  board.getPlayerTeam(player);
	   return team.getDisplayName();
   }
   public void setScoreboardPlayer(Player player){
	   player.setScoreboard(board);
   }


}
