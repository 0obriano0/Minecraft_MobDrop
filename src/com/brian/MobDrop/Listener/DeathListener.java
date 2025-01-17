﻿package com.brian.MobDrop.Listener;

import java.util.List;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;
import org.bukkit.inventory.ItemStack;

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
    	if (entityDeth.getKiller() != null && entityDeth.getKiller() instanceof Player){
    		Player killBy = entityDeth.getKiller();
    		String sEntitlyName = "";
    		try {
	    		if (entityDeth.getCustomName() != null) {
	    			if(DataBase.MobItemMap.containsKey(entityDeth.getCustomName().toUpperCase()))
	    				sEntitlyName = entityDeth.getCustomName().toUpperCase();
	    		}else
	    			sEntitlyName = entityDeth.getType().getName().toUpperCase();
    		} catch (NullPointerException e) {
    			return;
    		}
    		
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
        					if(killBy.getInventory().firstEmpty() == -1)
        						entityDeth.getWorld().dropItemNaturally(entityDeth.getLocation(), MobDropItem_);
        					else
        						killBy.getInventory().addItem(MobDropItem_);
        					// 顯示掉落訊息
        					
        					if(DataBase.Config.IsOpen && DataBase.Config.Chance >= MobDropItem.Chance) 
        						DataBase.server.broadcastMessage("§b" + DataBase.language.Plugin_name + " " + formatmessage(DataBase.language.message.Gobal_mobDropItem, killBy, sEntitlyName, MobDropItem, MobDropItem_));
    						
        					killBy.sendMessage("§b" + DataBase.language.Plugin_name + "§f " + " " + formatmessage(DataBase.language.message.mobDropItem, killBy, sEntitlyName, MobDropItem, MobDropItem_));
        				}
    				//}
    			}
    		}
    	}
    }
	
	private String formatmessage(String message, Player player,String MobName,MobItemList MobDropItem,ItemStack Item) {
		return message.replaceAll("%player%", player.getName()).replaceAll("%mob%",DataBase.GetEntityName(MobName)).replaceAll("%item%",MobDropItem.Item.ItemName).replaceAll("%item_num%","" + Item.getAmount());
	}
}
