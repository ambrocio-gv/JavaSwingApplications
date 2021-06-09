/**
 This class refers to a screen that is positioned in the PC object and will change into a random color
 later on upon clicking.

 @author Gerard V. Ambrocio (207165)
 @version April 13, 2021
 **/

import java.awt.*;
import java.awt.geom.AffineTransform;


public class Screen implements DrawingObject {

    private double x;
    private double y;
    private double size;
    private Color color;
    Square screen;

    public Screen(double x, double y, double size, Color color){
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }



    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();
        g2d.setTransform(reset);

        g2d.translate(x,y);
        screen = new Square(x + 50, y+0 , size*110, color);

        screen.draw(g2d);

        g2d.setFont(new Font("Lucida Handwriting", Font.BOLD, 20));
        g2d.setColor(Color.black);
        g2d.drawString("Eat. Pray. Java. ", 385, 160);

        g2d.setTransform(reset);

    }

    public void setColor(Color color){
        this.color=color;
    }

}
