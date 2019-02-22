package com.brian.MobDrop;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Server;

import com.brian.MobDrop.DropItems.MobDropItems;
import com.brian.MobDrop.LoadFile.LoadConfig;
import com.brian.MobDrop.LoadFile.LoadItems;

public class DataBase {
	// �D����
		public static Main main;
		
		// �]�w��
		public static LoadConfig loadConfig;
		public static LoadItems LoadItems;
		
		// ���A��
		public static Server server;
		
		// ������D
		public static String detailStr = "[MobDrop]";
		
		// ����ؿ�
		public static String pluginMainDir = "./plugins/MobDrop/";

		// �������~�M��
		public static Map<String, List<MobDropItems>> MobDropItemsMap = new HashMap<String, List<MobDropItems>>();

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
}
