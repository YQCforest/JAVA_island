package MultiThreading;

public class MTS06_1_myJoin {
    public static void main(String[] args) throws InterruptedException {

        MTS06_2_myJoin mc = new MTS06_2_myJoin();
        mc.setName("线程1");
        mc.start();
        //插入线程，将这个线程执行玩后才会执行其他线程
        mc.join();

        for(int i=0;i<=10;i++){
            System.out.println("main方法的线程>"+i);
        }


    }
}
class MTS06_2_myJoin extends Thread{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+">"+i);
        }
    }
}
