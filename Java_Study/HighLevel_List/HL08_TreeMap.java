package HighLevel_List;

import java.util.Comparator;
import java.util.TreeMap;

public class HL08_TreeMap {

    //不重复、无索引、可排序

    public static void main(String[] args) {
        System.out.println("--------practice01--------");
        practice01();
        System.out.println("--------practice02--------");
        practice02();
        System.out.println("--------practice03--------");
        practice03();
    }

    public static void practice01() {
        TreeMap<Integer, String> tm = new TreeMap<>(new Comparator<Integer>() {
            //重写comparator方法实现降序排列
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        //在TreeMap中Integer和Double 默认的是键值的升序排列
        //String按照ASCII码表排列
        tm.put(1, "A");
        tm.put(2, "B");
        tm.put(3, "C");
        tm.put(4, "D");
        tm.put(5, "E");
        System.out.println(tm);
    }

    private static void practice02() {
        //在TreeMap中添加自定义元素的时候，需要重写Comparable接口中的抽象方法，否则会报错
        TreeMap<woman, String> tm = new TreeMap<>();
        woman m1 = new woman("zhanSan", 23);
        woman m2 = new woman("liSi", 24);
        woman m3 = new woman("wangWu", 25);
        woman m4 = new woman("aiMi", 23);

        tm.put(m1, "江苏");
        tm.put(m2, "安徽");
        tm.put(m3, "北京");
        tm.put(m4, "上海");
        System.out.println(tm);
    }

    private static void practice03(){
        //统计字符串中每个字符出现的次数
        String str = "abcdedbacebdcababcdeaadebc";
        TreeMap<Character,Integer> tm = new TreeMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if(tm.containsKey(c)){
                int count = tm.get(c);
                count++;
                tm.put(c,count);
            }else{
                tm.put(c,1);
            }
        }
        System.out.println(tm);
        StringBuilder sb = new StringBuilder();
        tm.forEach((key,value)->sb.append(key).append("(").append(value).append(")"));
        System.out.println(sb);
    }
}

class woman implements Comparable<woman> {
    private String name;
    private int age;


    public woman() {
    }

    public woman(String name, int age) {
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
        return "woman{name = " + name + ", age = " + age + "}";
    }

    @Override
    public int compareTo(woman o) {
        int i = this.getAge() - o.getAge();
        i = i == 0 ? this.getName().compareTo(o.getName()) : i;
        return i;
    }
}