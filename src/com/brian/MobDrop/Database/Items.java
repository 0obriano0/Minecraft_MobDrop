package com.brian.MobDrop.Database;

import java.util.List;

import org.bukkit.Color;
import org.bukkit.Material;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.LeatherArmorMeta;

public class Items {
	//���~�W��
	public String ItemName;
	//���~�W��
	boolean UseCustomName;
	// ���~����
	public List<String> ItemLores;
	//���~�W��(�t�ΦW��)
	public String ItemRealname;
	// �C��
	public int Red;
	public int Green;
	public int Blue;
	// ���~���]
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
		// ���ͪ��~��
		ItemStack ResultItem;
	    ItemMeta newItemMeta;
	    LeatherArmorMeta LeatherArmorMeta;
		
		// �X����o�쪺���~�]�w
	    ResultItem = new ItemStack(Material.getMaterial(ItemRealname));
		
		// �P�_�O�_�n�]�w�C��
		if(ItemRealname.split("_")[0].equals("LEATHER")) {
			LeatherArmorMeta = (LeatherArmorMeta)ResultItem.getItemMeta();
			LeatherArmorMeta.setColor(Color.fromRGB(this.Red, this.Green, this.Blue));
			ResultItem.setItemMeta(LeatherArmorMeta);
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
		if (!this.UseCustomName)
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
	    // �]�w�@�[���̰�
		ResultItem.setDurability((short)0);
		// �^��
		return ResultItem;
	}
}
