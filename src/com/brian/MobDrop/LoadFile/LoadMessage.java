package com.brian.MobDrop.LoadFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.brian.MobDrop.AnsiColor;
import com.brian.MobDrop.DataBase;

public class LoadMessage {
	// �D�nŪ���]�w��
	private FileConfiguration data = null;

	// �}�ɥ�
	private File filePreload = null;
	
	private String loadfilename = ".yml";
	
	public LoadMessage()
	{
		
	}
	
	public void ReLoadMessage() {
		// �T�{�ɮ׬O�_�s�b
	    this.filePreload = new File(DataBase.pluginMainDir + "Language/" + LoadConfig.Language + loadfilename);
	    if (this.filePreload.exists())
	    {
	    	// Ū���]�w�ɤ��e
	    	this.data = YamlConfiguration.loadConfiguration(this.filePreload);
	    }else
	    {
	    	// �ɮפ��s�b�A�إ߹w�]��
	    	CreateDefaultfile();
	    	// �����ɮ�
	    	this.filePreload = new File(DataBase.pluginMainDir + loadfilename);
	    	// Ū���]�w�ɤ��e
	    	this.data = YamlConfiguration.loadConfiguration(this.filePreload);
	    }
	}
	public void CreateDefaultfile() {
		try
		{
			File createDir = new File(DataBase.pluginMainDir);
			if (!createDir.exists())
			{
				boolean dirCreated = false;
	
				int retries = 15;
	
				while ((!dirCreated) && (retries != 0))
				{
					retries--;
					dirCreated = createDir.mkdir();
				}
	
				if (!dirCreated)
				{
					DataBase.main.getLogger().info(AnsiColor.RED + "[CreateDefaultFile]Message.yml failed to create. No permissions?" + AnsiColor.RESET);
					return;
				}
			}
			
			FileOutputStream fos = new FileOutputStream(DataBase.pluginMainDir + loadfilename);
		    fos.write(new byte[]{(byte)0xEF, (byte)0xBB, (byte)0xBF});
		    OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		    
			BufferedWriter out = new BufferedWriter(osw);
			
			out.write("items:\r\n");
		    out.close();
		}
		catch (Exception e)
		{
			System.out.println(DataBase.detailStr + "[CreateDefaultConfig]Error on create default config!");
		}
	}
}
