/**
 This class refers to the clock that will be used to display time
 and will be animated to change the time on click later on.

 @author Gerard V. Ambrocio (207165)
 @version April 13, 2021
 **/


import java.awt.*;
import java.awt.geom.AffineTransform;


public class Clock implements DrawingObject {
    private double x;
    private double y;
    private double size;
    private Color color;

    private HorizontalRectangle clockface;
    private HorizontalRectangle clockcontainer;
    private Triangle clockstand;
    private String time;

    public Clock(double x, double y, double size, Color color, String time ){
        this.x = x;
        this.y = y;
        this.size = size;
        this.color = color;
        this.time = time;

    }

    @Override
    public void draw(Graphics2D g2d) {
        AffineTransform reset = g2d.getTransform();
        g2d.setTransform(reset);
        //g2d.rotate(Math.toRadians(degrees))
        g2d.translate(x,y);
        clockstand = new Triangle(20,10,size*1.5,color);
        clockface = new HorizontalRectangle(8,2.5,size*55, Color.decode("#202020"));
        clockcontainer = new HorizontalRectangle(0,0,size*65, color);




        clockcontainer.draw(g2d);
        clockstand.draw(g2d);


        //circlebody.draw(g2d);
        //g2d.setColor(color);
        clockface.draw(g2d);

        g2d.setFont(new Font("AMGDT", Font.BOLD, 50));
        g2d.setColor(Color.RED);


        g2d.drawString(time, 15, 50);

        g2d.setTransform(reset);


    }

    public void setTime(String time){
        this.time = time;
    }







}
