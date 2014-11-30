package com.ibsrapp.concurrent;

import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;

/**
 * Created with IntelliJ IDEA.
 * User: billlee
 * Date: 2014/11/18
 * Time: 16:48
 * To change this template use File | Settings | File Templates.
 */
public  class ProcessingThread{

    public static class ProcessThread extends Thread
    {
        private final String ident;
        private final CountDownLatch latch;
        public ProcessThread(String ident_,CountDownLatch cdl_)
        {
            ident=ident_;
            latch=cdl_;
        }
        public String getIdentifier()
        {
            return ident;
        }
        public void initialize()
        {
            latch.countDown();
        }
        public void run()
        {
            System.out.println("ident_="+ident+" begin run!");
            initialize();
        }
    }

    public static void main(String[] args) {
        final int MAX_THREADS=10;
        final int quorum=1+(int)(MAX_THREADS/2);
        final CountDownLatch cdl=new CountDownLatch(quorum);
        final Set<ProcessThread> nodes=new HashSet<>();
        try
        {
            for(int i=0;i<MAX_THREADS;i++)
            {
                ProcessThread local=new ProcessThread("localhost:"+(9000+i),cdl);
                nodes.add(local);
                System.out.println("localhost: i="+i);
                local.start();
            }
            cdl.await();
        }catch (InterruptedException e)
        {

        }
        finally {

        }
    }
}
