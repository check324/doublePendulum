package main.java.shape;

/**
 * Created by gandalf.midearth 2019/7/4
 */
public class PositionManager {
    private double refreshRate = 60;
    public void calculateEndpoint(double [] startPosition, double length, double angle, double [] endPosition){
        endPosition[0] = startPosition[0] - length * Math.sin(angle);
        endPosition[1] = startPosition[1] + length * Math.cos(angle);
    }
}
