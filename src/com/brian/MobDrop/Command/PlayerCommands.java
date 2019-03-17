package com.brian.MobDrop.Command;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import com.brian.MobDrop.Command.CommandsList.GetItemCommand;
import com.brian.MobDrop.Command.CommandsList.ItemListCommand;
import com.brian.MobDrop.Command.CommandsList.MobListCommand;
import com.brian.MobDrop.Command.CommandsList.ReloadCommand;
import com.brian.MobDrop.Database.DataBase;

public class PlayerCommands implements CommandExecutor ,TabExecutor{
	public PlayerCommands()
    {
    	
	}
 
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		// 判斷是否為玩家的指令
		if (sender instanceof Player){
			// 判斷指令長度
			if (args.length == 0){
				// 顯示說明
				sender.sendMessage("§9==========§dMobDrop§9==========");
				sender.sendMessage("§a/mdop moblist <生物名(可打可不打)> §f- §e列出所有生物的掉落資訊");
				sender.sendMessage("§a/mdop itemlist §f- §e列出所有道具的掉落資訊");
				if (sender.hasPermission("MobDrop.admin")) {
					sender.sendMessage("§a/mdop getitem <物品名稱> §f- §e獲取道具");
					sender.sendMessage("§a/mdop reload §f- §e重新讀取資料");
				}
				sender.sendMessage("§9===========================");
				return true;
			}
			else{
				if (sender.hasPermission("MobDrop.admin")) {
					if (args[0].equals("reload"))
						return ReloadCommand.parseCommands(sender, cmd, label, args);
					else if (args[0].equals("getitem"))
						return GetItemCommand.parseCommands(sender, cmd, label, args);
				}
				if (args[0].equals("moblist"))
					return MobListCommand.parseCommands(sender, cmd, label, args);
				else if(args[0].equals("itemlist")) 
					return ItemListCommand.parseCommands(sender, cmd, label, args);
				else
					sender.sendMessage("§c/" + label + " " + args[0] + " <-- 查無此指令");
			}
	    }
		else
		{
			if (args.length == 0){
				// 顯示說明
				sender.sendMessage("§9==========§dMobDrop§9==========");
				sender.sendMessage("§a/mdop moblist <生物名(可打可不打)> §f- §e列出所有生物的掉落資訊");
				sender.sendMessage("§a/mdop itemlist §f- §e列出所有道具的掉落資訊");
				sender.sendMessage("§a/mdop reload §f- §e重新讀取資料");
				sender.sendMessage("§9===========================");
				return true;
			}else if(args.length == 1) {
				if (args[0].equals("moblist"))
					return MobListCommand.parseCommands(sender, cmd, label, args);
				else if(args[0].equals("itemlist")) 
					return ItemListCommand.parseCommands(sender, cmd, label, args);
				else if(args[0].equals("reload")) 
					return ReloadCommand.parseCommands(sender, cmd, label, args);
				else {
					sender.sendMessage("§c/" + label + " " + args[0] + " <-- 查無此指令");
					return false;
				}
			}
	    	sender.sendMessage("§c 此指令不支援控制台模式!");
	    	return false;
	    }
		return false;
	}
	
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 1) 
			return DataBase.CommandsList.secand_arg(args[0],sender);
		else if (args.length == 2) {
			if (sender.hasPermission("MobDrop.admin")) {	
				if (args[0].equals("getitem")) {
					return GetItemCommand.onTabComplete(args[1]);
				}
			}
			if (args[0].equals("moblist")) {
				return MobListCommand.onTabComplete(args[1]);
			}
			if (args[0].equals("itemlist")) {
				return ItemListCommand.onTabComplete(args);
			}
		}
		return null;
	}
}
