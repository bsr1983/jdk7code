package com.ibsrapp.profile;

/**
 * Created with IntelliJ IDEA.
 * User: billlee
 * Date: 2014/12/22
 * Time: 14:02
 * To change this template use File | Settings | File Templates.
 */
public class SystemTime {
    public static void main(String[] args) {
        long nowNanos=0,startNanos=0;
        long startMillis=System.currentTimeMillis();
        long nowMillis=startMillis;
        while(startMillis==nowMillis)
        {
            startNanos=System.nanoTime();
            nowMillis=System.currentTimeMillis();
        }
        startMillis=nowMillis;
        double maxDrift=0;
        long lastMillis;
        while(true)
        {
            lastMillis=nowMillis;
            while (nowMillis-lastMillis<1000)
            {
                nowNanos=System.nanoTime();
                nowMillis=System.currentTimeMillis();
            }
            long durationMillis=nowMillis=startMillis;
            double driftNanos=1000000*(((double)(nowNanos-startNanos))/1000000-durationMillis);
            if (Math.abs(driftNanos)>maxDrift)
            {
                System.out.println("Now-Start="+durationMillis+" driftNanos = "+driftNanos);
                maxDrift=Math.abs(driftNanos);
            }
        }

    }
}
