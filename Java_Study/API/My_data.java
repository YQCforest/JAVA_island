package API;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;


/**
 * Date时间类
 * 全世界的时间有一个统一的计算标准 UTC
 * 中国的标准时间 = 世界标准时间 + 8
 * SimpleDateFormat类 格式化 解析:将字符串表示的时间变成Date对象
 * Calendar类 抽象类不能直接实例化 需要调用方法
 */

public class My_data {
    public static void main(String[] args) throws ParseException {
        test01();
        test02();
        test03();
        test04();
        test05();
        test06();
    }

    public static void test01() {
        //创建对象表示当前时间
        Date d = new Date();
        System.out.println(d);

        //创建对象获取指定的时间
        Date d2 = new Date(0L);
        System.out.println(d2);

        //set方法修改时间
        //1000毫秒 = 1秒
        d2.setTime(1000L);
        System.out.println(d2);

        //get方法获取时间
        long time = d2.getTime();
        System.out.println(time);
    }

    public static void test02() {
        //需求：打印时间原点1年以后的时间

        //step1、创建时间原点对象
        Date d1 = new Date(0L);
        //step2、获取d1时间对象的毫秒值
        long time = d1.getTime();
        //step3、加上一年时间毫秒即可
        time = time + 1000L * 60 * 60 * 24 * 365;
        //step4、将设置完的时间再放回原来的时间中
        d1.setTime(time);
        //输出
        System.out.println(d1);  //Fri Jan 01 08:00:00 CST 1971
    }

    public static void test03() {
        //需求、定义两个任意的Date对象，比较哪个时间在前哪个在后

        //获取随机的Date对象以及Date的时间
        Random r = new Random();
        Date d1 = new Date(Math.abs(r.nextInt()));
        Date d2 = new Date(Math.abs(r.nextInt()));

        //由于对象不能比较，所以我们要将对象时间转换成标准的数据类型-毫秒值
        long time1 = d1.getTime();
        long time2 = d2.getTime();

        if (time1 > time2) {
            System.out.println(d1);
            System.out.println(d2);
            System.out.println("第一个时间在后，第二个时间在前");
        } else if (time1 < time2) {
            System.out.println(d1);
            System.out.println(d2);
            System.out.println("第一个时间在前，第二个时间在后");
        } else {
            System.out.println(d1);
            System.out.println(d2);
            System.out.println("两个时间相等");
        }

    }

    public static void test04() {

        // y-年 M-月 d-日 H-时 m-分 s-秒 E-星期
        //空参构造创建对象-使用的默认格式
        SimpleDateFormat sdf = new SimpleDateFormat();
        Date d = new Date();
        String str = sdf.format(d);
        System.out.println(str);
        //  2023/5/5 下午2:15 —— 默认格式

        //带参构造指定格式
        SimpleDateFormat sdf2 = new SimpleDateFormat("y年M月d日 H:m:s E");
        String str2 = sdf2.format(d);
        System.out.println(str2);
        // 2023年5月5日 14:28:18 周五 —— 指定格式
    }

    public static void test05() throws ParseException {
        // SimpleDateFormat 解析:将字符串表示的时间变成Date对象
        String str = "2023-11-11 11:11:11";
        //创建对象的格式必须和字符串的格式相同
        SimpleDateFormat sdf = new SimpleDateFormat("y-M-d H:m:s");
        Date result = sdf.parse(str);
        System.out.println(result);             //Sat Nov 11 11:11:11 CST 2023
        System.out.println(result.getTime());   //1699672271000 获得毫秒值
    }

    public static void test06() {

        //1、获取日历对象
        //底层原理：回会根据系统的不同时区来返回不同的日历对象，默认表示当前的时间
        //会把时间当中的纪元 年 月 日 时 分 秒 星期 等等都放到一个数组中
        Calendar c = Calendar.getInstance();
        System.out.println(c);

        //2、修改日历代表的时间 使用setTime方法
        //细节：月份的范围:0~11 获取出的月份需要加上1才是正确月份   周一实际是周日，依次往后类推
        Date d = new Date(0L);
        c.setTime(d);
        System.out.println(c);

        c.set(Calendar.YEAR, 2000);   //使用set方法进行修改 两个参数分别是需要修改的 以及修改后的值
        c.set(Calendar.MONTH, 8);

        c.add(Calendar.DAY_OF_WEEK, 2);  //使用add方法进行值的增加

        //get()方法-获取到日期中的某个字段信息
        //由于日历返回的是一个数组对象，所以我们可以通过索引的方式来获得其中的字段信息
        //0-纪元 1-年 2-月 3-一年中的第几周 4-一个月中的第几周 5-日期 ...
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;        //真实月份要加上1
        int date = c.get(Calendar.DAY_OF_MONTH);
        int week = c.get(Calendar.DAY_OF_WEEK) - 1;   //实际星期要减一
        System.out.println("年:" + year + " 月:" + month + " 日:" + date + " 星期:" + week);  //年:1970 月:1 日:1 星期:4
    }
}
