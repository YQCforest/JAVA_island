package Algorithm;

/**
 * 排序算法
 */
public class A03_Sort {
    public static void main(String[] args) {
        int[] arr1 = {3,2,1,4,5};
        bubbleSort(arr1);
        printArr(arr1);
        System.out.println();
        int[] arr2 = {3,2,1,4,5};
        selectionSort(arr2);
        printArr(arr2);
        System.out.println();
        int[] arr3 = {3,2,1,4,5};
        insertionSort(arr3);
        printArr(arr3);
        System.out.println();
        int[] arr4 = {6,1,2,7,9,3,4,5,10,8};
        fastSort(arr4,0,arr4.length-1);
        printArr(arr4);
    }
    public static void printArr(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }

    public static void bubbleSort(int[]arr){
        //冒泡排序
        for(int i=0;i<arr.length-1;i++){
            for(int j=0;j<arr.length-i-1;j++){
                if(arr[j]>arr[j+1]){
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                }
            }
        }
    }

    public static void selectionSort(int[]arr){
        //选择排序
        //每一轮将该索引的数据和后一个数据进行比较，如果大于后面的数据就交换
        //直到整个数组从小到大有序
        for (int i = 0; i < arr.length-1; i++) {
            for(int j=i+1;j<arr.length;j++){
                if(arr[i]>arr[j]){
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    public static void insertionSort(int[]arr){
        //插入排序
        for (int i = 0; i < arr.length; i++) {
            for(int j=i;j>0;j--){
                if(arr[j]<arr[j-1]){
                    int temp = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = temp;
                }else{
                    break;
                }
            }
        }
    }

    public static void fastSort(int[]arr,int i,int j){

        //定义两个变量确定查找的范围
        int start = i;
        int end = j;
        //递归出口
        if(start>end){
            return;
        }
        //定义一个变量记录基准数
        //基准数的左边一定比基准数小，右边一定比基准数大
        int baseNumber = arr[i];
        //利用循环找到要交换的数字
        while(start!=end){

            // ！必须先找end再找start ！

            //利用end，从后往前找到比基准数小的数字
            while (true){
                if(end<=start||arr[end]<baseNumber){
                    break;
                }
                end--;
            }

            //利用start,从前往后找到比基准数大的数字
            while (true){
                if(end<=start||arr[start]>baseNumber){
                    break;
                }
                start++;
            }
            //将end和start指向的元素交换
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
        }
        //当start和end指向同一个元素的时候那么循环结束
        //表示已经数组中找到了基准数该存放的位置
        //接下来让基准数归位--拿着范围中的第一个数字和start指向的数字进行交换即可
        int cur = arr[i];
        arr[i] = arr[start];
        arr[start] = cur;

        //确定6左右边的数字重复这个范围
        //开始递归
        fastSort(arr,i,start-1);
        fastSort(arr,start+1,j);
    }

}
