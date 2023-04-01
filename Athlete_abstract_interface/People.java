package AthleteClass;

public abstract class People {
    private String name;
    private int age;

    public People(){};

    public People(String name, int age) {
        this.name = name;
        this.age = age;
    }

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

    //抽象方法，当父类中的方法体在后面的子类中不能具体表示时，我们用抽象方法

    public abstract void move();     //抽象方法无方法体，直接以" ; "号结束
}
