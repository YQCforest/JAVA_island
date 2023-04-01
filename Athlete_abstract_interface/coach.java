package AthleteClass;


//由于Coach需要继承People这个抽象类，那么要做的操作是:要么Coach是一个抽象类，要么在这个类中重写父类中所有的抽象方法
public class coach extends People{

    @Override
    public void move() {
        System.out.println("正在教学");
    }
}
