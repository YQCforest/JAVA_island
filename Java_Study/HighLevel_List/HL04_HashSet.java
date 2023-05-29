package HighLevel_List;


import java.util.HashSet;
import java.util.Objects;

public class HL04_HashSet {
    public static void main(String[] args) {

        student s1 = new student("张三",23);
        student s2 = new student("张三",23);

        //在重写了hashCode()后，属性值相同则哈希值相同
        System.out.println(s1.hashCode());
        System.out.println(s2.hashCode());
        System.out.println("-----------");
        test();
    }
    public static void test(){
        //创建一份存储学生对象的集合，存储多个学生对象
        //遍历这个集合
        //学生对象的成员变量相同，则认为这是同一个对象
        student s1 = new student("张三",23);
        student s2 = new student("王五",25);
        student s3 = new student("李四",24);
        student s4 = new student("赵六",26);
        student s5 = new student("张三",23);

        HashSet<student> ms = new HashSet<>();
        System.out.println(ms.add(s1));
        System.out.println(ms.add(s2));
        System.out.println(ms.add(s3));
        System.out.println(ms.add(s4));
        System.out.println(ms.add(s5));
        for (student mStr : ms) {
            System.out.println(mStr);
        }
    }
}

class student{
    private String name;
    private int age;


    public student() {
    }

    public student(String name, int age) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        student student = (student) o;
        return age == student.age && Objects.equals(name, student.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String toString() {
        return "student{name = " + name + ", age = " + age + "}";
    }
}
/*
24022543
24022543
-----------
true
true
true
true
false
student{name = 张三, age = 23}
student{name = 李四, age = 24}
student{name = 王五, age = 25}
student{name = 赵六, age = 26}
*/
