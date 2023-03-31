package girlFriendClass;

public class girlFriend {
    private String name;    //私有变量 名字
    private int age;        //私有变量 年龄
    private String hobby;   //私有变量 爱好


    //标准javabean
    //空参构造和全参构造
    //所有变量的getter和setter方法
    public girlFriend() {
    }

    public girlFriend(String name, int age, String hobby) {
        this.name = name;
        this.age = age;
        this.hobby = hobby;
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


    public String getHobby() {
        return hobby;
    }


    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    //成员方法，用来表示对象的行为
    public void shopping(String name) {
        System.out.println("陪" + name + "逛街");
    }

    public void eat(String name) {
        System.out.println(name + "在吃饭");
    }

    public void sleep(String name) {
        System.out.println(name + "在睡觉");
    }

    public void shout(String name) {
        System.out.println(name + "在和我争吵");
    }
}
