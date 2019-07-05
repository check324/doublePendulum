package main.java.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by gandalf.midearth 2019/7/4
 */

public class Canvas extends JFrame{
    Container container;
    Board board;

    JButton start;

    public Canvas(){
        container = getContentPane();
        board = new Board();
        start = new JButton("Start");

        //listener
        start.addActionListener(new ButtonListener());

        board.add(start);
        container.add(board);
    }

    class ButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == start) board.setStart(true);
            runByTimer();
        }
    }
    private void timerTask(){
        TimerTask task = new TimerTask() {

            @Override
            public void run() {
                board.setFirstLineAngle(10 + board.getFirstLineAngle());
                board.repaint();
            }
        };
        java.util.Timer timer = new Timer();
        long delay = 1;
        long intevalPeriod = 60;
        timer.scheduleAtFixedRate(task, delay,intevalPeriod);
    }

    private void runByTimer(){
        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        Runnable r = () -> {
            board.setFirstLineAngle(10*Math.PI/180*6/1000 + board.getFirstLineAngle());
            board.repaint();
        };
        executor.scheduleAtFixedRate(r, 1, 1, TimeUnit.MILLISECONDS);
    }
}
