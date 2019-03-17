package com.brian.MobDrop.Listener;

import java.util.List;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

import com.brian.MobDrop.AnsiColor;
import com.brian.MobDrop.Database.DataBase;
import com.brian.MobDrop.Database.MobItemList;

public class DeathListener implements Listener{
	public DeathListener()
    {
    	
	}
	
	@SuppressWarnings("deprecation")
	@EventHandler
    public void onEntityDeathEvents(EntityDeathEvent event)
    {
		LivingEntity entityDeth = event.getEntity();
    	// 判斷是否為玩家殺死的
    	if (entityDeth.getKiller() != null &&
    		entityDeth.getKiller() instanceof Player)
    	{
    		Player killBy = entityDeth.getKiller();
    		String sEntitlyName = "";
    		sEntitlyName = entityDeth.getType().getName().toUpperCase();
    		// 判斷是否有掉落物清單
    		if (DataBase.MobItemMap.containsKey(sEntitlyName))
    		{
    			// 取得掉落物清單
    			List<MobItemList> dropItems = DataBase.MobItemMap.get(sEntitlyName);
    			MobItemList MobDropItem;
    			// 迴圈判斷是否掉落物品
    			for (int i = 0; i < dropItems.size(); i++)
    			{
    				MobDropItem = dropItems.get(i);
    				// 判斷世界是否正確
    				//if (customItem.OnlyWorld.equals("") || customItem.OnlyWorld.toUpperCase().equals(entityDeth.getWorld().getName().toUpperCase()))
    				//{
    					// 取得基數(從1~10000中抽一個號碼)
        				int iChance = (int)(Math.random() * 10000 + 1);
        				// 判斷物品掉落機率(乘以100後)是否小於基數
        				if (iChance <= (MobDropItem.Chance * 100))
        				{	
        					// 判定掉落數量
        					ItemStack MobDropItem_ = MobDropItem.getResultItem();
            				int items_num = 1;
        					if(MobDropItem.Quantity < MobDropItem.Quantity_max) {
        						items_num = (int)(Math.random() * (MobDropItem.Quantity_max-MobDropItem.Quantity+1) + MobDropItem.Quantity);
            					MobDropItem_.setAmount(items_num);
        					}
        					// 判定掉落
        					entityDeth.getWorld().dropItemNaturally(entityDeth.getLocation(), MobDropItem_);
        					// 顯示掉落訊息
        					if(DataBase.GobalMessage.IsOpen && DataBase.GobalMessage.Chance >= MobDropItem.Chance) {
        						DataBase.server.broadcastMessage("§b" + DataBase.detailStr + " §6" + "恭喜§a " + killBy.getName() + "§6 將§f" + DataBase.GetEntityName(sEntitlyName) + "§6殺死後掉落§a" + MobDropItem.Item.ItemName + "§b " + items_num + "§6個!" );
    						}else {
    							DataBase.main.getLogger().info(entityDeth.getName());
    							DataBase.main.getLogger().info(AnsiColor.GREEN + "[玩家獲取道具] " + killBy.getName() + " 將" + DataBase.GetEntityName(sEntitlyName) + "殺死後掉落 " + MobDropItem.Item + " "+ items_num + "個!" + AnsiColor.RESET);
    						}
        					killBy.sendMessage("§b" + DataBase.detailStr + "§f " + DataBase.GetEntityName(sEntitlyName) + " §6掉落了§f" + MobDropItem.Item.ItemName + "§b " + items_num + "§6個!");
        				}
    				//}
    			}
    		}
    	}
    }
}
