package com.brian.MobDrop.Command.CommandsList;

public class CommandsList {
	private static MainList MainList = new MainList();
	
	public CommandsList(){
		
	}

	public MainList getMainList() {
		return MainList;
	}

	public static void setMainList(MainList mainList) {
		MainList = mainList;
	}
}
