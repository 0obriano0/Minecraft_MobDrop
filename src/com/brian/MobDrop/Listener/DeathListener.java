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
import com.brian.MobDrop.DropItems.MobDropItems;

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
    	if (entityDeth.getKiller() != null &&
    		entityDeth.getKiller() instanceof Player)
    	{
    		Player killBy = entityDeth.getKiller();
    		String sEntitlyName = "";
    		sEntitlyName = entityDeth.getType().getName().toUpperCase();
    		// �P�_�O�_���������M��
    		if (DataBase.MobDropItemsMap.containsKey(sEntitlyName))
    		{
    			// ���o�������M��
    			List<MobDropItems> dropItems = DataBase.MobDropItemsMap.get(sEntitlyName);
    			MobDropItems MobDropItem;
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
        					entityDeth.getWorld().dropItemNaturally(entityDeth.getLocation(), MobDropItem_);
        					// ��ܱ����T��
        					if(DataBase.showMessage.IsOpen && DataBase.showMessage.Chance >= MobDropItem.Chance) {
        						DataBase.server.broadcastMessage("��b" +DataBase.detailStr + "��6" + "���ߡ�a " + killBy.getName() + "��6 �N��f" + DataBase.GetEntityName(sEntitlyName) + "��6�����ᱼ����a" + MobDropItem.ItemName + "��b" + items_num + "��6��!" );
    						}else {
    							DataBase.main.getLogger().info(AnsiColor.GREEN + "[LoadConfig] showMessage: " + DataBase.showMessage.IsOpen + "," + DataBase.showMessage.Chance + AnsiColor.RESET);
    						}
        					killBy.sendMessage("��b" +DataBase.detailStr + "��f " + DataBase.GetEntityName(sEntitlyName) + " ��6�����F��f" + MobDropItem.ItemName + "��b " + items_num + "��6��!");
        				}
    				//}
    			}
    		}
    	}
    }
}
