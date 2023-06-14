package MultiThreading;

public class MTS07_1_ThreadSafety {
    public static void main(String[] args) {

        //用窗口卖票的实例来进行线程安全

        MTS07_2_ThreadSafety mc1 = new MTS07_2_ThreadSafety();
        MTS07_2_ThreadSafety mc2 = new MTS07_2_ThreadSafety();
        MTS07_2_ThreadSafety mc3 = new MTS07_2_ThreadSafety();

        mc1.setName("窗口1");
        mc2.setName("窗口2");
        mc3.setName("窗口3");

        mc1.start();
        mc2.start();
        mc3.start();

        MTS07_3_ThreadSafety mc = new MTS07_3_ThreadSafety();
        Thread t1 = new Thread(mc);
        Thread t2 = new Thread(mc);
        Thread t3 = new Thread(mc);

        t1.setName("窗口1");
        t2.setName("窗口2");
        t3.setName("窗口3");

        t1.start();
        t2.start();
        t3.start();



    }
}

class MTS07_2_ThreadSafety extends Thread {
    //同步代码块 实现线程安全
    static int ticket = 0;
    @Override
    public void run() {
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (MTS07_2_ThreadSafety.class) {
                if (ticket < 100) {
                    ticket++;
                    System.out.println(getName() + "正在卖" + ticket + "张票");
                } else {
                    break;
                }
            }
        }
    }
}

class MTS07_3_ThreadSafety  implements Runnable{

    int ticket=0;

    @Override
    public void run() {
        while(true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if(method()) break;
        }
    }

    private synchronized boolean method(){
        if(ticket==100){
            return true;
        }else{
            ticket++;
            System.out.println(Thread.currentThread().getName()+"正在卖" + ticket + "张票");
        }
        return false;
    }
}
