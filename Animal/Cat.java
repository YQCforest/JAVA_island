//继承父类Animal
public class Cat extends Animal_Extends_Polymorphism {
    public Cat() {
    }

    public Cat(String name, int age, String color) {
        super(name, age, color);
    }

    //对父类方法的重写
    @Override
    public void eat(String name, int age, String color) {
        System.out.println("一只"+age+"岁的"+color+"色"+"的"+name+"正在吃鱼");
    }
    //子类中独有的成员方法
    public void catchMouse(){
        System.out.println(name+"正在抓老鼠");
    }  
}
