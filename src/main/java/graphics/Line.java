package main.java.graphics;

import lombok.Getter;
import lombok.Setter;
import main.java.framework.SimulationBody;
import org.dyn4j.geometry.Vector2;

public class Line extends SimulationBody {
    @Getter @Setter
    private Vector2 startPosition;
    @Getter @Setter
    private Vector2 endposition;
    public Line(){

        startPosition = new Vector2();
        endposition = new Vector2();
    }
}
