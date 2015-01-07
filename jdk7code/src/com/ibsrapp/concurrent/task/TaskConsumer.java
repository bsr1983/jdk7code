package com.ibsrapp.concurrent.task;

import java.util.concurrent.TransferQueue;

/**
 * Created with IntelliJ IDEA.
 * User: billlee
 * Date: 2014/12/1
 * Time: 16:36
 * To change this template use File | Settings | File Templates.
 */
public class TaskConsumer implements Runnable{
    private TransferQueue<TaskDetail> taskDetailQueue;

    public TaskConsumer(TransferQueue<TaskDetail> queue)
    {
        this.taskDetailQueue=queue;
    }
    public void run()
    {
        while(!TaskManager.runTaskStopFlag){
            TaskManager.runTaskCallbackFlag = false;
            try {
                TaskDetail detail=taskDetailQueue.take();
                if(detail!=null)
                {
                    TaskManager.getInstance().runTask(detail);
                }
            } catch (Exception e)
            {
                e.printStackTrace();
                System.out.println("TaskConsumer run Exception:"+e.toString());
            }
            TaskManager.runTaskCallbackFlag = true;
        }
    }
}
