package MultiThreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class MTS11_1_myDefineThreadPool {

    public static void main(String[] args) {

        //创建自定义线程池
        ThreadPoolExecutor poolExecutor = new ThreadPoolExecutor(
                3,                          //核心线程的数量
                6,                                       //线程池中最大线程数量
                60,                                      //空闲时间(值)
                TimeUnit.SECONDS,                        //空闲时间(单位) 使用TimeUnit进行定义
                new ArrayBlockingQueue<>(3),    //阻塞队列
                Executors.defaultThreadFactory(),        //创建线程的方法(创建线程工厂)
                new ThreadPoolExecutor.AbortPolicy()     //对于过多任务的处理方法
        );
    }
}
