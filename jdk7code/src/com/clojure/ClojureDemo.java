package com.clojure;


import clojure.lang.ISeq;
import clojure.lang.StringSeq;

/**
 * Created with IntelliJ IDEA.
 * User: billlee
 * Date: 2015/1/13
 * Time: 16:04
 * To change this template use File | Settings | File Templates.
 */
public class ClojureDemo {
    public static void main(String[] args) {
        ISeq seq= StringSeq.create("football");
        while(seq!=null)
        {
            Object first=seq.first();
            System.out.println("Seq:"+seq+"  ;first:"+first);
            seq=seq.next();
        }
    }
}
