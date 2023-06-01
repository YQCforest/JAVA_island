package Stream_And_MethodReference;

import java.util.*;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Stream_Flow {
    public static void main(String[] args) {
       test01();
       test02();
       test03();
       test04();
       test05();
        practice01();
        practice02();
        practice03();
    }
    public static void test01(){
        List<String> mylist = new ArrayList<>();

        //找出张姓的，以及姓名长度为三的人
        mylist.add("张无忌");
        mylist.add("周芷若");
        mylist.add("赵敏");
        mylist.add("张强");
        mylist.add("张三丰");
        mylist.add("段正淳");

        mylist.stream().filter(name->name.startsWith("张")).filter(name->name.length()==3).forEach(name-> System.out.println(name));
    }

    public static void test02(){
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"张无忌","张无忌","周芷若","赵敏","张强", "张三丰", "段正淳");
        //索取前几个元素
        list.stream().limit(3)
                .forEach(name-> System.out.println(name));
        System.out.println("-------------");
        //跳过前几个元素
        list.stream().skip(2)
                .forEach(name-> System.out.println(name));
        System.out.println("-------------");
        //去重
        list.stream().distinct().forEach(s-> System.out.println(s));
    }

    public static void test03(){

        //将年龄获取出来
        List<String> list = new ArrayList<>();
        Collections.addAll(list,"张无忌-15","周芷若-16","赵敏-53","张强-23", "张三丰-45", "段正淳-12");

        //使用Stream流中的map进行类型的转化
        list.stream().map(new Function<String, Integer>() {
            @Override
            public Integer apply(String s) {
                String arr[] = s.split("-");
                String args = arr[1];
                Integer age = Integer.parseInt(args);
                return age;
            }
        }).forEach(age-> System.out.println(age));
        System.out.println("-----------------------------");
        //lambda表达式写法
        list.stream().map(s->Integer.parseInt(s.split("-")[1])).
                forEach(s-> System.out.println(s));


    }

    public static void test04(){

        List<String> list = new ArrayList<>();
        Collections.addAll(list,"张无忌","张无忌","周芷若","赵敏","张强", "张三丰", "段正淳");

        //统计
        long count = list.stream().count();
        System.out.println(count);

        //将流中的数据存储到数组中
        String[] array = list.stream().toArray(new IntFunction< String[]>() {
            @Override
            public String[] apply(int value) {
                return new String[value];
            }
        });
        System.out.println(Arrays.toString(array));
        System.out.println("------------------");

        //lambda表达式
        //在lambda表达式中的值是数组的长度
        String[] array1 = list.toArray(value->new String[value]);
        System.out.println(Arrays.toString(array1));

    }

    public static void test05(){

        List<String> list = new ArrayList<>();
        Collections.addAll(list,"张无忌-男-15","周芷若-女-16","赵敏-女-53","张强-男-23", "张三丰-男-45", "段正淳-男-12");

        //获取到所有的男性并放到集合中
        //使用Stream陆流中的collect方法，并在里面写入Collectors.toList()
        List<String> newlist = list.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toList());
        System.out.println(newlist);
        System.out.println("-------------------------");
        //收集到Set集合中是一样的，只是在Set集合中会进行去重的操作

        //收集到Map集合中，键值为姓名，数据值为年龄
        Map<String, Integer> map = list.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toMap(
                        //两个参数分别是流中的数据类型 和 键的数据类型
                        new Function<String, String>() {
                    @Override
                    public String apply(String s) {
                        return s.split("-")[0];
                    }
                }
                ,
                        //两个参数分别是流中的数据类型 和 值的数据类型
                        new Function<String, Integer>() {
                    @Override
                    public Integer apply(String s) {
                        return Integer.parseInt(s.split("-")[2]);
                    }
                }));
        System.out.println(map);
        System.out.println("-------------------------");
        //lambda表达式写法
        Map<String, String> map1 = list.stream()
                .filter(s -> "男".equals(s.split("-")[1]))
                .collect(Collectors.toMap(
                        s -> s.split("-")[0]   //键的生成规则
                        ,
                        s -> s.split("-")[2]   //值的生成规则
                ));
        System.out.println(map1);
    }

    public static void practice01(){

        //1,2,3,4,5,6,7,8,9,10 过滤奇数,留下偶数
        List<Integer> mylist = new ArrayList<>();
        Collections.addAll(mylist,1,2,3,4,5,6,7,8,9,10);
        List<Integer> list = mylist.stream().filter(s -> (s % 2) == 0).collect(Collectors.toList());
        System.out.println(list);

    }

    public static void practice02(){
        //添加姓名和年龄 并将其存入Map中，键值为姓名，数据值为年龄，并且添加的是年龄>=24岁的人
        
        List<String> mylist = new ArrayList<>();
        Collections.addAll(mylist,"zhangSan,23","liSi,24","wangWu,25");

        Map<String, Integer> map = mylist.stream().filter(s -> Integer.parseInt(s.split(",")[1]) >= 24).collect(Collectors.toMap(
                s -> s.split(",")[0]
                ,
                s -> Integer.parseInt(s.split(",")[1])
        ));
        System.out.println(map);
    }

    public static void  practice03(){
        
        /*  创建一个Actor类，类中只有姓名和年龄
            在集合中添加男演员 Stream流后要求：姓名长度为三，并且只获取前两个
            在另一个集合中添加女演员 Stream流后要求：姓杨，并且跳过第一个
            将两个流合并为一个流，最后存入到List集合中
        */
        
        Actor manActor1 = new Actor("黄嘉达",23);
        Actor manActor2 = new Actor("杨轲",25);
        Actor manActor3 = new Actor("徐自鹏",26);
        Actor manActor4 = new Actor("潘鑫岳",26);
        Actor manActor5 = new Actor("武桐含",26);
        Actor manActor6 = new Actor("姚鹏运",26);

        Actor womanActor1 = new Actor("杨紫琼",60);
        Actor womanActor2 = new Actor("迪丽热巴",28);
        Actor womanActor3 = new Actor("杨颖",28);
        Actor womanActor4 = new Actor("杨超越",28);
        Actor womanActor5 = new Actor("刘亦菲",28);
        Actor womanActor6 = new Actor("杨幂",28);

        List<Actor> manList = new ArrayList<>();
        Collections.addAll(manList,manActor1,manActor2,manActor3,manActor4,manActor5,manActor6);
        Stream<Actor> manStream = manList.stream().filter(s -> s.getName().length() == 3).limit(2);

        List<Actor> womanList = new ArrayList<>();
        Collections.addAll(womanList,womanActor1,womanActor2,womanActor3,womanActor4,womanActor5,womanActor6);
        Stream<Actor> womanStream = womanList.stream().filter(s -> s.getName().startsWith("杨")).skip(1);


        List<Actor> personList = Stream.concat(manStream, womanStream).collect(Collectors.toList());
        System.out.println(personList);

    }
}

class Actor{
    private String name;
    private int age;


    public Actor() {
    }

    public Actor(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    public String toString() {
        return "Actor{name = " + name + ", age = " + age + "}";
    }
}
