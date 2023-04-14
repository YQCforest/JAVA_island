import java.util.ArrayList;
import java.util.Scanner;

public class dishTest {

    //注意在前面要加上static关键字修饰，为了在下面的方法中能够调用
    static ArrayList<Dish> dishList = new ArrayList<>();
    static ArrayList<Dish> dishPerson = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);
    static Scanner v = new Scanner(System.in);


    public static void main(String[] args) {
        //首先初始化菜单对象
        initDish();
        //当我们还不要结账的时候，while循环一直在
        while(true){
            //展示菜单
            showMenu();
            //输入菜单号
            int num = sc.nextInt();
            switch (num){
                case 1:
                    //需要不断点菜
                    while(true){
                        //展示已经点好的菜品
                        showPersonMenu();
                        //当我们不想在继续点菜就跳出这个while循环
                        int n = sc.nextInt();
                        if(n==0){
                            break;
                        }
                        //将我们点好的菜获取出来
                        Dish dish = dishList.get(n-1);
                        System.out.println("你点了:"+dish.name);
                        //接着将获取出来的菜存入到一个新的集合中去，方便后面的操作
                        dishPerson.add(dish);
                    }
                case 2:
                    //展示我们已经点好的菜品
                    showHaveDish();
                    break;
                case 3:
                    //买单，也就是跳出整个while循环，点菜逻辑结束
                    Buy();
                    return;
                case 4:
                    //在刚刚已经点好的菜品中删除我们想要删除的第几道菜
                    //确认用户需要删除，否则继续到大菜单中
                    System.out.println("确认删除?请输入（YES/NO）");
                    String de = v.next();
                    if(de.equals("YES")){
                        //输入YES后确认删除
                        deleteDish();
                    }else{
                        break;
                    }
            }
        }

    }

    private static void deleteDish() {
        int i;
        //输入我们需要删除的第i道菜
        System.out.print("请输入你要删除第道菜:");
        i = sc.nextInt();
        //由于集合下标从0开始，所以要i-1
        //调用集合的 remove 方法，在方法中传入index
        dishPerson.remove(i-1);
        System.out.println("删除成功！选择（2）可查看当前已点!");
    }


    private static void Buy() {
        //定义vip
        String vip;
        //定义总值
        double sum = 0;
        //将刚刚我们已经点好的菜品，也就是加入到新集合中的菜品，遍历，相加
        for (int i = 0; i < dishPerson.size(); i++) {
            Dish dish = dishPerson.get(i);
            sum+=dish.price;
        }
        //判断是否是vip
        System.out.print("你是否是vip?请输入Y(是)或者N(不是):");
        vip = v.next();
        //是vip打八折
        if(vip.equals("Y")){
            sum*=0.8;
        }
        //不是直接输出总值
        System.out.println("请稍等，正在结算!");
        System.out.println("你本次一共消费"+(int)sum+"元!");
    }

    private static void showHaveDish() {
        System.out.println("你已经点了:");
        //遍历新集合（已点菜单）
        for (int i = 0; i < dishPerson.size(); i++) {
            Dish dish = dishPerson.get(i);
            System.out.println("编号:"+dish.id+"\t"+"菜名:"+dish.name+"\t"+"价格:"+dish.price);
        }
    }

    private static void showPersonMenu() {
        System.out.println("请你点菜:");
        for (int i = 0; i < dishList.size(); i++) {
            Dish dish = dishList.get(i);
            System.out.println("编号:"+dish.id+"\t"+"菜名:"+dish.name+"\t"+"价格:"+dish.price);
        }
        System.out.println("请输入你需要点菜的编号(输入0返回上级目录):");
    }

    public static void showMenu(){
        //打印菜单
        System.out.println("----菜单----");
        System.out.println("1   点菜");
        System.out.println("2   已点菜品");
        System.out.println("3   买单");
        System.out.println("4   删除菜品");
        System.out.println("-----------");
        System.out.println("请输入你的选择：");
    }

    public static void initDish() {
        //初始化菜单对象
        dishList.add(new Dish(1,"地三鲜",25.0));
        dishList.add(new Dish(2,"闷大虾",55.0));
        dishList.add(new Dish(3,"烧鸡",27.0));
        dishList.add(new Dish(4,"炖王八",67.0));
        dishList.add(new Dish(5,"炸猪排",34.0));
    }
}
