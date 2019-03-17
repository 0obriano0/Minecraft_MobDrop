package com.brian.MobDrop.Command.CommandsList;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.brian.MobDrop.Database.DataBase;

public class ReloadCommand {
	public static boolean parseCommands(CommandSender sender, Command cmd, String label, String[] args) {
		// 清除合成表
		DataBase.server.resetRecipes();
		// 清除對照表
		DataBase.MobItemMap.clear();
		DataBase.ItemMap.clear();
		// 重讀
		DataBase.LoadItems.ReLoadItems();
		sender.sendMessage(ChatColor.YELLOW +"設定檔讀取完成");
		return true;
	}
}
