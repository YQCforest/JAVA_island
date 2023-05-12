package API.JDK8_time;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;

/**
 * Instant 时间戳
 */
public class My_Instant {
    public static void main(String[] args) {
        test01();
        test02();
        test03();
        test04();
    }
    public static void test01(){

        //获取当前时间的Instate对象（标准时间）
        Instant now = Instant.now();
        System.out.println(now);

        //根据(秒/毫秒/纳秒)获取Instant对象
        Instant instant1 = Instant.ofEpochMilli(0L);//获取到计算机的起始时间
        System.out.println(instant1);
    }

    public static void test02(){

        //指定时区
        //ZonedDateTime atZone(ZoneId zone)
        //在atZone()方法中传入的不能时字符串类型的数据，而是需要用ZoneId.of()来获取时区
        //接着指定时区，接着获取指定时区的当前时间
        ZonedDateTime zonedDateTime = Instant.now().atZone(ZoneId.of("Asia/Shanghai"));
        System.out.println(zonedDateTime);
    }

    public static void  test03(){

        //判断系列的方法  判断调用者是否在参数的前面或者后面
        //boolean isXxx(Instant otherInstant)
        Instant instant1 = Instant.ofEpochMilli(0L);
        Instant instant2 = Instant.ofEpochMilli(1000L);
        boolean result = instant1.isBefore(instant2);
        System.out.println(result);  //true 表示instant1确实在instant2前面
        boolean result2 = instant2.isAfter(instant1);
        System.out.println(result2); //true 表示instant2确实在instant1后面
    }

    public static void test04(){

        //减少时间、增加时间系列的方法
        //Instant minusXxx(long millisToSubtract) 减少
        //Instant plusXxx(long millisToSubtract)  增加
        //JDK8 的时间对象是不会变的，如果要对其进行改变，会创建一个新的对象

        //减少
        Instant instant1 = Instant.ofEpochMilli(17761220040612L);
        System.out.println(instant1); //2532-10-30T16:14:00.612Z
        Instant instant2 = instant1.minusSeconds(5);//向前减去5秒
        System.out.println(instant2); //2532-10-30T16:13:55.612Z

        //增加
        Instant instant3 = instant1.plusSeconds(5);  //向后增加5秒
        System.out.println(instant3); //2532-10-30T16:14:05.612Z

    }
}
