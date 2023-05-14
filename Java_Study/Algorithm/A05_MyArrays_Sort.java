package Algorithm;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 在默认的Arrays类中的sort方法是升序排序
 * 提供的重载方法是可以在sort的参数中传入排序规则的
 * 细节：
 * 这个重载的方法只能是给引用数据类型进行排序的
 * 如果要进行基本数据类型的排序，那么要将其变成对应的包装类
 */
public class A05_MyArrays_Sort {
    public static void main(String[] args) {
        Integer[] arr = {2,6,7,1,3,4,5,9,8,10};

        //第二个参数是一个接口，所以我们在调用方法的时候，需要传递这个接口的实现对象，作为排序规则
        //这个实现类只使用一次，不需要单独再写一个类，直接使用匿名内部类即可

        //底层原理：使用二分查找和插入排序
        //将一个数组分成两个部分，刚开始以0索引为有序的一边，后面为无序的一边，然后开始遍历，将无序的一边(插入排序)插入到有序的一边
        //进行到后面的时候，使用二分查找寻找需要插入的索引值，再进行上面的步骤

        //返回值
        //负数:表示当前需要插入的元素是小的，要放在前面
        //正数:表示当前需要插入的元素是大的，要放在后面
        //0:表示当前需要插入的元素是一样的，但是也要放在后面

        //参数o1:代表无序序列中的元素
        //参数o2:代表有序序列中的元素

        //简单理解：
        //o1-o2: 升序排列
        //o2-o1: 降序排列

        Arrays.sort(arr, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2-o1;
            }
        });
        System.out.println(Arrays.toString(arr));  //[10, 9, 8, 7, 6, 5, 4, 3, 2, 1]
    }
}
