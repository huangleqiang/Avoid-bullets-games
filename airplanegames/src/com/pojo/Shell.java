package com.pojo;

import com.sun.org.apache.bcel.internal.classfile.Constant;
import com.util.Util;

import java.awt.Color;
import java.awt.Graphics;

public class Shell extends GameObject{
    double degree;

    public Shell() {
        degree=Math.random()*Math.PI*2;
        setX(200);
        setY(200);
        setWidth(10);
        setHeight(10);
        setSpeed(3);
    }

    public void draw(Graphics g){
        Color c=g.getColor();
        g.setColor(Color.yellow);

        g.fillOval((int) getX(),(int) getY(),getWidth(),getHeight());
        setX(getX()+getSpeed()*Math.cos(degree));
        setY(getY()+getSpeed()*Math.sin(degree));

        if (getY()> Util.HEIGHT-getHeight()||getY()<30)
            degree=-degree;
        if(getX()<0 ||getX()> Util.WIDTH-getWidth())
            degree=Math.PI-degree;
        g.setColor(c);

    }
}
