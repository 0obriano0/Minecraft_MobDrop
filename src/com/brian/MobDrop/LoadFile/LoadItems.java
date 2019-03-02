package com.brian.MobDrop.LoadFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
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
			File createDir = new File(DataBase.pluginMainDir);
			if (!createDir.exists())
			{
				boolean dirCreated = false;
	
				int retries = 15;
	
				while ((!dirCreated) && (retries != 0))
				{
					retries--;
					dirCreated = createDir.mkdir();
				}
	
				if (!dirCreated)
				{
					DataBase.main.getLogger().info(AnsiColor.RED + "[CreateDefaultFile]Items.yml failed to create. No permissions?" + AnsiColor.RESET);
					return;
				}
			}
			FileOutputStream fos = new FileOutputStream(DataBase.pluginMainDir + loadfilename);
		    fos.write(new byte[]{(byte)0xEF, (byte)0xBB, (byte)0xBF});
		    OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		    
			BufferedWriter out = new BufferedWriter(osw);
			out.write("items:\r\n");
			out.write("#================================#\r\n");
			out.write("#�ͪ�����ID                      #\r\n");
			out.write("#CREEPER         : �W�O��        #\r\n");
			out.write("#SKELETON        : �u�\          #\r\n");
			out.write("#SPIDER          : �j��          #\r\n");
			out.write("#GIANT           : ���H          #\r\n");
			out.write("#ZOMBIE          : �L��          #\r\n");
			out.write("#SLIME           : �v�ܩi        #\r\n");
			out.write("#GHAST           : ���F����      #\r\n");
			out.write("#ZOMBIE_PIGMAN   : �L�ͽޤH      #\r\n");
			out.write("#ENDERMAN        : �׬ɨϪ�      #\r\n");
			out.write("#CAVE_SPIDER     : �}�޻j��      #\r\n");
			out.write("#SILVERFISH      : ���Y��        #\r\n");
			out.write("#BLAZE           : �P�K�Ϫ�      #\r\n");
			out.write("#MAGMA_CUBE      : �P�K�v�ܩi    #\r\n");
			out.write("#ENDERDRAGON     : �׬��s        #\r\n");
			out.write("#WITHERBOSS      : ��s��        #\r\n");
			out.write("#WITCH       �@  : �űC          #\r\n");
			out.write("#BAT             : ����          #\r\n");
			out.write("#PIG             : ��            #\r\n");
			out.write("#SHEEP           : ��            #\r\n");
			out.write("#COW             : ��            #\r\n");
			out.write("#CHICKEN         : ��            #\r\n");
			out.write("#SQUID           : ����          #\r\n");
			out.write("#WOLF            : �T            #\r\n");
			out.write("#MOOSHROOM       : Ĩۣ��        #\r\n");
			out.write("#SNOWMAN         : ���H          #\r\n");
			out.write("#OZELOT          : ��            #\r\n");
			out.write("#VILLAGERGOLEM   : �K�H          #\r\n");
			out.write("#HORSE           : ��            #\r\n");
			out.write("#VILLAGER        : ����          #\r\n");
			out.write("#COD             : ����          #\r\n");
			out.write("#DOLPHIN         : ���b          #\r\n");
			out.write("#DONKEY          : �j�l          #\r\n");
			out.write("#DROWNED         : �I��          #\r\n");
			out.write("#ELDER_GUARDIAN  : ��j�`���u��  #\r\n");
			out.write("#ENDERMITE       : �׬���        #\r\n");
			out.write("#EVOKER          : ���]��        #\r\n");
			out.write("#GUARDIAN        : �`���u��      #\r\n");
			out.write("#HUSK            : �ʹ�          #\r\n");
			out.write("#LLAMA           : �Ͼm          #\r\n");
			out.write("#MULE            : �[            #\r\n");
			out.write("#PARROT          : �x�M          #\r\n");
			out.write("#PHANTOM         : �]�y          #\r\n");
			out.write("#POLAR_BEAR      : �_����        #\r\n");
			out.write("#PUFFERFISH      : �e�b          #\r\n");
			out.write("#RABBIT          : �ߤl          #\r\n");
			out.write("#SALMON          : �D��          #\r\n");
			out.write("#SHULKER         : �ɥ�F        #\r\n");
			out.write("#PUFFERFISH      : �e�b          #\r\n");
			out.write("#SKELETON_HORSE  : �u�\��        #\r\n");
			out.write("#STRAY           : �y���u�\      #\r\n");
			out.write("#TROPICAL_FISH   : ���a��        #\r\n");
			out.write("#TURTLE          : ���t          #\r\n");
			out.write("#VEX             : ��            #\r\n");
			out.write("#VINDICATOR      : �ùD�h        #\r\n");
			out.write("#WITHER_SKELETON : ��s�u�\      #\r\n");
			out.write("#ZOMBIE_HORSE    : �L�Ͱ�        #\r\n");
			out.write("#ZOMBIE_VILLAGER : �L�ͧ���      #\r\n");
			out.write("#================================#\r\n");
			out.write("  ZOMBIE:\r\n");
			out.write("#==============#\r\n");
			out.write("#���������~�W��#\r\n");
			out.write("#==============#\r\n");
			out.write("    ��f���p������C��f:\r\n");
			out.write("#==========================#\r\n");
			out.write("#���������~�O�_�M�έ�l�W��#\r\n");
			out.write("#==========================#\r\n");
			out.write("      UseCustomName: 0\r\n");
			out.write("#==================================================#\r\n");
			out.write("#�i�Ѧ�: https://minecraft-ids.grahamedgecombe.com/#\r\n");
			out.write("#���������~��l�W��(�ҡG��C=WOODEN_SWORD)         #\r\n");
			out.write("#==================================================#\r\n");
			out.write("      ItemRealname: WOODEN_SWORD\r\n");
			out.write("#==============#\r\n");
			out.write("#���������~����#\r\n");
			out.write("#==============#\r\n");
			out.write("      ItemLores:\r\n");
			out.write("      - ��e���p���ۤv�d�X�Ӫ���C��f\r\n");
			out.write("#=============================#\r\n");
			out.write("#���������~���]               #\r\n");
			out.write("#- <���]>:<����>              #\r\n");
			out.write("#PROTECTION_ENVIRONMENTAL �O�@#\r\n");
			out.write("#PROTECTION_EXPLOSIONS ���z   #\r\n");
			out.write("#PROTECTION_PROJECTILE ���u   #\r\n");
			out.write("#PROTECTION_FIRE �ܤ�         #\r\n");
			out.write("#PROTECTION_FALL ����(�})     #\r\n");
			out.write("#ARROW_INFINITE �L���}        #\r\n");
			out.write("#ARROW_DAMAGE �j�O�}          #\r\n");
			out.write("#ARROW_FIRE ���V�}            #\r\n");
			out.write("#ARROW_KNOCKBACK �}���h       #\r\n");
			out.write("#DAMAGE_UNDEAD �����g�P       #\r\n");
			out.write("#DAMAGE_ALL �W�Q              #\r\n");
			out.write("#DAMAGE_ARTHROPODS �`�ϫg�P   #\r\n");
			out.write("#OXYGEN ���(�Y)              #\r\n");
			out.write("#DURABILITY �@�[              #\r\n");
			out.write("#LOOT_BONUS_BLOCKS ���B       #\r\n");
			out.write("#LOOT_BONUS_MOBS ����         #\r\n");
			out.write("#SILK_TOUCH ������Ĳ          #\r\n");
			out.write("#WATER_WORKER �ˤ���          #\r\n");
			out.write("#DIG_SPEED �Ĳv               #\r\n");
			out.write("#KNOCKBACK ���h�C             #\r\n");
			out.write("#FIRE_ASPECT ���K���[         #\r\n");
			out.write("#=============================#\r\n");
			out.write("      Enchants:\r\n");
			out.write("      - DAMAGE_ALL:1\r\n");
			out.write("#==================#\r\n");
			out.write("#���������~�ƶq    #\r\n");
			out.write("#���G���]���~�L��  #\r\n");
			out.write("#==================#\r\n");
			out.write("      Quantity: 1\r\n");
			out.write("#========================#\r\n");
			out.write("#���������v(0.01~100)    #\r\n");
			out.write("#�Y�L���]�w�h���100%����#\r\n");
			out.write("#========================#\r\n");
			out.write("      Chance: 100\r\n");
			out.write("#========#\r\n");
			out.write("#��L�d��#\r\n");
			out.write("#========#\r\n");
			out.write("    ��f�v�ܩi���C��f:\r\n");
			out.write("      ItemRealname: IRON_SWORD\r\n");
			out.write("      ItemLores:\r\n");
			out.write("      - ��e�ѥv�ܩi���y���C��f\r\n");
			out.write("      - ��e�ϥΥL�i�H�o�쯫�O��f\r\n");
			out.write("      Enchants:\r\n");
			out.write("      - DAMAGE_ALL:8\r\n");
			out.write("      Quantity: 1\r\n");
			out.write("      Chance: 0.5\r\n");
			out.write("    ��f�p�ۡ�f:\r\n");
			out.write("      ItemRealname: Diamond\r\n");
			out.write("      ItemLores:\r\n");
			out.write("      - ��e���q���p�ۡ�f\r\n");
			out.write("      Quantity: 1\r\n");
			out.write("#========================#\r\n");
			out.write("#���������~���̤j�ƶq    #\r\n");
			out.write("#========================#\r\n");
			out.write("      Quantity_max: 4\r\n");
			out.write("      Chance: 1\r\n");
			out.write("#========#\r\n");
			out.write("#��L�d��#\r\n");
			out.write("#========#\r\n");
			out.write("  SKELETON:\r\n");
			out.write("    ��f���Y����f:\r\n");
			out.write("      ItemRealname: leather_helmet\r\n");
			out.write("      ItemLores:\r\n");
			out.write("      - ��e�u�\�ͫe���˳ơ�f\r\n");
			out.write("      Enchants:\r\n");
			out.write("      - PROTECTION_ENVIRONMENTAL:1\r\n");
			out.write("      RGB: 255,255,255\r\n");
			out.write("      Quantity: 1\r\n");
			out.write("      Chance: 50\r\n");
			out.write("    ��f�դW�硱f:\r\n");
			out.write("      ItemRealname: leather_chestplate\r\n");
			out.write("      ItemLores:\r\n");
			out.write("      - ��e�u�\�ͫe���˳ơ�f\r\n");
			out.write("      Enchants:\r\n");
			out.write("      - PROTECTION_ENVIRONMENTAL:1\r\n");
			out.write("      RGB: 255,255,255\r\n");
			out.write("      Quantity: 1\r\n");
			out.write("      Chance: 50\r\n");
			out.write("    ��f�տǤl��f:\r\n");
			out.write("      ItemRealname: leather_leggings\r\n");
			out.write("      ItemLores:\r\n");
			out.write("      - ��e�u�\�ͫe���˳ơ�f\r\n");
			out.write("      Enchants:\r\n");
			out.write("      - PROTECTION_ENVIRONMENTAL:1\r\n");
			out.write("      RGB: 255,255,255\r\n");
			out.write("      Quantity: 1\r\n");
			out.write("      Chance: 50\r\n");
			out.write("    ��f�վc�l��f:\r\n");
			out.write("      ItemRealname: leather_boots\r\n");
			out.write("      ItemLores:\r\n");
			out.write("      - ��e�u�\�ͫe���˳ơ�f\r\n");
			out.write("      Enchants:\r\n");
			out.write("      - PROTECTION_ENVIRONMENTAL:1\r\n");
			out.write("      RGB: 255,255,255\r\n");
			out.write("      Quantity: 1\r\n");
			out.write("      Chance: 50\r\n");
			out.write("  PHANTOM:\r\n");
			out.write("    ��c�b�ڡ�f:\r\n");
			out.write("      UseCustomName: 1\r\n");
			out.write("      ItemRealname: arrow\r\n");
			out.write("      Quantity: 10\r\n");
			out.write("      Quantity_max: 30\r\n");
			out.write("      Chance: 70\r\n");
		    out.close();
		}
		catch (Exception e)
		{
			System.out.println(DataBase.detailStr + "[CreateDefaultConfig]Error on create default config!");
		}
	}
}
