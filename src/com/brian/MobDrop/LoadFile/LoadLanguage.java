package com.brian.MobDrop.LoadFile;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.brian.MobDrop.AnsiColor;
import com.brian.MobDrop.Database.DataBase;
import com.brian.MobDrop.Database.GobalMessage;

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
			// 確認檔案是否存在
		    this.filePreload = new File(DataBase.pluginMainDir + loadfiledir + "/" + loadfilename);
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
		    	if(data.contains("InventoryGUI.MobsList")) DataBase.language.Inventory.MobsList = data.getString("InventoryGUI.MobsList");
		    	if(data.contains("InventoryGUI.ItemList")) DataBase.language.Inventory.ItemList = data.getString("InventoryGUI.ItemList");
		    	if(data.contains("InventoryGUI.close"))    DataBase.language.Inventory.close    = data.getString("InventoryGUI.close");
		    	if(data.contains("InventoryGUI.next"))     DataBase.language.Inventory.next     = data.getString("InventoryGUI.next");
		    }
		    
		    DataBase.main.getLogger().info(AnsiColor.GREEN + "[Loadlanguage] " + loadfilename + " 設定成功" + AnsiColor.RESET);
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
}
