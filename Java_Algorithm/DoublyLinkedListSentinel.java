package Thired_DoublyLinkedList;

import java.util.Iterator;

public class DoublyLinkedListSentinel implements Iterable<Integer> {

    private static class Node {
        Node prev; //双向链表的上一个指针节点
        Integer value;
        Node next;//双向链表的下一个指针节点

        public Node(Node prev, Integer value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node head;  //头哨兵
    private Node tail;  //尾哨兵

    public DoublyLinkedListSentinel() {

        head = new Node(null, 666, null);
        tail = new Node(null, 666, null);
        head.next = tail;
        tail.prev = head;
    }

    //根据索引找到节点的工具方法
    private Node findNode(int index) {
        int i = -1;
        Node p = head;
        while (p != tail) {
            if (i == index) {
                return p;
            }
            p = p.next;
            i++;
        }
        return null;
    }
    
    //头插节点
    public void addFirst(int value) {
        insertByIndex(0, value);
    }

    //尾插节点
    public void removeFirst() {
        removeByIndex(0);
    }

    //在链表的尾部插入节点
    public void addLast(int value) {
        Node oldLast = tail.prev;
        Node addedNode = new Node(oldLast, value, tail);
        oldLast.next = addedNode;
        tail.prev = addedNode;
    }

    //在链表的尾部删除节点
    public void removeLast() {
        Node removed = tail.prev;
        if (removed == head) {
            throw new IllegalArgumentException(
                    String.format("index[%d] 不合法", 0));
        }
        Node prevNode = removed.prev;
        prevNode.next = tail;
        tail.prev = prevNode;
    }

    //依据索引插入节点
    public void insertByIndex(int index, int value) {
        Node prevNode = findNode(index - 1);
        if (prevNode == null) {
            throw new IllegalArgumentException(
                    String.format("index[%d] 不合法", index));
        }
        Node nextNode = prevNode.next;
        Node insertedNode = new Node(prevNode, value, nextNode);
        prevNode.next = insertedNode;
        nextNode.prev = insertedNode;
    }

    //依据索引删除节点
    public void removeByIndex(int index) {
        Node prevNode = findNode(index - 1);
        if (prevNode == null) {
            throw new IllegalArgumentException(
                    String.format("index[%d] 不合法", index));
        }
        Node removed = prevNode.next;
        if (removed == tail) {
            throw new IllegalArgumentException(
                    String.format("index[%d] 不合法", index));
        }
        Node nextNode = removed.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    //迭代器
    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            Node p = head.next;

            @Override
            public boolean hasNext() {
                return p != tail;
            }

            @Override
            public Integer next() {
                int value = p.value;
                p = p.next;
                return value;
            }
        };
    }
}
