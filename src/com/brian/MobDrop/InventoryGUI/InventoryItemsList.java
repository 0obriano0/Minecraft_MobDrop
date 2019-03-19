package com.brian.MobDrop.InventoryGUI;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;

import com.brian.MobDrop.Database.DataBase;
import com.brian.MobDrop.Database.Items;
import com.brian.MobDrop.HashMap.HashMapItemList;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;
import fr.minuskube.inv.content.Pagination;
import fr.minuskube.inv.content.SlotIterator;

public class InventoryItemsList implements InventoryProvider{
	public static final SmartInventory INVENTORY = SmartInventory.builder()
            .id("Itemlist")
            .provider(new InventoryItemsList())
            .size(5, 9)
            .title(ChatColor.BLUE + "物品列表")
            .build();

    @Override
    public void init(Player player, InventoryContents contents) {
    	Pagination pagination = contents.pagination();
    	
        ClickableItem[] items = new ClickableItem[DataBase.ItemMap.size()];
        int index = 0;
        HashMapItemList ItemList = new HashMapItemList((HashMap<String, Items>) DataBase.ItemMap);
        
        for (Map.Entry<String, Items> entry:ItemList.list_Data) {
            //System.out.print(entry.getKey() + "\t" + entry.getValue());
            ItemStack item = entry.getValue().getResultItem();
            ItemMeta newItemMeta = item.getItemMeta();
            List<String> Lore =  newItemMeta.getLore();
            if(Lore == null)
            	Lore = new ArrayList<String>();
            Lore.add("");
            Lore.add("§7 - " + entry.getKey());
            newItemMeta.setLore(Lore);
        	item.setItemMeta(newItemMeta);
        	item.setAmount(1);
            items[index] = ClickableItem.empty(item);
        	index++;
        }
        
        pagination.setItems(items);
        pagination.setItemsPerPage(36);

        pagination.addToIterator(contents.newIterator(SlotIterator.Type.HORIZONTAL, 0, 0));
        
        
        contents.set(4, 0, ClickableItem.of(InventoryTools.createPageButton(Material.ACACIA_DOOR,"§a回目錄"),
                e -> InventoryMenu.INVENTORY.open(player)));
        contents.set(4, 3, ClickableItem.of(InventoryTools.createPageButton(Material.ARROW,"§a上一頁"),
                e -> INVENTORY.open(player, pagination.previous().getPage())));
        contents.set(4, 5, ClickableItem.of(InventoryTools.createPageButton(Material.ARROW,"§a下一頁"),
                e -> INVENTORY.open(player, pagination.next().getPage())));
    }

	@Override
	public void update(Player player, InventoryContents contents) {
		// TODO Auto-generated method stub
		
	}
}
