package AthleteClass;

public class athletePingPang extends athlete implements speakEnglish{
    @Override
    public void move() {
        System.out.println("正在训练乓乓球");
    }
    //为了实现接口，要么是抽象类，要么重写接口所有中的抽象方法
    @Override
    public void speakEng(String name) {
        System.out.println(name+"正在说英语");
    }
}
