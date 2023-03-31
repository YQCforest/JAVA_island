//继承父类Animal
public class Dog extends Animal_Extends_Polymorphism {
    public Dog() {
    }

    public Dog(String name, int age, String color) {
        super(name, age, color);
    }

    //当父类成员方法无法满足需求额的时候
    //对父类方法的重写
    @Override
    public void eat(String name, int age, String color) {
        System.out.println("一只"+age+"岁的"+color+"色"+"的"+name+"正在吃骨头");
    }
    //子类中独有的成员方法
    public void lookHome(){
        System.out.println(name+"正在看家");
    }
}