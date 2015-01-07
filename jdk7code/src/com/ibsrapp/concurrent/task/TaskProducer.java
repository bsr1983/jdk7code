package com.ibsrapp.concurrent.task;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TransferQueue;

/**
 * Created with IntelliJ IDEA.
 * User: billlee
 * Date: 2014/12/1
 * Time: 16:42
 * To change this template use File | Settings | File Templates.
 */
public class TaskProducer implements Runnable{
    private TransferQueue<TaskDetail> taskDetailQueue;
    public TaskProducer(TransferQueue<TaskDetail> queue)
    {
        this.taskDetailQueue=queue;
    }
    public void run()
    {
        while(!TaskManager.runTaskStopFlag){
            TaskManager.runTaskCallbackFlag = false;
            try {
                List<TaskDetail> details = getTaskDetails();
                if(details != null && details.size() > 0){
                    for(TaskDetail detail : details)
                    {
                        taskDetailQueue.transfer(detail);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("TaskProducer run Exception:"+e.toString());
            }
            TaskManager.runTaskCallbackFlag = true;
        }
    }
    public List<TaskDetail> getTaskDetails()
    {
        List<TaskDetail> details=new ArrayList<>();
        int random=randomInt(10);
        String message="";
        for(int i=0;i<random;i++)
        {
            message=System.currentTimeMillis()+" i="+i+" random="+randomInt(10000);
            TaskDetail detail=new TaskDetail(message);
            details.add(detail);
        }
        return details;
    }
    public static int randomInt(int max)
    {
        return (int) (Math.random() * 100000 % max) + 1;
    }
    public TransferQueue<TaskDetail> getTaskDetailQueue() {
        return taskDetailQueue;
    }

    public void setTaskDetailQueue(TransferQueue<TaskDetail> taskDetailQueue) {
        this.taskDetailQueue = taskDetailQueue;
    }
}

