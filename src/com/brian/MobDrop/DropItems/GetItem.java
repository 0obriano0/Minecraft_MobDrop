package com.brian.MobDrop.DropItems;

import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.brian.MobDrop.Database.DataBase;

public class GetItem {
	public static boolean getitem(Player player,String[] args) {
		if(DataBase.ItemMap.containsKey(args[1].toUpperCase())) {
			ItemStack Itemcreate = DataBase.ItemMap.get(args[1].toUpperCase()).getResultItem();
			Itemcreate.setAmount(1);
			if(player.getInventory().firstEmpty() == -1)
				player.sendMessage("��b" + DataBase.language.Plugin_name + " ��c�I�]�w���A�L�k����D��");
			else {
				player.getInventory().addItem(Itemcreate);
				player.sendMessage("��b" + DataBase.language.Plugin_name + " ��f����D��: " + DataBase.ItemMap.get(args[1].toUpperCase()).ItemName);
			}
		}else {
			player.sendMessage("��b" + DataBase.language.Plugin_name + " ��c�d�L�˳� ID �Э��s�d��");
			return false;
		}
		return true;
	}
}
