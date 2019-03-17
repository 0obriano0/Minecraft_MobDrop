package com.brian.MobDrop.DropItems;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.brian.MobDrop.Database.DataBase;

public class GetItem {
	public static boolean getitem(Player player,String[] args) {
		if(DataBase.ItemMap.containsKey(args[1].toUpperCase())) {
			ItemStack Itemcreate = DataBase.ItemMap.get(args[1].toUpperCase()).getResultItem();
			Itemcreate.setAmount(1);
			player.getInventory().addItem(Itemcreate);
			player.sendMessage("§b" + DataBase.detailStr + " §f獲取道具: " + DataBase.ItemMap.get(args[1].toUpperCase()).ItemName);
		}else {
			player.sendMessage("§b" + DataBase.detailStr + " §c查無裝備 ID 請重新查詢");
			return false;
		}
		return true;
	}
}
