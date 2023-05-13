package API;

import java.util.Scanner;

/**
 * 包装类：基本数据类型对应的引用数据类型
 * 理解：就是将基本数据类型通过创建对象的方式给包装起来，在这个类中会有构造方法...
 * 在集合中不能存储基本数据类型，只能存储应用数据类型
 * 这次的包装类以 Integer 作为示范
 */
public class My_PackagedClass {
    public static void main(String[] args) {
        test01();
        test02();
        test03();
        test04();
    }
    public static void test01(){
        /*
            Integer这个类在在底层会将-128~127的所有数字会创建好对象，会将其提前
            放入到一个数组中，如果在这个范围内那么valueOf 这个方法不会再创建新的
            对象，而是返回已经创建好的对象，然而一旦超过了这个范围，那么valueOf
            这个方法就会创建新的对象
         */
        Integer i1 = Integer.valueOf(127);
        Integer i2 = Integer.valueOf(127);
        System.out.println(i1 == i2); //true

        Integer i3 = Integer.valueOf(128);
        Integer i4 = Integer.valueOf(128);
        System.out.println(i3 == i4); //false
    }

    public static void test02(){
        /*
         在JDK5以后提出了自动装箱和自动拆箱
         自动装箱：将基本数据类型自动变成其对应的包装类
         自动拆箱：将包装类自动变成其对应的基本数据类型
         */

        //在底层自动调用valueOf方法得到了一个integer对象
        Integer i = 10;
        System.out.println(i);
        //将包装类自动变成其对应的基本数据类型
        Integer i2 = 20;
        int i3 = i2;
        System.out.println(i3);
    }

    public static void test03(){

        //常用方法1、将十进制转换成其他进制 返回的类型都是String
        String str1 = Integer.toBinaryString(100);  //转换成二进制 1100100
        System.out.println(str1);
        String str2 = Integer.toOctalString(100);   //转换成八进制 144
        System.out.println(str2);
        String str3 = Integer.toHexString(100);     //转换成十六进制 64
        System.out.println(str3);

        //常用方法2、将字符串类型的数据转欢成int类型的整数
        //Java是强类型语言：每种数据在Java中都有各自的数据类型
        //在计算的时候如果不是同种的数据类型是无法进行直接计算的
        int i = Integer.parseInt("1234");
        System.out.println(i + 1);               //1235
        //parseInt 方法中传入的参数必须是纯数字字符串
        //在8中包装类中，除了Character都有对应的parseXxx的方法，进行类型的转换
    }

    public static void test04(){

        //拥有了类型转换的方法之后，更改键盘录入的方法
        //nextLine 可以录入在控制台中输入的空格制表符和回车
        //约定：之后的所有键盘录入都用nextLine方法，之后再经行数据类型之间的转换
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个数:");
        String result = sc.nextLine();
        System.out.println(result);
        //之后再进行类型之间的转换来进行后续的操作
        int i = Integer.parseInt(result);
        System.out.println(i + 1);   //124
    }
}
