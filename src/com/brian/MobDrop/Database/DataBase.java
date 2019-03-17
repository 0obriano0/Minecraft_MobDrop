package com.brian.MobDrop.Database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Server;

import com.brian.MobDrop.Main;
import com.brian.MobDrop.Command.CommandsList.MainList;
import com.brian.MobDrop.LoadFile.LoadConfig;
import com.brian.MobDrop.LoadFile.LoadItems;
import com.brian.MobDrop.LoadFile.LoadMobs;

public class DataBase {
	// 主插件
		public static Main main;
		
		// 設定檔
		public static LoadConfig LoadConfig;
		public static LoadItems LoadItems;
		public static LoadMobs LoadMobs;
		
		// 伺服器
		public static Server server;
		
		// 插件標題
		public static String detailStr = "[MobDrop]";
		
		// 插件目錄
		public static String pluginMainDir = "./plugins/MobDrop/";
		
		//指令目錄
		public static MainList CommandsList = new MainList();

		//掉落物品清單
		//public static Map<String, List<MobDropItems>> MobDropItemsMap = new HashMap<String, List<MobDropItems>>();
		public static Map<String, List<MobItemList>> MobItemMap = new HashMap<String, List<MobItemList>>();
		
		//物品設定
		public static Map<String, Items> ItemMap = new HashMap<String, Items>();
		
		//公開顯示訊息
		public static GobalMessage GobalMessage;
		
		// 顯示訊息
		public static void Print(String msg)
		{
			System.out.print(detailStr + msg);
		}
		
		// 取得生物名稱(中文)
		public static String GetEntityName(String entityId)
		{
			if (entityId.equals("CREEPER")) { return "苦力怕"; }
			else if (entityId.equals("SKELETON")) { return "骷髏"; }
			else if (entityId.equals("SPIDER")) { return "蜘蛛"; }
			else if (entityId.equals("GIANT")) { return "巨人"; }
			else if (entityId.equals("ZOMBIE")) { return "殭屍"; }
			else if (entityId.equals("SLIME")) { return "史萊姆"; }
			else if (entityId.equals("GHAST")) { return "幽靈水母"; }
			else if (entityId.equals("ZOMBIE_PIGMAN")) { return "殭屍豬人"; }
			else if (entityId.equals("ENDERMAN")) { return "終界使者"; }
			else if (entityId.equals("CAVE_SPIDER")) { return "洞穴蜘蛛"; }
			else if (entityId.equals("SILVERFISH")) { return "石頭蟲"; }
			else if (entityId.equals("BLAZE")) { return "烈焰使者"; }
			else if (entityId.equals("MAGMA_CUBE")) { return "烈焰史萊姆"; }
			else if (entityId.equals("ENDERDRAGON")) { return "終界龍"; }
			else if (entityId.equals("WITHERBOSS")) { return "凋零怪"; }
			else if (entityId.equals("WITCH")) { return "巫婆"; }
			else if (entityId.equals("BAT")) { return "蝙蝠"; }
			else if (entityId.equals("PIG")) { return "豬"; }
			else if (entityId.equals("SHEEP")) { return "羊"; }
			else if (entityId.equals("COW")) { return "牛"; }
			else if (entityId.equals("CHICKEN")) { return "雞"; }
			else if (entityId.equals("SQUID")) { return "章魚"; }
			else if (entityId.equals("WOLF")) { return "狼"; }
			else if (entityId.equals("MOOSHROOM")) { return "蘑菇牛"; }
			else if (entityId.equals("SNOWMAN")) { return "雪人"; }
			else if (entityId.equals("OCELOT")) { return "貓"; }
			else if (entityId.equals("VILLAGERGOLEM")) { return "鐵人"; }
			else if (entityId.equals("HORSE")) { return "馬"; }
			else if (entityId.equals("VILLAGER")) { return "村民"; }
			else if (entityId.equals("COD")) { return "鱈魚"; }
			else if (entityId.equals("DOLPHIN")) { return "海豚"; }
			else if (entityId.equals("DONKEY")) { return "驢子"; }
			else if (entityId.equals("DROWNED")) { return "沉屍"; }
			else if (entityId.equals("ELDER_GUARDIAN")) { return "原古深海守衛"; }
			else if (entityId.equals("ENDERMITE")) { return "終界蟲"; }
			else if (entityId.equals("EVOKER")) { return "喚魔者"; }
			else if (entityId.equals("GUARDIAN")) { return "深海守衛"; }
			else if (entityId.equals("HUSK")) { return "屍殼"; }
			else if (entityId.equals("LLAMA")) { return "羊駝"; }
			else if (entityId.equals("MULE")) { return "騾"; }
			else if (entityId.equals("PARROT")) { return "鸚鵡"; }
			else if (entityId.equals("PHANTOM")) { return "夜魅"; }
			else if (entityId.equals("POLAR_BEAR")) { return "北極熊"; }
			else if (entityId.equals("PUFFERFISH")) { return "河豚"; }
			else if (entityId.equals("RABBIT")) { return "兔子"; }
			else if (entityId.equals("SALMON")) { return "鮭魚"; }
			else if (entityId.equals("SHULKER")) { return "界伏蚌"; }
			else if (entityId.equals("PUFFERFISH")) { return "河豚"; }
			else if (entityId.equals("SKELETON_HORSE")) { return "骷髏馬"; }
			else if (entityId.equals("STRAY")) { return "流浪骷髏"; }
			else if (entityId.equals("TROPICAL_FISH")) { return "熱帶魚"; }
			else if (entityId.equals("TURTLE")) { return "海龜"; }
			else if (entityId.equals("VEX")) { return "鬼"; }
			else if (entityId.equals("VINDICATOR")) { return "衛道士"; }
			else if (entityId.equals("WITHER_SKELETON")) { return "凋零骷髏"; }
			else if (entityId.equals("ZOMBIE_HORSE")) { return "殭屍馬"; }
			else if (entityId.equals("ZOMBIE_VILLAGER")) { return "殭屍村民"; }
			return entityId;
		}
		
