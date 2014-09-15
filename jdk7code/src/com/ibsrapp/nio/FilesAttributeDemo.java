package com.ibsrapp.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.*;
import java.util.Set;

/**
 * Created with IntelliJ IDEA.
 * User: billlee
 * Date: 14-9-12
 * Time: 下午6:17
 * To change this template use File | Settings | File Templates.
 */
public class FilesAttributeDemo {
    public static void main(String[] args) {
        readAttribute();
        readWindowsAttribute();
    }
    public static void readAttribute()
    {
        Path txt= Paths.get("c://demo//demo1.txt");
        try {
            System.out.println("Files.getLastModifiedTime(txt) "+Files.getLastModifiedTime(txt));
            System.out.println("Files.size(txt) "+Files.size(txt));
            System.out.println("Files.isSymbolicLink(txt) "+Files.isSymbolicLink(txt));
            System.out.println("Files.isDirectory(txt) "+Files.isDirectory(txt));
            System.out.println("Files.readAttributes "+Files.readAttributes(txt,"*"));
            System.out.println("Files.readAttributes "+Files.readAttributes(txt,"lastModifiedTime"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void readWindowsAttribute()
    {
        Path txt= Paths.get("c://demo//demo1.txt");
        try {
           DosFileAttributes dosFileAttributes=Files.readAttributes(txt,DosFileAttributes.class);
            System.out.format("%s %b %s %b %s %b %s %b","isArchive=",dosFileAttributes.isArchive(),"isHidden=",dosFileAttributes.isHidden(),
            "isReadOnly=",dosFileAttributes.isReadOnly(),".isSystem=",dosFileAttributes.isSystem());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
