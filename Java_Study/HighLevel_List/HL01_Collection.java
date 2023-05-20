package HighLevel_List;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class HL01_Collection {

    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        System.out.println("-----------------test1----------------");
        //注意点：Collection是一个接口，不能直接创建对象
        //因此只能创建其实现类的对象
        //比如ArrayList

        Collection<String> coll = new ArrayList<>();
        //添加元素
        //方法的返回值是一个boolean
        coll.add("aaa");
        coll.add("bbb");
        coll.add("ccc");
        System.out.println(coll);

        //清空
        //coll.clear();

        //删除
        //注意在Collection中的方法是共性的，只能指定元素对象删除而不能通过索引删除
        //方法的返回值是一个boolean
        coll.remove("aaa");

        //判断是否包含
        //返回值是boolean
        //注意在底层是依赖equals方法，所以如果要判断是否包含自定义数据类型的时候，需要在自定义数据的javabean类中重写equals方法
        System.out.println(coll.contains("bbb"));

        //判断是否为空
        System.out.println(coll.isEmpty());

        //集合的长度
        System.out.println(coll.size());

    }

    public static void test2() {
        System.out.println("-----------------test2----------------");
        //Collection的遍历 迭代器遍历 增强for循环遍历 lambda遍历

        Collection<String> coll = new ArrayList<>();
        coll.add("aaa");
        coll.add("bbb");
        coll.add("ccc");
        coll.add("ddd");

        //迭代器遍历
        //注意：在循环中只能使用一次next()方法、在迭代器遍历的时候不能使用集合的方法进行增加或者删除
        //注意：遍历完毕后迭代器的指针不会复位，想要再次遍历只能获取一个新的迭代器的对象
        Iterator<String> it = coll.iterator();
        while (it.hasNext()) {
            String str = it.next();
            System.out.println(str);
            if ("bbb".equals(str)) {
                it.remove();
                //在迭代器遍历的时候不能使用集合的方法进行增加或者删除
                //转而使用迭代器的删除方法  [aaa, ccc, ddd]
            }
        }
        System.out.println(coll);
        System.out.println("============");
        //增强for遍历
        for (String s : coll) {
            System.out.println(s);
        }
        System.out.println("============");
        //lambda 表达式遍历
        coll.forEach(s-> System.out.println(s));
    }
}
/*
    -----------------test1----------------
    [aaa, bbb, ccc]
    true
    false
    2
    -----------------test2----------------
    aaa
    bbb
    ccc
    ddd
    [aaa, ccc, ddd]
    ============
    aaa
    ccc
    ddd
    ============
    aaa
    ccc
    ddd
*/