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
		
		private String loadfiledir = "lang";
		private String loadfilename = "zh_TW.yml";
		
		public LoadLanguage(){
			
		}
		
		public void ReLoadLanguage(){
			// �T�{�ɮ׬O�_�s�b
		    this.filePreload = new File(DataBase.pluginMainDir + loadfiledir + "/" + loadfilename);
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
		    	if(data.contains("InventoryGUI.MobsList")) DataBase.language.Inventory.MobsList = data.getString("InventoryGUI.MobsList");
		    	if(data.contains("InventoryGUI.ItemList")) DataBase.language.Inventory.ItemList = data.getString("InventoryGUI.ItemList");
		    	if(data.contains("InventoryGUI.close"))    DataBase.language.Inventory.close    = data.getString("InventoryGUI.close");
		    	if(data.contains("InventoryGUI.next"))     DataBase.language.Inventory.next     = data.getString("InventoryGUI.next");
		    }
		    
		    DataBase.main.getLogger().info(AnsiColor.GREEN + "[Loadlanguage] " + loadfilename + " �]�w���\" + AnsiColor.RESET);
		}
		
		public void CreateDefaultfile(){
			try
			{
				if(CopyFileAPI.createFile(DataBase.pluginMainDir + "/" + loadfiledir, "/" + loadfilename, "/" + loadfiledir + "/" + loadfilename, DataBase.main))
					DataBase.main.getLogger().info(AnsiColor.GREEN + "[FileCreate] " + AnsiColor.YELLOW + loadfilename + AnsiColor.GREEN +  " �Ыئ��\" + AnsiColor.RESET);
				else
					DataBase.main.getLogger().info(AnsiColor.RED + "[FileCreate] ��ƳЫإX�{���`�A�и߰ݵ{���]�p�v1" + AnsiColor.RESET);
			}
			catch (Exception e)
			{
				DataBase.main.getLogger().info(AnsiColor.RED + "[FileCreate] ��ƳЫإ��ѡA�и߰ݵ{���]�p�v" + AnsiColor.RESET);
			}
		}
}
