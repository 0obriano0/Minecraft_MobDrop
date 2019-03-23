package com.brian.MobDrop.Database.lang;

import java.util.ArrayList;
import java.util.List;

public class InventoryGUI {
	public String MobsList = "怪物掉落列表";
	public String ItemList = "物品列表";
	public String close = "關閉";
	public String next = "下一頁";
	public String previous = "上一頁";
	public String menu = "回首頁";
	public String back = "返回";
	public List<String> admin_lore;
	
	public InventoryGUI() {
		admin_lore = new ArrayList<String>();
		admin_lore.add("點擊左鍵");
		admin_lore.add("拿取道具");
	}
}
