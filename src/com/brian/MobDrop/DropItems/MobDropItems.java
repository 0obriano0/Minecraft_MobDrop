package com.brian.MobDrop.DropItems;

import java.util.List;

import org.bukkit.inventory.ItemStack;

public class MobDropItems {
	//物品名稱
	public String ItemName;
	//物品名稱
	public int UseOriginalName;
	// 物品說明
	public List<String> ItemLores;
	// 物品附屬ID(原始ID)
	public byte ItemSubID;
	//物品名稱(系統名稱)
	public String ItemRealname;
	// 顏色
	public byte Red;
	public byte Green;
	public byte Blue;
	// 物品附魔
	public List<String> Enchants;
	// 得到的物品數量
	public int Quantity;
	// 掉落率
	public double Chance;
	
	public MobDropItems(String newItemName,
				   int newUseOriginalName,
				   List<String> newItemLores,
				   String newItemRealname,
				   byte newRed,
				   byte newGreen,
				   byte newBlue,
				   byte newItemSubID,
				   List<String> newEnchants,
				   int newQuantity,
				   double newChance)
	{	    
	// 設定資料
	this.ItemName = newItemName;
	this.UseOriginalName = newUseOriginalName;
	this.ItemLores = newItemLores;
	this.ItemRealname = newItemRealname;
	this.Red = newRed;
	this.Green = newGreen;
	this.Blue = newBlue;
	this.ItemSubID = newItemSubID;
	this.Enchants = newEnchants;
	this.Quantity = newQuantity;
	this.Chance = newChance;
	}
	
	@SuppressWarnings("deprecation")
	public ItemStack getResultItem() {
		return null;
	}
}
