package AthleteClass;

public class athletePingPang extends athlete implements speakEnglish{
    @Override
    public void move() {
        System.out.println("正在训练乓乓球");
    }

    @Override
    public void speakEng(String name) {
        System.out.println(name+"正在说英语");
    }
}
