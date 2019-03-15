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
	// �D�nŪ���]�w��
	private FileConfiguration data = null;

	// �}�ɥ�
	private File filePreload = null;
	
	private String loadfilename = "Items.yml";
	
	public LoadItems()
	{
		
	}
	
	public void ReLoadItems()
	{
		// �T�{�ɮ׬O�_�s�b
	    this.filePreload = new File(DataBase.pluginMainDir + loadfilename);
	    if (this.filePreload.exists())
	    {
	    	// Ū���]�w�ɤ��e
	    	this.data = YamlConfiguration.loadConfiguration(this.filePreload);
	    }
	    else
	    {
	    	// �ɮפ��s�b�A�إ߹w�]��
	    	CreateDefaultfile();
	    	// �����ɮ�
	    	this.filePreload = new File(DataBase.pluginMainDir + loadfilename);
	    	// Ū���]�w�ɤ��e
	    	this.data = YamlConfiguration.loadConfiguration(this.filePreload);
	    }
	    
		if (data.contains("items"))
	    {
			// ���������~�W��
			String ItemName = "";
			// ���������~�O�_�M�έ�l�W��
			int UseOriginalName = 0;
			// ���������~����
			List<String> ItemLores = new ArrayList<String>();
			// ���������~�W��(��l�W��)
			String ItemRealname = "";
			// ��m
			int Red = 0;
			int Green = 0;
			int Blue = 0;
			// ���������~���]
			List<String> Enchants = new ArrayList<String>();
			// ���������~�ƶq
			int Quantity = 1;
			int Quantity_max = 1;
			// ���������v
			double Chance = 1000;
			// ��Ѫ��~����ID��
			//String strItemID = "";
			
			// ���x�s���������M��
			List<MobDropItems> dropItems = new ArrayList<MobDropItems>();
			
			// ���o�ͪ��W��
			for (String entity_name : data.getConfigurationSection("items").getKeys(false))
		    {
				// �M�żȦs��
				dropItems = new ArrayList<MobDropItems>();
				// �j��Ū�X������
				for (String name : data.getConfigurationSection("items." + entity_name).getKeys(false))
			    {
					// ###########################################
					// �M�żȦs��
					// ###########################################
					// ���������~�W��
					ItemName = "";
					// ���������~�O�_�M�έ�l�W��
					UseOriginalName = 0;
					// ���������~����
					ItemLores = new ArrayList<String>();
					// ���������~�W��(��l�W��)
					ItemRealname = "";
					// ��m
					Red = 0;
					Green = 0;
					Blue = 0;
					// ���������~���]
					Enchants = new ArrayList<String>();
					// ���������~�ƶq
					Quantity = 1;
					Quantity_max = 1;
					// ���������v
					Chance = 1000;
					// ��Ѫ��~����ID��
					//strItemID = "";
					// ###########################################
					// �}�lŪ�����e
					// ###########################################
					// Ū�����~�W��
					ItemName = name.replaceAll("_", " ");
					// �O�_�M�έ�l�W��
					if (data.contains("items." + entity_name + "." + name + ".UseCustomName"))
					{
						UseOriginalName = this.data.getInt("items." + entity_name + "." + name + ".UseCustomName");
					}
					// ���~����
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
					
					// �P�_�O�_���֥�(Ū���V��X)
					if(ItemRealname.split("_")[0].equals("LEATHER")) {
						if (data.contains("items." + entity_name + "." + name + ".RGB")) {
							String RGBbuffer = this.data.getString("items." + entity_name + "." + name + ".RGB");
							Red = Integer.parseInt(RGBbuffer.split(",")[0]);
							Green = Integer.parseInt(RGBbuffer.split(",")[1]);
							Blue = Integer.parseInt(RGBbuffer.split(",")[2]);
						}
					}
					
					// ���o���]
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
					// �P�_�O�_�����n��T
					if (ItemRealname.length() > 0 && (Red <=255 && Red >= 0) && (Blue <=255 && Blue >= 0) && (Green <=255 && Green >= 0))
					{
						// �[�J
						DataBase.main.getLogger().info(AnsiColor.GREEN + "[LoadItems] " + AnsiColor.WHITE + DataBase.GetEntityName(entity_name) + AnsiColor.GREEN + " �������� " + AnsiColor.WHITE + name + AnsiColor.GREEN + " �]�w���\" + AnsiColor.RESET);
						dropItems.add(new MobDropItems(ItemName, UseOriginalName, ItemLores, ItemRealname, Red, Green, Blue, Enchants, Quantity, Quantity_max, Chance));
					}
					else
					{
						// ĵ�i
						DataBase.main.getLogger().info(AnsiColor.RED + "[LoadItems] " + AnsiColor.WHITE + DataBase.GetEntityName(entity_name) + AnsiColor.RED + " �������� " + AnsiColor.WHITE + name + AnsiColor.RED + " ���]�w���\" + AnsiColor.RESET);
					}
			    }
				DataBase.MobDropItemsMap.put(entity_name, dropItems);
		    }
	    }
	}
	
	// �إ߹w�]��
	public void CreateDefaultfile()
	{
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
