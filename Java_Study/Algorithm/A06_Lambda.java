package Algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * lambda表达式 简化匿名内部类
 * 函数式编程,忽略面向对象的复杂语法,强调做什么,不强调谁去做
 * () -> {
 * Lambda表达式的格式  ()对应着方法的形参 ->固定格式 {}对应着方法的方法体
 * }
 */
public class A06_Lambda {
    public static void main(String[] args) {
        Integer[] arr = {3, 1, 2, 6, 5, 4, 7, 9, 8, 10};
        Arrays.sort(arr, (Integer o1, Integer o2) -> {
            return o1 - o2;
        });
        // Arrays.sort(arr,(o1,o2)->o1-o2);      终极简化版
        System.out.println(Arrays.toString(arr));
        System.out.println("----------------------------------");
        /*使用前提:Lambda只能简化函数式接口的匿名内部类的写法
        有且只有一个抽象方法的接口叫做函数式接口 接口加上 @FunctionalInterface 注解进行验证*/

        test(
                () -> {
                    System.out.println("正在游泳");
                }  //lambda表达式
        );
        System.out.println("----------------------------------");
        practice();
    }

    public static void test(Swim s) {
        s.swimming();
    }

    public static void practice(){

        //练习:将数组中的字符串按照长度进行排列
        String []arr={"aa","a","aaaa","aaa"};
        /*Arrays.sort(arr, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.length()-o2.length();
            }
        });  //匿名内部类的写法*/

        Arrays.sort(arr,(o1,o2)->o1.length()-o2.length()); //lambda表达式终极简写版 "优雅永不过时"

        System.out.println(Arrays.toString(arr));
    }
}

@FunctionalInterface      //函数式注解:有且仅有一个抽象方法
interface Swim {
    void swimming();
}


