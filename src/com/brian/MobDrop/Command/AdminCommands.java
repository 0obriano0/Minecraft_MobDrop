package com.brian.MobDrop.Command;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import com.brian.MobDrop.DataBase;
import com.brian.MobDrop.DropItems.MobDropItems;

public class AdminCommands implements CommandExecutor
{    
    public AdminCommands()
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
				sender.sendMessage("§a/mobdrop reload §f- §e重讀設定檔");
				sender.sendMessage("§a/mobdrop list §f- §e列出所有生物的掉落資訊");
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
					// 迴圈顯示
					List<MobDropItems> lstMobDropItems = new ArrayList<MobDropItems>();
					sender.sendMessage("§9==================================");
					for (String key : DataBase.MobDropItemsMap.keySet())
					{
						sender.sendMessage("§a「" + DataBase.GetEntityName(key) + "」");
						lstMobDropItems = DataBase.MobDropItemsMap.get(key);
						for (MobDropItems MobDropItems : lstMobDropItems)
						{
							//if (customItem.OnlyWorld.equals(""))
							//{
								sender.sendMessage("§a" + MobDropItems.ItemName + "§a(§f" + MobDropItems.Chance + "%§a掉落§f" + MobDropItems.Quantity + "§a個)");
							//}
							//else
							//{
								//sender.sendMessage("§a" + MobDropItems.ItemName + "§a(§f" + MobDropItems.Chance + "%§a掉落§f" + MobDropItems.Quantity + "§a個) - 限定在§f" + customItem.OnlyWorld);
							//}
						}
			        }
					sender.sendMessage("§9==================================");
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