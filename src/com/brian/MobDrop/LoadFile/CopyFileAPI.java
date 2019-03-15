package com.brian.MobDrop.LoadFile;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

import com.brian.MobDrop.Main;

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
