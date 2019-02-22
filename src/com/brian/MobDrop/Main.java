package com.brian.MobDrop;

import org.bukkit.plugin.java.JavaPlugin;

import com.brian.MobDrop.Command.AdminCommands;
import com.brian.MobDrop.Listener.DeathListener;
import com.brian.MobDrop.LoadFile.LoadItems;

public class Main extends JavaPlugin {
	public void onEnable()
	{
		// ���U
		getServer().getPluginManager().registerEvents(new DeathListener(), this);
		getCommand("mobdrop").setExecutor(new AdminCommands());
		// �]�w�D����
		DataBase.main = this;
		// �]�w���A��
		DataBase.server = this.getServer();
		// Ū���]�w��
		DataBase.LoadItems = new LoadItems();
		DataBase.LoadItems.ReLoadItems();
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
