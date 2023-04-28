package cn.tx;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

/**
 * 定义一个玩家
 * 继承于键盘适配器，键盘适配器可以监听键盘事件
 */

public class Player extends KeyAdapter {

    GameFrame frame;

    public Player(GameFrame frame) {
        this.frame = frame;
    }

    //重写两个方法，分别是按下按键和松开按键
    @Override
    public void keyPressed(KeyEvent e) {
       int keyCode = e.getKeyCode();
        //38上、40下、37左、39右
        switch (keyCode){
            case 38:
                frame.heroFly.up=true;
                break;
            case 40:
                frame.heroFly.down=true;
                break;
            case 37:
                frame.heroFly.left=true;
                break;
            case 39:
                frame.heroFly.right=true;
                break;
            case 66:
                addBullet();
                break;
        }
    }


    @Override
    public void keyReleased(KeyEvent e) {
        int keyCode = e.getKeyCode();
        //38上、40下、37左、39右
        switch (keyCode){
            case 38:
                frame.heroFly.up=false;
                break;
            case 40:
                frame.heroFly.down=false;
                break;
            case 37:
                frame.heroFly.left=false;
                break;
            case 39:
                frame.heroFly.right=false;
                break;
       }
    }

    //装弹
    public void addBullet(){
        frame.bullets.add(new Bullet(frame.heroFly.x+5,frame.heroFly.y-20));
    }
}
