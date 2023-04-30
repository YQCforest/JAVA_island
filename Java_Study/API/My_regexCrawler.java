package API;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 爬虫
 * Pattern类 正则表达式类
 * Matcher类 文本匹配器 按照正则表达式的规则去读取字符串，从头开始读取 在大串中查找符合匹配规则的字串
 */
public class My_regexCrawler {
    public static void main(String[] args) {
        //test01();
        //test02();
        //test03();
        test04();
    }

    public static void test01() {

        /*
         Java自从95年问世以来，经历了很多版本，目前企业中用的最多的是Java8和Java11
         因为这两个是长期支持版本，下一个长期支持版本是Java17，相信在未来的不久Java17
         也逐渐会登上历史的舞台
         要求：爬取出里面所有的JavaXX
         */

        String str = "Java自从95年问世以来，经历了很多版本，目前企业中用的最多的是Java8和Java11," +
                "因为这两个是长期支持版本，下一个长期支持版本是Java17，相信在未来的不久Java17," +
                "也逐渐会登上历史的舞台";

        //获取正则表达式的对象
        //Pattern对象不能直接new，需要通过静态方法调用
        Pattern p = Pattern.compile("Java\\d{0,2}");

        //获取文本匹配器对象
        Matcher m = p.matcher(str);
        //解释：m:文本匹配器的对象 str:大串 p:规则 m要在str中找出符合p规则的小串

        //find()方法
        //文本匹配器从头开始读取，寻找是否有满足的子串
        //如果没有返回false,否则返回true
        //返回true后会在底层记录子串的起始索引和结束索引+1
        //boolean b = m.find();

        //group()方法
        //会根据find()记录的索引值进行子串的截取
        //将截取到的子串进行返回
        //String sonStr = m.group();
        //System.out.println(sonStr);  //Java

        //利用循环进行全段文字的读取和爬取
        while (m.find()) {
            String s = m.group();
            System.out.println(s);
        }
    }

    public static void test02() {
        String str = "java自从95年问世以来，经历了很多版本，目前企业中用的最多的是Java8和JAva11," +
                "因为这两个是长期支持版本，下一个长期支持版本是JAVa17，相信在未来的不久JAVA17," +
                "也逐渐会登上历史的舞台";
        //有条件爬取

        //需求1、爬取版本号为8、11、17的Java文本，但是只要Java，不显示版本号

        String regex1 = "((?i)Java)(?=8|11|17)";  //对于该正则表达式的理解：?理解为前面的数据Java，=表示在Java后面要跟随的数据，但是在获取的时候只要获取前半部分
        Pattern p1 = Pattern.compile(regex1);
        Matcher m1 = p1.matcher(str);
        while (m1.find()) {
            System.out.println(m1.group());
        }
        System.out.println("===========================");
        //需求2、爬取版本号为8、11、17的Java文本
        String regex2 = "((?i)Java)(?:8|11|17)";//对于该正则表达式的理解：?理解为前面的数据Java，:表示在Java后面要跟随的数据,要全部获取到
        Pattern p2 = Pattern.compile(regex2);
        Matcher m2 = p2.matcher(str);
        while (m2.find()) {
            System.out.println(m2.group());
        }
        System.out.println("===========================");
        //需求3、爬取除了版本号为8、11、17的Java文本
        String regex3 = "((?i)Java)(?!8|11|17)";//对于该正则表达式的理解：?理解为前面的数据Java，!表示在Java后面要跟随的数据,表示除了带有!后面的文本都要爬取
        Pattern p3 = Pattern.compile(regex3);
        Matcher m3 = p3.matcher(str);
        while (m3.find()) {
            System.out.println(m3.group());
        }

        /*  运行结果:
            Java
            JAva
            JAVa
            JAVA
            ===========================
            Java8
            JAva11
            JAVa17
            JAVA17
            ===========================
            java
            */
    }

    public static void test03(){
        /*
            贪婪爬取和非贪婪爬取

            贪婪爬取：尽可能多的获取数据
            非贪婪爬取：尽可能少的获取数据

            只写+和*表示贪婪爬取，在后面加上?表示非贪婪爬取
            Java中默认贪婪爬取

        */

        String str = "abbbbbbbbbbbbbbbbbbaaaaaaa";
        //贪婪:
        String regex = "ab+";
        Pattern p = Pattern.compile(regex);
        Matcher m = p.matcher(str);
        while(m.find()){
            System.out.println(m.group());
        }   //abbbbbbbbbbbbbbbbbb
        //非贪婪:
        String regex2 = "ab+?";
        Pattern p2 = Pattern.compile(regex2);
        Matcher m2 = p2.matcher(str);
        while(m2.find()){
            System.out.println(m2.group());
        }   //ab

    }

    public static void test04(){

        //关于正则表达式在字符串方法中使用

        /*
            海绵宝宝shfoiaheoaihfgawe2131o派大星dhfioahf3123awiuh章鱼哥
            需求1、替换掉除了文字之外的所有字母成vs
            需求2、将名字剪切出来
         */

        String s= "海绵宝宝shfoiaheoaihfgaweo派大星dhfioahfawiuh章鱼哥";

        //需求1、替换掉除了文字之外的所有字母成vs
        //使用 replaceAll方法 两个参数分别是: 正则表达式 需要替换的内容  返回值是一个字符串
        //方法解释：按照第一个参数正则表达式的规则，将所有满足正则表达式的子串替换成第二个参数需要替换的内容
        String s1 = s.replaceAll("[\\w&&[^_]]+", "vs");
        System.out.println(s1);                 //海绵宝宝vs派大星vs章鱼哥


        //需求2、将名字剪切出来
        //使用split方法 参数是一个正则表达式  返回值是一个数组，将切割出的片段放入一个数组中
        //方法解释：以满足传入的正则表达式的字符为切割点，将大串切割成若干小串放入一个数组中
        String[] srr = s.split("[\\w&&[^_]]+");
        for (int i = 0; i < srr.length; i++) {
            System.out.println(srr[i]);
        }
        /*
        海绵宝宝
        派大星
        章鱼哥
         */
    }
}
