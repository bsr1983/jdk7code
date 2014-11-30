package com.ibsrapp.concurrent;

import java.util.concurrent.Callable;

/**
 * Created with IntelliJ IDEA.
 * User: billlee
 * Date: 2014/11/18
 * Time: 19:13
 * To change this template use File | Settings | File Templates.
 */
public class CallableDemo {
    public static void main(String[] args) throws Exception{
        CallableDemo callableDemo=new CallableDemo();
        callableDemo.callableDemo();
    }
    public void callableDemo() throws Exception {
        final Author author=getAuthorForDemo();
        Callable<String> cb=new Callable<String>() {
            @Override
            public String call() throws Exception {
                return author.toString();
            }
        };
        String str=cb.call();
        System.out.println("str ="+str);
    }
    public Author getAuthorForDemo()
    {
        Author author=new Author("Wang Bo");
        return author;
    }
}
