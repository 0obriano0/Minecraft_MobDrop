package com.brian.MobDrop.LoadFile;

import java.io.File;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.brian.MobDrop.AnsiColor;
import com.brian.MobDrop.Database.DataBase;
import com.brian.MobDrop.Database.GobalMessage;

public class LoadLanguage {
	// �D�nŪ���]�w��
		private FileConfiguration data = null;

		// �}�ɥ�
		private File filePreload = null;
		
		private String loadfilename = "lang/zh_TW.yml";
		
		public LoadLanguage(){
			
		}
		
		String InventoryGUI_MobsList;
		
		public void ReLoadLanguage(){
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
		    
		    
		    
		    if(data.contains("InventoryGUI")) {
		    	if(data.contains("InventoryGUI.MobsList")) 
		    		InventoryGUI_MobsList = data.getString("InventoryGUI.MobsList");
		    }
		    
		    DataBase.language.setInventoryGUI(InventoryGUI_MobsList);
		    
		    /*if (data.contains("GobalMessage")){
		    	if(data.contains("GobalMessage.IsOpen") && data.contains("GobalMessage.Chance")) {
		    		DataBase.GobalMessage = new GobalMessage(data.getBoolean("GobalMessage.IsOpen"),data.getInt("GobalMessage.Chance"),command_cmd_show,command_old_list,list_Chinese);
		    		DataBase.main.getLogger().info(AnsiColor.GREEN + "[LoadConfig] GobalMessage �]�w���\" + AnsiColor.RESET);
		    	}else{
		    		DataBase.main.getLogger().info(AnsiColor.RED + "[LoadConfig] ���Ū�����~�A�p�G���|�]�w�A�бN GobalMessage.yml �R���í��s reload" + AnsiColor.RESET);
		    		return;
		    	}
		    }else {
		    	DataBase.GobalMessage = new GobalMessage(true,50,false,false,false);
		    	DataBase.main.getLogger().info(AnsiColor.RED + "[LoadConfig] GobalMessage ���Ū�����~�A�ϥιw�]��" + AnsiColor.RESET);
		    }*/
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
