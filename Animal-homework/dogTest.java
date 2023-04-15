/*202202050231  姚鹏运*/
package Animal;

public class dogTest {
    public static void main(String[] args) {

        //创建第一个狗对象
        Dog d1 = new Dog();
        d1.setName("甜心");
        d1.setAge(2);
        d1.setMood("心情很好");
        d1.setVariety("贵宾犬");
        showDog(d1);
        d1.run();
        showDog(d1);
        d1.shout();
        System.out.println("==================================");
        //创建第二个狗对象
        Dog d2 = new Dog("德国牧羊犬",3,"心情不好","太子");
        showDog(d2);
        d2.run();
        showDog(d2);
        d2.shout();
    }


    public static void showDog(Dog d){
        System.out.print("名字叫"+d.getName()+"的"+d.getVariety()+d.getMood()+",");
    }
}
