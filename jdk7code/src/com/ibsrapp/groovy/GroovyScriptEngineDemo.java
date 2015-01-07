package com.ibsrapp.groovy;

import groovy.lang.Binding;
import groovy.util.GroovyScriptEngine;

/**
 * Created with IntelliJ IDEA.
 * User: billlee
 * Date: 2015/1/5
 * Time: 20:25
 * To change this template use File | Settings | File Templates.
 */
public class GroovyScriptEngineDemo {
    public static void main(String[] args) {
        try {
            String root[]=new String[]{"C:/groovy"};
            GroovyScriptEngine groovyScriptEngine=new GroovyScriptEngine(root);
            Binding binding=new Binding();
            binding.setVariable("name","billlee");
            Object object=groovyScriptEngine.run("hello.groovy",binding);
            System.out.println("output "+object.toString());
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Exception e="+e.toString());
        }

    }
}
