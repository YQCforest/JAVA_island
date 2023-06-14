package MultiThreading;

public class MTS02_1_myRunnable {
    public static void main(String[] args) {
        MTS02_2_myRunnable m = new MTS02_2_myRunnable();

        Thread t1 = new Thread(m);
        Thread t2 = new Thread(m);
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }
}
class MTS02_2_myRunnable implements Runnable{

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName()+"EVANGLION:III:I");
        }
    }
}