import java.util.ArrayList;
import java.util.Scanner;

//创建一个集合，在集合中用键盘输入的方式存入数据，接着找到该集合中的最小值和最大值
//找到最小值后删除最小值（试一下不就知道怎么写了）
public class Test01_01 {
    public static void main(String[] args) {
        //在集合中<>中应该放入泛型
        ArrayList <Integer> list = new ArrayList<>(); //集合变量名应该放在泛型的后面
        int n,num,min,max;
        System.out.println("请输入在集合中需要添加几个数字:");
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        System.out.println("请输入在集合中添加的数字:");
        for(int i=0;i<n;i++){
            list.add(num=sc.nextInt());
        }
        System.out.println("该集合中已经成功存入:");
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
        System.out.println();
        min = listMiniFind(list);
        System.out.println("这个集合中最小的数据是:"+min);
        max = listMaxFind(list);
        System.out.println("这个集合中最大的数据是:"+max);

        deleteListMini(list);
        System.out.println("删除最小值后的集合是:");
        for(int i=0;i<list.size();i++){
            System.out.print(list.get(i)+" ");
        }
    }

    public static int listMiniFind(ArrayList list){
        int min = (int) list.get(0);
        for(int i=0;i<list.size();i++){
            if((int)list.get(i)<min){
                min = (int)list.get(i);
            }
        }
        return min;
    }
    public static int listMaxFind(ArrayList list){
        int max = (int) list.get(0);
        for(int i=0;i<list.size();i++){
            if((int)list.get(i)>max){
                max = (int)list.get(i);
            }
        }
        return max;
    }
    //删除最小值的 方法
    public static void deleteListMini(ArrayList list){
        int i,ct=0;
        int minDelete = (int)list.get(0);
        for(i=0;i<list.size();i++){
            if((int)list.get(i)<minDelete){
                minDelete = (int)list.get(i);
                ct++;
            }
        }
        list.remove(ct);             //删除集合中的指定下标的方法 remove(index)
        System.out.println("已经成功删除最小值:"+minDelete);
    }
}