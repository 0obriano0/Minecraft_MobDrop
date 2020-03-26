package com.brian.MobDrop.Database;

import java.util.HashMap;
import java.util.Map;

import com.brian.MobDrop.Database.lang.InventoryGUI;
import com.brian.MobDrop.Database.lang.message;

public class language {
	public String Plugin_name = "[MobDrop]";
	
	public InventoryGUI Inventory = new InventoryGUI();
	public message message = new message();
	
	public Map<String,String> IDMobtoMessage = new HashMap<String,String>();
	public Map<String,String> MessagetoIDMob = new HashMap<String,String>();
	
	public void setPlugin(String Plugin_name){
		this.Plugin_name = Plugin_name;
	}
}
