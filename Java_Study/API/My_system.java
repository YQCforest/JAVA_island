package API;

/**
 * System工具类 提供与系统相关的方法
 * 静态类，直接调用方法
 */

public class My_system {
    public static void main(String[] args) {

        test01();
        test02();
        test03();
    }

    public static void test01(){
        //exit 结束java虚拟机
        //方法的形参 状态码 0：表示当前虚拟机是正常停止 非0：表示当前虚拟机是异常停止
        System.exit(0);             //程序执行到这行的时候就直接结束
        System.out.println("执行了么？");   //这行不会执行
    }
    public static void test02(){
        //currentTimeMillis 返回系统时间毫秒形式
        long l = System.currentTimeMillis();
        System.out.println(l);
    }
    public static void test03(){
        //arraycopy 拷贝数组
        //参数：数据源数组，起始索引，目的地数组，起始索引，拷贝个数
        int []arr1 = {1,2,3,4,5,6,7,8,9,10};
        int[]arr2 = new int[10];
        System.arraycopy(arr1,0,arr2,0,10);
        for (int i = 0; i < arr2.length; i++) {
            System.out.print(arr2[i]+" ");
        }
        /*
          注意1：如果数据源数组和目的地数组都是基本数据类型，那么两者的类型必须保持一致，否则报错
          注意2：在拷贝的时候需要考虑数组的长度，如果超出范围会报错
          注意3：如果数据源数组和目的地数组都是引用数据类型，那么子类类型可以赋值给父类类型
         */
        //关于注意3：
        Student s1 = new Student(23,"张三");
        Student s2 = new Student(22,"李四");
        Student s3 = new Student(24,"王五");

        Student []srr1={s1,s2,s3};
        //srr2是一个父类的数组
        Person []srr2 = new Person[3];

        //将srr1对象的地址值赋值给srr2
        System.arraycopy(srr1,0,srr2,0,3);
        for (int i = 0; i < srr2.length; i++) {
            //当子类类型赋值给父类的时候需要强制类型转换
            Student str = (Student) srr2[i];
            System.out.println(str.getName()+","+str.getAge());
        }
    }
}
//注意3：
class Person{
    private int age;
    private String name;

    public Person() {
    }

    public Person(int age, String name) {
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
}

class Student extends Person{
    public Student() {
    }

    public Student(int age, String name) {
        super(age, name);
    }
}
