package com.ibsrapp.concurrent.task;

/**
 * Created with IntelliJ IDEA.
 * User: billlee
 * Date: 2014/12/1
 * Time: 16:37
 * To change this template use File | Settings | File Templates.
 */
public class TaskDetail {
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public TaskDetail(String message)
    {
     this.message=message;
    }
}
