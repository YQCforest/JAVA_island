package MultiThreading.MTS09_1_WaitAndNotify;

public class Test {

    public static void main(String[] args) {

        Foodie f = new Foodie();
        Cook c=  new Cook();

        f.start();
        c.start();

    }


}
