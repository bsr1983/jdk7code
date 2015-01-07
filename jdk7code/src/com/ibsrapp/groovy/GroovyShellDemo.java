package com.ibsrapp.groovy;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;

/**
 * Created with IntelliJ IDEA.
 * User: billlee
 * Date: 2015/1/5
 * Time: 19:28
 * To change this template use File | Settings | File Templates.
 */
public class GroovyShellDemo {
    public static void main(String[] args) {
        Binding binding=new Binding();
        binding.setVariable("x",3);
        binding.setVariable("y",0.2);
        GroovyShell groovyShell=new GroovyShell(binding);
        Object value=groovyShell.evaluate("x+y");
        System.out.println("x+y="+value.toString());
        value=groovyShell.evaluate("x-y");
        System.out.println("x-y="+value.toString());
        value=groovyShell.evaluate("x*y");
        System.out.println("x*y="+value.toString());
        value=groovyShell.evaluate("x/y");
        System.out.println("x/y="+value.toString());
    }
}
