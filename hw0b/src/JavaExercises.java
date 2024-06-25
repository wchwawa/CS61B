import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class JavaExercises {

    /** Returns an array [1, 2, 3, 4, 5, 6] */
    public static int[] makeDice() {
    int [] a = {1, 2, 3, 4, 5, 6};
    return a;
    }

    /** Returns the order depending on the customer.
     *  If the customer is Ergun, return ["beyti", "pizza", "hamburger", "tea"].
     *  If the customer is Erik, return ["sushi", "pasta", "avocado", "coffee"].
     *  In any other case, return an empty String[] of size 3. */
    public static String[] takeOrder(String customer) {
        // TODO: Fill in this function.
        if (customer.equals("Ergun")) {
            return new String[] {"beyti", "pizza", "hamburger", "tea"};
        } else if (customer.equals("Erik")) {
            return new String[]{"sushi", "pasta", "avocado", "coffee"};
        }else{
            return new String[3];
        }
    }

    /** Returns the positive difference between the maximum element and minimum element of the given array.
     *  Assumes array is nonempty. */
    public static int findMinMax(int[] array) {
        // TODO: Fill in this function.
        if (array.length == 1) {
            return 0;
        }
        int min = array[1];
        int max = 0;
        int positiveDifference;
        for (int i = 0; i < array.length; i++) {
            if (min > array[i]) {
                max = array[i];
            }
            if (min < array[i]) {
                min = array[i];
            }
        }
        positiveDifference = Math.abs(max - min);
        return positiveDifference;
    }

    /**
      * Uses recursion to compute the hailstone sequence as a list of integers starting from an input number n.
      * Hailstone sequence is described as:
     *    - Pick a positive integer n as the start
      *        - If n is even, divide n by 2
      *        - If n is odd, multiply n by 3 and add 1
      *    - Continue this process until n is 1
      */
    public static List<Integer> hailstone(int n) {
        if (n <= 0) {
            System.out.println("Ple");
            return null;
        }
        return hailstoneHelper(n, new ArrayList<>());
    }

    private static List<Integer> hailstoneHelper(int x, List<Integer> list) {
        // TODO: Fill in this function.
        list.add(x);
        if (x == 1){
            return list;
        }
        if (x % 2 == 0) {
            return hailstoneHelper(x / 2, list);
        }
        if (x % 2 != 0) {
            return hailstoneHelper(x * 3 + 1, list);
        }
        return Collections.singletonList(1);
    }

    public static void main(String[] args) {
        int [] a = makeDice();
        for (int i : a){
            System.out.print(i);
        }
        List<Integer> b = hailstone(3);
        System.out.println(b);

    }
}
