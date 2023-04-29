package API;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Random;

/**
 * BigInteger类 大整数
 * BigDecimal类 大小数 用于小数的精确运算
 */

public class My_BigIntegerAndBigDecimal {
    public static void main(String[] args) {
        System.out.println("BigInteger:");
        test01();
        test02();
        test03();
        test04();
        System.out.println("==================");
        System.out.println("BigDecimal:");
        test05();
    }

    public static void test01(){
        //获取随机的大整数
        //参数的意义：第一个参数指的是该随机大整数的范围是 [0,2^num-1]，第二个参数就是随机数字
        BigInteger bd = new BigInteger(4,new Random());
        System.out.println(bd);
    }
    public static void test02(){
        //获取指定大整数
        //注意参数的传入是一个字符串 而且这个字符串中只能传入整数
        BigInteger bd = new BigInteger("999999999999");
        System.out.println(bd);
    }
    public static void test03(){
        //静态方法获取BigInteger对象，内部有优化
        //能表示的范围较小 只能表示long 类型之内的整数 范围超过long类型就不行了
        //对于常用的数字 -16~16 进行了优化 提前把BigInteger对象创建好，如果多次获取就不会创建新的对象
        System.out.println(BigInteger.valueOf(100));

        BigInteger b1 =  BigInteger.valueOf(16);
        BigInteger b2 =  BigInteger.valueOf(16);
        System.out.println(b1==b2);  //true

        BigInteger b3 =  BigInteger.valueOf(17);
        BigInteger b4 =  BigInteger.valueOf(17);
        System.out.println(b3==b4);  //false

        //对象一旦创建内部的数据不会发生改变
        BigInteger b5 =  BigInteger.valueOf(1);
        BigInteger b6 =  BigInteger.valueOf(2);
        BigInteger result = b5.add(b6);
        System.out.println(b5);
        System.out.println(b6);
        System.out.println(result);
        System.out.println(b5==result); //false
        System.out.println(b6==result); //false
        //不会修改参与计算的对象的值，而是会创建一个新的BigInteger对象来记录结果值
    }
    public static void test04(){
        //BigInteger类中的常见方法
        //因为BigInteger是一个类，所以不能直接使用基本的操作，而是要用方法

        BigInteger bd1 = BigInteger.valueOf(10);
        BigInteger bd2 = BigInteger.valueOf(5);

        System.out.println(bd1.add(bd2));        //加法
        System.out.println(bd1.subtract(bd2));   //减法
        System.out.println(bd1.multiply(bd2));   //乘法
        System.out.println(bd1.divide(bd2));     //除法，只获取商

        BigInteger bd3 = BigInteger.valueOf(10);
        BigInteger bd4 = BigInteger.valueOf(3);
        BigInteger[] arr = bd3.divideAndRemainder(bd4); //除法 获取到商和余数 用数组保存 0索引存商 1索引存余数
        System.out.println(arr.length);  //2
        System.out.println(arr[0]);      //3
        System.out.println(arr[1]);      //1

        System.out.println(bd3.equals(bd4));      //比较

        System.out.println(bd2.pow(2)); //次幂

        System.out.println(bd1.max(bd2));         //返回较大的值
        System.out.println(bd1.min(bd2));         //返回较小的值
    }
    public static void test05(){
        //通过传递double类型的小数来创建对象
        //这种方式是不精确的，不建议使用
        BigDecimal d1 = new BigDecimal(0.01);
        BigDecimal d2 = new BigDecimal(0.02);
        System.out.println(d1);
        System.out.println(d2);

        //通过传递字符串来创建对象
        //这种方法精确
        BigDecimal d3 = new BigDecimal("0.01");
        BigDecimal d4 = new BigDecimal("0.09");
        System.out.println(d3);
        System.out.println(d4);

        //同样可以用静态方法获取对象
        BigDecimal bd5 = BigDecimal.valueOf(2.5);
        System.out.println(bd5);

        /*
        注意点: 如果创建的对象范围超出了double类型的范围 建议使用构造方法，如果没有超出double类型的范围 建议使用静态方法
        如果传递的是0~10之间的数字，那么静态方法会返回已经创建好的对象，不会重新new
        成员方法和 BigInteger 类似，不做演示
        */

    }
}
