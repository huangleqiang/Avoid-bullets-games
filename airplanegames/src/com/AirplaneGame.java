package com;

import com.pojo.Shell;
import com.pojo.ext.Plane;
import com.util.Explode;
import com.util.Util;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.Date;

public class AirplaneGame extends Frame {
    Image ball= Util.getImage(Util.BALL_PATH);
    Image bg=Util.getImage(Util.BG_PATH);
    Image planeImage=Util.getImage(Util.PLANE_PATH);

    Plane plane=new Plane(planeImage,250,250);
    ArrayList<Shell> shells =new ArrayList<>();
    Explode explode;

    Date startTime=new Date();
    Date endTime;

    int period;

    @Override
    public void paint(Graphics g) {
        g.drawImage(bg,0,0,null);
        plane.drawSelf(g);
        for (int i = 0; i < shells.size(); i++) {
            Shell shell=shells.get(i);
            shell.draw(g);
            boolean collision=shell.getRect().intersects(plane.getRect());
            if (collision) {
                plane.setLive(false);
                if (explode==null) {
                    explode = new Explode(plane.getX(), plane.getY());
                    endTime=new Date();
                    period=(int) (endTime.getTime()-startTime.getTime())/1000;
                }

                explode.drawd(g);
            }
            if (!plane.isLive()){
                g.setColor(Color.red);
                Font font=new Font("宋体",Font.BOLD,60);
                g.setFont(font);
                g.drawString("时间"+period+"s",Util.WIDTH/2-30,Util.HEIGHT/2-30);

            }
        }
    }

    public Image offScreenImage=null;

    /**
     * 在内存创建缓冲区
     * 在缓冲区画图
     * 释放内存缓冲区
     * 双缓冲技术：现在内存中绘图，再拷贝到对象中，然后释放
     */
    @Override
    public void update(Graphics g){
        if (offScreenImage==null)
            offScreenImage=this.createImage(Util.WIDTH,Util.HEIGHT);
        Graphics gOff=offScreenImage.getGraphics();
        paint(gOff);
        g.drawImage(offScreenImage,0,0,null);
    }


    public void launchFrame(){
        setTitle("飞机大战");
        setVisible(true);
        setSize(Util.WIDTH,Util.HEIGHT);
        setLocation(300,300);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });

        new PaintThread().start();

        //飞机移动键盘监听事件
        addKeyListener(new KeyMonitor());

        for (int i = 0; i < 50; i++) {
            Shell shell=new Shell();
            shells.add(shell);
        }
    }


    class KeyMonitor extends KeyAdapter{

        @Override
        public void keyTyped(KeyEvent e) {
            super.keyTyped(e);
        }

        @Override
        public void keyPressed(KeyEvent e) {
            plane.addDirection(e);
        }

        @Override
        public void keyReleased(KeyEvent e) {
            plane.minuDirection(e);
        }
    }

    class PaintThread extends Thread{
        @Override
        public void run() {
            while (true){
                repaint();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        AirplaneGame f=new AirplaneGame();
        f.launchFrame();
    }
}
