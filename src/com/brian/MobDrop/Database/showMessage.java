package com.brian.MobDrop.Database;

public class showMessage {
	//���}��ܱ�����
	public boolean IsOpen;
	//���}��ܱ����� �n�X�w�H�U
	public int Chance;
	//���O list �n���n��ܤ���
	public boolean list_Chinese;
	
	public showMessage(boolean newIsOpen,int newChance,boolean newlist_Chinese) {
		this.IsOpen = newIsOpen;
		this.Chance = newChance;
		this.list_Chinese = newlist_Chinese;
	}
}
