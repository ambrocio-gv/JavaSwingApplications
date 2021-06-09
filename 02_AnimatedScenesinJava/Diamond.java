/**
 This class refers to the required composite shape programmatically drawn
 to use and to be be used by other classes, that diamond-shaped.

 @author Gerard V. Ambrocio (207165)
 @version April 13, 2021
 **/
import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Path2D;



public class Diamond implements DrawingObject {

    private double x;
    private double y;
    private double size;
    private Color color;
    private Line lineV;
    private Line lineH;

    public Diamond (double x, double y, double size, Color color){
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

        Path2D.Double diamond = new Path2D.Double();
        diamond.moveTo(50,0);
        diamond.lineTo(0,75);
        diamond.lineTo(50,150);
        diamond.lineTo(100,75);
        diamond.closePath();


        g2d.scale(size,size);
        g2d.setColor(color);
        g2d.fill(diamond);

        g2d.setTransform(reset);
        g2d.translate(x,y);
        lineV = new Line(150,0,150,450,2, Color.black);
        lineH = new Line(0,225,300,225,2, Color.black);
        lineV.draw(g2d);
        lineH.draw(g2d);

        g2d.setTransform(reset);
    }

    public void setColor(Color color){
        this.color=color;
    }

}
