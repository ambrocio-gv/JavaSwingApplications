/**
 This SceneCanvas class extends the JComponent class that allows graphics objects to be drawn
 by overriding the paintcomponent method and these objects are also used by the SceneFrame class where their
 properties such as color and position in reference to the frame will be altered.

 @author Gerard V. Ambrocio (207165)
 @version April 13, 2021
 **/

import javax.swing.*;
import java.awt.*;
import java.awt.geom.*;
import java.util.*;
import java.awt.Color;


public class SceneCanvas extends JComponent {
    private int width;
    private int height;
    private Color bgColor;
    private ArrayList<DrawingObject> ar;
    private Square chair1;
    private Circle circle1;
    private Line tableline1;
    private Line tableline2;
    private Body body1;
    private PC pc1;
    private Diamond window1;
    private Diamond window2;
    private Triangle triangle1;
    private Arm arm1;
    private  HorizontalRectangle table1;
    private HorizontalRectangle keyboard1;
    private Screen screen1;
    private Clock clock1;


    public SceneCanvas(int w, int h, Color bgc) {

        width = w;
        height = h;
        bgColor = bgc;

        setPreferredSize(new Dimension(1024, 768));

        chair1 = new Square(140, 290, 200, Color.black);



        table1 = new HorizontalRectangle(100,120,320, Color.decode("#BF6336"));
        tableline1 = new Line(215,575,215,800,30,Color.decode("#523A28"));
        tableline2 = new Line(1010,575,1010,800,30,Color.decode("#523A28"));

        keyboard1 = new HorizontalRectangle(130,200,100, Color.black);
        body1 = new Body(160,250,150,Color.darkGray);
        arm1 = new Arm(600,-150,150,Color.darkGray);


        clock1 = new Clock(780,350,1,Color.decode("#228280"),"06:10");

        triangle1 = new Triangle(300,200,1,Color.green);
        circle1 = new Circle(500,250,25, Color.RED);

        pc1 = new PC(120,10,2.5,Color.black);
        screen1 = new Screen(125,15,2.25, Color.cyan);

        window1 = new Diamond(0,0,3,Color.decode("#EF810E"));
        window2 = new Diamond(725,0,3,Color.decode("#EF810E"));

        ar = new ArrayList<DrawingObject>();


        ar.add(window1);
        ar.add(window2);
        ar.add(table1);
        ar.add(keyboard1);
        ar.add(pc1);
        ar.add(screen1);

        ar.add(tableline1);
        ar.add(tableline2);

        ar.add(body1);
        ar.add(arm1);
        ar.add(chair1);

        ar.add(clock1);

        ar.add(circle1);

    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;

        RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        g2d.setRenderingHints(rh);

        Rectangle2D.Double background = new Rectangle2D.Double(0, 0, width, height);
        g2d.setColor(bgColor);
        g2d.fill(background);



        for (int i = 0; i < ar.size(); i++){

            ar.get(i).draw(g2d);
        }

    }

    public Arm getArm(){
        return arm1;
    }
    public Screen getScreen(){
        return screen1;
    }

    public Diamond getWindow1(){return window1;}
    public Diamond getWindow2(){return window2;}
    public Clock getClock1(){return clock1;}

    public Circle getCircle1() {return circle1;}

    public void setColor(Color color){
        this.bgColor=color;
    }

}
