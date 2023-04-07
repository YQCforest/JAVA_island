package Teacher;

public class englishTeacher extends teachingTeacher implements teachEnglish{

    @Override
    public void teach() {
        System.out.println("英语老师在教英语");
    }
}
