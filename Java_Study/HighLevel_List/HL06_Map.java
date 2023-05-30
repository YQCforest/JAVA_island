package HighLevel_List;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;


public class HL06_Map {
    public static void main(String[] args) {
        System.out.println("---------test01---------");
        test01();
        System.out.println("---------test02---------");
        test02();
        System.out.println("---------test03---------");
        test03();
        System.out.println("---------test04---------");
        test04();
    }

    public static void test01() {
        //Map是接口，并且有泛型
        Map<String, String> m = new HashMap<>();
        //添加元素
        //put()方法 1、添加 2、覆盖
        //put()方法会有返回值 在添加元素的时候，如果键不存在，那么直接直接将键值对象添加到map集合中，方法返回null
        //如果键值存在，那么会将原有的键值对对象覆盖，将被覆盖的值进行返回
        m.put("海绵宝宝", "派大星");
        m.put("蟹老板", "痞老板");
        m.put("珊迪", "章鱼哥");
        System.out.println(m);                    //{海绵宝宝=派大星, 蟹老板=痞老板, 珊迪=章鱼哥}
        String vale = m.put("海绵宝宝", "小黑子");  //派大星
        System.out.println(vale);
        System.out.println(m);                    //{海绵宝宝=小黑子, 蟹老板=痞老板, 珊迪=章鱼哥}


        //删除
        m.remove("珊迪");
        System.out.println(m);

        //判断
        boolean isKey = m.containsKey("海绵宝宝");         //是否包含键值
        System.out.println(isKey);
        boolean isValue = m.containsValue("痞老板");       //是否包含数据
        System.out.println(isValue);

        //判空
        if (m.isEmpty()) {
            System.out.println("map为空");
        } else {
            System.out.println("不为空");
        }

        //map的大小
        System.out.println("map的大小是:" + m.size());


    }

    public static void test02() {
        //map的第一种遍历方法  键找值
        //首先获取到每一个键值，放入到一个单列集合中，再遍历单列集合获取键值对应的值
        Map<String, String> m = new HashMap<>();

        m.put("灰太狼", "红太狼");
        m.put("沸羊羊", "美羊羊");
        m.put("喜羊羊", "慢羊羊");

        //调用keySet()方法，获取到map中的键放入到一个Set集合中
        System.out.println("增强for遍历:");
        Set<String> keys = m.keySet();
        for (String key : keys) {
            //调用get()方法，获取到map中键值对应的数据
            String value = m.get(key);
            System.out.println(key + "->" + value);
        }

        System.out.println("迭代器遍历:");
        Iterator<String> it = keys.iterator();
        while (it.hasNext()) {
            String itNext = it.next();
            String itValue = m.get(itNext);
            System.out.println(itNext + "->" + itValue);
        }

        System.out.println("lambda表达式遍历:");
        keys.forEach(s -> System.out.println(s + "->" + m.get(s)));
    }

    public static void test03() {

        //map的第二种遍历方法  键值对对象遍历
        Map<String, String> m = new HashMap<>();

        m.put("灰太狼", "红太狼");
        m.put("沸羊羊", "美羊羊");
        m.put("喜羊羊", "慢羊羊");

        //调用entrySet()方法,获取到所有的键值对对象，并返回一个Set集合
        Set<Map.Entry<String, String>> entries = m.entrySet();
        //遍历这个集合，获取这个集合中的每一个键值和数据值
        for (Map.Entry<String, String> entry : entries) {
            String key = entry.getKey();
            String value = entry.getValue();
            System.out.println(key + "->" + value);
        }
    }

    public static void test04() {
        //Map的第三种遍历方式 lambda表达式遍历
        //底层就是利用增强for循环遍历
        Map<String, String> m = new HashMap<>();

        m.put("灰太狼", "红太狼");
        m.put("沸羊羊", "美羊羊");
        m.put("喜羊羊", "慢羊羊");

        m.forEach((key, value) -> System.out.println(key + "->" + value));
    }
}
