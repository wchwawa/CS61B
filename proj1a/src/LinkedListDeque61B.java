import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque61B<T> implements Deque61B<T> {

    private int nodeNum = 0;

    public class Node{
        Node prev;
        Node next;
        T item;

        public Node(Node prev, T item, Node next){
            this.prev = prev;
            this.next = next;
            this.item = item;
        }
    }

    private Node sentinel;
    public LinkedListDeque61B(){        //constructor
        sentinel = new Node(null, null, null);
        if (sentinel.next == null){
            sentinel.next = sentinel;
            sentinel.prev = sentinel;
        }
    }

    @Override
    public void addFirst(T x) {
        nodeNum ++;
        Node tempNode = new Node(sentinel, x, sentinel.next);
        sentinel.next.prev = tempNode;
        sentinel.next = tempNode;

    }

    @Override
    public void addLast(T x) {
        nodeNum++;
        Node tempNode = new Node(sentinel.prev, x, sentinel);
        sentinel.prev.next = tempNode;
        sentinel.prev = tempNode;
    }

    @Override
    public List<T> toList() {
        List<T> dequeList = new ArrayList<>();

        Node first = sentinel.next;
        for (int i = 0; i < nodeNum; i++){
            T item = first.item;
            first = first.next;
            dequeList.add(item);
        }
        return dequeList;
    }

    @Override
    public boolean isEmpty() {
        if (sentinel.next == sentinel.prev){
            return true;
        }
        return false;
    }

    @Override
    public int size() {
        return nodeNum;
    }

    @Override
    public T removeFirst() {
        Node first = sentinel.next;
        if (first != null){
            sentinel.next = first.next;
            return first.item;
        }
        return null;
    }

    @Override
    public T removeLast() {
    return null;}

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T getRecursive(int index) {
        return null;
    }
}