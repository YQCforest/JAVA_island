package HighLevel_List;

import java.util.ArrayList;
import java.util.Arrays;

public class HL03_Generics {
    public static void main(String[] args) {
        MyArrayList<String> list1 = new MyArrayList<>();
        list1.add("aaa");
        list1.add("bbb");
        list1.add("ccc");
        String str = list1.get(0);
        System.out.println(str);
        System.out.println(list1);

        MyArrayList<Integer> list2 = new MyArrayList<>();
        list2.add(123);
        list2.add(456);
        list2.add(789);
        int i = list2.get(2);
        System.out.println(i);
        System.out.println(list2);

        ArrayList<String> list3 = new ArrayList<>();
        MyAddAll(list3, "a", "b", "c", "d");
        System.out.println(list3);
    }

    //泛型方法
    public static <E> void MyAddAll(ArrayList<E> list, E e1, E e2, E e3, E e4) {
        list.add(e1);
        list.add(e2);
        list.add(e3);
        list.add(e4);
    }

}

//自己定义的集合类
//泛型类
class MyArrayList<E> {

    Object[] obj = new Object[10];
    int size;

    public boolean add(E e) {
        obj[size] = e;
        size++;
        return true;
    }

    public E get(int index) {
        return (E) obj[index];
    }

    public String toString() {
        return Arrays.toString(obj);
    }
}

