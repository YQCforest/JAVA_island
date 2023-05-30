package HighLevel_List;

import java.util.*;

public class HL07_HashMap {
    public static void main(String[] args) {
        //practice01();
        practice02();
    }
    public static void practice01(){
        HashMap<people,String> hm = new HashMap<>();
        people  p1 =new people("zhanSan",23);
        people  p2 =new people("liSi",24);
        people  p3 =new people("wangWu",25);

        //当自定义数据类型作为键值的时候，需要重写hashCode()方法和equals()方法
        hm.put(p1,"江苏");
        hm.put(p2,"安徽");
        hm.put(p3,"浙江");

        Set<people> peopleSet = hm.keySet();
        for (people people : peopleSet) {
            System.out.println(people+"->"+hm.get(people));
        }
    }

    public static void practice02(){
        //统计80个同学对于四个景点的投票情况
        String arr[] = {"A","B","C","D"};
        Random r= new Random();
        ArrayList<String> al = new ArrayList<>();
        for (int i = 0; i <80; i++) {
           int index = r.nextInt(arr.length);
           al.add(arr[index]);
        }

        HashMap<String,Integer> hm = new HashMap<>();
        for (String name : al) {
            if(hm.containsKey(name)){
                int count = hm.get(name);
                count++;
                hm.put(name,count);
            }else{
                hm.put(name,1);
            }
        }
        System.out.println(hm);

        int max = 0;
        Set<Map.Entry<String, Integer>> entries = hm.entrySet();
        for (Map.Entry<String, Integer> entry : entries) {
            int count = entry.getValue();
            if(count>max){
                max = count;
            }
        }
        System.out.println(max);
        for (Map.Entry<String, Integer> entry : entries) {
            int count = entry.getValue();
            if(count==max){
                System.out.println(entry.getKey());
            }
        }
    }
}

class people{

    private String name;
    private int age;


    public people() {
    }

    public people(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return age
     */
    public int getAge() {
        return age;
    }

    /**
     * 设置
     * @param age
     */
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        people people = (people) o;
        return age == people.age && Objects.equals(name, people.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    public String toString() {
        return "people{name = " + name + ", age = " + age + "}";
    }
}
