import jh61b.utils.Reflection;
import org.checkerframework.checker.index.qual.PolyUpperBound;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Field;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class ArrayDeque61BTest  {

     @Test
     @DisplayName("ArrayDeque61B has no fields besides backing array and primitives")
     void noNonTrivialFields() {
         List<Field> badFields = Reflection.getFields(ArrayDeque61B.class)
                 .filter(f -> !(f.getType().isPrimitive() || f.getType().equals(Object[].class) || f.isSynthetic()))
                 .toList();

         assertWithMessage("Found fields that are not array or primitives").that(badFields).isEmpty();
     }

     @Test
    public void testAddFirstBasic(){
         Deque61B<Integer> deque = new ArrayDeque61B<>();
         deque.addFirst(1);
         assertThat(deque.toList()).containsExactly(1);
    }

    @Test
    public void testAddLastBasic(){
        Deque61B<Integer> deque = new ArrayDeque61B<>();
        deque.addLast(1);
        assertThat(deque.toList()).containsExactly(1);
    }

    @Test
    public void testAddLastAndFirst(){
        Deque61B<Character> deque = new ArrayDeque61B<>();
        deque.addLast('a');
        deque.addFirst('b');
        deque.addFirst('c');
        deque.addLast('d');
        deque.addFirst('e');
        assertThat(deque.toList()).containsExactly('a', 'd','e','c','b').inOrder();
    }

/* Test GET INDEX */
    @Test
    public void testGet(){
        Deque61B<Character> deque = new ArrayDeque61B<>();
        deque.addLast('a');
        deque.addFirst('b');
        deque.addFirst('c');
        deque.addLast('d');
        deque.addFirst('e');
        char gotItem = deque.get(5);
        assertThat(gotItem).isEqualTo('e');
    }

    @Test
    public void testIsEmptyPositive(){
        Deque61B<Character> deque = new ArrayDeque61B<>();
        assertThat(deque.isEmpty()).isTrue();
    }

    @Test
    public void testIsEmptyNegative(){
        Deque61B<Character> deque = new ArrayDeque61B<>();
        deque.addLast('a');
        assertThat(deque.isEmpty()).isFalse();
    }

    /* TEST SIZE*/
    @Test
    public void testSize(){
        Deque61B<Character> deque = new ArrayDeque61B<>();
        deque.addLast('a');
        assertThat(deque.size()).isEqualTo(1);
        deque.addFirst('c');
        deque.addLast('d');
        deque.addFirst('e');
        assertThat(deque.size()).isEqualTo(4);
    }

    @Test
    public void testEmptySize(){
        Deque61B<Character> deque = new ArrayDeque61B<>();
        assertThat(deque.size()).isEqualTo(0);
    }

    /*test REMOVE*/
    @Test
    public void testRemoveFirst(){
        Deque61B<Character> deque = new ArrayDeque61B<>();
        deque.addLast('a');
        deque.addFirst('b');
        deque.addFirst('c');
        deque.addLast('d');
        deque.addFirst('e');
        deque.removeFirst();
        assertThat(deque.toList()).containsExactly('a', 'd', 'c','b').inOrder();
    }

    @Test
    public void testRemoveLast(){
        Deque61B<Character> deque = new ArrayDeque61B<>();
        deque.addLast('a');
        deque.addFirst('b');
        deque.addFirst('c');
        deque.addLast('d');
        deque.addFirst('e');
        deque.removeLast();
        assertThat(deque.toList()).containsExactly('a', 'e', 'c','b').inOrder();
    }

    /*IMPORTANT: TEST RESIZE UP*/
    @Test
    public void testResizeUp(){
        Deque61B<Character> deque = new ArrayDeque61B<>();
        deque.addLast('a');
        deque.addFirst('b');
        deque.addFirst('c');
        deque.addLast('d');
        deque.addFirst('e');
        deque.addFirst('g');
        deque.addFirst('f');
        deque.addFirst('p');
        deque.addFirst('m');
        deque.addFirst('e');
        deque.addFirst('g');
        deque.addFirst('f');
        deque.addFirst('p');
        deque.addFirst('m');
        deque.addFirst('e');
        deque.addFirst('g');
        deque.addFirst('f');
        deque.addFirst('p');
        deque.addFirst('m');
        assertThat(deque.size()).isEqualTo(19);
    }

    @Test
    public void testResizeDown(){
        Deque61B<Character> deque = new ArrayDeque61B<>();
        deque.addLast('a');
        deque.addFirst('b');
        deque.addFirst('c');
        deque.addLast('d');
        deque.addFirst('e');
        deque.addFirst('g');
        deque.addFirst('f');
        deque.addFirst('p');
        deque.addFirst('m');
        deque.addFirst('e');
        deque.addFirst('g');
        deque.addFirst('f');
        deque.addFirst('p');
        deque.addFirst('m');
        deque.addFirst('e');
        deque.addFirst('g');
        deque.addFirst('f');
        deque.addFirst('p');
        deque.addFirst('m');
        deque.removeFirst();
        deque.removeLast();
        deque.removeFirst();
        deque.removeFirst();
        deque.removeFirst();
        deque.removeFirst();
        deque.removeFirst();
        deque.removeFirst();
        deque.removeFirst();
        deque.removeFirst();
        deque.removeFirst();
        deque.removeFirst();
        deque.removeFirst();
        deque.removeFirst();
        assertThat(deque.size()).isEqualTo(12);
    }


}
