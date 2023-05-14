package Algorithm;

public class A01_Search {
    public static void main(String[] args) {
        int[] arr={1,4,6,7,8};
        boolean ifIn = basicSearch(arr, 3);
        System.out.println(ifIn);
        int i = binarySearch(arr, 6);
        System.out.println(i);
        int i1 = insertionSearch(arr, 7);
        System.out.println(i1);
    }

    public static boolean basicSearch(int[] arr,int target){
        //基本查找
        //最基本的遍历查找，时间复杂度高
        //无需有序
        for (int i = 0; i < arr.length; i++) {
            if(arr[i]==target){
                return true;
            }
        }
        return false;
    }

    public static int binarySearch(int[]arr,int target){
        //二分查找
        //条件：二分查找时候数组中的数据必须是有序的
        int left=0,right = arr.length-1;
        while(true){
            if(left>right){
                return -1;
            }
            int mid =(left+right)/2;
            if(arr[mid]>target){
                right = mid-1;
            } else if (arr[mid]<target) {
                left = mid+1;
            }else{
                return mid;
            }
        }
    }

    public static int insertionSearch(int[]arr,int target){

        //插值查找
        //同二分查找的核心相同，都是不断地进行区间的折半
        //只是对于 mid 的计算有了新的方法，提高了了 mid 的查找效率
        //mid = left+((target-arr[left])/(arr[right]-arr[left]))*(right-left)
        //缺点：数组中的数据分布必须要相对的均匀
        int left=0,right = arr.length-1;
        while(true){
            if(left>right){
                return -1;
            }
            int mid = left+((target-arr[left])/(arr[right]-arr[left]))*(right-left);
            if(arr[mid]>target){
                right = mid-1;
            } else if (arr[mid]<target) {
                left = mid+1;
            }else{
                return mid;
            }
        }
    }


}
