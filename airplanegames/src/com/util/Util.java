package com.util;


import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.awt.Image;
import java.io.IOException;
import java.net.URL;

public class Util {
    public static final int WIDTH=500;
    public static final int HEIGHT=500;
    public static final int PLANE_WIDTH=20;
    public static final int PLANE_HEIGHT=20;
    public static final String BALL_PATH="images/ball.png";
    public static final String PLANE_PATH="images/plane.png";
    public static final String BG_PATH="images/bg.png";
    public static final String BANG_PATH="images/effects/bang";
    private Util(){

    }

    public static Image getImage(String path){
        BufferedImage bufferedImage=null;
        try {
            URL url=Util.class.getClassLoader().getResource(path);
            bufferedImage= ImageIO.read(url);
        }catch (IOException e){
            e.printStackTrace();
        }
        return bufferedImage;
    }
}
