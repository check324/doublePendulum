package main.java.graphics;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by gandalf.midearth 2019/7/4
 */
public class Board extends JPanel {
    private int [][]x,y;
    private int [] n;


    public Board(){
        n = new int[3];
        x = new int[3][10000];
        y = new int[3][10000];
    }

    //drawing
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;

        if (Canvas.isGradientFlag()){
            //gradient1
            GradientPaint p1 = new GradientPaint(0,0, Color.RED, 0, 300, Color.YELLOW);
            g2.setPaint(p1);
            g2.fill(new Rectangle2D.Float(0,0,600,300));

            //gradient2
            GradientPaint p2 = new GradientPaint(0,300, Color.YELLOW, 0, 600, Color.GREEN);
            g2.setPaint(p2);
            g2.fill(new Rectangle2D.Float(0,300,600,600));
        }
        else Canvas.setGradientFlag(true);

        if(Canvas.isCircleFlag()){
            //circle
            g.setColor(Color.CYAN);
            g.fillOval(200,200,300,300);
        }
    }
}
