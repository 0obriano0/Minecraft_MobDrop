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
	// �D�nŪ���]�w��
		private FileConfiguration data = null;

		// �}�ɥ�
		private File filePreload = null;
		
		private String loadfilename = "Mobs.yml";
		
		public LoadMobs(){
			
		}
		
		public void ReLoadMobs(){
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
		    
		    // ���x�s���������M��
		 	List<MobItemList> ItemsList = new ArrayList<MobItemList>();
		 	
		    for (String entity_name : data.getConfigurationSection("").getKeys(false)) {
		    	ItemsList = new ArrayList<MobItemList>();
		    	for (String Itemkey : data.getConfigurationSection(entity_name).getKeys(false)) {
		    		// �o�쪺���~�ƶq
		    		int Quantity = -1;
		    		int Quantity_max = 0;
		    		// �����v
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
		    			DataBase.main.getLogger().info(AnsiColor.GREEN + "[LoadMobs] " + AnsiColor.WHITE + DataBase.GetEntityName(entity_name) + AnsiColor.GREEN + " �������� " + AnsiColor.WHITE + DataBase.ItemMap.get(Itemkey).ItemName + AnsiColor.GREEN + " �]�w���\" + AnsiColor.RESET);
		    		}else {
		    			if(DataBase.ItemMap.containsKey(Itemkey))
		    				DataBase.main.getLogger().info(AnsiColor.RED + "[LoadMobs] " + AnsiColor.WHITE + DataBase.GetEntityName(entity_name) + AnsiColor.RED + " �������� " + AnsiColor.WHITE + DataBase.ItemMap.get(Itemkey).ItemName + AnsiColor.RED + " ���]�w���\" + AnsiColor.RESET);
		    			else
		    				DataBase.main.getLogger().info(AnsiColor.RED + "[LoadMobs] " + AnsiColor.WHITE + DataBase.GetEntityName(entity_name) + AnsiColor.RED + " �������� " + AnsiColor.WHITE + Itemkey + AnsiColor.RED + " ���]�w���\" + AnsiColor.RESET);
		    		}
		    	}
		    	DataBase.MobItemMap.put(entity_name.toUpperCase(),ItemsList);
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
