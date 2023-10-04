//动态数组

import java.util.Arrays;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.stream.IntStream;

public class DynamicArray implements Iterable<Integer> {

    private int size = 0;       //逻辑大小
    private int capacity = 8;   //容量
    private int[] array = {};

    //在数组的最后添加元素
    public void addLast(int element) {
        add(size, element);
    }

    //指定位置插入元素
    public void add(int index, int element) {

        checkAndGrow();
        if (index >= 0 && index < size) {
            System.arraycopy(array, index, array,
                    index + 1, size - index);
        }
        array[index] = element;
        size++;

    }

    private void checkAndGrow() {
        if (size==0){
         array = new int[capacity];
        }else if (size == capacity) {
            capacity += capacity >> 1;
            int[] newArray = new int[capacity];
            System.arraycopy(array,0,
                    newArray,0,size);
            array = newArray;
        }
    }

    //以String类型输出数组
    public void showArrayByString() {
        System.out.println(Arrays.toString(array));
    }

    //遍历数组
    /*
     * 使用函数式接口的方式让这个遍历的功能不仅仅局限于打印输出
     * */
    public void foreach(Consumer<Integer> consumer) {
        for (int i = 0; i < size; i++) {
            consumer.accept(array[i]);
        }
    }

    //通过指定索引获取到该位置的元素
    public int getElementByIndex(int index) {
        try {
            if (index < 0 || index > size) {
                throw new ArrayIndexOutOfBoundsException();
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            e.printStackTrace();
        }
        return array[index];
    }


    //迭代器重写方法发->增加了这个方法后可以使用增强for循环
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            int i = 0;

            @Override
            public boolean hasNext() {
                return i < size;
            }

            @Override
            public Integer next() {
                return array[i++];
            }
        };
    }


    //将数组变成stream流，使用stream流处理
    public IntStream stream() {
        return IntStream.of(Arrays.copyOfRange(array, 0, size));
    }

    //删除指定索引的元素
    public int remove(int index) {
        int removed = array[index];

        if (index > 0 && index < size) {
            System.arraycopy(array, index + 1,
                    array, index, size - index - 1);
        }
        size--;
        return removed;
    }

}
