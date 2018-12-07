package com.example.webmagic.util;

import java.io.*;

/**
 * @author czWang
 * @Created 2018/12/6 15:36.
 */
public class FileUtil {


    public static void  byte2File(byte[] bytes, String path){
        try {
          //  String path1 = FileUtil.class.getResource("/").getPath();
            path = FileUtil.class.getResource("/").getPath() + "/temp/" + path;
            File file = new File(path);
            if (!file.exists() && file.isDirectory())
            {
                file.mkdirs();
            }
            FileOutputStream fos = new FileOutputStream(file);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            bos.write(bytes);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
