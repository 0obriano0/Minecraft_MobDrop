package com.brian.MobDrop.Listener;

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
    	// �P�_�O�_�����a������
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
    		
    		// �P�_�O�_���������M��
    		if (DataBase.MobItemMap.containsKey(sEntitlyName))
    		{
    			// ���o�������M��
    			List<MobItemList> dropItems = DataBase.MobItemMap.get(sEntitlyName);
    			MobItemList MobDropItem;
    			// �j��P�_�O�_�������~
    			for (int i = 0; i < dropItems.size(); i++)
    			{
    				MobDropItem = dropItems.get(i);
    				// �P�_�@�ɬO�_���T
    				//if (customItem.OnlyWorld.equals("") || customItem.OnlyWorld.toUpperCase().equals(entityDeth.getWorld().getName().toUpperCase()))
    				//{
    					// ���o���(�q1~10000����@�Ӹ��X)
        				int iChance = (int)(Math.random() * 10000 + 1);
        				// �P�_���~�������v(���H100��)�O�_�p����
        				if (iChance <= (MobDropItem.Chance * 100))
        				{	
        					// �P�w�����ƶq
        					ItemStack MobDropItem_ = MobDropItem.getResultItem();
            				int items_num = 1;
        					if(MobDropItem.Quantity < MobDropItem.Quantity_max) {
        						items_num = (int)(Math.random() * (MobDropItem.Quantity_max-MobDropItem.Quantity+1) + MobDropItem.Quantity);
            					MobDropItem_.setAmount(items_num);
        					}
        					// �P�w����
        					if(killBy.getInventory().firstEmpty() == -1)
        						entityDeth.getWorld().dropItemNaturally(entityDeth.getLocation(), MobDropItem_);
        					else
        						killBy.getInventory().addItem(MobDropItem_);
        					// ��ܱ����T��
        					
        					if(DataBase.Config.IsOpen && DataBase.Config.Chance >= MobDropItem.Chance) 
        						DataBase.server.broadcastMessage("��b" + DataBase.language.Plugin_name + " " + formatmessage(DataBase.language.message.Gobal_mobDropItem, killBy, sEntitlyName, MobDropItem, MobDropItem_));
    						
        					killBy.sendMessage("��b" + DataBase.language.Plugin_name + "��f " + " " + formatmessage(DataBase.language.message.mobDropItem, killBy, sEntitlyName, MobDropItem, MobDropItem_));
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
