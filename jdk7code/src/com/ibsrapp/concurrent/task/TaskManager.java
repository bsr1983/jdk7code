package com.ibsrapp.concurrent.task;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedTransferQueue;
import java.util.concurrent.TransferQueue;

/**
 * Created with IntelliJ IDEA.
 * User: billlee
 * Date: 2014/12/1
 * Time: 16:37
 * To change this template use File | Settings | File Templates.
 */
public class TaskManager {
    public static boolean runTaskCallbackFlag=false;
    public static boolean runTaskStopFlag=false;
    private static TaskManager instance=new TaskManager();
    public static TaskManager getInstance()
    {
        return instance;
    }
    public void runTask(TaskDetail detail)
    {
        try {
            Thread.currentThread().sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
        }
        System.out.println("detail message="+detail.getMessage());
    }

    public static void main(String[] args) {
        // 借助Executors
        ExecutorService service = Executors.newCachedThreadPool();
        TransferQueue<TaskDetail> taskDetailQueue = new LinkedTransferQueue<TaskDetail>();
        TaskProducer taskProducer = new TaskProducer(taskDetailQueue);
        TaskConsumer taskConsumer = new TaskConsumer(taskDetailQueue);
        // 启动线程
        service.execute(taskProducer);
        service.execute(taskConsumer);
    }
}
