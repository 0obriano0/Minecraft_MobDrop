package com.brian.MobDrop.Command.CommandsList;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.brian.MobDrop.Database.DataBase;
import com.brian.MobDrop.GetItem.GetItem;

public class GetItemCommand {
	public static boolean parseCommands(CommandSender sender, Command cmd, String label, String[] args) {
		if(args.length == 1) {
			sender.sendMessage("��b" + DataBase.detailStr + " ��c/mdop getitem <null> <- �п�J�Ǫ��W�� ");
		}else {
			if(args.length == 2) {
				sender.sendMessage("��b" + DataBase.detailStr + " ��c/mdop getitem " + args[1] + " <null> <- �п�J�D��id ");
			}else {
				GetItem.getitem((Player) sender, args);
			}
		}
		return true;
	}
}
