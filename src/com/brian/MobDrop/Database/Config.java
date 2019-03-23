package com.brian.MobDrop.Database;

public class Config {
	//公開顯示掉落物
	public boolean IsOpen;
	//公開顯示掉落物 要幾趴以下
	public int Chance;
	public boolean list_Chinese;
	public boolean command_cmd_show;
	public boolean command_old_list;
	public String lang = "zh_TW";
	
	public Config(boolean newIsOpen,int newChance,boolean command_cmd_show,boolean command_old_list,boolean list_Chinese,String lang) {
		this.IsOpen = newIsOpen;
		this.Chance = newChance;
		this.command_cmd_show = command_cmd_show;
		this.command_old_list = command_old_list;
		this.list_Chinese = list_Chinese;
		this.lang = lang;
	}
}
