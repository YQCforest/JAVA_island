public class Animal_Extends_Polymorphism {  //定义成员变量
    String name;
    private int age;
    private String color;


    /*空参构造和带有全部参数的构造*/
    public Animal_Extends_Polymorphism() {
    }

    public Animal_Extends_Polymorphism(String name, int age, String color) {
        this.name = name;
        this.age = age;
        this.color = color;
    }


    //成员方法
    public void eat(String name,int age,String color){
        System.out.println("一只"+age+"的"+color+"色"+"的"+name+"正在吃东西");
    }

    //各个参数的getter和setter方法
    public String getName() {
        return name;
    }


    public void setName(String name) {
        this.name = name;
    }


    public int getAge() {
        return age;
    }


    public void setAge(int age) {
        this.age = age;
    }


    public String getColor() {
        return color;
    }


    public void setColor(String color) {
        this.color = color;
    }

    public String toString() {
        return "Animal{name = " + name + ", age = " + age + ", color = " + color + "}";
    }
}
