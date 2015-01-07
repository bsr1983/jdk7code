package com.ibsrapp.groovy;

import groovy.lang.GroovyClassLoader;
import groovy.lang.GroovyObject;

import java.io.File;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: billlee
 * Date: 2015/1/5
 * Time: 19:38
 * To change this template use File | Settings | File Templates.
 */
public class GroovyClassLoaderDemo {
    public static void main(String[] args) {
        GroovyClassLoader loader=new GroovyClassLoader();
        try {
            Class<?> groovyClass=loader.parseClass(new File("GetMaxValueOfList.groovy"));
            GroovyObject groovyObject=(GroovyObject)groovyClass.newInstance();
            ArrayList<Integer> integers=new ArrayList<>();
            integers.add(1);
            integers.add(122);
            integers.add(145);
            integers.add(173);
            Object[] arguments={integers};
            Object maxValue=groovyObject.invokeMethod("getMaxOfList",arguments);
            System.out.println("maxValue="+maxValue.toString());

        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception e="+e.toString());
        }

    }
}
