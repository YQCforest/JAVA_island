

public class animalTest {

    public static void main(String[] args) {
        Animal_Extends_Polymorphism d = new Dog();   //Animal d 和Dog d 是一个多态的表现，多态要求必须有继承关系
        d.setName("大黄狗");
        d.setColor("黄");
        d.setAge(2);
        d.eat(d.getName(), d.getAge(), d.getColor());
        System.out.println();
        //值得注意的是，当我们直接用animal这个父类来new对象的时候，new出来的对象是无法调用子类Dog中的独有的成员方法的
        //而我们用子类Dog来new对象的时候，是可以调用子类Dog中的特有的成员方法的

        Dog d2 = new Dog();
        d2.setName("大白狗");
        d2.setColor("白");
        d2.setAge(3);
        d2.eat(d2.getName(), d2.getAge(), d2.getColor());
        d2.lookHome();
        System.out.println();

        Cat c = new Cat();
        c.setName("小黑猫");
        c.setColor("黑");
        c.setAge(3);
        c.eat(c.getName(), c.getAge(), c.getColor());
        c.catchMouse();
        System.out.println();

    }
}

/* run result:
一只2岁的黄色的大黄狗正在吃骨头

一只3岁的白色的大白狗正在吃骨头
大白狗正在看家

一只3岁的黑色的小黑猫正在吃鱼
小黑猫正在抓老鼠
*/
