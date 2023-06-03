package Abnormal_And_File;

import java.util.Scanner;

public class catchAbnormal {
    public static void main(String[] args) {
        study01();
        study02();
        study03();
        study04();
        practice();
        study05();
    }

    public static void study01() {
        //自己捕获异常

        int[] arr = {1, 2, 3, 4, 5};
        try {
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组索引越界");
        }
        System.out.println("这句码子仍然执行");
    }

    public static void study02() {

        //当try中遇到多个问题,使用多个catch进行异常捕获
        //异常中出现父类关系的时候，父类需要写在下面
        int[] arr = {1, 2, 3, 4};

        try {
            System.out.println(arr[5]); //ArrayIndexOutOfBoundsException
            System.out.println(2 / 0);  //ArithmeticException
            String s = null;
            System.out.println(s.equals("aaa"));  //NullPointerException
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组索引越界");
        } catch (ArithmeticException e) {
            //算数异常
            System.out.println("除数不能为零");
        } catch (NullPointerException e) {
            System.out.println("空指针");
        } catch (Exception e) {
            System.out.println("出现异常");
        }
        System.out.println("这句码子仍然执行");
    }

    public static void study03() {

        //异常中的常用方法

        int[] arr = {1, 2, 3, 4, 5};

        try {
            System.out.println(arr[10]);
        } catch (ArrayIndexOutOfBoundsException e) {
            String message = e.getMessage();
            System.out.println(message);//结果：Index 10 out of bounds for length 5

            String s = e.toString();
            System.out.println(s);      //结果：java.lang.ArrayIndexOutOfBoundsException: Index 10 out of bounds for length 5

            e.printStackTrace();        //在控制台中以红色字体输出异常信息，相较于前两个信息最全面，并且不会结束虚拟机的运行
        }

        System.out.println("这句码子还执行没？");

    }

    public static void study04() {

        //抛出异常
        int[] arr = null;
        int max = 0;
        try {
            max = getMax(arr);
        } catch (NullPointerException e) {
            System.out.println("空指针异常");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("数组越界异常");
        }
        System.out.println(max);
    }
    public static int getMax(int[] arr) {

        if (arr == null) {
            //空指针异常
            throw new NullPointerException();
        }

        if (arr.length == 0) {
            //数组越界异常
            throw new ArrayIndexOutOfBoundsException();
        }

        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void practice() {

        /*
            需求：键盘录入英雄的姓名和年龄，姓名的长度在3~10位，年龄在18~60
                  超出这个范围数据异常不能赋值，需要重新录入，一直到录入正确为止
            需要考虑到键盘录入的所有情况
         */
        Scanner sc = new Scanner(System.in);
        Hero hero = new Hero();
        while (true) {
            try {
                System.out.println("请输入英雄的姓名:");
                String nameStr = sc.nextLine();
                System.out.println("请输入英雄的年龄:");
                String ageStr = sc.nextLine();
                int age = Integer.parseInt(ageStr);
                hero.setName(nameStr);
                hero.setAge(age);
                System.out.println(hero);
                break;
            } catch (NumberFormatException e) {
                System.out.println("输入的年龄格式有误，请重新输入！");
            }catch (RuntimeException e){
                System.out.println("输入的年龄或者姓名长度不在范围，请重新输入！");
            }
        }
    }

    public static void study05(){

        //利用自定义异常类进行异常的表示
        //使得异常可以更好的描述我们所出现的情况
        Scanner sc = new Scanner(System.in);
        Hero hero = new Hero();
        while (true) {
            try {
                System.out.println("请输入英雄的姓名:");
                String nameStr = sc.nextLine();
                System.out.println("请输入英雄的年龄:");
                String ageStr = sc.nextLine();
                int age = Integer.parseInt(ageStr);
                hero.setName(nameStr);
                hero.setAge(age);
                System.out.println(hero);
                break;
            } catch (NumberFormatException e) {
                e.printStackTrace();
            }catch (NameFormatException e){
                e.printStackTrace();
            }catch (AgeOutOfBoundsException e){
                e.printStackTrace();
            }

        }
    }
}

class Hero {
    private String name;
    private int age;

    public Hero() {
    }

    public Hero(String name, int age) {
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
        if(name.length()<3||name.length()>10){
            throw new NameFormatException(name+"姓名的格式有误!");
        }
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
        if(age<18||age>40){
            throw new AgeOutOfBoundsException(age+"年龄的范围有误!");
        }
        this.age = age;
    }

    public String toString() {
        return "Hero{name = " + name + ", age = " + age + "}";
    }
}

//自定义异常类
class NameFormatException extends RuntimeException{

    public NameFormatException() {
    }

    public NameFormatException(String message) {
        super(message);
    }
}
class AgeOutOfBoundsException extends RuntimeException{

    public AgeOutOfBoundsException() {
    }

    public AgeOutOfBoundsException(String message) {
        super(message);
    }
}