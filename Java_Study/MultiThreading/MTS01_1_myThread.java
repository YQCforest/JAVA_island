package MultiThreading;

public class MTS01_1_myThread {
    public static void main(String[] args) {
        MTS01_2_myThread t1 = new MTS01_2_myThread();
        MTS01_2_myThread t2 = new MTS01_2_myThread();
        t1.setName("线程1");
        t2.setName("线程2");
        t1.start();
        t2.start();
    }
}
class MTS01_2_myThread extends Thread {
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+"EVANGLION:III:I");
        }

    }
}