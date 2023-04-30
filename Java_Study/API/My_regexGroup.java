package API;

/**
 * 正则表达式中 关于捕获分组和非捕获分组
 * 非捕获分组在爬虫中有，不再写
 */

public class My_regexGroup {
    public static void main(String[] args) {
        test01();
        test02();
        test03();
    }

    public static void test01(){
        //需求1、判断一个字符的开头和结尾是否相同
        // 举例: a123a  12341 &4533& a5235b
        //  \\组号: 表示把第X组中的数据再拿出来用一次
        String regex1 = "(.).+\\1";
        System.out.println("a123a".matches(regex1));    //true
        System.out.println("12341".matches(regex1));    //true
        System.out.println("&4533&".matches(regex1));   //true
        System.out.println("a5235b".matches(regex1));   //false

        System.out.println("--------------------------------------------------");

        //需求2、判断一个字符的开始部分和结束部分是否相同，但是开始部分和结束部分有多个字符
        //举例: abc12313432abc   1235743123  &!@543795&!@   @@4567@!
        //同需求1一样，但是在正则表达式中进行一个不止出现一次的判断添加
        String regex2 = "(.+).+\\1";
        System.out.println("abc12313432abc".matches(regex2));    //true
        System.out.println("1235743123".matches(regex2));        //true
        System.out.println("&!@543795&!@".matches(regex2));      //true
        System.out.println("@@4567@!".matches(regex2));          //false

        //需求3、判断一个字符的开始部分和结束部分是否相同，但是开始部分和结束部分中的所有字符也要一致
        //举例: aaa1232aaa   1115743111  @@@54379@@@   @!@4567@!!

    }

    public static void test02(){
        //需求3、判断一个字符的开始部分和结束部分是否相同，但是开始部分和结束部分中的所有字符也要一致
        //举例: aaa1232aaa   1115743111  @@@54379@@@   @!@4567@!!
        //同前两个需求一样，但是对于这个需求需要考虑到捕获分组的情况

        //正则表达式解释：
        // (.)：将首字母看作第一组 可以是任意的字符
        // \\2：将首字母拿出来再次使用   对于\\2 的解释：由于(.)已经表示了第一组的数据，所以从后面开始的任意数据就是从第二组开始算起
        // +:作用与\\2，表示后面出现的内容出现一次或者多次
        String regex3 = "((.)\\2+).+\\1";
        System.out.println("aaa1232aaa".matches(regex3));  //true
        System.out.println("1115743111".matches(regex3));  //true
        System.out.println("@@@54379@@@".matches(regex3)); //true
        System.out.println("@!@4567@!!".matches(regex3));  //false
    }

    public static void test03(){

        //在组外使用组内的数据
        //使用 $ 符号
        //需求4：我要学学编编编编编程程程程程程程程程->我要学编程
        String s = "我要学学编编编编编程程程程程程程程程";

        //正则表达式解释：
        // (.)表示把重复内容的第一个字符看作一组
        // \\1+ 表示第一组字符再次出现至少一次
        // &1表示把正则表达式中第一组出现的内容再次拿出来用
        String result = s.replaceAll("(.)\\1+", "$1");
        System.out.println(result);    //我要学编程
    }

}
