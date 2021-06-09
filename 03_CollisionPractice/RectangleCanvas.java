/**
 This is a template for a Java file.

 @author Gerard V. Ambrocio
 @version May 05,2021
 **/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class RectangleCanvas extends JComponent {
    private MyRectangle r1;
    private MyRectangle r2;
    private int width;
    private int height;

    public RectangleCanvas(int w, int h){
        //instantiating 2  MyRectangles
        width = w;
        height = h;
        r1 = new MyRectangle(110,140,150,150,5);
        r2 = new MyRectangle(320,200,150,150,5);
    }

    //drawing the rectangles
    @Override
    protected void paintComponent(Graphics g){
        g.setColor(Color.black);
        r1.draw(g);
        g.setColor(Color.blue);
        r2.draw(g);
    }

    public void startAnimation() {
        //instantiating a timer every 20 ms
        Timer animationTimer = new Timer(20, new ActionListener() {

            //moving the rectangles
            @Override
            public void actionPerformed(ActionEvent ae) {
                //determining if collision occurs and adjusting the movement of each rectangle
                if(r1.isColliding(r2)){
                    r1.reverseHspeed();
                    r1.reverseVspeed();
                    r2.reverseHspeed();
                    r2.reverseVspeed();
                }

                //determining the appropriate direction of movement of each rectangle
                if(r1.getX() + r1.getWidth() >= width) {
                   r1.reverseHspeed();
                }
                else if(r1.getY() + r1.getHeight() >= height){
                    r1.reverseVspeed();
                }
                else if(r1.getX() <= 0 ){
                    r1.reverseHspeed();
                }
                else if(r1.getY() <= 0){
                    r1.reverseVspeed();
                }

                if(r2.getX() + r2.getWidth() >= width) {
                    r2.reverseHspeed();
                }
                else if(r2.getY() + r2.getHeight() >= height){
                    r2.reverseVspeed();
                }
                else if(r2.getX() <= 0 ){
                    r2.reverseHspeed();
                }
                else if(r2.getY() <= 0){
                    r2.reverseVspeed();
                }

                r1.setDirection("1");
                r1.move();
                r2.setDirection("2");
                r2.move();
                repaint();
            }
        });
        animationTimer.start();
    }


}
