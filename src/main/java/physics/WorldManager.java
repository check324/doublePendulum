package main.java.physics;

import lombok.Getter;
import org.dyn4j.dynamics.Body;
import org.dyn4j.geometry.Geometry;
import org.dyn4j.geometry.MassType;

public class WorldManager {
    private static WorldManager worldManager;
    private World world;
    @Getter
    private Body firstBallBody;
    Ball firstBall;
    private WorldManager(){
        world = World.getInstance();
        firstBallBody = new Body();
        firstBall = new Ball();
        firstBallBody.addFixture(Geometry.createCircle(firstBall.getFirstBallRaidus()));
        firstBallBody.setMass(MassType.NORMAL);
    }

    public static WorldManager getInstance(){
        if(worldManager == null) worldManager = new WorldManager();
        return worldManager;
    }

}
