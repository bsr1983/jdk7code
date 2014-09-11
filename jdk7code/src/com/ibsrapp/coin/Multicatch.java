package com.ibsrapp.coin;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: billlee
 * Date: 14-9-11
 * Time: 下午4:54
 * To change this template use File | Settings | File Templates.
 */
public class Multicatch {
    public static void main(String[] args)
    {
        getConfigFile("demo.xml");
    }
    public static void getConfigFile(String fileName)
    {
        try {
            String filePath;
            filePath = "C:/"+fileName;
            File configFile=new File(filePath);
            if(configFile!=null)
            {
                String configFileAbsolutePath=configFile.getAbsolutePath();
                byte fileNameBytes[]=fileName.getBytes();
                for (byte b:fileNameBytes) {
                    System.out.print(" "+b);
                }
            }
        } catch (NullPointerException|ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        } finally {
        }
    }
}
