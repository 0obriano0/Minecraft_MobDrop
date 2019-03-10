package com.brian.MobDrop.Database;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.Server;

import com.brian.MobDrop.Main;
import com.brian.MobDrop.DropItems.MobDropItems;
import com.brian.MobDrop.LoadFile.LoadConfig;
import com.brian.MobDrop.LoadFile.LoadItems;

public class DataBase {
	// ¥D´¡¥ó
		public static Main main;
		
		// ³]©wÀÉ
		public static LoadConfig LoadConfig;
		public static LoadItems LoadItems;
		
		// ¦øªA¾¹
		public static Server server;
		
		// ´¡¥ó¼ÐÃD
		public static String detailStr = "[MobDrop]";
		
		// ´¡¥ó¥Ø¿ý
		public static String pluginMainDir = "./plugins/MobDrop/";
		
		//«ü¥O¥Ø¿ý
		public static com.brian.MobDrop.Command.CommandsList.CommandsList CommandsList = new com.brian.MobDrop.Command.CommandsList.CommandsList();

		// ±¼¸¨ª««~²M³æ
		public static Map<String, List<MobDropItems>> MobDropItemsMap = new HashMap<String, List<MobDropItems>>();
		
		//¤½¶}Åã¥Ü°T®§
		public static showMessage showMessage;
		
		// Åã¥Ü°T®§
		public static void Print(String msg)
		{
			System.out.print(detailStr + msg);
		}
		
