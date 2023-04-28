package cn.tx;

import javax.swing.*;
import java.awt.*;

public class Bullet {

    int x,y;
    int width=50,height=50;

    //定义子弹默认速度
    int speed = 10;

    Image image = new ImageIcon("飞机/30022.png").getImage();

    public Bullet(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Bullet(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;
    }
}
