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
		// �P�_�O�_�����a�����O
		if (sender instanceof Player)
		{
			// �P�_���O����
			if (args.length == 0)
			{
				// ��ܻ���
				sender.sendMessage("��9==========��dMobDrop��9==========");
				sender.sendMessage("��a/mobdrop list <�ͪ��W(�i���i����)> ��f- ��e�C�X�Ҧ��ͪ���������T");
				sender.sendMessage("��9===========================");
				return true;
			}
			else
			{
				if (args[0].equals("reload"))
				{
					// �M���X����
					DataBase.server.resetRecipes();
					// �M����Ӫ�
					DataBase.MobDropItemsMap.clear();
					// ��Ū
					DataBase.LoadItems.ReLoadItems();
					sender.sendMessage(ChatColor.YELLOW +"�]�w��Ū������");
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
	    	sender.sendMessage("�����O���䴩����x�Ҧ�!");
	    	return false;
	    }
		return false;
	}
}
