package com.clojure;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;

/**
 * Created with IntelliJ IDEA.
 * User: billlee
 * Date: 2015/1/13
 * Time: 16:58
 * To change this template use File | Settings | File Templates.
 */
public class Debitter implements Runnable {
    private final Account acc;
    private final CountDownLatch cdl;

    public Debitter(Account acc, CountDownLatch cdl) {
        this.acc = acc;
        this.cdl = cdl;
    }
    public void run()
    {
        double bal=acc.getBalance();
        Lock lk=acc.getLock();
        while (bal>0)
        {
            try {
                Thread.sleep(1);
            }
            catch (InterruptedException e)
            {

            }
            lk.lock();
            bal=acc.getBalance();
            if (bal>0)
            {
                acc.debit(1);
                bal--;
            }
            lk.unlock();
        }
        cdl.countDown();
    }

    public static void main(String[] args)  {
        try {
            int num=10;
            Account myAcc=new Account(50000,"Test Account");
            CountDownLatch stop1=new CountDownLatch(num);
            for (int i=0;i<num;i++)
            {
                new Thread(new Debitter(myAcc,stop1)).start();
            }
            stop1.await();
            System.out.println(myAcc);
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println(e.toString());
        }
    }
}
