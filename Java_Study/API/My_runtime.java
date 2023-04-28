package API;

import java.io.IOException;

/**
 * Runtime类 表示当前虚拟机的运行环境
 * 非静态类 需要先创建对象来获取方法
 * 这个类的对象不可以直接 new 需要用 getRuntime()方法来获取
 */

public class My_runtime {
    public static void main(String[] args) throws IOException {
        test01();
        test02();
        test03();
        test04();
        test05();
        test06();
        test07();
    }
    public static void test01(){
        //获取Runtime的对象，调用getRuntime()方法
        Runtime r1 = Runtime.getRuntime();
        Runtime r2 = Runtime.getRuntime();
        //两次的结果是生成的是同一个对象
        System.out.println(r1==r2);
    }
    public static void test02(){
        //exit 停止虚拟机
        //状态码：0，非0
        Runtime r1 = Runtime.getRuntime();
        r1.exit(0);
        System.out.println("执行了么？");
    }
    public static void test03(){
        //availableProcessors 获取CPU的线程数
        System.out.println(Runtime.getRuntime().availableProcessors());
    }
    public static void test04(){
        //maxMemory JAVA能从系统获取的最大内存数 单位:byte
        System.out.println(Runtime.getRuntime().maxMemory()/1024/1024);
        //除以两次是单位的换算 结果是“兆”
    }
    public static void test05(){
        //totalMemory JAVA已经从系统中获得总内存大小
        System.out.println(Runtime.getRuntime().totalMemory()/1024/1024);
    }
    public static void test06(){
        //freeMemory 剩余内存大小
        System.out.println(Runtime.getRuntime().freeMemory()/1024/1024);
    }
    public static void test07() throws IOException {
        //exec 使用cmd 命令 但是不是全部
       // Runtime.getRuntime().exec("notepad");  //打开记事本
       /*
       shutdown ：关机 加上参数才能执行
       -s : 默认在一分钟之后关机
       -s -t: 指定关机时间
       -a : 取消关机操作
       -r : 关机并重启
        */
        Runtime.getRuntime().exec("shutdown -a");

    }
}
