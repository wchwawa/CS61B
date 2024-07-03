import edu.princeton.cs.algs4.In;
import jh61b.utils.Reflection;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import java.util.List;
import java.util.ArrayList;
import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

/** Performs some basic linked list tests. */
public class LinkedListDeque61BTest {

    @Test
    /** In this test, we have three different assert statements that verify that addFirst works correctly. */
    public void addFirstTestBasic() {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();

        lld1.addFirst("back"); // after this call we expect: ["back"]
        assertThat(lld1.toList()).containsExactly("back").inOrder();

        lld1.addFirst("middle"); // after this call we expect: ["middle", "back"]
        assertThat(lld1.toList()).containsExactly("middle", "back").inOrder();

        lld1.addFirst("front"); // after this call we expect: ["front", "middle", "back"]
        assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();

         /* Note: The first two assertThat statements aren't really necessary. For example, it's hard
            to imagine a bug in your code that would lead to ["front"] and ["front", "middle"] failing,
            but not ["front", "middle", "back"].
          */
    }

    @Test
    /** In this test, we use only one assertThat statement. IMO this test is just as good as addFirstTestBasic.
     *  In other words, the tedious work of adding the extra assertThat statements isn't worth it. */
    public void addLastTestBasic() {
        Deque61B<String> lld1 = new LinkedListDeque61B<>();

        lld1.addLast("front"); // after this call we expect: ["front"]
        lld1.addLast("middle"); // after this call we expect: ["front", "middle"]
        lld1.addLast("back"); // after this call we expect: ["front", "middle", "back"]
        assertThat(lld1.toList()).containsExactly("front", "middle", "back").inOrder();
    }

    @Test
    /** This test performs interspersed addFirst and addLast calls. */
    public void addFirstAndAddLastTest() {
        Deque61B<Integer> lld1 = new LinkedListDeque61B<>();

         /* I've decided to add in comments the state after each call for the convenience of the
            person reading this test. Some programmers might consider this excessively verbose. */
        lld1.addLast(0);   // [0]
        lld1.addLast(1);   // [0, 1]
        lld1.addFirst(-1); // [-1, 0, 1]
        lld1.addLast(2);   // [-1, 0, 1, 2]
        lld1.addFirst(-2); // [-2, -1, 0, 1, 2]

        assertThat(lld1.toList()).containsExactly(-2, -1, 0, 1, 2).inOrder();
    }

    @Test
    /*This test aim to test weather empty deque return true while calling @code isEmpty*/
    public void testIsEmptyPositive() {
        Deque61B<Integer> deque = new LinkedListDeque61B<>();
        assertThat(deque.isEmpty()).isTrue();
    }

    @Test
    public void testIsEmptyNegative() {
        Deque61B<Integer> deque = new LinkedListDeque61B<>();
        deque.addFirst(1);
        assertThat(deque.isEmpty()).isFalse();
    }

    @Test
    public void testSizePositive() {
        Deque61B<Integer> deque = new LinkedListDeque61B<>();
        deque.addFirst(1);
        deque.addLast(1);
        int actual = deque.size();
        assertThat(actual).isEqualTo(2);
    }

    @Test
    public void testSizeNegative() {
        Deque61B<Integer> deque = new LinkedListDeque61B<>();
        int actual = deque.size();
        assertThat(actual).isEqualTo(0);
    }

    //get method
    @Test
    public void testGetOutOfBound() {
        Deque61B<Integer> deque = new LinkedListDeque61B<>();
        deque.addFirst(1);      //[1]
        deque.addFirst(2);      //[2, 1]
        deque.addFirst(3);      //[3, 2, 1]
        deque.addFirst(4);      //[4, 3, 2, 1]

        assertThat(deque.get(5)).isEqualTo(null);
    }

    @Test
    public void testGet(){
        Deque61B<Integer> deque = new LinkedListDeque61B<>();
        deque.addLast(1);      //[1]
        deque.addLast(2);      //[1, 2]
        deque.addLast(3);      //[1, 2, 3]
        deque.addLast(4);      //[1, 2, 3, 4]

        assertThat(deque.get(2)).isEqualTo(3);
        assertThat(deque.get(1)).isEqualTo(2);
    }

