/**
 This is a template for a Java file.

 @author Gerard V. Ambrocio
 @version May 05,2021
 **/

import java.awt.*;

public class MyRectangle {
    //instance fields
    private int x ;
    private int y;
    private int width;
    private int height;
    private int Hspeed;
    private int Vspeed;
    private boolean up, down, left, right;

    //constructor
    public MyRectangle(int x, int y, int width, int height, int speed){
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
        this.Hspeed = speed;
        this.Vspeed = speed;
        this.up = false;
        this.down = false;
        this.left = false;
        this.right = false;
    }

    public void draw(Graphics g){
        g.fillRect(x, y, width, height);
    }
    //accessor for all
    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public int getHspeed() { return Hspeed; }

    public int getVspeed() {
        return Vspeed;
    }

    //mutator for position
    public void setX(int n){ this.x = n;}
    public void setY(int n){ this.y = n;}

    public void move(){
        if (up) {
            this.y -= getVspeed();
        }
        else if (down){
            this.y += getVspeed();
        }
        if(left){
            this.x -= getHspeed();
        }
        else if(right){
            this.x += getHspeed();
        }
    }

    //change direction of movement
    public void setDirection(String dir){
        if(dir.equals("1")){
            up = true;
            down = false;
            left = true;
            right = false;
        } else if(dir.equals("2")){
            up = false;
            down = true;
            left = true;
            right = false;

        } else{
            up = false;
            down = false;
            left = false;
            right = false;
        }
    }

    //reverse horizontal speed
    public void reverseHspeed(){
        this.Hspeed *= -1;
    }

    //reverse vertical speed
    public void reverseVspeed(){
        this.Vspeed *= -1;
    }

    //if collision occurs between two rectangles
    public boolean isColliding(MyRectangle other){
        return !(this.x + this.width <= other.getX() ||
                this.x >= other.getX() + other.getWidth() ||
                this.y + this.height <= other.getY() ||
                this.y >= other.getY() + other.getHeight());
    }

}
