package com.brian.MobDrop.LoadFile;

import java.io.File;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.brian.MobDrop.AnsiColor;
import com.brian.MobDrop.Database.DataBase;

public class LoadLanguage {
	// 主要讀取設定用
		private FileConfiguration data = null;

		// 開檔用
		private File filePreload = null;
		
		private String loadfiledir = "lang";
		private String loadfilename = "zh_TW.yml";
		
		public LoadLanguage(){
			
		}
		
		public void ReLoadLanguage(){
			loadfilename = DataBase.Config.lang + ".yml";
			// 確認檔案是否存在
		    this.filePreload = new File(DataBase.pluginMainDir + loadfiledir + "/" + loadfilename);
		    if (!this.filePreload.exists()){
		    	DataBase.main.getLogger().info(AnsiColor.RED + "[FileLoad] " + DataBase.Config.lang + ".yml 讀取失敗，使用預設值 zh_TW.yml" + AnsiColor.RESET);
		    	DataBase.Config.lang = "zh_TW";
		    	loadfilename = DataBase.Config.lang + ".yml";
		    	this.filePreload = new File(DataBase.pluginMainDir + loadfiledir + "/" + loadfilename);
		    }
		    if (this.filePreload.exists()){
		    	// 讀取設定檔內容
		    	this.data = YamlConfiguration.loadConfiguration(this.filePreload);
		    }
		    else{
		    	// 檔案不存在，建立預設檔
		    	CreateDefaultfile();
		    	// 重載檔案
		    	this.filePreload = new File(DataBase.pluginMainDir + loadfilename);
		    	// 讀取設定檔內容
		    	this.data = YamlConfiguration.loadConfiguration(this.filePreload);
		    }
		    
		    
		    
		    if(data.contains("InventoryGUI")) {
		    	if(data.contains("InventoryGUI.MobsList"))  DataBase.language.Inventory.MobsList    = data.getString("InventoryGUI.MobsList").replace("&","§");     else errorMessage("InventoryGUI","MobsList");
		    	if(data.contains("InventoryGUI.ItemList"))  DataBase.language.Inventory.ItemList    = data.getString("InventoryGUI.ItemList").replace("&","§");     else errorMessage("InventoryGUI","MobsList");
		    	if(data.contains("InventoryGUI.close"))     DataBase.language.Inventory.close       = data.getString("InventoryGUI.close").replace("&","§");        else errorMessage("InventoryGUI","close");
		    	if(data.contains("InventoryGUI.next"))      DataBase.language.Inventory.next        = data.getString("InventoryGUI.next").replace("&","§");         else errorMessage("InventoryGUI","next");
		    	if(data.contains("InventoryGUI.previous"))  DataBase.language.Inventory.previous    = data.getString("InventoryGUI.previous").replace("&","§");     else errorMessage("InventoryGUI","previous");
		    	if(data.contains("InventoryGUI.menu"))      DataBase.language.Inventory.menu        = data.getString("InventoryGUI.menu").replace("&","§");         else errorMessage("InventoryGUI","menu");
		    	if(data.contains("InventoryGUI.back"))      DataBase.language.Inventory.back        = data.getString("InventoryGUI.back").replace("&","§");         else errorMessage("InventoryGUI","back");
		    	if(data.contains("InventoryGUI.back_menu")) DataBase.language.Inventory.back_menu   = data.getString("InventoryGUI.back_menu").replace("&","§");    else errorMessage("InventoryGUI","back_menu");
		    	if(data.contains("InventoryGUI.dropList"))  DataBase.language.Inventory.dropList    = data.getString("InventoryGUI.dropList").replace("&","§");     else errorMessage("InventoryGUI","dropList");
		    	if(data.contains("InventoryGUI.items"))     DataBase.language.Inventory.items       = data.getString("InventoryGUI.items").replace("&","§");        else errorMessage("InventoryGUI","items");
		    	if(data.contains("InventoryGUI.mobs"))      DataBase.language.Inventory.mobs        = data.getString("InventoryGUI.mobs").replace("&","§");         else errorMessage("InventoryGUI","mobs");
		    	if(data.contains("InventoryGUI.admin_lore")) DataBase.language.Inventory.admin_lore = getListString(data.getStringList("InventoryGUI.admin_lore")); else errorMessage("InventoryGUI","admin_lore");
		    }
		    
		    DataBase.main.getLogger().info(AnsiColor.GREEN + "[Loadlanguage] " + loadfilename + " 讀取結束" + AnsiColor.RESET);
		}
		
		public void CreateDefaultfile(){
			try
			{
				if(CopyFileAPI.createFile(DataBase.pluginMainDir + "/" + loadfiledir, "/" + loadfilename, "/" + loadfiledir + "/" + loadfilename, DataBase.main))
					DataBase.main.getLogger().info(AnsiColor.GREEN + "[FileCreate] " + AnsiColor.YELLOW + loadfilename + AnsiColor.GREEN +  " 創建成功" + AnsiColor.RESET);
				else
					DataBase.main.getLogger().info(AnsiColor.RED + "[FileCreate] 資料創建出現異常，請詢問程式設計師1" + AnsiColor.RESET);
			}
			catch (Exception e)
			{
				DataBase.main.getLogger().info(AnsiColor.RED + "[FileCreate] 資料創建失敗，請詢問程式設計師" + AnsiColor.RESET);
			}
		}
		
		public void errorMessage(String title,String name) {
			DataBase.main.getLogger().info(AnsiColor.RED + "[Loadlanguage] " + title + " -> " + name + " 資料讀取失敗，使用預設值..." + AnsiColor.RESET);
		}
		
		public List<String> getListString(List<String> data) {
			for (int i = 0; i < data.size(); i++)
			{
				data.set(i, data.get(i).replace("_", " ").replace("&","§"));
			}
			return data;
		}
}
