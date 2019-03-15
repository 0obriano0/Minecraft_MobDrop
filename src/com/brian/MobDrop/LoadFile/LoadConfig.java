package com.brian.MobDrop.LoadFile;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.brian.MobDrop.AnsiColor;
import com.brian.MobDrop.Database.DataBase;
import com.brian.MobDrop.Database.showMessage;

public class LoadConfig {
	// 主要讀取設定用
	private FileConfiguration data = null;

	// 開檔用
	private File filePreload = null;
	
	private String loadfilename = "Config.yml";
	
	public LoadConfig(){
		
	}
	
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
	    
	    if (data.contains("showMessage")){
	    	if(data.contains("showMessage.IsOpen") && data.contains("showMessage.Chance")) {
	    		DataBase.showMessage = new showMessage(data.getBoolean("showMessage.IsOpen"),data.getInt("showMessage.Chance"),data.getBoolean("list.Chinese"));
	    		DataBase.main.getLogger().info(AnsiColor.GREEN + "[LoadConfig] showMessage 設定成功" + AnsiColor.RESET);
	    	}else{
	    		DataBase.main.getLogger().info(AnsiColor.RED + "[LoadConfig] 資料讀取錯誤，如果不會設定，請將 showMessage.yml 刪掉並重新 reload" + AnsiColor.RESET);
	    		return;
	    	}
	    }else {
	    	DataBase.showMessage = new showMessage(false,0,false);
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
