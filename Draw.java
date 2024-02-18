import java.util.*;

public class Draw {
    public static void main(String[] args) {
        int number;
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入需要抽取的人数:");
        number = sc.nextInt();
        Random r = new Random();
        HashSet<Integer> has = new HashSet<>();
        do {
            int cur = r.nextInt(34);
            has.add(cur);
        }while (has.size()<number);
        System.out.println(has);
        String[] arr = {"白雯旭", "陈志源", "邓添宁", "桂腾浩", "侯俊杰", "黄嘉达", "黄宗锋", "金承豪", "李玟萱", "廖孔旗", "刘善益", "刘绎", "潘鑫岳", "祁晨锋",
                "滕恩长", "仝晏绮", "王岩", "王奕为", "吴黄浩轩", "武桐含", "徐义超", "徐自鹏", "杨轲", "杨旻", "姚鹏运", "姚扬", "俞华军", "张佳艺",
                "张恺颖", "赵一凡", "周宇豪", "李向洋", "林智瀚", "戴浩源",};
        Integer[] integersArr = has.toArray(new Integer[has.size()]);
        for (int i = 0;i<integersArr.length;i++){
            System.out.println(arr[integersArr[i]]);
        }

    }
}
/*这是一个抽签系统，就是在没人报名，活动却要强制每个班要出人的时候用*/
/*只需要指定需要number的值，就能指定需要抽取多少人，而且不会有重复*/
