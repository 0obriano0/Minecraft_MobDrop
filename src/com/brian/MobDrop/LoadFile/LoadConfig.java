package com.brian.MobDrop.LoadFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.YamlConfiguration;

import com.brian.MobDrop.AnsiColor;
import com.brian.MobDrop.Database.DataBase;
import com.brian.MobDrop.Database.showMessage;

public class LoadConfig {
	// �D�nŪ���]�w��
	private FileConfiguration data = null;

	// �}�ɥ�
	private File filePreload = null;
	
	private String loadfilename = "Config.yml";
	
	public LoadConfig(){
		
	}
	
	public void ReLoadConfig(){
		// �T�{�ɮ׬O�_�s�b
	    this.filePreload = new File(DataBase.pluginMainDir + loadfilename);
	    if (this.filePreload.exists()){
	    	// Ū���]�w�ɤ��e
	    	this.data = YamlConfiguration.loadConfiguration(this.filePreload);
	    }
	    else{
	    	// �ɮפ��s�b�A�إ߹w�]��
	    	CreateDefaultfile();
	    	// �����ɮ�
	    	this.filePreload = new File(DataBase.pluginMainDir + loadfilename);
	    	// Ū���]�w�ɤ��e
	    	this.data = YamlConfiguration.loadConfiguration(this.filePreload);
	    }
	    
	    if (data.contains("showMessage")){
	    	if(data.contains("showMessage.IsOpen") && data.contains("showMessage.Chance")) {
	    		DataBase.showMessage = new showMessage(data.getBoolean("showMessage.IsOpen"),data.getInt("showMessage.Chance"));
	    		DataBase.main.getLogger().info(AnsiColor.GREEN + "[LoadConfig] showMessage �]�w���\" + AnsiColor.RESET);
	    	}else{
	    		DataBase.main.getLogger().info(AnsiColor.RED + "[LoadConfig] ���Ū�����~�A�p�G���|�]�w�A�бN showMessage.yml �R���í��s reload" + AnsiColor.RESET);
	    		return;
	    	}
	    }else {
	    	DataBase.showMessage = new showMessage(false,0);
	    }
	}
	
	public void CreateDefaultfile(){
		try{
			File createDir = new File(DataBase.pluginMainDir);
			if (!createDir.exists()){
				boolean dirCreated = false;
	
				int retries = 15;
	
				while ((!dirCreated) && (retries != 0)){
					retries--;
					dirCreated = createDir.mkdir();
				}
	
				if (!dirCreated){
					DataBase.main.getLogger().info(AnsiColor.RED + "[CreateDefaultFile]Items.yml failed to create. No permissions?" + AnsiColor.RESET);
					return;
				}
			}
			FileOutputStream fos = new FileOutputStream(DataBase.pluginMainDir + loadfilename);
		    fos.write(new byte[]{(byte)0xEF, (byte)0xBB, (byte)0xBF});
		    OutputStreamWriter osw = new OutputStreamWriter(fos, "UTF-8");
		    
			BufferedWriter out = new BufferedWriter(osw);
			out.write("showMessage:\r\n");
			out.write("  IsOpen: true\r\n");
			out.write("  Chance: 20\r\n");
		    out.close();
		}
		catch (Exception e){
			System.out.println(DataBase.detailStr + "[CreateDefaultConfig]Error on create default config!");
		}
	}
}
