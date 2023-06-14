package MultiThreading;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MTS10_1_ThreadPool {
    public static void main(String[] args) throws InterruptedException {
        //无上限线程池
        ExecutorService pool1 = Executors.newCachedThreadPool();
        //添加睡眠时间观察复用情况
        Thread.sleep(1000);
        pool1.submit(new myThread());
        Thread.sleep(1000);
        pool1.submit(new myThread());
        Thread.sleep(1000);
        pool1.submit(new myThread());
        Thread.sleep(1000);
        pool1.submit(new myThread());
        pool1.shutdown();


        //有上限线程池
        ExecutorService pool2 = Executors.newFixedThreadPool(3);
        pool2.submit(new myThread());
        pool2.submit(new myThread());
        pool2.submit(new myThread());
        pool2.shutdown();
    }
}

class myThread implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "----");
    }
}
