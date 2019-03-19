package com.brian.MobDrop.Command.CommandsList;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.bukkit.command.CommandSender;

public class MainList {
	CommandsTools Tools = new CommandsTools();
	
	private List<String> playercommands = Arrays.asList("itemlist moblist menu".split(" "));
	private List<String> admincommands = Arrays.asList("reload getitem".split(" "));
	
	public List<String> secand_arg(String commands, CommandSender sender) {
		List<String> show_commands = new ArrayList<String>();
		Tools.search(playercommands, commands, show_commands);
		if (sender.hasPermission("MobDrop.admin"))
			Tools.search(admincommands, commands, show_commands);
		return show_commands;
	}
	
	public MainList(){
		
	}
}
