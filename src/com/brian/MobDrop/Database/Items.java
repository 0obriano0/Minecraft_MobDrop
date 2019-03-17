package com.brian.MobDrop.Database;

import java.util.List;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Items {
	//物品名稱
	public String ItemName;
	//物品名稱
	boolean UseCustomName;
	// 物品說明
	public List<String> ItemLores;
	//物品名稱(系統名稱)
	public String ItemRealname;
	// 顏色
	public int Red;
	public int Green;
	public int Blue;
	// 物品附魔
	public List<String> Enchants;
	
	public Items(String ItemName, boolean UseCustomName, String ItemRealname, List<String> ItemLores, int Red, int Green, int Blue,List<String> Enchants){
		this.ItemName = ItemName;
		this.UseCustomName = UseCustomName;
		this.ItemRealname = ItemRealname;
		this.ItemLores = ItemLores;
		this.Red = Red;
		this.Green = Green;
		this.Blue = Blue;
		this.Enchants = Enchants;
	}
	
	@SuppressWarnings("deprecation")
	public ItemStack getResultItem() {
		// 產生物品用
		ItemStack ResultItem;
	    ItemMeta newItemMeta;
	    LeatherArmorMeta LeatherArmorMeta;
		
		// 合成後得到的物品設定
	    ResultItem = new ItemStack(Material.getMaterial(ItemRealname));
		
		// 判斷是否要設定顏色
		if(ItemRealname.split("_")[0].equals("LEATHER")) {
			LeatherArmorMeta = (LeatherArmorMeta)ResultItem.getItemMeta();
			LeatherArmorMeta.setColor(Color.fromRGB(this.Red, this.Green, this.Blue));
			ResultItem.setItemMeta(LeatherArmorMeta);
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
		if (!this.UseCustomName)
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
	    // 設定耐久為最高
		ResultItem.setDurability((short)0);
		// 回傳
		return ResultItem;
	}
}
