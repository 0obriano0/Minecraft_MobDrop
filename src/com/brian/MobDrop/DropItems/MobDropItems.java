package com.brian.MobDrop.DropItems;

import java.util.List;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

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
	public int Quantity_max;
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
				   int newQuantity_max,
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
	this.Quantity_max = newQuantity_max;
	this.Chance = newChance;
	}
	
	@SuppressWarnings("deprecation")
	public ItemStack getResultItem() {
		// 產生物品用
		ItemStack ResultItem;
	    ItemMeta newItemMeta;
	    LeatherArmorMeta LeatherArmorMeta;
		
		// 合成後得到的物品設定
	    
		if (this.ItemSubID != 0)
		{ ResultItem = new ItemStack(Material.getMaterial(ItemRealname), 1, this.ItemSubID); }
		else
		{ ResultItem = new ItemStack(Material.getMaterial(ItemRealname)); }
		
		// 判斷是否要設定顏色
		if(ItemRealname.indexOf(":") != -1) {
			if(ItemRealname.split("_")[0].equals("leather")) {
				LeatherArmorMeta = (LeatherArmorMeta)ResultItem.getItemMeta();
				LeatherArmorMeta.setColor(Color.fromRGB(this.Red, this.Green, this.Blue));
				ResultItem.setItemMeta(LeatherArmorMeta);
			}
		}
		
		newItemMeta = ResultItem.getItemMeta();
		// 附魔
		for (int i = 0; i < this.Enchants.size(); i++)
		{
			String[] EnchantsParts = this.Enchants.get(i).split(":");
			int level = Integer.parseInt(EnchantsParts[1]);
			Enchantment enchantment = Enchantment.getByName(EnchantsParts[0]);
			newItemMeta.addEnchant(enchantment, level, true);
		}
		// 名稱
		if (this.UseOriginalName == 0)
		{
			newItemMeta.setDisplayName(this.ItemName);
		}
		// 說明
		if (this.ItemLores.size() > 0)
		{
			newItemMeta.setLore(this.ItemLores);
		}
		// 寫入資料
		ResultItem.setItemMeta(newItemMeta);
    	// 設定數量
		ResultItem.setAmount(this.Quantity);
	    // 設定耐久為最高
		ResultItem.setDurability((short)0);
		// 回傳
		return ResultItem;
	}
}
