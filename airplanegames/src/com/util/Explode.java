package com.util;

import java.awt.*;

/**
 * 爆炸特效类
 * 图片太少了，搞不动
 */
public class Explode {
    double x,y;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    static Image[] images=new Image[6];
    static {
        for (int i = 0; i < 6; i++) {
            images[i]=Util.getImage("images/effects/bang"+(i+1)+".png");
            images[i].getWidth(null);
        }
    }
    public int count=1;
    public void drawd(Graphics g){
        if (count<=5){
            g.drawImage(images[count],(int) x,(int) y,null);
            count++;
        }
    }
    public Explode(double x, double y){
        this.x=x;
        this.y=y;
    }
}
