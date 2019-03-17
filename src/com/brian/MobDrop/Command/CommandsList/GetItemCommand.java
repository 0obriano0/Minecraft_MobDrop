package com.brian.MobDrop.Command.CommandsList;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.brian.MobDrop.Database.DataBase;
import com.brian.MobDrop.DropItems.GetItem;

public class GetItemCommand {
	public static boolean parseCommands(CommandSender sender, Command cmd, String label, String[] args) {
		GetItem.getitem((Player) sender, args);
		return true;
	}
	
	public static List<String> onTabComplete(String command){
		List<String> show_commands = new ArrayList<String>();
		for (String key : DataBase.ItemMap.keySet())
		{
			if(key.indexOf(command.toUpperCase()) != -1)
				show_commands.add(key);	
		}
		return show_commands;
	}
}
