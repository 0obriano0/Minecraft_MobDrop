package com.brian.MobDrop.Command;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.brian.MobDrop.Database.DataBase;
import com.brian.MobDrop.DropItems.MobDropItems;

public class publicCommand {
	private static boolean list_base(CommandSender sender,List<MobDropItems> lstMobDropItems,String keyName){
		try {
			sender.sendMessage("§a「" + DataBase.GetEntityName(keyName) + "」");
			int itemnum = 0;
			for (MobDropItems MobDropItems : lstMobDropItems)
			{
				if(MobDropItems.Quantity == MobDropItems.Quantity_max) {
					sender.sendMessage("§f  "+ itemnum +". " + MobDropItems.ItemName + " §a(§f" + MobDropItems.Chance + "%§a掉落§f " + MobDropItems.Quantity + " §a個)");
				}else {
					sender.sendMessage("§f  " + itemnum +". " + MobDropItems.ItemName + " §a(§f" + MobDropItems.Chance + "%§a掉落§f " + MobDropItems.Quantity + "-" + MobDropItems.Quantity_max + " §a個)");
				}
				itemnum++;
			}
		}
		catch (NullPointerException e)
		{
			sender.sendMessage("§b" + DataBase.detailStr + "§c查無「§n " + DataBase.GetEntityName(keyName) + " §r§c」生物，請重新查詢");
		}
		return true;
	}
	public static boolean list(CommandSender sender, Command cmd, String label, String[] args) {
		// 迴圈顯示
		List<MobDropItems> lstMobDropItems = new ArrayList<MobDropItems>();
		sender.sendMessage("§9============§dMobDrop 怪物掉落資訊§9===========");
		if(args.length == 2) {
			//把讀取到的怪物名稱轉換成中文
			lstMobDropItems = DataBase.MobDropItemsMap.get(DataBase.getEntityNameGameCode(args[1].toUpperCase()));
			list_base(sender,lstMobDropItems,args[1].toUpperCase());
		}else {
			for (String key : DataBase.MobDropItemsMap.keySet())
			{
				lstMobDropItems = DataBase.MobDropItemsMap.get(key);
				list_base(sender,lstMobDropItems,key);
			}
		}
		sender.sendMessage("§9========================================");
		return true;
	}
}
