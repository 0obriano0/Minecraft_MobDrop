package com.brian.MobDrop.Database;

import org.bukkit.inventory.ItemStack;

public class MobItemList {
	public Items Item;
	// �o�쪺���~�ƶq
	public int Quantity;
	public int Quantity_max;
	// �����v
	public double Chance;
	
	public MobItemList(int Quantity, int Quantity_max, double Chance, Items Item) {
		this.Quantity = Quantity;
		this.Quantity_max = Quantity_max;
		this.Chance = Chance;
		this.Item = Item;
	}
	
	public ItemStack getResultItem() {
		ItemStack ResultItem = Item.getResultItem();
		ResultItem.setAmount(this.Quantity);
		return ResultItem;
	}
}
