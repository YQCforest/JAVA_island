package Stream_And_MethodReference;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;


public class MethodReference {
    public static void main(String[] args) {
        study01();
        study02();
        study03();
        study04();
        study05();
        study06();
        practice();
    }

    public static void study01() {
        Integer[] arr = {3, 2, 1, 4, 6, 5};
        Arrays.sort(arr, MethodReference::subsTract);
        System.out.println(Arrays.toString(arr));
    }
    public static int subsTract(Integer o1, Integer o2) {
        return o2 - o1;
    }

    public static void study02() {
        //静态方法的引用
        //将字符串类型的数据转换成整数类型
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "1", "2", "3", "4", "5", "6");
        list.stream().map(Integer::parseInt).forEach(s -> System.out.println(s));
    }

    public static void study03() {

        //成员方法引用

        List<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌", "张三丰", "张强", "赵敏");

        /*list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return s.startsWith("张")&&s.length()==3;
            }
        }).forEach(s-> System.out.println(s));*/

        //成员方法的引用
        list.stream().filter(new MethodReference()::sub)
                .forEach(s -> System.out.println(s));

    }
    public boolean sub(String s) {
        return s.startsWith("张") && s.length() == 3;
    }

    public static void study04() {

        //引用构造方法
        //在集合中添加字符串类型 姓名和年龄要求封装成Student对象并且收集到List集合中
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "张无忌,15", "周芷若,16", "张三丰,17", "赵无极,18", "赵敏,19", "尼古拉斯赵四,20");
        //常规方法
        List<Man> newList = list.stream().map(new Function<String, Man>() {
            @Override
            public Man apply(String s) {
                String[] arr = s.split(",");
                String name = arr[0];
                int age = Integer.parseInt(arr[1]);
                return new Man(name, age);
            }
        }).collect(Collectors.toList());

        System.out.println(newList);
        System.out.println("------------------");
        //使用构造方法的引用
        //需要在类中进行一个构造方法的添加，以符合方法的形参和构造方法的形参保持一致
        List<Man> newList2 = list.stream().map(Man::new).collect(Collectors.toList());
        System.out.println(newList2);
    }

    public static void study05() {

        //类名引用成员方法
        //格式  ： 类名::方法    会存在局限性
        //将集合中的所有小写转换成大写
        List<String> list = new ArrayList<>();
        Collections.addAll(list, "aaa", "bbb", "ccc", "ddd");
        //用map()方法，需求的本质就是传唤，只是类型不变
        //拿着流中的每一个数据，去调用String类中的toUpperCase方法，方法的返回值就是转换后的结果
        list.stream().map(String::toUpperCase).forEach(s -> System.out.println(s));
    }

    public static void study06() {

        //引用数组的构造方法
        //创建一个指定类型的数组，在集合中存储一点整数，并将这些整数存入数组中

        //格式 ： 类型[]::new
        List<Integer> list = new ArrayList<>();
        Collections.addAll(list, 1, 2, 3, 4, 5);

        Integer[] arr = list.stream().toArray(Integer[]::new);
        System.out.println(Arrays.toString(arr));

    }

    public static void practice(){

        //创建集合添加学生对象，只获取到姓名添加到数组中
        Man m1 = new Man("zhaoSi",24);
        Man m2 = new Man("wangWu",25);
        Man m3 = new Man("zhaoLiu",26);

        List<Man> list = new ArrayList<>();
        Collections.addAll(list,m1,m2,m3);

        String[] array = list.stream().map(Man::getName).toArray(String[]::new);
        System.out.println(Arrays.toString(array));
    }

}

class Man {
    private String name;
    private int age;


    public Man() {
    }

    //新的构造方法为了适配方法形参
    public Man(String str) {

        this.name = str.split(",")[0];
        this.age = Integer.parseInt(str.split(",")[1]);

    }

    public Man(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 获取
     *
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     *
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     *
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Man{name = " + name + ", age = " + age + "}";
    }
}