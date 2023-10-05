//双向带哨兵循环链表
import java.util.Iterator;

public class DoublyRoundLinkedListSentinel implements Iterable<Integer> {


    private static class Node {
        Node prev;
        Integer value;
        Node next;

        public Node(Node prev, Integer value, Node next) {
            this.prev = prev;
            this.value = value;
            this.next = next;
        }
    }

    private Node sentinel = new Node(null, -1, null);

    public DoublyRoundLinkedListSentinel() {
        sentinel.next = sentinel;
        sentinel.prev = sentinel;
    }

    public void addFirst(int value) {
        Node prevNode = sentinel;
        Node nextNode = prevNode.next;
        Node added = new Node(prevNode, value, nextNode);
        prevNode.next = added;
        nextNode.prev = added;
    }

    public void addLast(int value) {
        Node prevNode = sentinel.prev;
        Node nextNode = sentinel;
        Node added = new Node(prevNode, value, nextNode);
        prevNode.next = added;
        nextNode.prev = added;
    }

    public void removeFirst() {
        Node removed = sentinel.next;
        if (removed == sentinel) {
            throw new IllegalArgumentException("非法!");
        }
        Node prevNode = sentinel;
        Node nextNode = removed.next;
        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void removeLast() {

        Node removed = sentinel.prev;
        if (removed == sentinel) {
            throw new IllegalArgumentException("非法!");
        }
        Node prevNode = removed.prev;
        Node nextNode = sentinel;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    public void removeNodeByValue(int value) {
        Node removed = findNodeByValue(value);
        if(removed == null){
            throw new IllegalArgumentException("参数非法");
        }
        Node prevNode = removed.prev;
        Node nextNode = removed.next;

        prevNode.next = nextNode;
        nextNode.prev = prevNode;
    }

    private Node findNodeByValue(int value) {
        Node p = sentinel.next;
        while (p != sentinel) {
            if (p.value == value) {
                return p;
            }
            p = p.next;
        }
        return null;
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<>() {
            Node p = sentinel.next;

            @Override
            public boolean hasNext() {
                return p != sentinel;
            }

            @Override
            public Integer next() {
                Integer value = p.value;
                p = p.next;
                return value;
            }
        };
    }

}
