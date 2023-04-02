package com.pojo.ext;

import com.pojo.GameObject;
import com.util.Util;

import java.awt.*;
import java.awt.event.KeyEvent;

public class Plane extends GameObject {


    boolean left,up,right,down,live=true;

    public boolean isLive() {
        return live;
    }

    public void setLive(boolean live) {
        this.live = live;
    }

    public Plane() {
        super();
    }

    public Plane(Image image, double x, double y) {
        super(image, x, y);
        setHeight(Util.PLANE_HEIGHT);
        setWidth(Util.PLANE_WIDTH);
    }

    public Plane(Image image, double x, double y, int speed, int width, int height) {
        super(image, x, y, speed, width, height);
    }

    public void addDirection(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                left=true;
                break;
            case KeyEvent.VK_UP:
                up=true;
                break;
            case KeyEvent.VK_RIGHT:
                right=true;
                break;
            case KeyEvent.VK_DOWN:
                down=true;
                break;
            default:
                break;
        }
    }

    public void minuDirection(KeyEvent e){
        switch (e.getKeyCode()){
            case KeyEvent.VK_LEFT:
                left=false;
                break;
            case KeyEvent.VK_UP:
                up=false;
                break;
            case KeyEvent.VK_RIGHT:
                right=false;
                break;
            case KeyEvent.VK_DOWN:
                down=false;
                break;
            default:
                break;
        }
    }


    @Override
    public void drawSelf(Graphics g) {
        if(live) {
            super.drawSelf(g);
            if (left)
                setX(getX() - getSpeed());
            if (right)
                setX(getX() + getSpeed());
            if (up)
                setY(getY() - getSpeed());
            if (down)
                setY(getY() + getSpeed());
        }else {
            System.out.println("Done!");
        }
    }
}
