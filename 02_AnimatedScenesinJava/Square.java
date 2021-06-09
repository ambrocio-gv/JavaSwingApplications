/**
 This class refers to the required square class to draw a basic square shape
 to use and to be used by other classes.

 @author Gerard V. Ambrocio (207165)
 @version April 13, 2021
 **/

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public class Square implements DrawingObject {

    private double x;
    private double y;
    private double size;
    private Color color;

    public Square(double x, double y, double size, Color color){
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
    }



    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();
        g2d.setTransform(reset);
        //g2d.rotate(Math.toRadians(degrees))
        g2d.translate(x,y);

        Rectangle2D.Double sq = new Rectangle2D.Double(x, y, size, size); // square same width and height
        g2d.setColor(color);
        g2d.fill(sq);
        g2d.setTransform(reset);

    }


}
