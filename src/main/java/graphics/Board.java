package main.java.graphics;

import lombok.Getter;
import lombok.Setter;
import main.java.physics.WorldManager;
import main.java.shape.PositionManager;
import org.dyn4j.geometry.Vector2;

import javax.swing.*;
import java.awt.*;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by gandalf.midearth 2019/7/4
 */
public class Board extends JPanel {
//    private double [] lineStartPosition = {300,300};
    private Vector2 lineStartPosition;
    private double firstLineLength = 50;
    private double [] firstLineEndPosition = new double [2];
    @Getter @Setter
    private double firstLineAngle = 30;
    private double firstBallRadius = 10;
    private PositionManager positionManager;
    private final double refreshRate = 60;

    Example ex;
    public Board(){
        positionManager = new PositionManager();
        ex = new Example();
        lineStartPosition = new Vector2();
        lineStartPosition.x = 300;
        lineStartPosition.y = 300;

    }
    @Getter @Setter
    private boolean start;

    //drawing
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        drawShapes(g2);
//        timerTask(g2);
//        ex.printHello();
    }

    private void drawShapes(Graphics2D g2){
        positionManager.calculateEndpoint(lineStartPosition, firstLineLength, firstLineAngle, WorldManager.getInstance().getFirstBallBody().getLocalCenter());
        drawLine(g2);
        drawCircle(g2);
    }
    private void drawCircle(Graphics2D g2) {
        Ellipse2D.Double circle = new Ellipse2D.Double(firstLineEndPosition[0]-firstBallRadius/2, firstLineEndPosition[1]-firstBallRadius/2,firstBallRadius,firstBallRadius);
        g2.setColor(Color.BLUE);
        g2.fill(circle);
    }
    private void drawLine(Graphics2D g2) {
        Line2D line2D = new Line2D.Double(lineStartPosition.x, lineStartPosition.y, firstLineEndPosition[0], firstLineEndPosition[1]);
        g2.setColor(Color.BLUE);
        g2.draw(line2D);
    }

    private void byLoop(Graphics2D g2){
        for(int i=0; i< 10000; ++i){
            firstLineAngle += 1 / (refreshRate / 1000);
            positionManager.calculateEndpoint(lineStartPosition, firstLineLength, firstLineAngle, WorldManager.getInstance().getFirstBallBody().getLocalCenter());
            drawShapes(g2);
        }
    }

    private void runByTimer(Graphics2D g2){

        ScheduledExecutorService executor = Executors.newSingleThreadScheduledExecutor();
        Runnable r = () -> {
            firstLineAngle += 1 / (refreshRate / 1000);
            positionManager.calculateEndpoint(lineStartPosition, firstLineLength, firstLineAngle, WorldManager.getInstance().getFirstBallBody().getLocalCenter());
            drawShapes(g2);
        };
        executor.scheduleAtFixedRate(r, 0, 10000000,TimeUnit.MINUTES);
    }
}
