package cn.tx;

import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;
import java.util.Vector;

//继承于总父类 JFrame 是JAVA中的的可视化窗口类
public class GameFrame extends JFrame {

    //我的飞机
    HeroFly heroFly;

    //定义子弹的集合
    //并发处理集合,当子弹超过背景的xy轴时候就要销毁，需要线程安全的集合
    Vector<Bullet> bullets = new Vector<>();
    //敌坤集合，用来存放敌坤
    Vector<EnemyFly> enemyFlies = new Vector<>();

    GameFrame frame;

    public GameFrame(){

        frame=this;

        //创建我的飞机
        heroFly = new HeroFly();
        //启动线程
        heroFly.start();

        //设置窗体的宽高
        this.setSize(500,760);
        //标题
        this.setTitle("雷霆战坤");
        this.setResizable(false);
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        //窗口可见
        this.setVisible(true);


        //启动单独线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                //不断调用这个画板
                while(true) {
                    repaint();
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();

        //启动单独线程 产生敌坤
        new Thread(new Runnable() {
            Random r= new Random();
            @Override
            public void run() {
                while(true){
                    EnemyFly enemyFly = new EnemyFly(r.nextInt(500),0,frame);
                    enemyFly.start();
                    //随机产生x轴坐标，随机产生敌机
                    enemyFlies.add(enemyFly);
                    try {
                        Thread.sleep(1500);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            }
        }).start();
    }



    //需要不断绘画这个画板，采用多线程
    //给一个单独线程，不断调用这个方法，从而不断打印这个画板
    public void paint(Graphics g){
       // System.out.println("绘制画板");
        //画背景
        BufferedImage image = (BufferedImage) this.createImage(this.getSize().width,this.getSize().height);
        //高效缓存的画笔
        Graphics bi = image.getGraphics();
        //画背景
        bi.drawImage(new ImageIcon("飞机/MAP02_02.png").getImage(),10,0,null);
        //将我的飞机画进背景图片
        bi.drawImage(heroFly.img, heroFly.x, heroFly.y,heroFly.width, heroFly.height, null);
        //飞机发炮
        //遍历整个集合，拿出每一个子弹然后画出来
        for (int i = 0; i < bullets.size(); i++) {
            Bullet bullet = bullets.get(i);
            if(bullet.y>0){
                bi.drawImage(bullet.image, bullet.x, bullet.y-=bullet.speed,bullet.width, bullet.height, null);
            }
            else{
                bullets.remove(bullet);
            }
        }
        //遍历整个集合，画出敌坤
        for (int i = 0; i < enemyFlies.size(); i++) {
            EnemyFly ep = enemyFlies.get(i);
            if(ep.y<760){
                bi.drawImage(ep.img, ep.x, ep.y+=ep.speed,ep.width, ep.height, null);
            }
            else{
                bullets.remove(ep);
            }
        }





        //生效
        g.drawImage(image,0,0,null);
    }

    //主线程
    public static void main(String[] args) {
        GameFrame frame = new GameFrame();

        Player player = new Player(frame);
        frame.addKeyListener(player);

    }


}
