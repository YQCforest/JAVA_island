package girlFriendClass;

import girlFriendClass.girlFriend;

public class girlFriendTest {
    public static void main(String[] args) {

        //定义女朋友类
        //通过setter方法传入参数值
        //调用成员方法
        girlFriend girlFriendNum1 = new girlFriend();
        girlFriendNum1.setName("小美");
        girlFriendNum1.setAge(19);
        girlFriendNum1.setHobby("吃美食");
        System.out.println(girlFriendNum1.getName() + "," + girlFriendNum1.getAge() + "岁," + "爱好是" + girlFriendNum1.getHobby());
        girlFriendNum1.shopping(girlFriendNum1.getName());
        girlFriendNum1.eat(girlFriendNum1.getName());
        girlFriendNum1.shout(girlFriendNum1.getName());
        girlFriendNum1.sleep(girlFriendNum1.getName());

        System.out.println();

        girlFriend girlFriendNum2 = new girlFriend();
        girlFriendNum2.setName("大美");
        girlFriendNum2.setAge(23);
        girlFriendNum2.setHobby("做美食");
        System.out.println(girlFriendNum2.getName() + "," + girlFriendNum2.getAge() + "岁," + "爱好是" + girlFriendNum2.getHobby());
        girlFriendNum2.shopping(girlFriendNum1.getName());
        girlFriendNum2.eat(girlFriendNum1.getName());
        girlFriendNum2.shout(girlFriendNum1.getName());
        girlFriendNum2.sleep(girlFriendNum1.getName());
    }
}
