package Stream_And_MethodReference;

import java.util.List;

/**
 * 不可变集合
 * 在 List Set Map 接口中，都存在静态的of方法，可以获取一个不可变的集合
 * 在获取不可变的 Set集合的时候，需要确保集合中数据的唯一性
 * Map集合的键需要确保唯一的 且在不可变的Map中最多只能传入10个键值对 如果超过10个就需要使用ofEntries()方法
 */
public class UnchangedList {
    public static void main(String[] args) {
        List<String> stringList = List.of("a", "b", "c", "d");    //调用of方法即可获得一个不可变的集合  传入的是一个可变参数
        //只能进行查询操作
        System.out.println(stringList);
        for (String s : stringList) {
            System.out.println(s);
        }
        //stringList.remove(0);   //无法修改 删除的方法不可用
    }
}
