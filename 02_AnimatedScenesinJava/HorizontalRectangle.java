/**
 This class refers to the an extra class to draw a horizontal rectangle shape
 to use and to be used by other classes.

 @author Gerard V. Ambrocio (207165)
 @version April 13, 2021
 **/

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public class HorizontalRectangle implements DrawingObject {

    private double x;
    private double y;
    private double size;
    private Color color;

    public HorizontalRectangle(double x, double y, double size, Color color){
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

        Rectangle2D.Double sq = new Rectangle2D.Double(x, y, size*3, size); // square same width and height
        g2d.setColor(color);
        g2d.fill(sq);

        g2d.setTransform(reset);

    }





}
