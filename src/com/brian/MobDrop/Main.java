package com.brian.MobDrop;

import org.bukkit.plugin.java.JavaPlugin;

import com.brian.MobDrop.Command.AdminCommands;
import com.brian.MobDrop.Command.PlayerCommands;
import com.brian.MobDrop.Database.DataBase;
import com.brian.MobDrop.Listener.DeathListener;
import com.brian.MobDrop.LoadFile.LoadConfig;
import com.brian.MobDrop.LoadFile.LoadItems;

public class Main extends JavaPlugin {
	public void onEnable()
	{
		// 註冊
		getServer().getPluginManager().registerEvents(new DeathListener(), this);
		getCommand("mdop").setExecutor(new AdminCommands());
		getCommand("mobdrop").setExecutor(new PlayerCommands());
		// 設定主插件
		DataBase.main = this;
		// 設定伺服器
		DataBase.server = this.getServer();
		// 讀取設定檔
		DataBase.LoadItems = new LoadItems();
		DataBase.LoadConfig = new LoadConfig();
		DataBase.LoadItems.ReLoadItems();
		DataBase.LoadConfig.ReLoadConfig();
		// 訊息
		DataBase.Print("MobDropItems is enabled!");
	}
	
	// 載出
	public void onDisable()
	{
		// 清除合成表
		DataBase.server.resetRecipes();
		// 清除對照表
		DataBase.MobDropItemsMap.clear();
		// 訊息
		DataBase.Print("MobDropItems is disable!");
	}
}
