import java.util.ArrayList;
import java.util.List;
import java.lang.Math;

public class ArrayDeque61B<T> implements Deque61B<T> {
    private T[] items;
    private int size;
    private int itemLength;
    public int nextFirst;
    public int nextLast;

    public ArrayDeque61B(){
        items = (T[]) new Object[8];
        size = 0;
        itemLength = items.length;
        this.nextFirst = items.length - 1;
        this.nextLast = 0;

    }

    @Override
    public void addFirst(T x) {
        if (size == itemLength){
            resize(2);
        }
        size ++;
        items[nextFirst] = x;
        nextFirst = Math.floorMod(nextFirst - 1, itemLength);

    }

    @Override
    public void addLast(T x) {
        if (size == itemLength){
            resize(2);
        }
        size++;
        items[nextLast] = x;
        nextLast = Math.floorMod(nextLast + 1, itemLength);
    }

    @Override
    public List<T> toList() {
        List<T> l = new ArrayList<>();

        for (int i = 0; i < items.length; i ++){
            if (items[i] == null){
                continue;
            }else {
                l.add(items[i]);
            }
        }
        return l;
    }

    @Override
    public boolean isEmpty() {
        if (size == 0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (size == 0){
            return null;
        }
        if (size < 0.25 * itemLength){
            resize(0.50);
        }
        size --;
        T removedItem = items[nextFirst + 1];
        items[nextFirst + 1] = null;
        nextFirst = Math.floorMod(nextFirst + 1, itemLength);
        return removedItem;
    }

    @Override
    public T removeLast() {
        if (size == 0){
            return null;
        }
        if (size < 0.25 * itemLength){
            resize(0.50);
        }

        size --;
        T removedItem = items[nextLast - 1];
        items[nextLast - 1] = null;
        nextLast = Math.floorMod(nextLast - 1, itemLength);
        return removedItem;
    }

    @Override
    public T get(int index) {
        if (index < itemLength && index >= 0){
            return items[index];
        }
        return null;
    }

    @Override
    public T getRecursive(int index) {
        return null;
    }

    public static void main(String[] args) {
        System.out.println(Math.floorMod(-1, 7));
        System.out.println();
    }

    public void resize(double factor){
        double cal = itemLength * factor;
        int newLength = (int)cal;
        T[] newItem = (T[]) new Object[newLength];

        for (int i = 0; i < nextLast; i++) {
            newItem[i] = items[i];
        }
        int totalFirstItemCount = itemLength - 1 - nextFirst;
        int newItemLength = newItem.length;
        for (int j = itemLength - 1; j > nextFirst; j --){
            newItem[newItemLength - 1] = items[j];
            newItemLength --;
        }
        items = newItem;
        itemLength = items.length;
        nextFirst = itemLength - totalFirstItemCount - 1;
    }

}
