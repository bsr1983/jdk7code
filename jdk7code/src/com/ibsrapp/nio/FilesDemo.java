package com.ibsrapp.nio;

import com.ibsrapp.coin.TryWithResources;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Iterator;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: billlee
 * Date: 14-9-12
 * Time: 下午4:59
 * To change this template use File | Settings | File Templates.
 */
public class FilesDemo {
    public static void main(String[] args) {
        Path dir=createDir("c://demo");
        Path file1=createFile(dir,"demo1.txt");
        Path file2=createFile(dir,"demo2.txt");
        Path file3=createFile(dir,"demo3.txt");
        writeFile(file1,"I am file1!This is my text!");
        writeFile(file2,"I am file2!This is my text!");
        writeFile(file3,"I am file3!This is my text!");
        System.out.println("readFileAllLinesAndPrint");
        readFileAllLinesAndPrint(file1);
        System.out.println("readFileAllBytesAndPrint");
        readFileAllBytesAndPrint(file2);
        System.out.println("readFileEachLineAndPrint");
        readFileEachLineAndPrint(file3);
        Path file4=Paths.get(dir.toString(),"demo3.txt");
        try {
            Files.copy(file3,file4, StandardCopyOption.REPLACE_EXISTING);
        } catch (IOException e) {
            e.printStackTrace();
        }
//        System.out.println("$sadsad".replace("sadsad","$"));
//        System.out.println("sadsad.".replaceAll("sadsad","$"));
//        System.out.println("sadsad".replaceFirst("sadsad","$"));
    }
    public static Path createDir(String dirName)
    {
        Path dir=null;
        try {
            Path target= Paths.get(dirName);
            if (target.toFile().exists())
            {
                deleteFileOrDir(target.toFile());
            }
            dir= Files.createDirectory(target);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dir;
    }

    private static void deleteFileOrDir(File target) {
        if (target==null)
        {
            return;
        }
        if (target.isDirectory())
        {
            for (File file:target.listFiles())
            {
                deleteFileOrDir(file);
            }
            target.delete();
        }
        else
        {
            target.delete();
        }
    }

    public static Path createFile(Path dir,String fileName)
    {
        Path file=null;
        try {
            if (dir!=null) {
                Path target= dir.resolve(fileName);
                file= Files.createFile(target);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }
    public static void writeFile(Path path,String text)
    {
        try(BufferedWriter writer=Files.newBufferedWriter(path, StandardCharsets.UTF_8, StandardOpenOption.APPEND))
        {
            writer.write("Hello BufferWriter!");
            writer.newLine();
            writer.write(text);
        }
        catch(IOException e)
        {
            System.err.println("IOException "+e.toString());
        }
    }
    public static void readFileAllLinesAndPrint(Path path)
    {
        try {
            List<String> textLines=Files.readAllLines(path,StandardCharsets.UTF_8);
            for (String s : textLines) {
                System.out.println(s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void readFileAllBytesAndPrint(Path path)
    {
        try {
            byte[] bytes=Files.readAllBytes(path);
            String text=new String(bytes,StandardCharsets.UTF_8);
            System.out.println(text);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readFileEachLineAndPrint(Path path)
    {
        try(BufferedReader reader=Files.newBufferedReader(path,StandardCharsets.UTF_8))
        {
            String line;
            while ((line=reader.readLine())!=null)
            {
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