		// 取得生物名稱(中文)
		public static String getEntityNameGameCode(String entityId)
			{
				if (entityId.equals("苦力怕")) { return "CREEPER"; }
				else if (entityId.equals("骷髏")) { return "SKELETON"; }
				else if (entityId.equals("蜘蛛")) { return "SPIDER"; }
				else if (entityId.equals("巨人")) { return "GIANT"; }
				else if (entityId.equals("殭屍")) { return "ZOMBIE"; }
				else if (entityId.equals("史萊姆")) { return "SLIME"; }
				else if (entityId.equals("幽靈水母")) { return "GHAST"; }
				else if (entityId.equals("殭屍豬人")) { return "ZOMBIE_PIGMAN"; }
				else if (entityId.equals("終界使者")) { return "ENDERMAN"; }
				else if (entityId.equals("洞穴蜘蛛")) { return "CAVE_SPIDER"; }
				else if (entityId.equals("石頭蟲")) { return "SILVERFISH"; }
				else if (entityId.equals("烈焰使者")) { return "BLAZE"; }
				else if (entityId.equals("烈焰史萊姆")) { return "MAGMA_CUBE"; }
				else if (entityId.equals("終界龍")) { return "ENDERDRAGON"; }
				else if (entityId.equals("凋零怪")) { return "WITHERBOSS"; }
				else if (entityId.equals("巫婆")) { return "WITCH"; }
				else if (entityId.equals("蝙蝠")) { return "BAT"; }
				else if (entityId.equals("豬")) { return "PIG"; }
				else if (entityId.equals("羊")) { return "SHEEP"; }
				else if (entityId.equals("牛")) { return "COW"; }
				else if (entityId.equals("雞")) { return "CHICKEN"; }
				else if (entityId.equals("章魚")) { return "SQUID"; }
				else if (entityId.equals("狼")) { return "WOLF"; }
				else if (entityId.equals("蘑菇牛")) { return "MOOSHROOM"; }
				else if (entityId.equals("雪人")) { return "SNOWMAN"; }
				else if (entityId.equals("貓")) { return "OCELOT"; }
				else if (entityId.equals("鐵人")) { return "VILLAGERGOLEM"; }
				else if (entityId.equals("馬")) { return "HORSE"; }
				else if (entityId.equals("村民")) { return "VILLAGER"; }
				else if (entityId.equals("鱈魚")) { return "COD"; }
				else if (entityId.equals("海豚")) { return "DOLPHIN"; }
				else if (entityId.equals("驢子")) { return "DONKEY"; }
				else if (entityId.equals("沉屍")) { return "DROWNED"; }
				else if (entityId.equals("原古深海守衛")) { return "ELDER_GUARDIAN"; }
				else if (entityId.equals("終界蟲")) { return "ENDERMITE"; }
				else if (entityId.equals("喚魔者")) { return "EVOKER"; }
				else if (entityId.equals("深海守衛")) { return "GUARDIAN"; }
				else if (entityId.equals("屍殼")) { return "HUSK"; }
				else if (entityId.equals("羊駝")) { return "LLAMA"; }
				else if (entityId.equals("騾")) { return "MULE"; }
				else if (entityId.equals("鸚鵡")) { return "PARROT"; }
				else if (entityId.equals("夜魅")) { return "PHANTOM"; }
				else if (entityId.equals("北極熊")) { return "POLAR_BEAR"; }
				else if (entityId.equals("河豚")) { return "PUFFERFISH"; }
				else if (entityId.equals("兔子")) { return "RABBIT"; }
				else if (entityId.equals("鮭魚")) { return "SALMON"; }
				else if (entityId.equals("界伏蚌")) { return "SHULKER"; }
				else if (entityId.equals("河豚")) { return "PUFFERFISH"; }
				else if (entityId.equals("骷髏馬")) { return "SKELETON_HORSE"; }
				else if (entityId.equals("流浪骷髏")) { return "STRAY"; }
				else if (entityId.equals("熱帶魚")) { return "TROPICAL_FISH"; }
				else if (entityId.equals("海龜")) { return "TURTLE"; }
				else if (entityId.equals("鬼")) { return "VEX"; }
				else if (entityId.equals("衛道士")) { return "VINDICATOR"; }
				else if (entityId.equals("凋零骷髏")) { return "WITHER_SKELETON"; }
				else if (entityId.equals("殭屍馬")) { return "ZOMBIE_HORSE"; }
				else if (entityId.equals("殭屍村民")) { return "ZOMBIE_VILLAGER"; }
				return entityId;
			}
}
