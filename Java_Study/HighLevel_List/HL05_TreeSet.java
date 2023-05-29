package HighLevel_List;

import java.util.Comparator;
import java.util.Iterator;
import java.util.TreeSet;

/**
 * TreeSet中的元素可以排序，按照默认的规则（从小到大）
 * 在底层基于红黑树数据结构实现排序，增删改查性能都比较好
 */
public class HL05_TreeSet {
    public static void main(String[] args) {
        System.out.println("------------test-------------");
        test();
        System.out.println("-----------test02------------");
        test02();
        System.out.println("-----------test03------------");
        test03();
    }
    public static void test(){
        //利用TreeSet存储整数并且进行排序
        TreeSet<Integer> ts = new TreeSet<>();

        ts.add(3);
        ts.add(1);
        ts.add(4);
        ts.add(2);
        ts.add(5);
        System.out.println(ts); //直接打印
        System.out.println("------------------");
        Iterator<Integer> it = ts.iterator(); //遍历打印
        while(it.hasNext()){
            int i = it.next();
            System.out.print(i+" ");
        }
        System.out.println();
    }

    public static void test02(){
        //当我我们需要对自定义类型进行排序的时候，需要进行方法的重写
        //在自定义类型中进行Comparable接口中的抽象方法的重写，指定里面的比较规则
        person p1 = new person("zhanSan",22);
        person p2 = new person("liSi",25);
        person p3 = new person("wangWu",23);
        TreeSet<person>ts = new TreeSet<>();
        ts.add(p1);
        ts.add(p3);
        ts.add(p2);
        for (person t : ts) {
            System.out.println(t);
        }

    }

    public static void test03(){
        //比较方式2:比较器排序：创建TreeSet对象的时候，传递比较器Comparable指定规则
        //默认采用之前的第一种比较规则，当第一种比较规则不能满足当前需求的时候，就要用到第二种排序规则
        // 对于 c ab df qwer 这四个字符串进行排序，首先按照长度排序，如果长度一样就按照首字母排序

        //o1表示当前需要添加的元素
        //o2表示在红黑树中已经存在的元素
        TreeSet<String> ts = new TreeSet<>((String o1, String o2)-> {
                //按照长度排序
                int i = o1.length()-o2.length();
                //当长度一样，就按照首字母排序
                i= i==0?o1.compareTo(o2):i;
                return i;
            }
        );


        ts.add("c");
        ts.add("ad");
        ts.add("qwer");
        ts.add("df");

        System.out.println(ts);

    }
}

class person implements Comparable <person>{
    private String name;
    private int age;


    public person() {
    }

    public person(String name, int age) {
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
        return "person{name = " + name + ", age = " + age + "}";
    }


    //重写排序方法
    @Override
    public int compareTo(person o) {
        return this.getAge()-o.getAge();
    }
}
/*
-----------test-------------
[1, 2, 3, 4, 5]
------------------
1 2 3 4 5 
-----------test02------------
person{name = zhanSan, age = 22}
person{name = wangWu, age = 23}
person{name = liSi, age = 25}
-----------test03------------
[c, ad, df, qwer]
*/
