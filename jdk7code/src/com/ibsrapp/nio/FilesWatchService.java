package com.ibsrapp.nio;

import java.io.IOException;
import java.nio.file.*;
import static java.nio.file.StandardWatchEventKinds.*;
/**
 * Created with IntelliJ IDEA.
 * User: billlee
 * Date: 14-9-12
 * Time: 下午6:16
 * To change this template use File | Settings | File Templates.
 */
public class FilesWatchService {
    private boolean shutdown=false;
    //主要是使用java.nio.file.WatchService类监测文件或目录变化。
    public static void main(String[] args) {
        FilesWatchService filesWatchService=new FilesWatchService();
        filesWatchService.watchFile("C:\\logs");
    }

    /**
     * 监测指定路径的文件夹，如果文件夹中的某个文件被修改，则会输出“文件夹中内容被修改！",且
     *输出的次数和文件数相等
     *
     * @param path
     */
    public void watchFile(String path)
    {
        try
        {
            WatchService watchService= FileSystems.getDefault().newWatchService();
            Path dir=FileSystems.getDefault().getPath(path);
            WatchKey key=dir.register(watchService,ENTRY_MODIFY);
            while (!shutdown)
            {
                key=watchService.take();
                for (WatchEvent<?> event:key.pollEvents())
                {
                    if (event.kind()==ENTRY_MODIFY)
                    {
                        System.out.println("文件夹中内容被修改！");
                    }
                }
                key.reset();
            }
        }
        catch (IOException|InterruptedException e) {
            System.out.println(e.toString());
        }
    }
}
