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
		// �P�_�O�_�����a�����O
		if (sender instanceof Player)
		{
			// �P�_���O����
			if (args.length == 0)
			{
				// ��ܻ���
				sender.sendMessage("��9==========��dMobDrop��9==========");
				sender.sendMessage("��a/mobdrop reload ��f- ��e��Ū�]�w��");
				sender.sendMessage("��a/mobdrop list ��f- ��e�C�X�Ҧ��ͪ���������T");
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
					// �j�����
					List<MobDropItems> lstMobDropItems = new ArrayList<MobDropItems>();
					sender.sendMessage("��9==================================");
					for (String key : DataBase.MobDropItemsMap.keySet())
					{
						sender.sendMessage("��a�u" + DataBase.GetEntityName(key) + "�v");
						lstMobDropItems = DataBase.MobDropItemsMap.get(key);
						for (MobDropItems MobDropItems : lstMobDropItems)
						{
							//if (customItem.OnlyWorld.equals(""))
							//{
								sender.sendMessage("��a" + MobDropItems.ItemName + "��a(��f" + MobDropItems.Chance + "%��a������f" + MobDropItems.Quantity + "��a��)");
							//}
							//else
							//{
								//sender.sendMessage("��a" + MobDropItems.ItemName + "��a(��f" + MobDropItems.Chance + "%��a������f" + MobDropItems.Quantity + "��a��) - ���w�b��f" + customItem.OnlyWorld);
							//}
						}
			        }
					sender.sendMessage("��9==================================");
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