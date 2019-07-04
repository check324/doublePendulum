package main.java.graphics;

import ch.aplu.turtle.Turtle;

/**
 * Created by gandalf.midearth 2019/7/4
 */
public class Path extends Turtle {
    public void figure(double s){
        square(s);

        if (s < 1) {
            return;
        }else{
            forward(s);
            left(30);
            figure((Math.sqrt(3)*s)/2);
            right(90);
            forward((Math.sqrt(3)*s/2));

            //right part
            figure(s/2);
            back((Math.sqrt(3)*s/2));
            left(60);
            back(s);
        }
    }

    private void square(double s){
        for(int i=0; i<4; ++i){
            forward(s);
            right(90);
        }
    }
}