		// ¨ú±o¥Íª«¦WºÙ(¤¤¤å)
		public static String GetEntityName(String entityId)
		{
			if (entityId.equals("CREEPER")) { return "­W¤O©È"; }
			else if (entityId.equals("SKELETON")) { return "¾uÅ\"; }
			else if (entityId.equals("SPIDER")) { return "»jµï"; }
			else if (entityId.equals("GIANT")) { return "¥¨¤H"; }
			else if (entityId.equals("ZOMBIE")) { return "íL«Í"; }
			else if (entityId.equals("SLIME")) { return "¥vµÜ©i"; }
			else if (entityId.equals("GHAST")) { return "«ÕÆF¤ô¥À"; }
			else if (entityId.equals("ZOMBIE_PIGMAN")) { return "íL«Í½Þ¤H"; }
			else if (entityId.equals("ENDERMAN")) { return "²×¬É¨ÏªÌ"; }
			else if (entityId.equals("CAVE_SPIDER")) { return "¬}¥Þ»jµï"; }
			else if (entityId.equals("SILVERFISH")) { return "¥ÛÀYÂÎ"; }
			else if (entityId.equals("BLAZE")) { return "¯PµK¨ÏªÌ"; }
			else if (entityId.equals("MAGMA_CUBE")) { return "¯PµK¥vµÜ©i"; }
			else if (entityId.equals("ENDERDRAGON")) { return "²×¬ÉÀs"; }
			else if (entityId.equals("WITHERBOSS")) { return "­ä¹s©Ç"; }
			else if (entityId.equals("WITCH")) { return "§Å±C"; }
			else if (entityId.equals("BAT")) { return "½¿½»"; }
			else if (entityId.equals("PIG")) { return "½Þ"; }
			else if (entityId.equals("SHEEP")) { return "¦Ï"; }
			else if (entityId.equals("COW")) { return "¤û"; }
			else if (entityId.equals("CHICKEN")) { return "Âû"; }
			else if (entityId.equals("SQUID")) { return "³¹³½"; }
			else if (entityId.equals("WOLF")) { return "¯T"; }
			else if (entityId.equals("MOOSHROOM")) { return "Ä¨Û£¤û"; }
			else if (entityId.equals("SNOWMAN")) { return "³·¤H"; }
			else if (entityId.equals("OCELOT")) { return "¿ß"; }
			else if (entityId.equals("VILLAGERGOLEM")) { return "ÅK¤H"; }
			else if (entityId.equals("HORSE")) { return "°¨"; }
			else if (entityId.equals("VILLAGER")) { return "§ø¥Á"; }
			else if (entityId.equals("COD")) { return "÷«³½"; }
			else if (entityId.equals("DOLPHIN")) { return "®ü³b"; }
			else if (entityId.equals("DONKEY")) { return "Æj¤l"; }
			else if (entityId.equals("DROWNED")) { return "¨I«Í"; }
			else if (entityId.equals("ELDER_GUARDIAN")) { return "­ì¥j²`®ü¦u½Ã"; }
			else if (entityId.equals("ENDERMITE")) { return "²×¬ÉÂÎ"; }
			else if (entityId.equals("EVOKER")) { return "³êÅ]ªÌ"; }
			else if (entityId.equals("GUARDIAN")) { return "²`®ü¦u½Ã"; }
			else if (entityId.equals("HUSK")) { return "«Í´ß"; }
			else if (entityId.equals("LLAMA")) { return "¦Ï¾m"; }
			else if (entityId.equals("MULE")) { return "Å["; }
			else if (entityId.equals("PARROT")) { return "ÆxÄM"; }
			else if (entityId.equals("PHANTOM")) { return "©]¾y"; }
			else if (entityId.equals("POLAR_BEAR")) { return "¥_·¥ºµ"; }
			else if (entityId.equals("PUFFERFISH")) { return "ªe³b"; }
			else if (entityId.equals("RABBIT")) { return "¨ß¤l"; }
			else if (entityId.equals("SALMON")) { return "ÂD³½"; }
			else if (entityId.equals("SHULKER")) { return "¬É¥ñ°F"; }
			else if (entityId.equals("PUFFERFISH")) { return "ªe³b"; }
			else if (entityId.equals("SKELETON_HORSE")) { return "¾uÅ\°¨"; }
			else if (entityId.equals("STRAY")) { return "¬y®ö¾uÅ\"; }
			else if (entityId.equals("TROPICAL_FISH")) { return "¼ö±a³½"; }
			else if (entityId.equals("TURTLE")) { return "®üÀt"; }
			else if (entityId.equals("VEX")) { return "°­"; }
			else if (entityId.equals("VINDICATOR")) { return "½Ã¹D¤h"; }
			else if (entityId.equals("WITHER_SKELETON")) { return "­ä¹s¾uÅ\"; }
			else if (entityId.equals("ZOMBIE_HORSE")) { return "íL«Í°¨"; }
			else if (entityId.equals("ZOMBIE_VILLAGER")) { return "íL«Í§ø¥Á"; }
			return entityId;
		}
		
		// ¨ú±o¥Íª«¦WºÙ(¤¤¤å)
		public static String getEntityNameGameCode(String entityId)
			{
				if (entityId.equals("­W¤O©È")) { return "CREEPER"; }
				else if (entityId.equals("¾uÅ\")) { return "SKELETON"; }
				else if (entityId.equals("»jµï")) { return "SPIDER"; }
				else if (entityId.equals("¥¨¤H")) { return "GIANT"; }
				else if (entityId.equals("íL«Í")) { return "ZOMBIE"; }
				else if (entityId.equals("¥vµÜ©i")) { return "SLIME"; }
				else if (entityId.equals("«ÕÆF¤ô¥À")) { return "GHAST"; }
				else if (entityId.equals("íL«Í½Þ¤H")) { return "ZOMBIE_PIGMAN"; }
				else if (entityId.equals("²×¬É¨ÏªÌ")) { return "ENDERMAN"; }
				else if (entityId.equals("¬}¥Þ»jµï")) { return "CAVE_SPIDER"; }
				else if (entityId.equals("¥ÛÀYÂÎ")) { return "SILVERFISH"; }
				else if (entityId.equals("¯PµK¨ÏªÌ")) { return "BLAZE"; }
				else if (entityId.equals("¯PµK¥vµÜ©i")) { return "MAGMA_CUBE"; }
				else if (entityId.equals("²×¬ÉÀs")) { return "ENDERDRAGON"; }
				else if (entityId.equals("­ä¹s©Ç")) { return "WITHERBOSS"; }
				else if (entityId.equals("§Å±C")) { return "WITCH"; }
				else if (entityId.equals("½¿½»")) { return "BAT"; }
				else if (entityId.equals("½Þ")) { return "PIG"; }
				else if (entityId.equals("¦Ï")) { return "SHEEP"; }
				else if (entityId.equals("¤û")) { return "COW"; }
				else if (entityId.equals("Âû")) { return "CHICKEN"; }
				else if (entityId.equals("³¹³½")) { return "SQUID"; }
				else if (entityId.equals("¯T")) { return "WOLF"; }
				else if (entityId.equals("Ä¨Û£¤û")) { return "MOOSHROOM"; }
				else if (entityId.equals("³·¤H")) { return "SNOWMAN"; }
				else if (entityId.equals("¿ß")) { return "OCELOT"; }
				else if (entityId.equals("ÅK¤H")) { return "VILLAGERGOLEM"; }
				else if (entityId.equals("°¨")) { return "HORSE"; }
				else if (entityId.equals("§ø¥Á")) { return "VILLAGER"; }
				else if (entityId.equals("÷«³½")) { return "COD"; }
				else if (entityId.equals("®ü³b")) { return "DOLPHIN"; }
				else if (entityId.equals("Æj¤l")) { return "DONKEY"; }
				else if (entityId.equals("¨I«Í")) { return "DROWNED"; }
				else if (entityId.equals("­ì¥j²`®ü¦u½Ã")) { return "ELDER_GUARDIAN"; }
				else if (entityId.equals("²×¬ÉÂÎ")) { return "ENDERMITE"; }
				else if (entityId.equals("³êÅ]ªÌ")) { return "EVOKER"; }
				else if (entityId.equals("²`®ü¦u½Ã")) { return "GUARDIAN"; }
				else if (entityId.equals("«Í´ß")) { return "HUSK"; }
				else if (entityId.equals("¦Ï¾m")) { return "LLAMA"; }
				else if (entityId.equals("Å[")) { return "MULE"; }
				else if (entityId.equals("ÆxÄM")) { return "PARROT"; }
				else if (entityId.equals("©]¾y")) { return "PHANTOM"; }
				else if (entityId.equals("¥_·¥ºµ")) { return "POLAR_BEAR"; }
				else if (entityId.equals("ªe³b")) { return "PUFFERFISH"; }
				else if (entityId.equals("¨ß¤l")) { return "RABBIT"; }
				else if (entityId.equals("ÂD³½")) { return "SALMON"; }
				else if (entityId.equals("¬É¥ñ°F")) { return "SHULKER"; }
				else if (entityId.equals("ªe³b")) { return "PUFFERFISH"; }
				else if (entityId.equals("¾uÅ\°¨")) { return "SKELETON_HORSE"; }
				else if (entityId.equals("¬y®ö¾uÅ\")) { return "STRAY"; }
				else if (entityId.equals("¼ö±a³½")) { return "TROPICAL_FISH"; }
				else if (entityId.equals("®üÀt")) { return "TURTLE"; }
				else if (entityId.equals("°­")) { return "VEX"; }
				else if (entityId.equals("½Ã¹D¤h")) { return "VINDICATOR"; }
				else if (entityId.equals("­ä¹s¾uÅ\")) { return "WITHER_SKELETON"; }
				else if (entityId.equals("íL«Í°¨")) { return "ZOMBIE_HORSE"; }
				else if (entityId.equals("íL«Í§ø¥Á")) { return "ZOMBIE_VILLAGER"; }
				return entityId;
			}
}
