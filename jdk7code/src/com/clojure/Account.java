package com.clojure;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA.
 * User: billlee
 * Date: 2015/1/13
 * Time: 16:55
 * To change this template use File | Settings | File Templates.
 */
public class Account {
    private double balance=0;
    private final String name;
    private final Lock lock=new ReentrantLock();

    public Account(double balance, String name) {
        this.balance = balance;
        this.name = name;
    }

    public double getBalance() {
        return balance;
    }

    public String getName() {
        return name;
    }

    public Lock getLock() {
        return lock;
    }
    public synchronized void debit(double debitAmt_)
    {
        balance-=debitAmt_;
        System.out.println("Thread Id="+Thread.currentThread().getId()+"   balance="+balance);
    }
    @Override
    public String toString() {
        return "Account{" +
                "balance=" + balance +
                ", name='" + name + '\'' +
                '}';
    }
}
