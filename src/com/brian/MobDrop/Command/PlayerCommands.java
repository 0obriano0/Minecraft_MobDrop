package com.brian.MobDrop.Command;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.brian.MobDrop.Database.DataBase;

public class PlayerCommands implements CommandExecutor{
	public PlayerCommands()
    {
    	
	}
 
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		// 判斷是否為玩家的指令
		if (sender instanceof Player)
		{
			// 判斷指令長度
			if (args.length == 0)
			{
				// 顯示說明
				sender.sendMessage("§9==========§dMobDrop§9==========");
				sender.sendMessage("§a/mobdrop list <生物名(可打可不打)> §f- §e列出所有生物的掉落資訊");
				sender.sendMessage("§9===========================");
				return true;
			}
			else
			{
				if (args[0].equals("reload"))
				{
					// 清除合成表
					DataBase.server.resetRecipes();
					// 清除對照表
					DataBase.MobDropItemsMap.clear();
					// 重讀
					DataBase.LoadItems.ReLoadItems();
					sender.sendMessage(ChatColor.YELLOW +"設定檔讀取完成");
					return true;
				}
				else if (args[0].equals("list"))
				{
					publicCommand.list(sender, cmd, label, args);
					return true;
				}
			}
	    }
		else
		{
	    	sender.sendMessage("此指令不支援控制台模式!");
	    	return false;
	    }
		return false;
	}
}
