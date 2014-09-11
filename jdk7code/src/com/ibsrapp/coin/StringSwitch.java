package com.ibsrapp.coin;

public class StringSwitch {
    public static void main(String[] args)
    {
        stringSwitchDemo("suN");
        stringSwitchDemo("mon");
        stringSwitchDemo("113");
    }
    public static void stringSwitchDemo(String weekName)
    {
        switch (weekName.toUpperCase())
        {
            case "SUN":
                System.out.println("Sunday");
                break;
            case "MON":
                System.out.println("Monday");
                break;
            case "TUE":
                System.out.println("Tuesday");
                break;
            case "WED":
                System.out.println("WednesDay");
                break;
            case "THU":
                System.out.println("ThursDay");
                break;
            case "FRI":
                System.out.println("Friday");
                break;
            case "SAT":
                System.out.println("Saturday");
                break;
            default:
                System.err.println("Error!");
        }
    }

}
