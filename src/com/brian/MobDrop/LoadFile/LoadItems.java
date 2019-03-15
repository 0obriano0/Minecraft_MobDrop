package com.brian.MobDrop.LoadFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.brian.MobDrop.AnsiColor;
import com.brian.MobDrop.Database.DataBase;
import com.brian.MobDrop.DropItems.MobDropItems;

public class LoadItems {
	// 主要讀取設定用
	private FileConfiguration data = null;

	// 開檔用
	private File filePreload = null;
	
	private String loadfilename = "Items.yml";
	
	public LoadItems()
	{
		
	}
	
	public void ReLoadItems()
	{
		// 確認檔案是否存在
	    this.filePreload = new File(DataBase.pluginMainDir + loadfilename);
	    if (this.filePreload.exists())
	    {
	    	// 讀取設定檔內容
	    	this.data = YamlConfiguration.loadConfiguration(this.filePreload);
	    }
	    else
	    {
	    	// 檔案不存在，建立預設檔
	    	CreateDefaultfile();
	    	// 重載檔案
	    	this.filePreload = new File(DataBase.pluginMainDir + loadfilename);
	    	// 讀取設定檔內容
	    	this.data = YamlConfiguration.loadConfiguration(this.filePreload);
	    }
	    
		if (data.contains("items"))
	    {
			// 掉落的物品名稱
			String ItemName = "";
			// 掉落的物品是否套用原始名稱
			int UseOriginalName = 0;
			// 掉落的物品說明
			List<String> ItemLores = new ArrayList<String>();
			// 掉落的物品名稱(原始名稱)
			String ItemRealname = "";
			// 色彩
			int Red = 0;
			int Green = 0;
			int Blue = 0;
			// 掉落的物品附魔
			List<String> Enchants = new ArrayList<String>();
			// 掉落的物品數量
			int Quantity = 1;
			int Quantity_max = 1;
			// 掉落的機率
			double Chance = 1000;
			// 拆解物品附屬ID用
			//String strItemID = "";
			
			// 待儲存的掉落物清單
			List<MobDropItems> dropItems = new ArrayList<MobDropItems>();
			
			// 取得生物名稱
			for (String entity_name : data.getConfigurationSection("items").getKeys(false))
		    {
				// 清空暫存區
				dropItems = new ArrayList<MobDropItems>();
				// 迴圈讀出掉落物
				for (String name : data.getConfigurationSection("items." + entity_name).getKeys(false))
			    {
					// ###########################################
					// 清空暫存區
					// ###########################################
					// 掉落的物品名稱
					ItemName = "";
					// 掉落的物品是否套用原始名稱
					UseOriginalName = 0;
					// 掉落的物品說明
					ItemLores = new ArrayList<String>();
					// 掉落的物品名稱(原始名稱)
					ItemRealname = "";
					// 色彩
					Red = 0;
					Green = 0;
					Blue = 0;
					// 掉落的物品附魔
					Enchants = new ArrayList<String>();
					// 掉落的物品數量
					Quantity = 1;
					Quantity_max = 1;
					// 掉落的機率
					Chance = 1000;
					// 拆解物品附屬ID用
					//strItemID = "";
					// ###########################################
					// 開始讀取內容
					// ###########################################
					// 讀取物品名稱
					ItemName = name.replaceAll("_", " ");
					// 是否套用原始名稱
					if (data.contains("items." + entity_name + "." + name + ".UseCustomName"))
					{
						UseOriginalName = this.data.getInt("items." + entity_name + "." + name + ".UseCustomName");
					}
					// 物品說明
					if (data.contains("items." + entity_name + "." + name + ".ItemLores"))
					{
						ItemLores = this.data.getStringList("items." + entity_name + "." + name + ".ItemLores");
						for (int i = 0; i < ItemLores.size(); i++)
						{
							ItemLores.set(i, ItemLores.get(i).replace("_", " "));
						}
					}
					if (data.contains("items." + entity_name + "." + name + ".ItemRealname"))
					{
						ItemRealname = this.data.getString("items." + entity_name + "." + name + ".ItemRealname").toUpperCase();
					}
					
					// 判斷是否為皮甲(讀取染色碼)
					if(ItemRealname.split("_")[0].equals("LEATHER")) {
						if (data.contains("items." + entity_name + "." + name + ".RGB")) {
							String RGBbuffer = this.data.getString("items." + entity_name + "." + name + ".RGB");
							Red = Integer.parseInt(RGBbuffer.split(",")[0]);
							Green = Integer.parseInt(RGBbuffer.split(",")[1]);
							Blue = Integer.parseInt(RGBbuffer.split(",")[2]);
						}
					}
					
					// 取得附魔
					if (data.contains("items." + entity_name + "." + name + ".Enchants"))
					{
						Enchants = this.data.getStringList("items." + entity_name + "." + name + ".Enchants");
					}
					if (data.contains("items." + entity_name + "." + name + ".Quantity"))
					{
						Quantity = this.data.getInt("items." + entity_name + "." + name + ".Quantity");
					}
					if (data.contains("items." + entity_name + "." + name + ".Quantity_max"))
					{
						Quantity_max = this.data.getInt("items." + entity_name + "." + name + ".Quantity_max");
					}else
					{
						Quantity_max = Quantity;
					}
					if (data.contains("items." + entity_name + "." + name + ".Chance"))
					{
						Chance = this.data.getDouble("items." + entity_name + "." + name + ".Chance");
					}
					// 判斷是否有必要資訊
					if (ItemRealname.length() > 0 && (Red <=255 && Red >= 0) && (Blue <=255 && Blue >= 0) && (Green <=255 && Green >= 0))
					{
						// 加入
						DataBase.main.getLogger().info(AnsiColor.GREEN + "[LoadItems] " + AnsiColor.WHITE + DataBase.GetEntityName(entity_name) + AnsiColor.GREEN + " 的掉落物 " + AnsiColor.WHITE + name + AnsiColor.GREEN + " 設定成功" + AnsiColor.RESET);
						dropItems.add(new MobDropItems(ItemName, UseOriginalName, ItemLores, ItemRealname, Red, Green, Blue, Enchants, Quantity, Quantity_max, Chance));
					}
					else
					{
						// 警告
						DataBase.main.getLogger().info(AnsiColor.RED + "[LoadItems] " + AnsiColor.WHITE + DataBase.GetEntityName(entity_name) + AnsiColor.RED + " 的掉落物 " + AnsiColor.WHITE + name + AnsiColor.RED + " 未設定成功" + AnsiColor.RESET);
					}
			    }
				DataBase.MobDropItemsMap.put(entity_name, dropItems);
		    }
	    }
	}
	
	// 建立預設檔
	public void CreateDefaultfile()
	{
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
