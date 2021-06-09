import java.awt.*;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RoundRectangle2D;

public class Body implements DrawingObject {
    private double x;
    private double y;
    private double size;
    private Color color;
    private Square squarebody;
    private Circle circlebody;

    public Body(double x, double y, double size, Color color){
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
        g2d.setColor(color);
        circlebody = new Circle(x+40,y-130,size, color);


        RoundRectangle2D.Double mainbody = new RoundRectangle2D.Double(x,y,size*1.5,size*2,100,100);



        circlebody.draw(g2d);
        g2d.setColor(color);
        g2d.fill(mainbody);


        g2d.setTransform(reset);


    }
}
