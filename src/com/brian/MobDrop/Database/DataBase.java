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
	// �D����
		public static Main main;
		
		// �]�w��
		public static LoadConfig LoadConfig;
		public static LoadItems LoadItems;
		public static LoadMobs LoadMobs;
		public static LoadLanguage LoadLanguage;
		
		// ���A��
		public static Server server;
		
		//�y���]
		public static language language = new language();
		
		// ����ؿ�
		public static String pluginMainDir = "./plugins/MobDrop/";
		
		//���O�ؿ�
		public static MainList CommandsList = new MainList();

		//�������~�M��
		public static Map<String, List<MobItemList>> MobItemMap = new HashMap<String, List<MobItemList>>();
		
		//���~�]�w
		public static Map<String, Items> ItemMap = new HashMap<String, Items>();
		
		//���}��ܰT��
		public static Config Config;
		
		// ��ܰT��
		public static void Print(String msg)
		{
			System.out.print("[MobDrop] " + msg);
		}
		
		// ���o�ͪ��W��(����)
		public static String GetEntityName(String entityId){
			if(DataBase.language.IDMobtoMessage.containsKey(entityId))
				return DataBase.language.IDMobtoMessage.get(entityId);
			else
				return entityId;
		}
		
		// ���o�ͪ��W��(����)
		public static String getEntityNameGameCode(String entityId){
			if(DataBase.language.MessagetoIDMob.containsKey(entityId))
				return DataBase.language.MessagetoIDMob.get(entityId);
			else
				return entityId;
			}
}
