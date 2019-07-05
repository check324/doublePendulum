package main.java.shape;

import org.dyn4j.geometry.Vector2;

/**
 * Created by gandalf.midearth 2019/7/4
 */
public class PositionManager {
    private double refreshRate = 60;
    public void calculateEndpoint(double [] startPosition, double length, double angle, double [] endPosition){
        endPosition[0] = startPosition[0] - length * Math.sin(angle);
        endPosition[1] = startPosition[1] + length * Math.cos(angle);
    }

    public void calculateEndpoint(Vector2 startPosition, double length, double angle, Vector2 endPosition){
        endPosition.x = startPosition.x - length * Math.sin(angle);
        endPosition.y = startPosition.y + length * Math.cos(angle);
    }
}
