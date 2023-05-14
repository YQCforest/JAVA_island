package Algorithm;

import java.util.Arrays;

/**
 * 操作数组的工具类
 * 这个类中的方法基本都是static静态方法，而且这个类中没有构造方法
 * 因此不用创建对象直接调用方法即可
 */
public class A04_Arrays {
    public static void main(String[] args) {

        //Arrays.toString()方法
        //将数组转换成字符串返回
        System.out.println("--------------toString--------------");
        int[]arr = {1,2,3,4,5,6,7,8,9,10};
        String str = Arrays.toString(arr);
        System.out.println(str);

        //Arrays.binarySearch()方法
        //注意：在Arrays的二分查找方法必须是要求数组升序的
        //细节：如果在数组中存在这个元素，那么返回这个元素的索引，如果不存在，则返回这个值是 -插入点-1
        System.out.println("------------binarySearch------------");
        System.out.println(Arrays.binarySearch(arr, 4));  //3   存在直接返回索引值
        System.out.println(Arrays.binarySearch(arr, 11)); //-11 不存在，11在数组中的插入点应该是索引为10的位置，那么返回值就是 -10-1=-11


        //copyOf方法，拷贝数组
        //重载方法: copyOfRange 指定拷贝范围(包左不包右)
        System.out.println("--------------copyOf----------------");
        int[] newArr = Arrays.copyOf(arr,10);
        String str2 = Arrays.toString(newArr);
        System.out.println(str2);

        //fill 填充方法
        //覆盖填充，将新的数据覆盖原来数组中的元素进行填充
        System.out.println("--------------fill------------------");
        Arrays.fill(arr,10);
        System.out.println(Arrays.toString(arr));

        //sort方法
        //默认情况下，给基本数据类型进行升序排序(底层是快速排序)
        System.out.println("--------------sort------------------");
        int[] arr2 = {2,4,1,3,5,6,7,9,10,8};
        Arrays.sort(arr2);
        System.out.println(Arrays.toString(arr2));
    }

}
