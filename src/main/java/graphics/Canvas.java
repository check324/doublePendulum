package main.java.graphics;

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
            if(e.getSource() == green) board.setGreenFlag(true);
            if(e.getSource() == blue) board.setBlueFlag(true);
            if(e.getSource() == red) board.setRedFlag(true);
            if(e.getSource() == gradient) board.setGradientFlag(true);
            if(e.getSource() == circle) board.setCircleFlag(true);
            board.repaint();
        }
    }
}
