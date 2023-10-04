package Second_List;


import java.util.Iterator;
import java.util.function.Consumer;

/*
 * 链表类
 * */
public class SinglyLinkedList implements Iterable<Integer> {

    //哨兵节点
    private Node head = null;

    /*
     * 内部类->节点类
     * */
    private static class Node {
        Integer value;
        Node next;

        public Node(Integer value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    //头插法添加节点
    public void addFirst(int value) {
        head = new Node(value, head);
    }

    //尾插法添加节点
    public void addLast(int value) {
        Node lastNode = findLast();
        if (lastNode == null) {
            addFirst(value);
        } else {
            lastNode.next = new Node(value, null);
        }
    }

    //对于尾插法，需要找到最后一个节点
    private Node findLast() {
        //如果是空链表
        if (head == null) {
            return null;
        }
        Node p;
        for (p = head; p.next != null; p = p.next) {
        }
        return p;
    }

    //遍历链表
    //while循环
    public void loopByWhile(Consumer<Integer> consumer) {
        Node p = head;
        while (p != null) {
            consumer.accept(p.value);
            p = p.next;
        }
    }

    //for循环
    public void loopByFor(Consumer<Integer> consumer) {
        for (Node p = head; p != null; p = p.next) {
            consumer.accept(p.value);
        }
    }

    //迭代器遍历
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>() {
            Node pointer = head;

            @Override
            public boolean hasNext() {//判断是否有下一个节点
                return pointer != null;
            }

            @Override
            public Integer next() {
                int value = pointer.value;
                pointer = pointer.next;
                return value;
            }
        };
    }

    //通过索引查找节点的值--索引从0开始
    //step-1 找到指定索引位置的节点
    private Node findNode(int index) {
        int i = 0;
        for (Node p = head; p != null; p = p.next, i++) {
            if (i == index) {
                return p;
            }
        }
        return null;
    }

    //step-2 返回这个节点的值
    public int getNodeByIndex(int index) {
        Node node = findNode(index);
        if (node == null) {
            throw new IllegalArgumentException
                    (String.format("index[%d] 不合法%n", index));
        }
        return node.value;
    }

    //向索引位置插入节点--索引从0开始
    public void insertByIndex(int index, int value) {

        //当插入位置的索引=0的时候就是在头部插入，直接调用之前的addFirst方法即可
        if (index == 0) {
            addFirst(value);
            return;
        }

        //首先找到需要插入位置的上一个节点，需要插入节点的指针和上一个节点的指针指向的是同一个节点
        //插入后让上一个节点指向新插入的节点
        Node prev = findNode(index - 1);//找到上一个节点
        if (prev == null) {
            throw new IllegalArgumentException
                    (String.format("index[%d] 不合法%n", index));
        }
        prev.next = new Node(value, prev.next);
    }

    //删除节点--删除头节点
    public void removeFirstNode() {
        if (head == null) {
            throw new IllegalArgumentException(
                    String.format("index[%d] 不合法%n", 0));
        }
        head = head.next;
    }

    //删除节点--依据索引删除
    public void removeByIndex(int index) {
        //如果要删除的节点索引就是0，则就是删除头结点
        if (index == 0) {
            removeFirstNode();
            return;
        }
        Node prev = findNode(index - 1);
        //判断prev为空的情况
        if (prev == null) {
            throw new IllegalArgumentException(
                    String.format("index[%d] 不合法%n", index));
        }
        Node removed = prev.next;
        //判断removed为空的情况
        if (removed == null) {
            throw new IllegalArgumentException(
                    String.format("index[%d] 不合法%n", index));
        }
        prev.next = removed.next;
    }
}
