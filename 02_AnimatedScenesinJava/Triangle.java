/**
 This class refers to the required composite shape programmatically drawn
 to use and to be be used by other classes, that triangle-shaped.

 @author Gerard V. Ambrocio (207165)
 @version April 13, 2021
 **/

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;

public class Triangle implements DrawingObject {

    private double x;
    private double y;
    private double size;
    private Color color;

    public Triangle(double x, double y, double size, Color color){
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

        Path2D.Double triangle = new Path2D.Double();
        triangle.moveTo(50,0);
        triangle.lineTo(0,50);
        triangle.lineTo(100,50);
        triangle.closePath();

        g2d.scale(size,size);
        g2d.setColor(color);
        g2d.fill(triangle);

        g2d.setTransform(reset);

    }

}
