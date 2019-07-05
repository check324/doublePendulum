package main.java.physics;

import lombok.Getter;
import lombok.Setter;
import org.dyn4j.dynamics.Body;
import org.dyn4j.dynamics.World;
import org.dyn4j.geometry.Geometry;
import org.dyn4j.geometry.MassType;

/**
 * Created by gandalf.midearth 2019/7/4
 */
public class Ball {
    @Getter @Setter
    private final double firstBallRaidus = 5;
    private final double firstBallMass = 5;
    public Ball(){
        World world = new World();
        Body body = new Body();
        body.addFixture(Geometry.createCircle(firstBallRaidus));
        body.setMass(MassType.NORMAL);
    }
}
