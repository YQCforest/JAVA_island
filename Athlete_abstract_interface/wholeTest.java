package AthleteClass;

public class wholeTest {
    public static void main(String[] args) {
        //创建对象
        coachBasketball c1 = new coachBasketball();
        c1.setName("蔡教练");
        c1.setAge(26);
        System.out.print(c1.getAge()+"岁的"+c1.getName());c1.move();
        System.out.println();
        coachPingPang p1 = new coachPingPang();
        p1.setName("马教练");
        p1.setAge(30);
        System.out.print(p1.getAge()+"岁的"+p1.getName());p1.move();
        p1.speakEng(p1.getName());
        System.out.println();
        athleteBasketball b= new athleteBasketball();
        b.setName("小坤");
        b.setAge(25);
        System.out.print(b.getAge()+"岁的"+b.getName());b.move();
        System.out.println();
        athletePingPang p=new athletePingPang();
        p.setName("小张");
        p.setAge(29);
        System.out.print(p.getAge()+"岁的"+p.getName());p.move();
        p.speakEng(p.getName());
    }
}
