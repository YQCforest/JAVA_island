package Teacher;


//people 作为一个抽象类，是不能够实例化的，也就是用people来创建对象是不行的
public abstract class people {
    private String name;
    private int age;
    private int num;
    private String wedding;


    public people(){}

    public people(String name, int age, int num, String wedding) {
        this.name = name;
        this.age = age;
        this.num = num;
        this.wedding = wedding;
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getWedding() {
        return wedding;
    }

    public void setWedding(String wedding) {
        this.wedding = wedding;
    }

    public abstract void move();
}
