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
import com.brian.MobDrop.LoadFile.LoadLanguage;

public class DataBase {
	// 主插件
		public static Main main;
		
		// 設定檔
		public static LoadConfig LoadConfig;
		public static LoadItems LoadItems;
		public static LoadMobs LoadMobs;
		public static LoadLanguage LoadLanguage;
		
		// 伺服器
		public static Server server;
		
		//語言包
		public static language language = new language();
		
		// 插件目錄
		public static String pluginMainDir = "./plugins/MobDrop/";
		
		//指令目錄
		public static MainList CommandsList = new MainList();

		//掉落物品清單
		public static Map<String, List<MobItemList>> MobItemMap = new HashMap<String, List<MobItemList>>();
		
		//物品設定
		public static Map<String, Items> ItemMap = new HashMap<String, Items>();
		
		//公開顯示訊息
		public static Config Config;
		
		// 顯示訊息
		public static void Print(String msg)
		{
			System.out.print("[MobDrop] " + msg);
		}
		
		// 取得生物名稱(中文)
		public static String GetEntityName(String entityId){
			if(DataBase.language.IDMobtoMessage.containsKey(entityId))
				return DataBase.language.IDMobtoMessage.get(entityId);
			else
				return entityId;
		}
		
		// 取得生物名稱(中文)
		public static String getEntityNameGameCode(String entityId){
			if(DataBase.language.MessagetoIDMob.containsKey(entityId))
				return DataBase.language.MessagetoIDMob.get(entityId);
			else
				return entityId;
			}
}
