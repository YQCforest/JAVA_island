package API.JDK8_time;

import java.time.ZoneId;
import java.util.Set;

/**
 * 在JDK8时提供了一些新的时间类
 * 相较于JDK7的时间类，在数据的安全和代码的复杂度方面进行了很大的提升
 * ZoneId 时区
 */

public class My_ZoneId {
    public static void main(String[] args) {
        test01();
        test02();
        test03();
    }

    public static void test01(){

        //获取Java中所有的时区
        //static Set<String> getAvailableZoneIds()
        //放在一个set中
        Set<String> zoneIds = ZoneId.getAvailableZoneIds();
        System.out.println(zoneIds.size());  //600 Java支持了600个时区的时间
    }

    public static void test02(){

        //获取当前系统的时区
        //static ZoneId systemDefault()
        ZoneId zoneId = ZoneId.systemDefault();
        System.out.println(zoneId);   //Asia/Shanghai
    }

    public static void test03(){

        //获取指定时区
        //static ZoneId of(String zoneId)
        ZoneId zoneId = ZoneId.of("Asia/Shanghai");
        System.out.println(zoneId);   //Asia/Shanghai
    }
}
