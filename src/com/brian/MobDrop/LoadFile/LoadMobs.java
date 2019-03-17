package com.brian.MobDrop.LoadFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.brian.MobDrop.AnsiColor;
import com.brian.MobDrop.Database.DataBase;
import com.brian.MobDrop.Database.MobItemList;

public class LoadMobs {
	// 主要讀取設定用
		private FileConfiguration data = null;

		// 開檔用
		private File filePreload = null;
		
		private String loadfilename = "Mobs.yml";
		
		public LoadMobs(){
			
		}
		
		public void ReLoadMobs(){
			// 確認檔案是否存在
		    this.filePreload = new File(DataBase.pluginMainDir + loadfilename);
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
		    
		    // 待儲存的掉落物清單
		 	List<MobItemList> ItemsList = new ArrayList<MobItemList>();
		 	
		    for (String entity_name : data.getConfigurationSection("").getKeys(false)) {
		    	ItemsList = new ArrayList<MobItemList>();
		    	for (String Itemkey : data.getConfigurationSection(entity_name).getKeys(false)) {
		    		// 得到的物品數量
		    		int Quantity = -1;
		    		int Quantity_max = 0;
		    		// 掉落率
		    		double Chance = -1;
		    		
		    		if (data.contains(entity_name + "." + Itemkey + "." + "Quantity")){
		    			Quantity = data.getInt(entity_name + "." + Itemkey + "." + "Quantity");
		    		}
		    		
		    		if (data.contains(entity_name + "." + Itemkey + "." + "Quantity_max")){
		    			Quantity_max = data.getInt(entity_name + "." + Itemkey + "." + "Quantity_max");
		    		}else {
		    			Quantity_max = Quantity;
		    		}
		    		
		    		if (data.contains(entity_name + "." + Itemkey + "." + "Chance")){
		    			Chance = data.getDouble(entity_name + "." + Itemkey + "." + "Chance");
		    		}
		    		Itemkey = Itemkey.toUpperCase();
		    		if(DataBase.ItemMap.containsKey(Itemkey) && Quantity >= 1 && !(Chance < 0)) {
		    			ItemsList.add(new MobItemList(Quantity, Quantity_max, Chance, DataBase.ItemMap.get(Itemkey)));
		    			DataBase.main.getLogger().info(AnsiColor.GREEN + "[LoadMobs] " + AnsiColor.WHITE + DataBase.GetEntityName(entity_name) + AnsiColor.GREEN + " 的掉落物 " + AnsiColor.WHITE + DataBase.ItemMap.get(Itemkey).ItemName + AnsiColor.GREEN + " 設定成功" + AnsiColor.RESET);
		    		}else {
		    			if(DataBase.ItemMap.containsKey(Itemkey))
		    				DataBase.main.getLogger().info(AnsiColor.RED + "[LoadMobs] " + AnsiColor.WHITE + DataBase.GetEntityName(entity_name) + AnsiColor.RED + " 的掉落物 " + AnsiColor.WHITE + DataBase.ItemMap.get(Itemkey).ItemName + AnsiColor.RED + " 未設定成功" + AnsiColor.RESET);
		    			else
		    				DataBase.main.getLogger().info(AnsiColor.RED + "[LoadMobs] " + AnsiColor.WHITE + DataBase.GetEntityName(entity_name) + AnsiColor.RED + " 的掉落物 " + AnsiColor.WHITE + Itemkey + AnsiColor.RED + " 未設定成功" + AnsiColor.RESET);
		    		}
		    	}
		    	DataBase.MobItemMap.put(entity_name.toUpperCase(),ItemsList);
		    }
		}
		
		public void CreateDefaultfile(){
			try
			{
				if(CopyFileAPI.createFile(DataBase.pluginMainDir, loadfilename, "/"+loadfilename, DataBase.main))
					DataBase.main.getLogger().info(AnsiColor.GREEN + "[FileCreate] " + AnsiColor.YELLOW + loadfilename + AnsiColor.GREEN +  " 創建成功" + AnsiColor.RESET);
				else
					DataBase.main.getLogger().info(AnsiColor.RED + "[FileCreate] 資料創建出現異常，請詢問程式設計師" + AnsiColor.RESET);
			}
			catch (Exception e)
			{
				DataBase.main.getLogger().info(AnsiColor.RED + "[FileCreate] 資料創建失敗，請詢問程式設計師" + AnsiColor.RESET);
			}
		}
}
