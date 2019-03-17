package com.brian.MobDrop.Database;

public class GobalMessage {
	//公開顯示掉落物
	public boolean IsOpen;
	//公開顯示掉落物 要幾趴以下
	public int Chance;
	//指令 list 要不要顯示中文
	public boolean list_Chinese;
	
	public GobalMessage(boolean newIsOpen,int newChance,boolean newlist_Chinese) {
		this.IsOpen = newIsOpen;
		this.Chance = newChance;
		this.list_Chinese = newlist_Chinese;
	}
}
