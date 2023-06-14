package MultiThreading;

public class MTS04_1_mySleepMethod {
    public static void main(String[] args) throws InterruptedException {

        /*System.out.println("1111");
        //此时可以用抛出异常
        Thread.sleep(2000);
        System.out.println("2222");*/


        MTS04_2_mySleepMethod mc = new MTS04_2_mySleepMethod();
        mc.start();

    }
}

class MTS04_2_mySleepMethod extends Thread{
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            //此时必须用try-catch包裹
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(getName()+"@"+i);
        }
    }
}
