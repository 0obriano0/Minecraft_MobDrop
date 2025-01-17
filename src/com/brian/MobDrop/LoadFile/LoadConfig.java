﻿package com.brian.MobDrop.LoadFile;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.brian.MobDrop.AnsiColor;
import com.brian.MobDrop.Database.DataBase;
import com.brian.MobDrop.Database.Config;

public class LoadConfig {
	// 主要讀取設定用
	private FileConfiguration data = null;

	// 開檔用
	private File filePreload = null;
	
	private String loadfilename = "Config.yml";
	
	public LoadConfig(){
		
	}
	
	boolean command_cmd_show = false;
	boolean command_old_list = false;
	boolean list_Chinese = false;
	String lang = "zh_TW";
	boolean dropItem = true;
	public void ReLoadConfig(){
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
	    
	    if(data.contains("command")) {
	    	if(data.contains("command.cmdShow")) 
	    		command_cmd_show = data.getBoolean("command.cmdShow");
	    	if(data.contains("command.oldList")) 
	    		command_old_list = data.getBoolean("command.oldList");
	    }
	    
	    if(data.contains("list.chinese")) 
	    	list_Chinese = data.getBoolean("list.chinese");
	    
	    if(data.contains("lang")) lang = data.getString("lang"); else errorMessage("","lang",lang);
	    if(data.contains("dropItem")) dropItem = data.getBoolean("dropItem"); else errorMessage("","dropItem",""+dropItem);
	    	
	    if (data.contains("GobalMessage")){
	    	if(data.contains("GobalMessage.IsOpen") && data.contains("GobalMessage.Chance")) {
	    		DataBase.Config = new Config(data.getBoolean("GobalMessage.IsOpen"),data.getInt("GobalMessage.Chance"),command_cmd_show,command_old_list,list_Chinese,lang,dropItem);
	    		DataBase.main.getLogger().info(AnsiColor.CYAN + "[LoadConfig]" + AnsiColor.GREEN +  " Config.yml Load Success" + AnsiColor.RESET);
	    	}else{
	    		DataBase.main.getLogger().info(AnsiColor.RED + "[LoadConfig] 資料讀取錯誤，如果不會設定，請將 config.yml 刪掉並重新 reload" + AnsiColor.RESET);
	    		return;
	    	}
	    }else {
	    	DataBase.Config = new Config(true,50,command_cmd_show,command_old_list,list_Chinese,lang,dropItem);
	    	DataBase.main.getLogger().info(AnsiColor.RED + "[LoadConfig] GobalMessage 資料讀取錯誤，使用預設值" + AnsiColor.RESET);
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
			e.printStackTrace();
			DataBase.main.getLogger().info(AnsiColor.RED + "[FileCreate] 資料創建出現嚴重的錯誤，請詢問程式設計師" + AnsiColor.RESET);
		}
	}
	
	public void errorMessage(String title,String name,String def) {
		DataBase.main.getLogger().info(AnsiColor.RED + "[Loadlanguage] " + title + " -> " + name + " 資料讀取失敗，使用預設值: " + def + AnsiColor.RESET);
	}
}
