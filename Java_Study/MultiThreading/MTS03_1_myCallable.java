package MultiThreading;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

public class MTS03_1_myCallable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //首先创建MTS03_2_myCallable对象
        MTS03_2_myCallable mc = new MTS03_2_myCallable();
        //接着创建FutureTask对象，注意有泛型，传入参数mc
        FutureTask<Integer> ft = new FutureTask<>(mc);
        //创建Thread对象，传入参数ft
        Thread t = new Thread(ft);
        //启动线程
        t.start();
        //获取到多线程的结果
        Integer result = ft.get();
        System.out.println(result);
    }
}

//实现Callable有泛型
//想要得到多线程的结果是什么类型，在Callable中的泛型中就写入什么类型
class MTS03_2_myCallable implements Callable<Integer> {

    //求1~100的和
    //重写call方法
    @Override
    public Integer call() throws Exception {
        int sum=0;
        for (int i = 1; i <= 100; i++) {
            sum+=i;
        }
        return sum;
    }
}