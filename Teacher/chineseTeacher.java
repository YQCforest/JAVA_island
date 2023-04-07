package Teacher;

public class chineseTeacher extends teachingTeacher implements teachChinese{
    @Override
    public void teachC() {
        System.out.println("语文老师正在教语文");
    }
}
