/**
 This class refers to the required circle class to draw a basic circle shape
 to use and to be used by other classes.

 @author Gerard V. Ambrocio (207165)
 @version April 13, 2021
 **/

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;


public class Circle implements DrawingObject{

    private double x;
    private double y;
    private double size;
    private Color color;

    public Circle(double x, double y, double size, Color color){
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();
        g2d.setTransform(reset);

        Ellipse2D.Double c = new Ellipse2D.Double(x, y, size, size);
        g2d.setColor(color);
        g2d.fill(c);


        g2d.setTransform(reset);

        //g2d.translate(x,y);

    }

    public void setLocation(double x, double y){

        this.x = x;
        this.y = y;


    }
}
