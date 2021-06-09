/**
 This class refers to the static PC object that will be contain a separate screen
 class that will be used to show animation.

 @author Gerard V. Ambrocio (207165)
 @version April 13, 2021
 **/

import java.awt.*;
import java.awt.geom.AffineTransform;


public class PC implements DrawingObject {
    private double x;
    private double y;
    private double size;
    private Color color;
    private Square monitor;
    private Triangle stand;

    public PC(double x, double y, double size, Color color){
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

        monitor = new Square(x + 50, y+0 , size*110, color);
        stand = new Triangle(x+270,y+250,size/1.5,color);

        monitor.draw(g2d);
        stand.draw(g2d);


        g2d.setTransform(reset);

    }
}

