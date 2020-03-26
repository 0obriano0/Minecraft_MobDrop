package com.brian.MobDrop.LoadFile;

import com.brian.MobDrop.AnsiColor;
import com.brian.MobDrop.Database.DataBase;

public class tools {
	public static void Setprint(String title, String Name, int totle, int Success, int Fail) {
		DataBase.main.getLogger().info(AnsiColor.CYAN + "[" + title + "] " + AnsiColor.GREEN + Name + " load " + AnsiColor.PURPLE + "Totle: " + AnsiColor.WHITE + totle + AnsiColor.YELLOW + "  Success: " + AnsiColor.WHITE + Success + AnsiColor.RED + "  Fail:  " + AnsiColor.WHITE + Fail + AnsiColor.RESET);
	}
}
