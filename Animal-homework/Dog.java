/*202202050231  姚鹏运*/
package Animal;

public class Dog {
    /*设定属性包括：品种，年龄，心情，名字；方法包括：叫，跑。*/

    private String variety;
    private int age;
    private String mood;
    private String name;

    //无参构造和带有全部参数的有参构造
    public Dog(){}

    public Dog(String variety, int age, String mood, String name) {
        this.variety = variety;
        this.age = age;
        this.mood = mood;
        this.name = name;
    }

    //所有成员变量的setter和getter方法
    public String getVariety() {
        return variety;
    }

    public void setVariety(String variety) {
        this.variety = variety;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getMood() {
        return mood;
    }

    //在mood 的 set方法中进行判断
    public void setMood(String mood) {
        if(mood.equals("心情很好")||mood.equals("心情不好")){
            this.mood = mood;
        }else{
            this.mood = "心情很好";
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    //成员方法
    //叫
    public void shout(){
        if(getMood().equals("心情很好")){
            System.out.println("开心地汪汪叫");
        }
        if (getMood().equals("心情不好")) {
            System.out.println("伤心地呜呜叫");
        }
    }

    //跑
    public void run(){
        if(getMood().equals("心情很好")){
            System.out.println("开心地围着主人身边转");
        }
        if (getMood().equals("心情不好")) {
            System.out.println("伤心地一动不动");
        }
    }
}
