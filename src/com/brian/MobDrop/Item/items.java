package com.brian.MobDrop.Item;

import java.util.List;

public class items {
	public String Itemname;
	public boolean UseCustomName;
	public String ItemRealname;
	public List<String> ItemLores; 
	public List<String> Enchants;
	
	items(String Itemname, boolean UseCustomName, String ItemRealname, List<String> ItemLores, List<String> Enchants){
		this.Itemname = Itemname;
		this.UseCustomName = UseCustomName;
		this.ItemRealname = ItemRealname;
		this.ItemLores = ItemLores;
		this.Enchants = Enchants;
	}
	
	public items(){
		
	}
}
