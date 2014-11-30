package com.ibsrapp.concurrent;

import java.util.concurrent.*;

/**
 * Created with IntelliJ IDEA.
 * User: billlee
 * Date: 2014/11/19
 * Time: 17:32
 * To change this template use File | Settings | File Templates.
 */
public class FutureDemo
{
    public static void main(String[] args) {
        FutureDemo futureDemo=new FutureDemo();
        futureDemo.demo();
    }
    public void demo()
    {
        Future<Long> future=new FutureTask<Long>(
                new Callable<Long>() {//使用Callable接口作为构造参数
            public Long call() throws InterruptedException {
                //真正的任务在这里执行，这里的返回值类型为String，可以为任意类型
                Thread.sleep(100000);
                System.out.println("call() execute");
                return 1L;
            }});
        Long result=null;
        while (result==null)
        {
            System.out.println("计算暂未完成！！");
            try
            {
                result=future.get(60, TimeUnit.SECONDS);
            }
            catch (TimeoutException tox)
            {

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
            System.out.println("计算暂未完成！！");
        }
        System.out.println("计算完成 result"+result);
    }

}
