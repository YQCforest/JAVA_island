package API.JDK8_time;

import java.time.Instant;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

/**
 * 日期格式化类
 * 用于时间的格式化和解析
 */
public class My_DateTimeFormatter {
    public static void main(String[] args) {
        test();
    }
    public static void test(){
        //获取格式对象
        //static DateTimeFormatter ofPattern(格式)

        //获取时间对象
        ZonedDateTime time = Instant.now().atZone(ZoneId.of("Asia/Shanghai"));
        //解析/格式化器
        DateTimeFormatter dtf1 = DateTimeFormatter.ofPattern("y-M-d H:m:s E a");
        //格式化
        System.out.println(dtf1.format(time));//2023-5-12 14:32:15 周五 下午
    }
}
