package com.brian.MobDrop.DropItems;

import java.util.List;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class MobDropItems {
	//���~�W��
	public String ItemName;
	//���~�W��
	public int UseOriginalName;
	// ���~����
	public List<String> ItemLores;
	// ���~����ID(��lID)
	public byte ItemSubID;
	//���~�W��(�t�ΦW��)
	public String ItemRealname;
	// �C��
	public byte Red;
	public byte Green;
	public byte Blue;
	// ���~���]
	public List<String> Enchants;
	// �o�쪺���~�ƶq
	public int Quantity;
	public int Quantity_max;
	// �����v
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
	// �]�w���
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
		// ���ͪ��~��
		ItemStack ResultItem;
	    ItemMeta newItemMeta;
	    LeatherArmorMeta LeatherArmorMeta;
		
		// �X����o�쪺���~�]�w
	    
		if (this.ItemSubID != 0)
		{ ResultItem = new ItemStack(Material.getMaterial(ItemRealname), 1, this.ItemSubID); }
		else
		{ ResultItem = new ItemStack(Material.getMaterial(ItemRealname)); }
		
		// �P�_�O�_�n�]�w�C��
		if(ItemRealname.indexOf(":") != -1) {
			if(ItemRealname.split("_")[0].equals("leather")) {
				LeatherArmorMeta = (LeatherArmorMeta)ResultItem.getItemMeta();
				LeatherArmorMeta.setColor(Color.fromRGB(this.Red, this.Green, this.Blue));
				ResultItem.setItemMeta(LeatherArmorMeta);
			}
		}
		
		newItemMeta = ResultItem.getItemMeta();
		// ���]
		for (int i = 0; i < this.Enchants.size(); i++)
		{
			String[] EnchantsParts = this.Enchants.get(i).split(":");
			int level = Integer.parseInt(EnchantsParts[1]);
			Enchantment enchantment = Enchantment.getByName(EnchantsParts[0]);
			newItemMeta.addEnchant(enchantment, level, true);
		}
		// �W��
		if (this.UseOriginalName == 0)
		{
			newItemMeta.setDisplayName(this.ItemName);
		}
		// ����
		if (this.ItemLores.size() > 0)
		{
			newItemMeta.setLore(this.ItemLores);
		}
		// �g�J���
		ResultItem.setItemMeta(newItemMeta);
    	// �]�w�ƶq
		ResultItem.setAmount(this.Quantity);
	    // �]�w�@�[���̰�
		ResultItem.setDurability((short)0);
		// �^��
		return ResultItem;
	}
}
