/**
This class refers to the arm that will be attatched to the body
 and will be animated to move using the adjustX class.

 @author Gerard V. Ambrocio (207165)
 @version April 13, 2021
 **/

import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.RoundRectangle2D;

public class Arm implements DrawingObject {
    private double x;
    private double y;
    private double size;
    private Color color;

    private Circle circlebody;

    public Arm(double x, double y, double size, Color color){
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


        circlebody = new Circle(x+10,y+40,size*.4, Color.black);


        RoundRectangle2D.Double armbody = new RoundRectangle2D.Double(x,y+50,size*.5,size*1.5,200,200);

        g2d.rotate(Math.toRadians(45),0,190);
        circlebody.draw(g2d);
        g2d.setColor(color);
        g2d.fill(armbody);


        g2d.translate(x,y);
        g2d.setTransform(reset);


    }

    public void adjustX(double amount){
        x+=-amount;
    }



}
