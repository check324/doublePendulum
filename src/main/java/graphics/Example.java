package main.java.graphics;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by gandalf.midearth 2019/7/4
 */
public class Example {
    public void printHello(){
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                System.out.println("Hello !!!");
            }
        };
        Timer timer = new Timer();
        long delay = 1;
        long intevalPeriod = 1 * 1000;
        timer.scheduleAtFixedRate(task, delay,intevalPeriod);
    }
}
