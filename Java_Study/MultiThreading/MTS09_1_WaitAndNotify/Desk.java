package MultiThreading.MTS09_1_WaitAndNotify;

public class Desk {

    //桌子状态  0表示没有  1表示有
    public static int foodFlag = 0;
    //总数
    public static int sum = 10;
    //锁对象
    public static Object lock = new Object();

}
