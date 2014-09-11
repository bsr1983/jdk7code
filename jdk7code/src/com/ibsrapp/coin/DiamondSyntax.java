package com.ibsrapp.coin;

import java.util.HashMap;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: billlee
 * Date: 14-9-11
 * Time: 下午5:49
 * To change this template use File | Settings | File Templates.
 */
public class DiamondSyntax {
    public static void main(String[] args)
    {
        diamondSyntax();
    }
    public static void diamondSyntax()
    {
        Map<Integer,Map<String,String>> valueMap=new HashMap<>();
        Map<String,String> oneMap=new HashMap<>();
        oneMap.put("one","ONE");
        valueMap.put(1,oneMap);
        Map<String,String> twoMap=new HashMap<>();
        twoMap.put("two","TWO");
        valueMap.put(2,twoMap);
        System.out.print(valueMap.toString());
    }
}
