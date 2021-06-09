/**
 This class refers to the required line class to draw a basic line
 to use and to be used by other classes.

 @author Gerard V. Ambrocio (207165)
 @version April 13, 2021
 **/

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Line2D;

public class Line implements DrawingObject {

    private double x1;
    private double y1;
    private double x2;
    private double y2;
    private float thickness;
    private Color color;

    public Line(double x1, double y1, double x2, double y2, float thickness, Color color){
        this.x1 = x1;
        this.y1 = y1;
        this.x2 = x2;
        this.y2 = y2;
        this.thickness = thickness;
        this.color = color;
    }

    @Override
    public void draw(Graphics2D g2d) {

        AffineTransform reset = g2d.getTransform();
        g2d.setTransform(reset);

        Line2D.Double l = new Line2D.Double(x1, y1, x2, y2);
        g2d.setColor(color);
        g2d.setStroke(new BasicStroke(thickness));
        g2d.draw(l);

        //g2d.translate(x,y);

        g2d.setTransform(reset);
    }
}
