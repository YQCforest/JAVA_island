package cn.tx;

import javax.swing.*;
import java.awt.*;

public class HeroFly extends Thread {

    //我的飞机在画板上的位置
    int x = 230, y = 600;
    int width = 50, height = 50;
    //飞机移动的速度
    int speed = 10;

    Image img = new ImageIcon("飞机/10011.png").getImage();


    //定义方向键标志
    boolean up, down, left, right;


    public HeroFly() {
    }

    public HeroFly(int x, int y, int width, int height) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.height = height;

    }

    //重写run方法
    @Override
    public void run() {
        //循环中不断判断是否按下了上下左右
        while (true) {
            if (up) {
                y -= speed;
            }
            else if (down) {
                y += speed;
            }
            else if (left) {
                x -= speed;
            }
            else if (right) {
                x += speed;
            }

            //在死循中需要加入睡眠防止出现问题
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
