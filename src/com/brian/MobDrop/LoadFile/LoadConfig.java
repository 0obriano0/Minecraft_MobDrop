package com.brian.MobDrop.LoadFile;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.brian.MobDrop.AnsiColor;
import com.brian.MobDrop.Database.DataBase;
import com.brian.MobDrop.Database.showMessage;

public class LoadConfig {
	// �D�nŪ���]�w��
	private FileConfiguration data = null;

	// �}�ɥ�
	private File filePreload = null;
	
	private String loadfilename = "Config.yml";
	
	public LoadConfig(){
		
	}
	
	public void ReLoadConfig(){
		// �T�{�ɮ׬O�_�s�b
	    this.filePreload = new File(DataBase.pluginMainDir + loadfilename);
	    if (this.filePreload.exists()){
	    	// Ū���]�w�ɤ��e
	    	this.data = YamlConfiguration.loadConfiguration(this.filePreload);
	    }
	    else{
	    	// �ɮפ��s�b�A�إ߹w�]��
	    	CreateDefaultfile();
	    	// �����ɮ�
	    	this.filePreload = new File(DataBase.pluginMainDir + loadfilename);
	    	// Ū���]�w�ɤ��e
	    	this.data = YamlConfiguration.loadConfiguration(this.filePreload);
	    }
	    
	    if (data.contains("showMessage")){
	    	if(data.contains("showMessage.IsOpen") && data.contains("showMessage.Chance")) {
	    		DataBase.showMessage = new showMessage(data.getBoolean("showMessage.IsOpen"),data.getInt("showMessage.Chance"),data.getBoolean("list.Chinese"));
	    		DataBase.main.getLogger().info(AnsiColor.GREEN + "[LoadConfig] showMessage �]�w���\" + AnsiColor.RESET);
	    	}else{
	    		DataBase.main.getLogger().info(AnsiColor.RED + "[LoadConfig] ���Ū�����~�A�p�G���|�]�w�A�бN showMessage.yml �R���í��s reload" + AnsiColor.RESET);
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
				DataBase.main.getLogger().info(AnsiColor.GREEN + "[FileCreate] " + AnsiColor.YELLOW + loadfilename + AnsiColor.GREEN +  " �Ыئ��\" + AnsiColor.RESET);
			else
				DataBase.main.getLogger().info(AnsiColor.RED + "[FileCreate] ��ƳЫإX�{���`�A�и߰ݵ{���]�p�v" + AnsiColor.RESET);
		}
		catch (Exception e)
		{
			DataBase.main.getLogger().info(AnsiColor.RED + "[FileCreate] ��ƳЫإ��ѡA�и߰ݵ{���]�p�v" + AnsiColor.RESET);
		}
	}
}
