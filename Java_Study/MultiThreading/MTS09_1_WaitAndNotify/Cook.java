package MultiThreading.MTS09_1_WaitAndNotify;

public class Cook extends Thread {

    @Override
    public void run() {

        while (true) {

            synchronized (Desk.lock) {

                if (Desk.sum == 0) {
                    break;
                } else {

                    if (Desk.foodFlag == 1) {
                        try {
                            Desk.lock.wait();
                        } catch (InterruptedException e) {
                            throw new RuntimeException(e);
                        }
                    } else {
                        System.out.println("厨师做了一碗面");
                        Desk.foodFlag = 1;
                        Desk.lock.notifyAll();
                    }
                }
            }
        }
    }
}
