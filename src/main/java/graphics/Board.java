package main.java.graphics;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Rectangle2D;

/**
 * Created by gandalf.midearth 2019/7/4
 */
public class Board extends JPanel {
    private int [][]x,y;
    private int [] n;


    private static @Getter
    @Setter
    boolean greenFlag;
    private @Getter @Setter boolean redFlag;
    private @Getter @Setter boolean blueFlag;
    private @Getter @Setter boolean gradientFlag;
    private @Getter @Setter boolean circleFlag;

    public Board(){
        n = new int[3];
        x = new int[3][10000];
        y = new int[3][10000];
    }

    //drawing
    public void paintComponent(Graphics g){
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        drawLines(g);
        if (gradientFlag){
            //gradient1
            GradientPaint p1 = new GradientPaint(0,0, Color.RED, 0, 300, Color.YELLOW);
            g2.setPaint(p1);
            g2.fill(new Rectangle2D.Float(0,0,600,300));

            //gradient2
            GradientPaint p2 = new GradientPaint(0,300, Color.YELLOW, 0, 600, Color.GREEN);
            g2.setPaint(p2);
            g2.fill(new Rectangle2D.Float(0,300,600,600));
        }

        if(circleFlag){
            //circle
            g.setColor(Color.CYAN);
            g.fillOval(200,200,300,300);
        }
    }

    public void drawLines(Graphics g){
        g.setColor(Color.CYAN);
        g.drawLine(10,10,30,30);
    }
}
