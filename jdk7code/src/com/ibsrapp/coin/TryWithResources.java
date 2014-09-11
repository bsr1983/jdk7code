package com.ibsrapp.coin;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: billlee
 * Date: 14-9-11
 * Time: 下午5:32
 * To change this template use File | Settings | File Templates.
 */
public class TryWithResources
{
     public static void main(String[] args)
     {
         readFile("C:/temp.txt");
     }
     public static void readFile(String filePath)
     {
         /**FileInputStream 已实现了AutoCloseable接口，因此可以使用TWR语法实现自动关闭
          * public class FileInputStream extends InputStream
          * public abstract class InputStream implements Closeable
          * public interface Closeable extends AutoCloseable
          * **/
         try (FileInputStream fileInputStream=new FileInputStream(filePath))
         {
             byte[] buf=new byte[1024];
             int len;
             while ((len=fileInputStream.read(buf))!=-1)
             {
                 System.out.println(new String(buf));
             }
         }
         catch (Exception e) {
             e.printStackTrace();
         }
     }
}
