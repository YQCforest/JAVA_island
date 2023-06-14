package MultiThreading;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class MTS08_1_Lock {
    public static void main(String[] args) {

        MTS08_2_Lock mc1 = new MTS08_2_Lock();
        MTS08_2_Lock mc2 = new MTS08_2_Lock();
        MTS08_2_Lock mc3 = new MTS08_2_Lock();

        mc1.setName("窗口1");
        mc2.setName("窗口2");
        mc3.setName("窗口3");

        mc1.start();
        mc2.start();
        mc3.start();
    }
}


class MTS08_2_Lock extends Thread{

    static int ticket = 0;
    static Lock lock = new ReentrantLock();
    @Override
    public void run() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
           e.printStackTrace();
        }
        while(true){
            lock.lock();
            try {
                if(ticket==100){
                    break;
                }else{
                    ticket++;
                    System.out.println(getName()+"正在卖"+ticket+"张票");
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        }
    }
}