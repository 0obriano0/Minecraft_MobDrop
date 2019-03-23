package com.brian.MobDrop.Command;

import java.util.List;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;

import com.brian.MobDrop.Command.CommandsList.GetItemCommand;
import com.brian.MobDrop.Command.CommandsList.ItemListCommand;
import com.brian.MobDrop.Command.CommandsList.MobListCommand;
import com.brian.MobDrop.Command.CommandsList.ReloadCommand;
import com.brian.MobDrop.Database.DataBase;
import com.brian.MobDrop.InventoryGUI.InventoryMenu;

public class PlayerCommands implements CommandExecutor ,TabExecutor{
	public PlayerCommands()
    {
    	
	}
 
	@Override
	public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args){
		// �P�_�O�_�����a�����O
		if (sender instanceof Player){
			// �P�_���O����
			if (args.length == 0){
				// ��ܻ���
				sender.sendMessage("��9==========��dMobDrop��9==========");
				sender.sendMessage("��a/mdop menu ��f- ��e�}�ҥؿ�");
				if(DataBase.Config.command_old_list) {
					sender.sendMessage("��a/mdop moblist <�ͪ��W(�i���i����)> ��f- ��e�C�X�Ҧ��ͪ���������T");
					sender.sendMessage("��a/mdop itemlist ��f- ��e�C�X�Ҧ��D�㪺������T");
				}
				if (sender.hasPermission("MobDrop.admin")) {
					if(DataBase.Config.command_old_list)
						sender.sendMessage("��a/mdop getitem <���~�W��> ��f- ��e����D��");
					sender.sendMessage("��a/mdop reload ��f- ��e���sŪ�����");
				}
				sender.sendMessage("��9===========================");
				return true;
			}
			else{
				if (sender.hasPermission("MobDrop.admin")) {
					if (args[0].equals("reload"))
						return ReloadCommand.parseCommands(sender, cmd, label, args);
					else if (args[0].equals("getitem") && DataBase.Config.command_old_list)
						return GetItemCommand.parseCommands(sender, cmd, label, args);
				}
				if (args[0].equals("moblist") && DataBase.Config.command_old_list)
					return MobListCommand.parseCommands(sender, cmd, label, args);
				//�ʦs
				else if(args[0].equals("itemlist") && DataBase.Config.command_old_list) 
					return ItemListCommand.parseCommands(sender, cmd, label, args);
				else if(args[0].equals("menu")) {
					InventoryMenu.INVENTORY.open((Player) sender);
					return true;
				}else
					sender.sendMessage("��c/" + label + " " + args[0] + " <-- �d�L�����O");
			}
	    }
		else
		{
			if (args.length == 0){
				// ��ܻ���
				sender.sendMessage("��9==========��dMobDrop��9==========");
				sender.sendMessage("��a/mdop moblist <�ͪ��W(�i���i����)> ��f- ��e�C�X�Ҧ��ͪ���������T");
				sender.sendMessage("��a/mdop itemlist ��f- ��e�C�X�Ҧ��D�㪺������T");
				sender.sendMessage("��a/mdop reload ��f- ��e���sŪ�����");
				sender.sendMessage("��9===========================");
				return true;
			}else if(args.length == 1) {
				if (args[0].equals("moblist"))
					return MobListCommand.parseCommands(sender, cmd, label, args);
				else if(args[0].equals("itemlist")) 
					return ItemListCommand.parseCommands(sender, cmd, label, args);
				else if(args[0].equals("reload")) 
					return ReloadCommand.parseCommands(sender, cmd, label, args);
				else {
					sender.sendMessage("��c/" + label + " " + args[0] + " <-- �d�L�����O");
					return false;
				}
			}
	    	sender.sendMessage("��c �����O���䴩����x�Ҧ�!");
	    	return false;
	    }
		return false;
	}
	
	public List<String> onTabComplete(CommandSender sender, Command cmd, String label, String[] args) {
		if (args.length == 1) 
			return DataBase.CommandsList.secand_arg(args[0],sender);
		else if (args.length == 2) {
			if (sender.hasPermission("MobDrop.admin")) {	
				if (args[0].equals("getitem")) {
					return GetItemCommand.onTabComplete(args[1]);
				}
			}
			if (args[0].equals("moblist")) {
				return MobListCommand.onTabComplete(args[1]);
			}
			if (args[0].equals("itemlist")) {
				return ItemListCommand.onTabComplete(args);
			}
		}
		return null;
	}
}
