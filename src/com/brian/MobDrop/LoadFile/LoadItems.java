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
	// 主要讀取設定用
	private FileConfiguration data = null;

	// 開檔用
	private File filePreload = null;
	
	private String loadfilename = "Items.yml";
	
	public LoadItems()
	{
		
	}
	
	public void ReLoadItems()
	{
		// 確認檔案是否存在
	    this.filePreload = new File(DataBase.pluginMainDir + loadfilename);
	    if (this.filePreload.exists())
	    {
	    	// 讀取設定檔內容
	    	this.data = YamlConfiguration.loadConfiguration(this.filePreload);
	    }
	    else
	    {
	    	// 檔案不存在，建立預設檔
	    	CreateDefaultfile();
	    	// 重載檔案
	    	this.filePreload = new File(DataBase.pluginMainDir + loadfilename);
	    	// 讀取設定檔內容
	    	this.data = YamlConfiguration.loadConfiguration(this.filePreload);
	    }
	    
		if (data.contains("items"))
	    {
			// 掉落的物品名稱
			String ItemName = "";
			// 掉落的物品是否套用原始名稱
			int UseOriginalName = 0;
			// 掉落的物品說明
			List<String> ItemLores = new ArrayList<String>();
			// 掉落的物品名稱(原始名稱)
			String ItemRealname = "";
			// 色彩
			byte Red = 0;
			byte Green = 0;
			byte Blue = 0;
			// 掉落的物品附屬ID(原始ID)
			byte ItemSubID = 0;
			// 掉落的物品附魔
			List<String> Enchants = new ArrayList<String>();
			// 掉落的物品數量
			int Quantity = 1;
			int Quantity_max = 1;
			// 掉落的機率
			double Chance = 1000;
			// 拆解物品附屬ID用
			//String strItemID = "";
			
			// 待儲存的掉落物清單
			List<MobDropItems> dropItems = new ArrayList<MobDropItems>();
			
			// 取得生物名稱
			for (String entity_name : data.getConfigurationSection("items").getKeys(false))
		    {
				// 清空暫存區
				dropItems = new ArrayList<MobDropItems>();
				// 迴圈讀出掉落物
				for (String name : data.getConfigurationSection("items." + entity_name).getKeys(false))
			    {
					// ###########################################
					// 清空暫存區
					// ###########################################
					// 掉落的物品名稱
					ItemName = "";
					// 掉落的物品是否套用原始名稱
					UseOriginalName = 0;
					// 掉落的物品說明
					ItemLores = new ArrayList<String>();
					// 掉落的物品名稱(原始名稱)
					ItemRealname = "";
					// 色彩
					Red = 0;
					Green = 0;
					Blue = 0;
					// 掉落的物品附屬ID(原始ID)
					ItemSubID = 0;
					// 掉落的物品附魔
					Enchants = new ArrayList<String>();
					// 掉落的物品數量
					Quantity = 1;
					Quantity_max = 1;
					// 掉落的機率
					Chance = 1000;
					// 拆解物品附屬ID用
					//strItemID = "";
					// ###########################################
					// 開始讀取內容
					// ###########################################
					// 讀取物品名稱
					ItemName = name.replaceAll("_", " ");
					// 是否套用原始名稱
					if (data.contains("items." + entity_name + "." + name + ".UseCustomName"))
					{
						UseOriginalName = this.data.getInt("items." + entity_name + "." + name + ".UseCustomName");
					}
					// 物品說明
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
					
					// 判斷是否為皮甲(讀取染色碼)
					if(ItemRealname.indexOf(":") != -1) {
						if(ItemRealname.split("_")[0].equals("leather")) {
							if (data.contains("items." + entity_name + "." + name + ".RGB")) {
								String RGBbuffer = this.data.getString("items." + entity_name + "." + name + ".RGB");
								Red = Byte.parseByte(RGBbuffer.split(",")[0]);
								Green = Byte.parseByte(RGBbuffer.split(",")[1]);
								Blue = Byte.parseByte(RGBbuffer.split(",")[2]);
							}
						}
					}
					
					// 判斷有無子ID
					if (data.contains("items." + entity_name + "." + name + ".ItemSubID"))
					{
						ItemSubID = (byte)this.data.getInt("items." + entity_name + "." + name + ".ItemSubID");
						if(ItemSubID > 0)
							ItemSubID = 0;
					}else {
						ItemSubID = 0;
					}
					
					// 取得附魔
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
					// 判斷是否有必要資訊
					if (ItemRealname.length() > 0)
					{
						// 加入
						DataBase.main.getLogger().info(AnsiColor.GREEN + "[LoadItems] " + AnsiColor.WHITE + DataBase.GetEntityName(entity_name) + AnsiColor.GREEN + " 的掉落物 " + AnsiColor.WHITE + name + AnsiColor.GREEN + " 設定成功" + AnsiColor.RESET);
						dropItems.add(new MobDropItems(ItemName, UseOriginalName, ItemLores, ItemRealname, Red, Green, Blue, ItemSubID, Enchants, Quantity, Quantity_max, Chance));
					}
					else
					{
						// 警告
						DataBase.main.getLogger().info(AnsiColor.RED + "[LoadItems] " + AnsiColor.WHITE + DataBase.GetEntityName(entity_name) + AnsiColor.RED + " 的掉落物 " + AnsiColor.WHITE + name + AnsiColor.RED + " 未設定成功" + AnsiColor.RESET);
					}
			    }
				DataBase.MobDropItemsMap.put(entity_name, dropItems);
		    }
	    }
	}
	
	// 建立預設檔
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
			out.write("#生物實體ID                      #\r\n");
			out.write("#CREEPER         : 苦力怕        #\r\n");
			out.write("#SKELETON        : 骷髏          #\r\n");
			out.write("#SPIDER          : 蜘蛛          #\r\n");
			out.write("#GIANT           : 巨人          #\r\n");
			out.write("#ZOMBIE          : 殭屍          #\r\n");
			out.write("#SLIME           : 史萊姆        #\r\n");
			out.write("#GHAST           : 幽靈水母      #\r\n");
			out.write("#ZOMBIE_PIGMAN   : 殭屍豬人      #\r\n");
			out.write("#ENDERMAN        : 終界使者      #\r\n");
			out.write("#CAVE_SPIDER     : 洞穴蜘蛛      #\r\n");
			out.write("#SILVERFISH      : 石頭蟲        #\r\n");
			out.write("#BLAZE           : 烈焰使者      #\r\n");
			out.write("#MAGMA_CUBE      : 烈焰史萊姆    #\r\n");
			out.write("#ENDERDRAGON     : 終界龍        #\r\n");
			out.write("#WITHERBOSS      : 凋零怪        #\r\n");
			out.write("#WITCH       　  : 巫婆          #\r\n");
			out.write("#BAT             : 蝙蝠          #\r\n");
			out.write("#PIG             : 豬            #\r\n");
			out.write("#SHEEP           : 羊            #\r\n");
			out.write("#COW             : 牛            #\r\n");
			out.write("#CHICKEN         : 雞            #\r\n");
			out.write("#SQUID           : 章魚          #\r\n");
			out.write("#WOLF            : 狼            #\r\n");
			out.write("#MOOSHROOM       : 蘑菇牛        #\r\n");
			out.write("#SNOWMAN         : 雪人          #\r\n");
			out.write("#OZELOT          : 貓            #\r\n");
			out.write("#VILLAGERGOLEM   : 鐵人          #\r\n");
			out.write("#HORSE           : 馬            #\r\n");
			out.write("#VILLAGER        : 村民          #\r\n");
			out.write("#COD             : 鱈魚          #\r\n");
			out.write("#DOLPHIN         : 海豚          #\r\n");
			out.write("#DONKEY          : 驢子          #\r\n");
			out.write("#DROWNED         : 沉屍          #\r\n");
			out.write("#ELDER_GUARDIAN  : 原古深海守衛  #\r\n");
			out.write("#ENDERMITE       : 終界蟲        #\r\n");
			out.write("#EVOKER          : 喚魔者        #\r\n");
			out.write("#GUARDIAN        : 深海守衛      #\r\n");
			out.write("#HUSK            : 屍殼          #\r\n");
			out.write("#LLAMA           : 羊駝          #\r\n");
			out.write("#MULE            : 騾            #\r\n");
			out.write("#PARROT          : 鸚鵡          #\r\n");
			out.write("#PHANTOM         : 夜魅          #\r\n");
			out.write("#POLAR_BEAR      : 北極熊        #\r\n");
			out.write("#PUFFERFISH      : 河豚          #\r\n");
			out.write("#RABBIT          : 兔子          #\r\n");
			out.write("#SALMON          : 鮭魚          #\r\n");
			out.write("#SHULKER         : 界伏蚌        #\r\n");
			out.write("#PUFFERFISH      : 河豚          #\r\n");
			out.write("#SKELETON_HORSE  : 骷髏馬        #\r\n");
			out.write("#STRAY           : 流浪骷髏      #\r\n");
			out.write("#TROPICAL_FISH   : 熱帶魚        #\r\n");
			out.write("#TURTLE          : 海龜          #\r\n");
			out.write("#VEX             : 鬼            #\r\n");
			out.write("#VINDICATOR      : 衛道士        #\r\n");
			out.write("#WITHER_SKELETON : 凋零骷髏      #\r\n");
			out.write("#ZOMBIE_HORSE    : 殭屍馬        #\r\n");
			out.write("#ZOMBIE_VILLAGER : 殭屍村民      #\r\n");
			out.write("#================================#\r\n");
			out.write("  ZOMBIE:\r\n");
			out.write("#==============#\r\n");
			out.write("#掉落的物品名稱#\r\n");
			out.write("#==============#\r\n");
			out.write("    §f李逍遙的木劍§f:\r\n");
			out.write("#==========================#\r\n");
			out.write("#掉落的物品是否套用原始名稱#\r\n");
			out.write("#==========================#\r\n");
			out.write("      UseOriginalName: 1\r\n");
			out.write("#==================================================#\r\n");
			out.write("#物品的ID 跟 原始名稱                              #\r\n");
			out.write("#可參考: https://minecraft-ids.grahamedgecombe.com/#\r\n");
			out.write("#掉落的物品子ID(例：木劍=0)                        #\r\n");
			out.write("#==================================================#\r\n");
			out.write("      ItemSubID: 0\r\n");
			out.write("#=========================================#\r\n");
			out.write("#掉落的物品原始名稱(例：木劍=WOODEN_SWORD)#\r\n");
			out.write("#=========================================#\r\n");
			out.write("      ItemRealname: WOODEN_SWORD\r\n");
			out.write("#==============#\r\n");
			out.write("#掉落的物品說明#\r\n");
			out.write("#==============#\r\n");
			out.write("      ItemLores:\r\n");
			out.write("      - §e李逍遙自己削出來的木劍§f\r\n");
			out.write("#=============================#\r\n");
			out.write("#掉落的物品附魔               #\r\n");
			out.write("#- <附魔>:<等級>              #\r\n");
			out.write("#PROTECTION_ENVIRONMENTAL 保護#\r\n");
			out.write("#PROTECTION_EXPLOSIONS 防爆   #\r\n");
			out.write("#PROTECTION_PROJECTILE 防彈   #\r\n");
			out.write("#PROTECTION_FIRE 抗火         #\r\n");
			out.write("#PROTECTION_FALL 輕盈(腳)     #\r\n");
			out.write("#ARROW_INFINITE 無限弓        #\r\n");
			out.write("#ARROW_DAMAGE 強力弓          #\r\n");
			out.write("#ARROW_FIRE 火燄弓            #\r\n");
			out.write("#ARROW_KNOCKBACK 弓擊退       #\r\n");
			out.write("#DAMAGE_UNDEAD 不死剋星       #\r\n");
			out.write("#DAMAGE_ALL 鋒利              #\r\n");
			out.write("#DAMAGE_ARTHROPODS 節肢剋星   #\r\n");
			out.write("#OXYGEN 氧氣(頭)              #\r\n");
			out.write("#DURABILITY 耐久              #\r\n");
			out.write("#LOOT_BONUS_BLOCKS 幸運       #\r\n");
			out.write("#LOOT_BONUS_MOBS 掠奪         #\r\n");
			out.write("#SILK_TOUCH 絲綢之觸          #\r\n");
			out.write("#WATER_WORKER 親水性          #\r\n");
			out.write("#DIG_SPEED 效率               #\r\n");
			out.write("#KNOCKBACK 擊退劍             #\r\n");
			out.write("#FIRE_ASPECT 火焰附加         #\r\n");
			out.write("#=============================#\r\n");
			out.write("      Enchants:\r\n");
			out.write("      - DAMAGE_ALL:1\r\n");
			out.write("#==================#\r\n");
			out.write("#掉落的物品數量    #\r\n");
			out.write("#註：附魔物品無效  #\r\n");
			out.write("#==================#\r\n");
			out.write("      Quantity: 1\r\n");
			out.write("#========================#\r\n");
			out.write("#掉落的機率(0.01~100)    #\r\n");
			out.write("#若無此設定則表示100%掉落#\r\n");
			out.write("#========================#\r\n");
			out.write("      Chance: 100\r\n");
			/*out.write("#============================#\r\n");
			out.write("#指定掉落的世界              #\r\n");
			out.write("#若無此設定則全部世界都會掉落#\r\n");
			out.write("#============================#\r\n");
			out.write("      OnlyWorld: world\r\n");*/
			out.write("#========#\r\n");
			out.write("#其他範例#\r\n");
			out.write("#========#\r\n");
			out.write("  ZOMBIE_PIGMAN:\r\n");
			out.write("    §f集字卡-「殭」§f:\r\n");
			out.write("      ItemSubID: 0\r\n");
			out.write("      ItemRealname: PAPER\r\n");
			out.write("      ItemLores:\r\n");
			out.write("      - §e集滿「殭」「屍」「豬」「人」§f\r\n");
			out.write("      - §e即可合成殭屍豬人的飲料§f\r\n");
			out.write("      Quantity: 1\r\n");
			out.write("      Chance: 25\r\n");
			out.write("    §f集字卡-「屍」§f:\r\n");
			out.write("      ItemSubID: 0\r\n");
			out.write("      ItemRealname: PAPER\r\n");
			out.write("      ItemLores:\r\n");
			out.write("      - §e集滿「殭」「屍」「豬」「人」§f\r\n");
			out.write("      - §e即可合成殭屍豬人的飲料§f\r\n");
			out.write("      Quantity: 1\r\n");
			out.write("      Chance: 25\r\n");
			out.write("    §f集字卡-「豬」§f:\r\n");
			out.write("      ItemSubID: 0\r\n");
			out.write("      ItemRealname: PAPER\r\n");
			out.write("      ItemLores:\r\n");
			out.write("      - §e集滿「殭」「屍」「豬」「人」§f\r\n");
			out.write("      - §e即可合成殭屍豬人的飲料§f\r\n");
			out.write("      Quantity: 1\r\n");
			out.write("      Chance: 25\r\n");
			out.write("    §f集字卡-「人」§f:\r\n");
			out.write("      ItemSubID: 0\r\n");
			out.write("      ItemRealname: PAPER\r\n");
			out.write("      ItemLores:\r\n");
			out.write("      - §e集滿「殭」「屍」「豬」「人」§f\r\n");
			out.write("      - §e即可合成殭屍豬人的飲料§f\r\n");
			out.write("      Quantity: 1\r\n");
			out.write("      Chance: 25\r\n");
		    out.close();
		}
		catch (Exception e)
		{
			System.out.println(DataBase.detailStr + "[CreateDefaultConfig]Error on create default config!");
		}
	}
}
