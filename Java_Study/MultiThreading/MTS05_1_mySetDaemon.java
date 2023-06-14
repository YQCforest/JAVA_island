package MultiThreading;

public class MTS05_1_mySetDaemon {
    public static void main(String[] args) {

        //守护线程
        MTS05_2_mySetDaemon mc1 = new MTS05_2_mySetDaemon();
        MTS05_3_mySetDaemon mc2 = new MTS05_3_mySetDaemon();

        mc1.setName("碇真嗣");
        mc2.setName("凌波丽");

        mc2.setDaemon(true);

        mc1.start();
        mc2.start();


    }
}

class MTS05_2_mySetDaemon extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(getName()+"---"+i);
        }
    }
}
class MTS05_3_mySetDaemon extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(getName()+"---"+i);
        }
    }
}