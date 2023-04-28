package cn.tx;

import javax.swing.*;
import java.awt.*;

public class EnemyFly extends Thread{

    public GameFrame gf;
    //子弹的坐标大小和速度
    public int x,y;
    public int width=50;
    public int height=50;
    public int speed=2;

    public Image img = new ImageIcon("飞机/10028.png").getImage();

    public EnemyFly(int x,int y,GameFrame gf){
        super();
        this.x=x;
        this.y=y;
        this.gf=gf;
    }

    public EnemyFly(int x,int y,int width,int height,GameFrame gf){
        super();
        this.x=x;
        this.y=y;
        this.width=width;
        this.height=height;
        this.gf=gf;
    }

    //敌坤飞翔逻辑
    public void run(){
        while(true){

            //中弹了
            if(hit()){
                this.speed=0;
                this.img=new ImageIcon("飞机/300310_1.png").getImage();
                try{
                    this.sleep(500);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                gf.enemyFlies.remove(this);
                //被子弹击毁
                break;
            }
            //离开背景
            if(this.y>=760){
                break;
            }
            try{
                this.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }

    //碰撞检测
    public boolean hit(){
        Rectangle myrect = new Rectangle(this.x,this.y,this.width,this.height);

        Rectangle rect = null;

        for(int i=0;i<gf.bullets.size();i++){
            Bullet bullet = gf.bullets.get(i);
            //System.out.println("test hit");
            rect = new Rectangle(bullet.x,bullet.y-1,bullet.width,bullet.height);
            //碰撞检测
            if(myrect.intersects(rect)){
                return true;
            }
        }
        return false;
    }

}
