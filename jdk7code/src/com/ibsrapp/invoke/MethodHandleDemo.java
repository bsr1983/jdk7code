package com.ibsrapp.invoke;

import java.io.ByteArrayOutputStream;
import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;
import java.lang.invoke.MethodType;

/**
 * Created with IntelliJ IDEA.
 * User: billlee
 * Date: 2014/12/12
 * Time: 16:38
 * To change this template use File | Settings | File Templates.
 */
public class MethodHandleDemo {
    /*
    * 16进制数字字符集
    */
    private static String hexString="0123456789ABCDEF";
    public static void main(String[] args) throws Throwable {
        MethodHandleDemo demo=new MethodHandleDemo();
        MethodHandle toStringMH=demo.getToStringMH();
        System.out.println("MethodHandleDemo.main"+toStringMH.invoke(demo));
        String decodeStr=decode("E2808FE2808FE2808FE2808F");
        System.out.println("decode=["+decodeStr+"]");
    }
    public static String toStringHex(String s)
    {
        byte[] baKeyword = new byte[s.length()/2];
        for(int i = 0; i < baKeyword.length; i++)
        {
            try
            {
                baKeyword[i] = (byte)(0xff & Integer.parseInt(s.substring(i*2, i*2+2),16));
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
        }
        try
        {
            s = new String(baKeyword, "utf-8");//UTF-16le:Not
        }
        catch (Exception e1)
        {
            e1.printStackTrace();
        }
        return s;
    }
    /*
    * 将16进制数字解码成字符串,适用于所有字符（包括中文）
    */
    public static String decode(String bytes)
    {
        ByteArrayOutputStream baos=new ByteArrayOutputStream(bytes.length()/2);
        //将每2位16进制整数组装成一个字节
        for(int i=0;i<bytes.length();i+=2)
            baos.write((hexString.indexOf(bytes.charAt(i))<<4 |hexString.indexOf(bytes.charAt(i+1))));
        return new String(baos.toByteArray());
    }
    public MethodHandle getToStringMH()
    {
        MethodHandle mh=null;
        MethodType methodType=MethodType.methodType(String.class);
        MethodHandles.Lookup lk=MethodHandles.lookup();
        try {
            mh=lk.findVirtual(getClass(),"toString",methodType);
        }
        catch (NoSuchMethodException|IllegalAccessException mhx)
        {
            throw (AssertionError)new AssertionError().initCause(mhx);
        }
        return mh;
    }
    public String toString()
    {
        return "MethodHandleDemo toString... be invoke";
    }
}
