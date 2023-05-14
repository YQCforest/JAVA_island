package API;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

public class API_Practice {
    public static void main(String[] args) {
        practice01();
        practice02();
        practice03();
    }

    public static void practice01(){

        //键盘录入一些数据添加到集合中，直到集合中的所有数据和超过200为止

        ArrayList<Integer>list = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("请输入一个整数:");
            String str = sc.nextLine();
            int number = Integer.parseInt(str);
            if(number<1||number>100){
                System.out.println("输入错误，请重新输入!");
                continue;
            }
            list.add(number);

            //统计集合中所有的数据和
           int sum =  getSum(list);
           if(sum>200){
               System.out.println("集合中所有的数据和已经满足要求");
               break;
           }
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i)+" ");
            }
        }
    }

    private static int getSum(ArrayList<Integer> list) {
        int sum = 0;
        for (int i = 0; i < list.size(); i++) {
            int num = list.get(i);
            sum+=num;
        }
        return sum;
    }

    public static void practice02(){

        //自己实现parseInt方法，将字符串形式的数据转成整数
        //要求:字符串中只能是数字不能有其他字符、最少一位且最多十位、0不能开头

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个字符串:");
        String str = sc.nextLine();
        if(!str.matches("[1-9]\\d{0,9}")){
            System.out.println("输入的字符串格式错误!");
        }else{
            System.out.println("输入的字符串格式正确!");
            int num=0;
            for (int i = 0; i < str.length(); i++) {
                int c = str.charAt(i)-'0';
                num=num*10+c;
            }
            System.out.println("字符串转换成整数类型的结果是:"+num);
        }
    }

    public static void practice03(){

        //判断一个年份是否为闰年

        Scanner sc = new Scanner(System.in);
        System.out.println("请输入一个年份:");
        int year = sc.nextInt();

        //jdk8方法
        //从3月1号减去一天，判断减去一天后2月有多少天，依次为依据判断是否为闰年
        LocalDate Id1 = LocalDate.of(year, 3, 1);
        LocalDate ID2 = Id1.minusDays(1);
        int day = ID2.getDayOfMonth();
        if(day==29){
            System.out.println("这一年是闰年");
        }else{
            System.out.println("这一年不是闰年");
        }

        //jdk8直接调用方法
        boolean isLeapYear = Id1.isLeapYear();
        if(isLeapYear){
            System.out.println("这一年是闰年");
        }else{
            System.out.println("这一年不是闰年");
        }
    }
}
