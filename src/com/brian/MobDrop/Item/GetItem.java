package com.brian.MobDrop.Item;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.entity.Player;

import com.brian.MobDrop.Database.DataBase;
import com.brian.MobDrop.DropItems.MobDropItems;

public class GetItem {
	public static boolean getitem(Player player,String[] args) {
		List<MobDropItems> lstMobDropItems = new ArrayList<MobDropItems>();
		lstMobDropItems = DataBase.MobDropItemsMap.get(DataBase.getEntityNameGameCode(args[1].toUpperCase()));
		if(lstMobDropItems == null) {
			player.sendMessage("§b" + DataBase.detailStr + " §c查無「§n " + DataBase.GetEntityName(args[1].toUpperCase()) + " §r§c」生物，請重新查詢");
			return false;
		}
		try {
			player.getInventory().addItem(lstMobDropItems.get(Integer.parseInt(args[2])).getResultItem());
			player.sendMessage("§b" + DataBase.detailStr + " §f獲取道具: " + lstMobDropItems.get(Integer.parseInt(args[2])).ItemName);
		}catch (IndexOutOfBoundsException e) {
			player.sendMessage("§b" + DataBase.detailStr + " §c查無裝備 ID 請重新查詢");
			return false;
		}
		return true;
	}
}
