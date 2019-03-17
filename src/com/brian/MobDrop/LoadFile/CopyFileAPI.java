package com.brian.MobDrop.LoadFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.brian.MobDrop.AnsiColor;
import com.brian.MobDrop.Main;
import com.brian.MobDrop.Database.DataBase;

public class CopyFileAPI {
	public static void copyFile(InputStream in, File out) throws Exception {
        InputStream fis = in;
        FileOutputStream fos = new FileOutputStream(out);
        try {
            byte[] buf = new byte[1024];
            int i = 0;
            while ((i = fis.read(buf)) != -1) {
                fos.write(buf, 0, i);
            }
        } catch (Exception e) {
            throw e;
        } finally {
            if (fis != null) {
            	fis.close();
            }
            if (fos != null) {
                fos.close();
            }
        }
    }
	
	public static boolean createFile(String Dir,String Filename,String JarURL,Main main) {
		Path p = Paths.get(Dir);    //���|�]�w
        /*�T�{��Ƨ��O�_�s�b*/
        if (!Files.exists(p)) {
            /*���s�b����,�����إ߸�Ƨ�*/
            try {
				Files.createDirectory(p);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            DataBase.main.getLogger().info(AnsiColor.GREEN + "[DirCreate] " + AnsiColor.GREEN +  "��Ƨ��Ыئ��\" + AnsiColor.RESET);
        }
		File QuestMaker = new File(Dir + Filename);
        if (!QuestMaker.exists()) {
            InputStream jarURL = main.getClass().getResourceAsStream(JarURL);
            try {
            	copyFile(jarURL, new File(Dir + Filename));
            	return true;
            } catch (Exception ex) {
            	return false;
            }
        }
        return false;
	}
}
