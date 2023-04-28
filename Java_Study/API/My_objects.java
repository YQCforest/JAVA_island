package API;

import java.util.Objects;

/**
 * Objects类 一个工具类，提供一些方法去完成一些功能
 * 方法为静态
 */

public class My_objects {
    public static void main(String[] args) {
        test01();
        test02();
        test03();
    }
    public static void test01(){
        //equal 先做非空判断 再比较两个对象
        Class c1 =null;
        Class c2 = new Class(23,"张三");
        System.out.println(Objects.equals(c1, c2));
        //方法细节: 底层实现中，会先判断 c1 是否为空，是则直接返回false
        //如果 c1 不是空，那么调用 equal 方法来和 c2 进行比较
    }
    public static void test02(){
        //isNULL 判断对象是否为空 是则返回true 否则false
        Class c1 = new Class();
        Class c2 = null;
        System.out.println(Objects.isNull(c1));
        System.out.println(Objects.isNull(c2));
    }
    public static void test03(){
        //nonNULL 判断对象是否为空 返回结果与isNULL相反
        Class c1 = new Class();
        Class c2 = null;
        System.out.println(Objects.nonNull(c1));
        System.out.println(Objects.nonNull(c2));
    }
}
class Class{
    private int age;
    private String name;

    public Class() {
    }
    public Class(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Class aClass = (Class) o;
        return age == aClass.age && Objects.equals(name, aClass.name);
    }

    @Override
    public String toString() {
        return name+","+age;
    }
}
