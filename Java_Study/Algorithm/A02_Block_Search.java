package Algorithm;

import java.util.Scanner;

/**
 * 分块和分块查找
 * 原则1、前一块中的最大数据，小于后一块中的所有数据（块内无序，块间有序）
 * 原则2、块的数量一般等于数字的个数开根号
 * 核心：先确定要找的数字在哪一块，然后在块内挨个查找
 */
public class A02_Block_Search {
    public static void main(String[] args) {
        int[] arr = {16, 5, 9, 12, 21, 18,
                32, 23, 37, 26, 45, 34,
                50, 48, 61, 52, 73, 66};

        Block b1 = new Block(21, 0, 5);
        Block b2 = new Block(45, 6, 11);
        Block b3 = new Block(73, 12, 17);

        //定义数组来管理块的对象(专业名称--索引表)
        Block[] barr = {b1, b2, b3};
        //输入需要查找的数字
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要查找的数字:");
        int target = sc.nextInt();
        int index = getIndex(barr, arr, target);
        System.out.println(index);
    }

    //定义方法寻找目标值的索引
    private static int getIndex(Block[] barr, int[] arr, int target) {

        //利用分块查找的原理寻找target的索引
        int indexBlock = findIndexBlock(barr, target);
        if (indexBlock == -1) {
            //表示target不在数组中
            return -1;
        }
        //获取到这一个块中的起始索引和结束索引
        int startIndex = barr[indexBlock].getStarIndex();
        int endIndex = barr[indexBlock].getEndIndex();
        //注意这里的 i<=endIndex
        for (int i = startIndex; i <= endIndex; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    //定义方法寻找目标值在哪一块中
    public static int findIndexBlock(Block[] barr, int target) {

        //从barr[]的0索引开始遍历，如果target小于等于max，那么就表示target在这一块中
        for (int i = 0; i < barr.length; i++) {
            if (target <= barr[i].getMax()) {
                return i;
            }
        }
        return -1;
    }

}

//这个类就是块的对象，数组分块后将每个块进行对象化
class Block {
    private int max;       //每个块中的最大值
    private int starIndex; //块中起始数据的索引值
    private int endIndex;  //块中结束数据的索引值


    public Block() {
    }

    public Block(int max, int starIndex, int endIndex) {
        this.max = max;
        this.starIndex = starIndex;
        this.endIndex = endIndex;
    }


    public int getMax() {
        return max;
    }


    public void setMax(int max) {
        this.max = max;
    }


    public int getStarIndex() {
        return starIndex;
    }


    public void setStarIndex(int starIndex) {
        this.starIndex = starIndex;
    }


    public int getEndIndex() {
        return endIndex;
    }


    public void setEndIndex(int endIndex) {
        this.endIndex = endIndex;
    }

    public String toString() {
        return "Block{max = " + max + ", starIndex = " + starIndex + ", endIndex = " + endIndex + "}";
    }
}