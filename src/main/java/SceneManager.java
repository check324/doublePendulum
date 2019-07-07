package main.java;

import main.java.framework.SimulationBody;
import main.java.framework.SimulationFrame;
import org.dyn4j.dynamics.World;
import org.dyn4j.dynamics.joint.RevoluteJoint;
import org.dyn4j.geometry.Geometry;
import org.dyn4j.geometry.MassType;
import org.dyn4j.geometry.Vector2;

import java.awt.*;

public class SceneManager extends SimulationFrame {
//    private Line firstLine;
    private static final double firstLineLength = 5;
    private static final double firstLineWidth = 0.01;
    private static final double firstLineAngle = 90; // in degree
    private static final double secondLineLength = 5;
    private static final double secondLineWidth = 0.01;
    private static final double secondLineAngle = 90; // in degree

    private SimulationBody firstBall;
    private SimulationBody firstLine;
    private SimulationBody secondtBall;
    private SimulationBody secondLine;

    private static final double firstBallRadius = 1;
    private static final double secondBallRadius = 1;
    public SceneManager(){
        super("SceneManager", 20);
    }

    @Override
    protected void initializeWorld() {
        // no gravity on a top-down view of a billiards game
        this.world.setGravity(World.EARTH_GRAVITY);
        // create a fixed point
        SimulationBody fixedPoint = new SimulationBody();
        fixedPoint.addFixture(Geometry.createCircle(0.01));
        fixedPoint.translate(0,0);
        fixedPoint.setMass(MassType.NORMAL.INFINITE);
        world.addBody(fixedPoint);

        // create firstLine
        firstLine = new SimulationBody();
        firstLine.addFixture(Geometry.createRectangle(firstLineWidth,firstLineLength));
        firstLine.rotate(firstLineAngle*Math.PI/180);
        firstLine.translate(getRectanglePosition(firstLine, firstLineLength/2).x,getRectanglePosition(firstLine, firstLineLength/2).y);
        firstLine.setMass(MassType.NORMAL);
        world.addBody(firstLine);

        // first line joint with fixed point
        RevoluteJoint firstPointToFirstLine = new RevoluteJoint(fixedPoint, firstLine, fixedPoint.getLocalCenter());
        firstPointToFirstLine.setLimitEnabled(false);
        firstPointToFirstLine.setLimits(Math.toRadians(0.0), Math.toRadians(0.0));
        firstPointToFirstLine.setReferenceAngle(Math.toRadians(0.0));
        firstPointToFirstLine.setMotorEnabled(false);
        firstPointToFirstLine.setMotorSpeed(Math.toRadians(0.0));
        firstPointToFirstLine.setMaximumMotorTorque(0.0);
        firstPointToFirstLine.setCollisionAllowed(false);
        world.addJoint(firstPointToFirstLine);

//
        // create firstBall
        firstBall = new SimulationBody();
        firstBall.addFixture(Geometry.createCircle(firstBallRadius));
        firstBall.translate(getRectanglePosition(firstLine, firstLineLength).x,getRectanglePosition(firstLine, firstLineLength).y);
        firstBall.setMass(MassType.NORMAL);
        world.addBody(firstBall);

        // first line joint with first ball
        RevoluteJoint firstLineToFirstBall = new RevoluteJoint(firstLine, firstBall, getRectanglePosition(firstLine, firstLineLength));
        firstLineToFirstBall.setLimitEnabled(false);
        firstLineToFirstBall.setLimits(Math.toRadians(0.0), Math.toRadians(0.0));
        firstLineToFirstBall.setReferenceAngle(Math.toRadians(0.0));
        firstLineToFirstBall.setMotorEnabled(false);
        firstLineToFirstBall.setMotorSpeed(Math.toRadians(0.0));
        firstLineToFirstBall.setMaximumMotorTorque(0.0);
        firstLineToFirstBall.setCollisionAllowed(false);
        world.addJoint(firstLineToFirstBall);

    }
    @Override
    protected void render(Graphics2D g, double elapsedTime) {
        // move the view a bit
        g.translate(0, 0);

        super.render(g, elapsedTime);
    }

    private Vector2 getRectanglePosition(SimulationBody body, double bodyLength){
        double x = body.getLocalCenter().x + bodyLength * Math.sin(body.getTransform().getRotation());
        double y = body.getLocalCenter().y - bodyLength * Math.cos(body.getTransform().getRotation());
        return new Vector2(x, y) ;
    }
}