    @Test
    public void testGetEdge(){
        Deque61B<Integer> deque = new LinkedListDeque61B<>();
        deque.addLast(1);      //[1]
        deque.addLast(2);      //[1, 2]
        deque.addLast(3);      //[1, 2, 3]
        deque.addLast(4);      //[1, 2, 3, 4]

        assertThat(deque.get(0)).isEqualTo(1);
        assertThat(deque.get(3)).isEqualTo(4);
    }

    // Get recursive boundary
    @Test
    public void testGetRecursiveOutOfBound() {
        Deque61B<Integer> deque = new LinkedListDeque61B<>();
        deque.addLast(1);      //[1]
        deque.addLast(2);      //[1, 2]
        deque.addLast(3);      //[1, 2, 3]
        deque.addLast(4);      //[1, 2, 3, 4]

        assertThat(deque.getRecursive(5)).isEqualTo(null);
    }

    @Test
    public void testGetRecursive(){
        Deque61B<Integer> deque = new LinkedListDeque61B<>();
        deque.addLast(1);      //[1]
        deque.addLast(2);      //[1, 2]
        deque.addLast(3);      //[1, 2, 3]
        deque.addLast(4);      //[1, 2, 3, 4]

        assertThat(deque.getRecursive(2)).isEqualTo(3);
        assertThat(deque.getRecursive(1)).isEqualTo(2);
    }

    @Test
    public void testGetRecursiveEdge(){
        Deque61B<Integer> deque = new LinkedListDeque61B<>();
        deque.addLast(1);      //[1]
        deque.addLast(2);      //[1, 2]
        deque.addLast(3);      //[1, 2, 3]
        deque.addLast(4);      //[1, 2, 3, 4]

        assertThat(deque.getRecursive(0)).isEqualTo(1);
        assertThat(deque.getRecursive(3)).isEqualTo(4);
    }

    @Test
    public void testRemoveFirst(){
        Deque61B<Integer> deque = new LinkedListDeque61B<>();
        deque.addLast(1);      //[1]
        deque.addLast(2);      //[1, 2]
        deque.addLast(3);      //[1, 2, 3]
        deque.addLast(4);      //[1, 2, 3, 4]

        deque.removeFirst();
        deque.removeFirst();
        List<Integer> actual = deque.toList();
        assertThat(actual).containsExactly(3, 4);
    }

    @Test
    public void testRemoveFirstEdge(){
        Deque61B<Integer> deque = new LinkedListDeque61B<>();
        deque.addLast(1);      //[1]
        deque.removeFirst();
        List<Integer> actual = deque.toList();
        assertThat(actual).containsExactly();
    }

    @Test
    public void testRemoveFirstAndSize(){
        Deque61B<Integer> deque = new LinkedListDeque61B<>();
        deque.addLast(1);      //[1]
        deque.removeFirst();
        int actual = deque.size();
        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void testRemoveFirstReturn(){
        Deque61B<Integer> deque = new LinkedListDeque61B<>();
        deque.addLast(1);      //[1]
        int actual = deque.removeFirst();
        assertThat(actual).isEqualTo(1);
    }

    @Test
    public void testRemoveLast(){
        Deque61B<Integer> deque = new LinkedListDeque61B<>();
        deque.addLast(1);      //[1]
        deque.addLast(2);      //[1, 2]
        deque.addLast(3);      //[1, 2, 3]
        deque.addLast(4);      //[1, 2, 3, 4]

        deque.removeLast();
        deque.removeLast();
        List<Integer> actual = deque.toList();
        assertThat(actual).containsExactly(1, 2);
    }

    /*TEST REMOVELAST*/
    @Test
    public void testRemoveLastEdge(){
        Deque61B<Integer> deque = new LinkedListDeque61B<>();
        deque.addLast(1);      //[1]
        deque.removeLast();
        List<Integer> actual = deque.toList();
        assertThat(actual).containsExactly();
    }

    @Test
    public void testRemoveLastAndSize(){
        Deque61B<Integer> deque = new LinkedListDeque61B<>();
        deque.addLast(1);      //[1]
        deque.removeFirst();
        int actual = deque.size();
        assertThat(actual).isEqualTo(0);
    }

    @Test
    public void testRemoveLastReturn(){
        Deque61B<Integer> deque = new LinkedListDeque61B<>();
        deque.addLast(1);      //[1]
        int actual = deque.removeFirst();
        assertThat(actual).isEqualTo(1);
    }
}