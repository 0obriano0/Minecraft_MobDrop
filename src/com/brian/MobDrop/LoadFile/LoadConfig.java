package com.brian.MobDrop.LoadFile;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.brian.MobDrop.AnsiColor;
import com.brian.MobDrop.Database.DataBase;
import com.brian.MobDrop.Database.Config;

public class LoadConfig {
	// �D�nŪ���]�w��
	private FileConfiguration data = null;

	// �}�ɥ�
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
	    		DataBase.main.getLogger().info(AnsiColor.RED + "[LoadConfig] ���Ū�����~�A�p�G���|�]�w�A�бN config.yml �R���í��s reload" + AnsiColor.RESET);
	    		return;
	    	}
	    }else {
	    	DataBase.Config = new Config(true,50,command_cmd_show,command_old_list,list_Chinese,lang,dropItem);
	    	DataBase.main.getLogger().info(AnsiColor.RED + "[LoadConfig] GobalMessage ���Ū�����~�A�ϥιw�]��" + AnsiColor.RESET);
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
			e.printStackTrace();
			DataBase.main.getLogger().info(AnsiColor.RED + "[FileCreate] ��ƳЫإX�{�Y�������~�A�и߰ݵ{���]�p�v" + AnsiColor.RESET);
		}
	}
	
	public void errorMessage(String title,String name,String def) {
		DataBase.main.getLogger().info(AnsiColor.RED + "[Loadlanguage] " + title + " -> " + name + " ���Ū�����ѡA�ϥιw�]��: " + def + AnsiColor.RESET);
	}
}
