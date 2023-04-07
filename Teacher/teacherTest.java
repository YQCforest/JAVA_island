package Teacher;

import com.sun.source.tree.NewArrayTree;

public class teacherTest {
    public static void main(String[] args) {
        englishTeacher et = new englishTeacher();
        et.setName("小苏");
        et.setAge(26);
        et.setNum(101);
        et.setWedding("NO");
        System.out.println(et.getName() + "," + et.getAge() + "岁," + et.getNum() + "," + "是否结婚:" + et.getWedding());
        et.move();
        et.teach();
        System.out.println("-------------------------------");
        chineseTeacher ct = new chineseTeacher();
        ct.setName("小张");
        ct.setAge(27);
        ct.setNum(102);
        ct.setWedding("YES");
        System.out.println(ct.getName() + "," + ct.getAge() + "岁," + ct.getNum() + "," + "是否结婚:" + ct.getWedding());
        ct.move();
        ct.teachC();
        System.out.println("-------------------------------");
        headmaster h = new headmaster();
        h.setName("老黄");
        h.setAge(56);
        h.setNum(103);
        h.setWedding("YES");
        System.out.println(h.getName() + "," + h.getAge() + "岁," + h.getNum() + "," + "是否结婚:" + h.getWedding());
        h.move();
        h.manage();
        System.out.println("-------------------------------");
        counselors c= new counselors();
        c.setName("小赵");
        c.setAge(27);
        c.setNum(104);
        c.setWedding("NO");
        System.out.println(c.getName() + "," + c.getAge() + "岁," + c.getNum() + "," + "是否结婚:" + c.getWedding());
        c.move();
        c.construct();
    }
}

       /* 小苏,26岁,101,是否结婚:NO
        教学老师主要负责教学任务！
        英语老师在教英语
        -------------------------------
        小张,27岁,102,是否结婚:YES
        教学老师主要负责教学任务！
        语文老师正在教语文
        -------------------------------
        老黄,56岁,103,是否结婚:YES
        行政老师主要负责学校管理任务！
        校长要管理学校
        -------------------------------
        小赵,27岁,104,是否结婚:NO
        行政老师主要负责学校管理任务！
        辅导员要进行班级建设*/