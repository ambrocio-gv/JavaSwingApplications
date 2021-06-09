/**
 This is a template for a Java file.

 @author Gerard V. Ambrocio
 @version May 05,2021
 **/

import javax.swing.*;
import java.awt.*;

public class CollisionTester{
    public static void main(String[] args) {
        //Instantiate JFrame
        JFrame f = new JFrame();

        //Instantiate a RectangleCanvas w/ dimension 800 x 600
        RectangleCanvas rc = new RectangleCanvas(800,600);
        f.add(rc);
        rc.setPreferredSize(new Dimension(800, 600));

        //Set title
        f.setTitle("Collision Detection");
        f.pack();

        //set close operation
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //set visibility of the frame
        f.setVisible(true);
        rc.startAnimation();
    }
}
