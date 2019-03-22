package com.brian.MobDrop.Command.CommandsList;

import java.util.ArrayList;
import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;

import com.brian.MobDrop.Database.DataBase;
import com.brian.MobDrop.Database.MobItemList;

public class MobListCommand {
	private static boolean list_base(CommandSender sender,List<MobItemList> MobDropItemList ,String keyName){
		try {
			sender.sendMessage("��a�u" + DataBase.GetEntityName(keyName) + "�v");
			int itemnum = 0;
			for (MobItemList MobDropItems : MobDropItemList)
			{
				if(MobDropItems.Quantity == MobDropItems.Quantity_max) {
					sender.sendMessage("��f  "+ itemnum +". " + MobDropItems.Item.ItemName + " ��a(��f" + MobDropItems.Chance + "%��a������f " + MobDropItems.Quantity + " ��a��)");
				}else {
					sender.sendMessage("��f  " + itemnum +". " + MobDropItems.Item.ItemName + " ��a(��f" + MobDropItems.Chance + "%��a������f " + MobDropItems.Quantity + "-" + MobDropItems.Quantity_max + " ��a��)");
				}
				itemnum++;
			}
		}
		catch (NullPointerException e)
		{
			sender.sendMessage("��b" + DataBase.language.Plugin_name + "��c�d�L�u��n " + DataBase.GetEntityName(keyName) + " ��r��c�v�ͪ��A�Э��s�d��");
		}
		return true;
	}
	
	public static boolean parseCommands(CommandSender sender, Command cmd, String label, String[] args) {
		// �j�����
		List<MobItemList> MobDropItemList = new ArrayList<MobItemList>();
		sender.sendMessage("��9============��dMobDrop �Ǫ�������T��9===========");
		if(args.length == 2) {
			//��Ū���쪺�Ǫ��W���ഫ������
			MobDropItemList = DataBase.MobItemMap.get(DataBase.getEntityNameGameCode(args[1].toUpperCase()));
			list_base(sender,MobDropItemList,args[1].toUpperCase());
		}else {
			for (String key : DataBase.MobItemMap.keySet())
			{
				MobDropItemList = DataBase.MobItemMap.get(key);
				list_base(sender,MobDropItemList,key);
			}
		}
		sender.sendMessage("��9========================================");
		return true;
	}
	
	public static List<String> onTabComplete(String command){
		List<String> show_commands = new ArrayList<String>();
		for (String key : DataBase.MobItemMap.keySet())
		{
			if(DataBase.GobalMessage.list_Chinese) {
				if(DataBase.GetEntityName(key.toUpperCase()).indexOf(command) != -1)
					show_commands.add(DataBase.GetEntityName(key));
			}else
				if(key.indexOf(command.toUpperCase()) != -1)
					show_commands.add(key);
					
		}
		return show_commands;
	}
}
