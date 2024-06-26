import edu.princeton.cs.algs4.In;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ListExercises {

    /** Returns the total sum in a list of integers */
	public static int sum(List<Integer> L) {
        // TODO: Fill in this function.
        if (L.isEmpty()){
            return 0;
        }
        int sum = 0;
        for (int i : L){
            sum = sum + i;
        }
        return sum;
    }

    /** Returns a list containing the even numbers of the given list */
    public static List<Integer> evens(List<Integer> L) {
        // TODO: Fill in this function.
        List<Integer> newEvensList = new ArrayList<>();
        for (int i : L){
            if(i%2==0){
                newEvensList.add(i);
            }
        }
        return newEvensList;
    }

    /** Returns a list containing the common item of the two given lists */
    public static List<Integer> common(List<Integer> L1, List<Integer> L2) {
        // TODO: Fill in this function.
        List<Integer> newList = new ArrayList<>();
        for(int i = 0; i < L1.size();i++){
            int L1Element = L1.get(i);
            for (int j : L2){
                if (L1Element == j){
                    newList.add(L1Element);
                }
            }
        }
        return newList;
    }


    /** Returns the number of occurrences of the given character in a list of strings. */
    public static int countOccurrencesOfC(List<String> words, char c) {
        // TODO: Fill in this function.
        int count = 0;
        for (int i = 0; i < words.size(); i++) {
            String word = words.get(i);
            for (int j = 0; j < word.length(); j++) {
                if (word.charAt(j) == c){
                    count ++;
                    break;
                }
            }
        }
        return count;
    }

    public static void main(String [] args){


    }
}
