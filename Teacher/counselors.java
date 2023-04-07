package Teacher;

public class counselors extends administrativeTeacher implements classConstruction{
    @Override
    public void construct() {
        System.out.println("辅导员要进行班级建设");
    }
}
