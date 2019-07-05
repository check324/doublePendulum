package main.java.physics;

public class World {
    private static World world;
    private World(){}
    public static World getInstance(){
        if(world == null) world = new World();
        return world;
    }
}
