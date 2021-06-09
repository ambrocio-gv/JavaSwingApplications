/**
 This SceneFrame class refers to the frame or window where the SceneCanvas of objects will be located, two methods
 will then be used to simulate animation, one will change objects' properties upon clicking on the frame and the other
 will constantly change the arm object's position by moving the mouse.

 @author Gerard V. Ambrocio (207165)
 @version April 13, 2021
 **/

import javax.swing.*;
import javax.swing.event.MouseInputAdapter;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SceneFrame {
    private JFrame frame;
    private SceneCanvas sceneCanvas;
    private int oldgetX = -1;
    private int armcounter = 5;
    private int clickcounter = 6;



    public SceneFrame() {
        frame = new JFrame();
        sceneCanvas = new SceneCanvas(1024, 768, Color.decode("#BEC1C2"));

        ActionsOnClick();
        ArmMove();

    }

    public void ActionsOnClick(){
        sceneCanvas.addMouseListener(new MouseInputAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);


                clickcounter+=1;
                Random rand = new Random();
                float r = (float) (rand.nextFloat() / 2f + 0.5);
                float g = (float) (rand.nextFloat() / 2f + 0.5);
                float b = (float) (rand.nextFloat() / 2f + 0.5);
                Color randomColor = new Color(r, g, b);

                Screen screen =sceneCanvas.getScreen();
                screen.setColor(randomColor);
                Diamond window1 = sceneCanvas.getWindow1();
                Diamond window2 = sceneCanvas.getWindow2();
                Clock clock1 = sceneCanvas.getClock1();
                Circle circle1 = sceneCanvas.getCircle1();


                int clicksetting = clickcounter % 6;

                switch (clicksetting){
                    case 1:
                        clock1.setTime("09:40");
                        circle1.setLocation(590,75);
                        window1.setColor(Color.decode("#E5DE44"));
                        window2.setColor(Color.decode("#E5DE44"));
                        sceneCanvas.setColor(Color.decode("#EDF1F2"));
                        break;
                    case 2:
                        clock1.setTime("13:30");
                        circle1.setLocation(670,250);
                        window1.setColor(Color.decode("#E5DE44"));
                        window2.setColor(Color.decode("#E5DE44"));
                        sceneCanvas.setColor(Color.decode("#EDF1F2"));
                        break;
                    case 3:
                        clock1.setTime("18:00");
                        circle1.setLocation(500,250);
                        window1.setColor(Color.decode("#EF810E"));
                        window2.setColor(Color.decode("#EF810E"));
                        sceneCanvas.setColor(Color.decode("#989A9B"));

                        break;
                    case 4:
                        clock1.setTime("22:20");
                        circle1.setLocation(590,75);
                        window1.setColor(Color.decode("#053752"));
                        window2.setColor(Color.decode("#053752"));
                        sceneCanvas.setColor(Color.decode("#626263"));
                        break;
                    case 5:
                        clock1.setTime("03:15");
                        circle1.setLocation(670,250);
                        window1.setColor(Color.decode("#001A26"));
                        window2.setColor(Color.decode("#001A26"));
                        sceneCanvas.setColor(Color.decode("#3E3E3F"));
                        break;
                    case 0:
                        clock1.setTime("05:45");
                        circle1.setLocation(500,250);
                        window1.setColor(Color.decode("#EF810E"));
                        window2.setColor(Color.decode("#EF810E"));
                        sceneCanvas.setColor(Color.decode("#7A7B7C"));
                        break;
                }

                sceneCanvas.repaint();
            }
        });
    }

    public void ArmMove(){
        sceneCanvas.addMouseMotionListener(new MouseInputAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                super.mouseMoved(e);

                Arm arm = sceneCanvas.getArm();

                int x = e.getX();

                if (oldgetX == -1){
                    oldgetX = x;
                }
                else if(x>=oldgetX){

                    // System.out.println("right" + counter);
                    armcounter +=1;

                    if (armcounter <7) {
                        arm.adjustX(-5);
                    }
                    else if (armcounter >=7) {
                        armcounter = 5;
                        arm.adjustX(5);
                    }
                }
                else if(x<oldgetX){

                    //System.out.println("left" + counter);
                    armcounter -=1;

                    if ( armcounter >3){
                        arm.adjustX(5);
                    }
                    else if (armcounter <=3){
                        armcounter = 5;
                        arm.adjustX(-5);
                    }
                }

                sceneCanvas.repaint();
            }
        });
    }

    public void setUpGUI() {
        Container cp = frame.getContentPane();
        frame.setSize(640, 480);
        frame.setTitle("Midterm Project - Ambrocio, Gerard 207165");

        cp.add(sceneCanvas, BorderLayout.CENTER);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }


}
