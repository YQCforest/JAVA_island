package AthleteClass;

public class coachPingPang extends coach implements speakEnglish{
    @Override
    public void move() {
        System.out.println("正在教学乓乓球");
    }

    @Override
    public void speakEng(String name) {
        System.out.println(name+"正在说英语");
    }
}
