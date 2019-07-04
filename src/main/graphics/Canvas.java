package main.graphics;

import lombok.Getter;
import lombok.Setter;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by gandalf.midearth 2019/7/4
 */

public class Canvas extends JFrame{
    Container container;
    Board board;
    JButton green, red, blue, gradient, circle;

    private static @Getter @Setter boolean greenFlag;
    private static @Getter @Setter boolean redFlag;
    private static @Getter @Setter boolean blueFlag;
    private static @Getter @Setter boolean gradientFlag;
    private static @Getter @Setter boolean circleFlag;

    public Canvas(){
        container = getContentPane();
        board = new Board();

        //buttons
        green = new JButton("Green");
        red = new JButton("Red");
        blue = new JButton("Blue");
        gradient = new JButton("Gradient");
        circle = new JButton("Circle");

        //listener
        green.addActionListener(new BListener());
        red.addActionListener(new BListener());
        blue.addActionListener(new BListener());
        gradient.addActionListener(new BListener());
        circle.addActionListener(new BListener());

        //add
        board.add(green);
        board.add(red);
        board.add(blue);
        board.add(gradient);
        board.add(circle);
        container.add(board);
    }

    //Listener
    class BListener implements ActionListener{
        public void actionPerformed(ActionEvent e){
            if(e.getSource() == green) setGreenFlag(true);
            if(e.getSource() == blue) setBlueFlag(true);
            if(e.getSource() == red) setRedFlag(true);
            if(e.getSource() == gradient) setGradientFlag(true);
            if(e.getSource() == circle) setCircleFlag(true);
            board.repaint();
        }
    }
}
