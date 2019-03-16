package com.brian.MobDrop;

import org.bukkit.plugin.java.JavaPlugin;

import com.brian.MobDrop.Command.PlayerCommands;
import com.brian.MobDrop.Database.DataBase;
import com.brian.MobDrop.Item.items;
import com.brian.MobDrop.Listener.DeathListener;
import com.brian.MobDrop.LoadFile.LoadConfig;
import com.brian.MobDrop.LoadFile.LoadItems;

public class Main extends JavaPlugin {
	public void onEnable()
	{   
		// �]�w�D����
		DataBase.main = this;
		// �]�w���A��
		DataBase.server = this.getServer();
		// Ū���]�w��
		DataBase.LoadItems = new LoadItems();
		DataBase.LoadConfig = new LoadConfig();
		DataBase.LoadItems.ReLoadItems();
		DataBase.LoadConfig.ReLoadConfig();
		// ���U
		getServer().getPluginManager().registerEvents(new DeathListener(), this);
		getCommand("mobdrop").setExecutor(new PlayerCommands());
		// �T��
		DataBase.Print("MobDropItems is enabled!");
	}
	
	// ���X
	public void onDisable()
	{
		// �M���X����
		DataBase.server.resetRecipes();
		// �M����Ӫ�
		DataBase.MobDropItemsMap.clear();
		// �T��
		DataBase.Print("MobDropItems is disable!");
	}
}
