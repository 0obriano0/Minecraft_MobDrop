package com.brian.MobDrop.Database;

public class showMessage {
	//公開顯示掉落物
	public boolean IsOpen;
	//公開顯示掉落物 要幾趴以下
	public int Chance;
	
	public showMessage(boolean newIsOpen,int newChance) {
		this.IsOpen = newIsOpen;
		this.Chance = newChance;
	}
}
