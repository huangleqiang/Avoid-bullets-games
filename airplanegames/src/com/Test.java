package com;


import com.util.Explode;

import javax.swing.*;
import java.awt.*;


public class Test extends JFrame {
    public static void main(String[] args) {

        Test test=new Test();
        test.setTitle("TEST");
        test.setSize(500,500);
        test.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        test.setVisible(true);
    }

    @Override
    public void paint(Graphics g) {
        Explode explode=new Explode(0,0);
        explode.drawd(g);
        explode.drawd(g);
        explode.drawd(g);
        explode.drawd(g);
        explode.drawd(g);
        explode.drawd(g);
    }
}
