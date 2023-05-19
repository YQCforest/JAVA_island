package Algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 关于一些算法的练习
 */
public class A07_Practice {
    public static void main(String[] args) {
        practice01();
        System.out.println("-----------------------");
        System.out.println(practice02(12));
        System.out.println("-----------------------");
        System.out.println(practice03(1));
        System.out.println("-----------------------");
        System.out.println(practice04(20));

    }

    public static void practice01() {
        /*
         定义一个数组并储存一些女朋友对象，利用Arrays的中的sort方法进行排序
         要求1、属性有姓名、年龄、身高
         要求2、按照年龄大小进行排序，年龄一样就按照身高，身高一样就按照姓名字母进行排序
        */
        //compareTo()方法 判断字符串是否相等 按照字符串的每一个字符进行ASCII码判断，不相等返回-1

        GirlFriend g1 = new GirlFriend("徐自鹏", 19, 172);
        GirlFriend g2 = new GirlFriend("杨轲", 20, 178);
        GirlFriend g3 = new GirlFriend("黄嘉达", 19, 185);
        GirlFriend[] arr = {g1, g2, g3};
        Arrays.sort(arr, new Comparator<GirlFriend>() {
            @Override
            public int compare(GirlFriend o1, GirlFriend o2) {
                double temp = o1.getAge() - o2.getAge();
                temp = temp == 0 ? o1.getHeight() - o2.getHeight() : temp;
                temp = temp == 0 ? o1.getName().compareTo(o2.getName()) : temp;
                if(temp>0){
                    return 1;
                }else if(temp<0){
                    return -1;
                }else{
                    return 0;
                }
            }
        });
        System.out.println(Arrays.toString(arr));
    }

    private static long practice02(int month){
        //斐波那契递归练习
        if(month==1||month==2){
            return 1;
        }
        return practice02(month-1)+practice02(month-2);
    }

    private  static long practice03(int day){
        //猴子吃桃子，每天吃的桃子是后一天吃的数量加1，乘2，第十天剩一个桃子，第一天有多少桃子？
        if(day<=0||day>=11){
            System.out.println("输入时间有误!");
            return -1;
        }
        if(day==10){
            return 1;
        }

        return (practice03(day+1)+1)*2;
    }

    private static long practice04(int num){
        //小明爬楼梯，有时候一次一阶，一次两阶，一次三阶，一共20阶，多少种爬法？
        if(num==1){
            return 1;
        }
        if(num==2){
            return 2;
        }
        if(num==3){
            return 4;
        }
        return practice04(num-1)+practice04(num-2)+practice04(num-3);
    }
}

class GirlFriend {
    private String name;
    private int age;
    private double height;


    public GirlFriend() {
    }

    public GirlFriend(String name, int age, double height) {
        this.name = name;
        this.age = age;
        this.height = height;
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

    /**
     * 获取
     *
     * @return height
     */
    public double getHeight() {
        return height;
    }

    /**
     * 设置
     *
     * @param height
     */
    public void setHeight(double height) {
        this.height = height;
    }

    public String toString() {
        return "GirlFriend{name = " + name + ", age = " + age + ", height = " + height + "}";
    }
}

/*[GirlFriend{name = 徐自鹏, age = 19, height = 172.0}, GirlFriend{name = 黄嘉达, age = 19, height = 185.0},
GirlFriend{name = 杨轲, age = 20, height = 178.0}]
-----------------------
144
-----------------------
1534
-----------------------
121415*/