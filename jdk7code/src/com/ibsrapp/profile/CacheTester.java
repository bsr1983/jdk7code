package com.ibsrapp.profile;

/**
 * Created with IntelliJ IDEA.
 * User: billlee
 * Date: 2014/12/22
 * Time: 15:41
 * To change this template use File | Settings | File Templates.
 */
public class CacheTester {
    private final int ARR_SIZE=1*1024*1024;
    private final int[] arr=new int[ARR_SIZE];

    private void doLoop2()
    {
        for(int i=0;i<arr.length;i++) arr[i]++;
    }
    private void doLoop1()
    {
        for (int i=0;i<arr.length;i+=16) arr[i]++;
    }
    private void run()
    {
        for(int i=0;i<100;i++)
        {
            doLoop1();
            doLoop2();
        }
        for(int i=0;i<100;i++)
        {
            long t0=System.nanoTime();
            doLoop1();
            long t1=System.nanoTime();
            doLoop2();
            long t2=System.nanoTime();
            long e1=t1-t0;
            long e2=t2-t1;
            System.out.println("Loop1: "+e1+" nanos; Loop2: "+e2);
        }
    }

    public static void main(String[] args) {
        CacheTester cacheTester=new CacheTester();
        cacheTester.run();
    }
}
