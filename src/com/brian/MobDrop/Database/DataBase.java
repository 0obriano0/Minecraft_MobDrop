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
	// �D����
		public static Main main;
		
		// �]�w��
		public static LoadConfig LoadConfig;
		public static LoadItems LoadItems;
		public static LoadMobs LoadMobs;
		
		// ���A��
		public static Server server;
		
		// ������D
		public static String detailStr = "[MobDrop]";
		
		// ����ؿ�
		public static String pluginMainDir = "./plugins/MobDrop/";
		
		//���O�ؿ�
		public static MainList CommandsList = new MainList();

		//�������~�M��
		//public static Map<String, List<MobDropItems>> MobDropItemsMap = new HashMap<String, List<MobDropItems>>();
		public static Map<String, List<MobItemList>> MobItemMap = new HashMap<String, List<MobItemList>>();
		
		//���~�]�w
		public static Map<String, Items> ItemMap = new HashMap<String, Items>();
		
		//���}��ܰT��
		public static GobalMessage GobalMessage;
		
		// ��ܰT��
		public static void Print(String msg)
		{
			System.out.print(detailStr + msg);
		}
		
		// ���o�ͪ��W��(����)
		public static String GetEntityName(String entityId)
		{
			if (entityId.equals("CREEPER")) { return "�W�O��"; }
			else if (entityId.equals("SKELETON")) { return "�u�\"; }
			else if (entityId.equals("SPIDER")) { return "�j��"; }
			else if (entityId.equals("GIANT")) { return "���H"; }
			else if (entityId.equals("ZOMBIE")) { return "�L��"; }
			else if (entityId.equals("SLIME")) { return "�v�ܩi"; }
			else if (entityId.equals("GHAST")) { return "���F����"; }
			else if (entityId.equals("ZOMBIE_PIGMAN")) { return "�L�ͽޤH"; }
			else if (entityId.equals("ENDERMAN")) { return "�׬ɨϪ�"; }
			else if (entityId.equals("CAVE_SPIDER")) { return "�}�޻j��"; }
			else if (entityId.equals("SILVERFISH")) { return "���Y��"; }
			else if (entityId.equals("BLAZE")) { return "�P�K�Ϫ�"; }
			else if (entityId.equals("MAGMA_CUBE")) { return "�P�K�v�ܩi"; }
			else if (entityId.equals("ENDERDRAGON")) { return "�׬��s"; }
			else if (entityId.equals("WITHERBOSS")) { return "��s��"; }
			else if (entityId.equals("WITCH")) { return "�űC"; }
			else if (entityId.equals("BAT")) { return "����"; }
			else if (entityId.equals("PIG")) { return "��"; }
			else if (entityId.equals("SHEEP")) { return "��"; }
			else if (entityId.equals("COW")) { return "��"; }
			else if (entityId.equals("CHICKEN")) { return "��"; }
			else if (entityId.equals("SQUID")) { return "����"; }
			else if (entityId.equals("WOLF")) { return "�T"; }
			else if (entityId.equals("MOOSHROOM")) { return "Ĩۣ��"; }
			else if (entityId.equals("SNOWMAN")) { return "���H"; }
			else if (entityId.equals("OCELOT")) { return "��"; }
			else if (entityId.equals("VILLAGERGOLEM")) { return "�K�H"; }
			else if (entityId.equals("HORSE")) { return "��"; }
			else if (entityId.equals("VILLAGER")) { return "����"; }
			else if (entityId.equals("COD")) { return "����"; }
			else if (entityId.equals("DOLPHIN")) { return "���b"; }
			else if (entityId.equals("DONKEY")) { return "�j�l"; }
			else if (entityId.equals("DROWNED")) { return "�I��"; }
			else if (entityId.equals("ELDER_GUARDIAN")) { return "��j�`���u��"; }
			else if (entityId.equals("ENDERMITE")) { return "�׬���"; }
			else if (entityId.equals("EVOKER")) { return "���]��"; }
			else if (entityId.equals("GUARDIAN")) { return "�`���u��"; }
			else if (entityId.equals("HUSK")) { return "�ʹ�"; }
			else if (entityId.equals("LLAMA")) { return "�Ͼm"; }
			else if (entityId.equals("MULE")) { return "�["; }
			else if (entityId.equals("PARROT")) { return "�x�M"; }
			else if (entityId.equals("PHANTOM")) { return "�]�y"; }
			else if (entityId.equals("POLAR_BEAR")) { return "�_����"; }
			else if (entityId.equals("PUFFERFISH")) { return "�e�b"; }
			else if (entityId.equals("RABBIT")) { return "�ߤl"; }
			else if (entityId.equals("SALMON")) { return "�D��"; }
			else if (entityId.equals("SHULKER")) { return "�ɥ�F"; }
			else if (entityId.equals("PUFFERFISH")) { return "�e�b"; }
			else if (entityId.equals("SKELETON_HORSE")) { return "�u�\��"; }
			else if (entityId.equals("STRAY")) { return "�y���u�\"; }
			else if (entityId.equals("TROPICAL_FISH")) { return "���a��"; }
			else if (entityId.equals("TURTLE")) { return "���t"; }
			else if (entityId.equals("VEX")) { return "��"; }
			else if (entityId.equals("VINDICATOR")) { return "�ùD�h"; }
			else if (entityId.equals("WITHER_SKELETON")) { return "��s�u�\"; }
			else if (entityId.equals("ZOMBIE_HORSE")) { return "�L�Ͱ�"; }
			else if (entityId.equals("ZOMBIE_VILLAGER")) { return "�L�ͧ���"; }
			return entityId;
		}
		
		// ���o�ͪ��W��(����)
		public static String getEntityNameGameCode(String entityId)
			{
				if (entityId.equals("�W�O��")) { return "CREEPER"; }
				else if (entityId.equals("�u�\")) { return "SKELETON"; }
				else if (entityId.equals("�j��")) { return "SPIDER"; }
				else if (entityId.equals("���H")) { return "GIANT"; }
				else if (entityId.equals("�L��")) { return "ZOMBIE"; }
				else if (entityId.equals("�v�ܩi")) { return "SLIME"; }
				else if (entityId.equals("���F����")) { return "GHAST"; }
				else if (entityId.equals("�L�ͽޤH")) { return "ZOMBIE_PIGMAN"; }
				else if (entityId.equals("�׬ɨϪ�")) { return "ENDERMAN"; }
				else if (entityId.equals("�}�޻j��")) { return "CAVE_SPIDER"; }
				else if (entityId.equals("���Y��")) { return "SILVERFISH"; }
				else if (entityId.equals("�P�K�Ϫ�")) { return "BLAZE"; }
				else if (entityId.equals("�P�K�v�ܩi")) { return "MAGMA_CUBE"; }
				else if (entityId.equals("�׬��s")) { return "ENDERDRAGON"; }
				else if (entityId.equals("��s��")) { return "WITHERBOSS"; }
				else if (entityId.equals("�űC")) { return "WITCH"; }
				else if (entityId.equals("����")) { return "BAT"; }
				else if (entityId.equals("��")) { return "PIG"; }
				else if (entityId.equals("��")) { return "SHEEP"; }
				else if (entityId.equals("��")) { return "COW"; }
				else if (entityId.equals("��")) { return "CHICKEN"; }
				else if (entityId.equals("����")) { return "SQUID"; }
				else if (entityId.equals("�T")) { return "WOLF"; }
				else if (entityId.equals("Ĩۣ��")) { return "MOOSHROOM"; }
				else if (entityId.equals("���H")) { return "SNOWMAN"; }
				else if (entityId.equals("��")) { return "OCELOT"; }
				else if (entityId.equals("�K�H")) { return "VILLAGERGOLEM"; }
				else if (entityId.equals("��")) { return "HORSE"; }
				else if (entityId.equals("����")) { return "VILLAGER"; }
				else if (entityId.equals("����")) { return "COD"; }
				else if (entityId.equals("���b")) { return "DOLPHIN"; }
				else if (entityId.equals("�j�l")) { return "DONKEY"; }
				else if (entityId.equals("�I��")) { return "DROWNED"; }
				else if (entityId.equals("��j�`���u��")) { return "ELDER_GUARDIAN"; }
				else if (entityId.equals("�׬���")) { return "ENDERMITE"; }
				else if (entityId.equals("���]��")) { return "EVOKER"; }
				else if (entityId.equals("�`���u��")) { return "GUARDIAN"; }
				else if (entityId.equals("�ʹ�")) { return "HUSK"; }
				else if (entityId.equals("�Ͼm")) { return "LLAMA"; }
				else if (entityId.equals("�[")) { return "MULE"; }
				else if (entityId.equals("�x�M")) { return "PARROT"; }
				else if (entityId.equals("�]�y")) { return "PHANTOM"; }
				else if (entityId.equals("�_����")) { return "POLAR_BEAR"; }
				else if (entityId.equals("�e�b")) { return "PUFFERFISH"; }
				else if (entityId.equals("�ߤl")) { return "RABBIT"; }
				else if (entityId.equals("�D��")) { return "SALMON"; }
				else if (entityId.equals("�ɥ�F")) { return "SHULKER"; }
				else if (entityId.equals("�e�b")) { return "PUFFERFISH"; }
				else if (entityId.equals("�u�\��")) { return "SKELETON_HORSE"; }
				else if (entityId.equals("�y���u�\")) { return "STRAY"; }
				else if (entityId.equals("���a��")) { return "TROPICAL_FISH"; }
				else if (entityId.equals("���t")) { return "TURTLE"; }
				else if (entityId.equals("��")) { return "VEX"; }
				else if (entityId.equals("�ùD�h")) { return "VINDICATOR"; }
				else if (entityId.equals("��s�u�\")) { return "WITHER_SKELETON"; }
				else if (entityId.equals("�L�Ͱ�")) { return "ZOMBIE_HORSE"; }
				else if (entityId.equals("�L�ͧ���")) { return "ZOMBIE_VILLAGER"; }
				return entityId;
			}
}
