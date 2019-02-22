package com.brian.MobDrop.Listener;

import java.util.List;

import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDeathEvent;

import com.brian.MobDrop.DataBase;
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
        					// �P�w����
        					entityDeth.getWorld().dropItemNaturally(entityDeth.getLocation(), MobDropItem.getResultItem());
        					// ��ܱ����T��
        					killBy.sendMessage(DataBase.GetEntityName(sEntitlyName) + "��6�����F��f" + MobDropItem.ItemName);
        				}
    				//}
    			}
    		}
    	}
    }
}
