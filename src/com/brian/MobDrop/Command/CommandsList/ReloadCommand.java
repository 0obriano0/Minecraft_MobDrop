package com.brian.MobDrop.Command.CommandsList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.brian.MobDrop.Database.DataBase;

public class ReloadCommand {
	public static boolean parseCommands(CommandSender sender, Command cmd, String label, String[] args) {
		// �M���X����
		DataBase.server.resetRecipes();
		// �M����Ӫ�
		DataBase.MobItemMap.clear();
		DataBase.ItemMap.clear();
		// ��Ū
		DataBase.LoadItems.ReLoadItems();
		sender.sendMessage(ChatColor.YELLOW +"�]�w��Ū������");
		return true;
	}
}
