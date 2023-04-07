package Teacher;

public class headmaster extends administrativeTeacher implements management{
    @Override
    public void manage() {
        System.out.println("校长要管理学校");
    }
}
