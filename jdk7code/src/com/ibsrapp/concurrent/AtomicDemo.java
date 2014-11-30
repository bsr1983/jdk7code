package com.ibsrapp.concurrent;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created with IntelliJ IDEA.
 * User: billlee
 * Date: 2014/11/17
 * Time: 15:23
 * To change this template use File | Settings | File Templates.
 */
public class AtomicDemo {
    private final AtomicInteger sequenceNumber=new AtomicInteger(0);
    public void printNumber()
    {
        System.out.println("sequenceNumber get="+sequenceNumber.get());
        System.out.println("sequenceNumber getAndIncrement="+sequenceNumber.getAndIncrement());
        System.out.println("sequenceNumber get="+sequenceNumber.get());
        System.out.println("sequenceNumber getAndIncrement="+sequenceNumber.getAndIncrement());
        System.out.println("sequenceNumber get="+sequenceNumber.get());
        System.out.println("sequenceNumber incrementAndGet="+sequenceNumber.incrementAndGet());
        System.out.println("sequenceNumber get="+sequenceNumber.get());
        System.out.println("sequenceNumber incrementAndGet="+sequenceNumber.incrementAndGet());
        System.out.println("sequenceNumber get="+sequenceNumber.get());
        System.out.println("sequenceNumber getAndDecrement="+sequenceNumber.getAndDecrement());
        System.out.println("sequenceNumber get="+sequenceNumber.get());
        System.out.println("sequenceNumber getAndDecrement="+sequenceNumber.getAndDecrement());
        System.out.println("sequenceNumber get="+sequenceNumber.get());
        System.out.println("sequenceNumber decrementAndGet="+sequenceNumber.decrementAndGet());
        System.out.println("sequenceNumber get="+sequenceNumber.get());
        System.out.println("sequenceNumber decrementAndGet="+sequenceNumber.decrementAndGet());
        System.out.println("sequenceNumber get="+sequenceNumber.get());
    }
    public static void main(String[] args) {
        AtomicDemo atomicDemo=new AtomicDemo();
        atomicDemo.printNumber();
    }
}
