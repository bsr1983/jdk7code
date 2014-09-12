package com.ibsrapp.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * Created with IntelliJ IDEA.
 * User: billlee
 * Date: 14-9-12
 * Time: 下午1:28
 * To change this template use File | Settings | File Templates.
 */
public class PathDemo {
    public static void main(String[] args)
    {
        somePathMethod();
        getPathBetweenTwoPath("C:\\","C:\\Perl\\html\\bin");
        findSymbolicLinkOfDir();
        Path root=Paths.get("C:\\Users\\Administrator\\Desktop");
        walkFileTree(root);
    }
    public static void somePathMethod()
    {
        Path dir= Paths.get("C:\\Perl\\html");
        dir= FileSystems.getDefault().getPath("C:\\Perl\\html\\bin");
        Path prefix=Paths.get("C:\\Perl");
        dir=prefix.resolve("\\html\\bin");
        System.out.println("File Name ["+dir.getFileName()+"]");
        System.out.println("Number of Name Elements in the Path["+dir.getNameCount()+"]");
        System.out.println("Parent Path ["+dir.getParent()+"]");
        System.out.println("Root of Path["+dir.getRoot()+"]");
        System.out.println("Sub Path from Root,1 elements deep ["+dir.subpath(0,2)+"]");
        Path normalizedPath=Paths.get("./blank.html").normalize();
        System.out.println("normalized Path ["+normalizedPath+"]");
        Path symbolicLink=Paths.get("C:\\Users\\Administrator\\Desktop\\Hibernate 手册.lnk");
        try {
            if(Files.isSymbolicLink(symbolicLink))
            {
                System.out.println("Real Path ["+symbolicLink.toRealPath()+"]");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public static void findSymbolicLinkOfDir()
    {
        Path root=Paths.get("C:\\Users\\Administrator\\Desktop");
        try(DirectoryStream<Path> stream=Files.newDirectoryStream(root)){
            for(Path subPath:stream)
            {
                if(Files.isSymbolicLink(subPath))
                {
                    System.out.println("Real Path ["+subPath.toRealPath()+"]");
                }
                else
                {
                    System.out.println("Absolute Path ["+subPath.toAbsolutePath()+"]");
                }
            }
        }catch (IOException e){
            System.err.println("IOException "+e.toString());
        }
    }
    public static void walkFileTree(Path root)
    {
        try {
            Files.walkFileTree(root,new FindShortLinkVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    private static class FindShortLinkVisitor extends SimpleFileVisitor<Path>
    {
        @Override
        public FileVisitResult visitFile(Path file,BasicFileAttributes attributes)
        {
            if (file.toString().endsWith(".lnk"))
            {
                System.out.println("short link file ["+file.getFileName()+"]");
            }
            return FileVisitResult.CONTINUE;
        }
    }
    public static void getPathBetweenTwoPath(String one,String other)
    {
        Path onePath=Paths.get(one);
        Path otherPath=Paths.get(other);
        Path oneToOther=onePath.relativize(otherPath);
        System.out.println(oneToOther.toString());
    }
}
