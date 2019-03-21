package com.brian.MobDrop.Database;

public class GobalMessage {
	//公開顯示掉落物
	public boolean IsOpen;
	//公開顯示掉落物 要幾趴以下
	public int Chance;
	
	public boolean list_Chinese;
	
	public boolean command_cmd_show;
	
	public boolean command_old_list;
	
	public GobalMessage(boolean newIsOpen,int newChance,boolean command_cmd_show,boolean command_old_list,boolean list_Chinese) {
		this.IsOpen = newIsOpen;
		this.Chance = newChance;
		this.command_cmd_show = command_cmd_show;
		this.command_old_list = command_old_list;
		this.list_Chinese = list_Chinese;
	}
}
