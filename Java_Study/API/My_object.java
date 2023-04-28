package API;

import java.util.Objects;

/**
 * Object类 JAVA中的顶级父类。所有的类都直接或者间接继承于 Object类
 */
public class My_object {
    public static void main(String[] args) {
        test01();
        test02();

    }
    public static void test01(){
        // toString方法 返回对象的字符串表现形式
        Object obj = new Object();
        System.out.println(obj.toString());//java.lang.Object@776ec8df--包名+类名+@+地址值
        //不想获得这个样式 重写toString方法获得类中的具体属性值
        Man m = new Man(23,"张三");
        System.out.println(m.toString());
    }
    public static void test02(){
        // equal方法 判断两个对象是否相等
        Man m1 = new Man(23,"张三");
        Man m2 = new Man(23,"张三");
        //比较的是地址值，两个对象都是 new 出来的，地址值肯定不同，但是对于实际开发中，需要比较的不是地址值而是类中的具体属性值，重写equal方法
        boolean res = m1.equals(m2);
        System.out.println(res);
    }

}

class Man{
    private int age;
    private String name;

    public Man() {
    }

    public Man(int age, String name) {
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

    //重写equal 方法
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Man man = (Man) o;
        return age == man.age && Objects.equals(name, man.name);
    }

    //重写toString方法
    @Override
    public String toString() {
        return age+","+name;
    }
}