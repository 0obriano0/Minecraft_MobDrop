package com.brian.MobDrop.DropItems;

import java.util.List;

import org.bukkit.inventory.ItemStack;

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
	this.Chance = newChance;
	}
	
	@SuppressWarnings("deprecation")
	public ItemStack getResultItem() {
		return null;
	}
}
