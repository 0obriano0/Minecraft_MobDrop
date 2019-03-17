package com.brian.MobDrop;

import org.bukkit.plugin.java.JavaPlugin;

import com.brian.MobDrop.Command.PlayerCommands;
import com.brian.MobDrop.Database.DataBase;
import com.brian.MobDrop.Listener.DeathListener;
import com.brian.MobDrop.LoadFile.LoadConfig;
import com.brian.MobDrop.LoadFile.LoadItems;
import com.brian.MobDrop.LoadFile.LoadMobs;

public class Main extends JavaPlugin {
	public void onEnable()
	{   
		// �]�w�D����
		DataBase.main = this;
		// �]�w���A��
		DataBase.server = this.getServer();
		// Ū���]�w��
		DataBase.LoadItems = new LoadItems();
		DataBase.LoadMobs = new LoadMobs();
		DataBase.LoadConfig = new LoadConfig();
		DataBase.LoadItems.ReLoadItems();
		DataBase.LoadMobs.ReLoadMobs();
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
		DataBase.MobItemMap.clear();
		DataBase.ItemMap.clear();
		// �T��
		DataBase.Print("MobDropItems is disable!");
	}
}
