package API;

/**
 * 正则表达式 1、可以校验字符串是否满足一定的规则，用来校验数据格式的合法化 2、在一段文本中查找一段满足要求的内容
 * 关于正则表达式的具体解释笔记看手写笔记
 */

public class My_regex {
    public static void main(String[] args) {
        test01();
        test02();
        test03();
    }

    public static void test01() {

        //字符类 正则表达式（只能匹配一个字符）
        System.out.println("a".matches("[abc]"));
        System.out.println("a".matches("[^abc]"));
        System.out.println("a".matches("[a-zA-Z]"));
        System.out.println("a".matches("[a-d[m-p]]"));
        System.out.println("a".matches("[a-z&&[def]]"));
        System.out.println("a".matches("[a-z&&[^de]]"));
        System.out.println("a".matches("[a-z&&[^m-p]]"));
        System.out.println("ab".matches("[a-z][a-b]"));  //由于每个只能匹配一个字符，所以对于两个字符需要用到两个正则表达式进行判断
    }

    public static void test02() {

        //预定义字符（只能匹配一个字符）
        //  "\" 转义字符 改变字符的原本的含义

        System.out.println("你".matches(".")); //true

        System.out.println("a".matches("\\d"));//false
        System.out.println("3".matches("\\d"));//true
        System.out.println("3".matches("\\D"));//false

        System.out.println("\n".matches("\\t"));//false
        System.out.println(" ".matches("\\S"));//false

        System.out.println("2".matches("\\w"));//true
        System.out.println("a".matches("\\w"));//true

        System.out.println("a".matches("\\W"));//false

    }

    public static void test03() {

        //数量词  解决只能匹配一个字符的问题

        System.out.println("232fef".matches("\\w{6}"));   //true
        System.out.println("232fef3".matches("\\w{6,}")); //true
        System.out.println("232fef3".matches("\\w{6,8}"));//true
    }
}
