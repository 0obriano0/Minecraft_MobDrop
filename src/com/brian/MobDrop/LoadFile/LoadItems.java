package com.brian.MobDrop.LoadFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.brian.MobDrop.AnsiColor;
import com.brian.MobDrop.Database.DataBase;
import com.brian.MobDrop.Database.Items;

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
	    
		// ���������~�W��
		String ItemName = "";
		// ���������~�O�_�M�έ�l�W��
		boolean UseCustomName = false;
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
		// ��Ѫ��~����ID��
		//String strItemID = "";
		
		int failData = 0;
		
		// ���o�ͪ��W��
		for (String ItemKey : data.getConfigurationSection("").getKeys(false))
	    {
			// �j��Ū�X������
			// ###########################################
			// �M�żȦs��
			// ###########################################
			// ���������~�W��
			ItemName = "";
			// ���������~�O�_�M�έ�l�W��
			UseCustomName = false;
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
			// ��Ѫ��~����ID��
			//strItemID = "";
			// ###########################################
			// �}�lŪ�����e
			// ###########################################
			// Ū�����~�W��
			if (data.contains(ItemKey + ".ItemName"))
			{
				ItemName = data.getString(ItemKey + ".ItemName");
			}
			
			if (data.contains(ItemKey + ".UseCustomName"))
			{
				UseCustomName = data.getBoolean(ItemKey + ".UseCustomName");
			}
			// ���~����
			if (data.contains(ItemKey + ".ItemLores"))
			{
				ItemLores = data.getStringList(ItemKey +  ".ItemLores");
				for (int i = 0; i < ItemLores.size(); i++)
				{
					ItemLores.set(i, ItemLores.get(i).replace("_", " "));
				}
			}
			if (data.contains(ItemKey +  ".ItemRealname"))
			{
				ItemRealname = data.getString(ItemKey + ".ItemRealname").toUpperCase();
			}
			
			// �P�_�O�_���֥�(Ū���V��X)
			if(ItemRealname.split("_")[0].equals("LEATHER")) {
				if (data.contains(ItemKey + ".RGB")) {
					String RGBbuffer = this.data.getString(ItemKey + ".RGB");
					Red = Integer.parseInt(RGBbuffer.split(",")[0]);
					Green = Integer.parseInt(RGBbuffer.split(",")[1]);
					Blue = Integer.parseInt(RGBbuffer.split(",")[2]);
				}
			}
			
			// ���o���]
			if (data.contains(ItemKey + ".Enchants"))
			{
				Enchants = this.data.getStringList(ItemKey + ".Enchants");
			}
			// �P�_�O�_�����n��T
			if (ItemRealname.length() > 0 && (Red <=255 && Red >= 0) && (Blue <=255 && Blue >= 0) && (Green <=255 && Green >= 0))
			{
				// �[�J
				if(DataBase.GobalMessage.command_cmd_show)
					DataBase.main.getLogger().info(AnsiColor.GREEN + "[LoadItems] " + AnsiColor.GREEN + "���~ " + AnsiColor.WHITE + ItemName + AnsiColor.GREEN + " �]�w���\" + AnsiColor.RESET);
				DataBase.ItemMap.put(ItemKey.toUpperCase(),new Items(ItemName, UseCustomName, ItemRealname, ItemLores, Red, Green, Blue, Enchants));
			}else
			{
				// ĵ�i
				failData++;
				DataBase.main.getLogger().info(AnsiColor.RED + "[LoadItems] " + AnsiColor.GREEN + "���~ " + AnsiColor.WHITE + ItemName + AnsiColor.RED + " ���]�w���\" + AnsiColor.RESET);
			}
	    }
		DataBase.main.getLogger().info(AnsiColor.GREEN + "[LoadItems] " + AnsiColor.GREEN + "���~Ū�� �`�@:  " + AnsiColor.WHITE + DataBase.ItemMap.size() + AnsiColor.YELLOW + " ���\:  " + AnsiColor.WHITE + (DataBase.ItemMap.size()-failData) + AnsiColor.RED + " ����:  " + AnsiColor.WHITE + failData + AnsiColor.RESET);
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
