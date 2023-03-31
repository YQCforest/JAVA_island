import java.util.ArrayList;
import java.util.Scanner;

public class Test01_02 {
    public static void main(String[] args) {
        //在集合中<>中应该放入泛型
        //找到最小值后删除最小值（试一下不就知道怎么写了）
        ArrayList <Integer> list = new ArrayList<>(); //集合变量名应该放在泛型的后面
        int n,num,min,max;

        System.out.println("请输入在集合中需要添加几个数字:");
        Scanner sc = new Scanner(System.in);
        n=sc.nextInt();
        System.out.println("请输入在集合中添加的数字:");
        for(int i=0;i<n;i++) {
            list.add(num = sc.nextInt());
        }
        System.out.print("该集合中已经成功存入:"+list);

        System.out.println();

        min = listMiniFind(list);
        System.out.println("这个集合中最小的数据是:"+min);
        max = listMaxFind(list);
        System.out.println("这个集合中最大的数据是:"+max);

        deleteListMini(list);
        System.out.print("删除最小值后的集合是:");
        System.out.print(list);
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
                ct=i;
            }
        }
       //list.remove(minDelete);//删除集合中的指定下标的方法 remove(index)
        list.remove(ct);
        System.out.println("已经成功删除最小值:"+minDelete);

    }
}

/*
请输入在集合中需要添加几个数字:
5
请输入在集合中添加的数字:
3 4 5 1 6
该集合中已经成功存入:[3, 4, 5, 1, 6]
这个集合中最小的数据是:1
这个集合中最大的数据是:6
已经成功删除最小值:1
删除最小值后的集合是:[3, 4, 5, 6]
*/
