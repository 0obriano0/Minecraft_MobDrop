package com.brian.MobDrop.InventoryGUI;

import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import com.brian.MobDrop.Database.DataBase;

import fr.minuskube.inv.ClickableItem;
import fr.minuskube.inv.SmartInventory;
import fr.minuskube.inv.content.InventoryContents;
import fr.minuskube.inv.content.InventoryProvider;

public class InventoryMenu implements InventoryProvider{
	public static final SmartInventory INVENTORY = SmartInventory.builder()
            .id("Menu")
            .provider(new InventoryMenu())
            .size(3, 9)
            .title(ChatColor.BLUE + DataBase.language.Inventory.menu)
            .build();
	
	@Override
	public void init(Player player, InventoryContents contents) {
		contents.fillBorders(ClickableItem.empty(new ItemStack(Material.BLACK_STAINED_GLASS_PANE)));
		
		contents.set(1, 2, ClickableItem.of(InventoryTools.createPageButton(Material.ITEM_FRAME,"§a" + DataBase.language.Inventory.ItemList,"§a - " + DataBase.language.Inventory.items + " §f" + DataBase.ItemMap.size()),
                e -> InventoryItemsList.INVENTORY.open(player)));
		contents.set(1, 6, ClickableItem.of(InventoryTools.createPageButton(Material.ZOMBIE_HEAD,"§a" + DataBase.language.Inventory.MobsList,"§a - " + DataBase.language.Inventory.mobs + " §f" + DataBase.MobItemMap.size()),
                e -> InventoryMobsList.INVENTORY.open(player)));
		contents.set(2, 8, ClickableItem.of(InventoryTools.createPageButton(Material.BARRIER,"§a" + DataBase.language.Inventory.close),
                e -> InventoryMobsList.INVENTORY.close(player)));
	}

	@Override
	public void update(Player player, InventoryContents contents) {
		// TODO Auto-generated method stub
		
	}

}
