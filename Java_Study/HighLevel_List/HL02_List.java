package HighLevel_List;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class HL02_List {
    public static void main(String[] args) {
        test1();
        test2();
    }

    public static void test1() {
        System.out.println("---------------test1--------------");
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        System.out.println("原来的集合是:"+list);
        //指定位置添加元素
        list.add(1, "QQQ");
        System.out.println(list);

        //删除指定位置的元素
        String remove = list.remove(0);
        System.out.println(list);
        System.out.println(remove);

        //修改指定位置的元素
        list.set(2, "YYY");
        System.out.println(list);

        //得到指定位置元素
        String ret = list.get(2);
        System.out.println(ret);

    }

    public static void test2(){
        System.out.println("---------------test2--------------");
        //遍历方法-列表迭代器
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        ListIterator<String> it =list.listIterator();
        while(it.hasNext()){
            String str = it.next();
            //添加元素
            if("bbb".equals(str)){
                it.add("qqq");
            }
            System.out.println(str);
        }
        System.out.println(list);
    }
}
/*
---------------test1--------------
原来的集合是:[aaa, bbb, ccc, ddd]
[aaa, QQQ, bbb, ccc, ddd]
[QQQ, bbb, ccc, ddd]
aaa
[QQQ, bbb, YYY, ddd]
YYY
---------------test2--------------
aaa
bbb
ccc
ddd
[aaa, bbb, qqq, ccc, ddd]
*/