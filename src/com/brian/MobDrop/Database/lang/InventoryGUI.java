package com.brian.MobDrop.Database.lang;

import java.util.ArrayList;
import java.util.List;

public class InventoryGUI {
	public String MobsList = "�Ǫ������C��";
	public String ItemList = "���~�C��";
	public String close = "����";
	public String next = "�U�@��";
	public String previous = "�W�@��";
	public String menu = "�D���";
	public String back = "��^";
	public String back_menu = "�^����";
	public List<String> admin_lore;
	public String dropList = "�����C��";
	public String items = "�D��:";
	public String mobs = "�Ǫ�:";
	public String Item_Chance = "Chance:";
	public String Item_Quantity = "Quantity:";
	
	public InventoryGUI() {
		admin_lore = new ArrayList<String>();
		admin_lore.add("�I������");
		admin_lore.add("�����D��");
	}
}
