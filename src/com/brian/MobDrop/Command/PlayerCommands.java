package com.brian.MobDrop.Command;

import java.util.List;

import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import com.brian.MobDrop.Database.DataBase;
import com.brian.MobDrop.GetItem.GetItem;

public class PlayerCommands implements CommandExecutor ,TabExecutor{
	public PlayerCommands()
    {
    	
	}
 
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
	{
		// �P�_�O�_�����a�����O
		if (sender instanceof Player)
		{
			// �P�_���O����
			if (args.length == 0)
			{
				// ��ܻ���
				sender.sendMessage("��9==========��dMobDrop��9==========");
				sender.sendMessage("��a/mdop list <�ͪ��W(�i���i����)> ��f- ��e�C�X�Ҧ��ͪ���������T");
				if (sender.hasPermission("MobDrop.admin")) {
					sender.sendMessage("��a/mdop getitem <�ͪ��W> <���~ID(��list�d�쪺ID)> ��f- ��e����D��");
					sender.sendMessage("��a/mdop reload ��f- ��e���sŪ�����");
				}
				sender.sendMessage("��9===========================");
				return true;
			}
			else
			{
				if (sender.hasPermission("MobDrop.admin")) {
					if (args[0].equals("reload")){
						// �M���X����
						DataBase.server.resetRecipes();
						// �M����Ӫ�
						DataBase.MobDropItemsMap.clear();
						// ��Ū
						DataBase.LoadItems.ReLoadItems();
						sender.sendMessage(ChatColor.YELLOW +"�]�w��Ū������");
						return true;
					}else if (args[0].equals("getitem"))
					{
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
				if (args[0].equals("list"))
				{
					publicCommand.list(sender, cmd, label, args);
					return true;
				}
			}
	    }
		else
		{
	    	sender.sendMessage("�����O���䴩����x�Ҧ�!");
	    	return false;
	    }
		return false;
	}
	
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 1) 
			return DataBase.CommandsList.getMainList().secand_arg(args[0],sender);
		return null;
	}
}
