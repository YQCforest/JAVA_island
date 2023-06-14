package MultiThreading.MTS09_1_WaitAndNotify;

public class Foodie extends Thread {
    @Override
    public void run() {

        while (true) {
            synchronized (Desk.lock) {
                if (Desk.sum == 0) {
                    break;
                } else {

                    if (Desk.foodFlag == 0) {
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        Desk.sum--;
                        System.out.println("我正在吃面，还能吃" + Desk.sum + "碗");
                        Desk.lock.notifyAll();
                        Desk.foodFlag = 0;
                    }
                }
            }
        }
    }
}
