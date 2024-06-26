import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExercises {
    /** Returns a map from every lower case letter to the number corresponding to that letter, where 'a' is
     * 1, 'b' is 2, 'c' is 3, ..., 'z' is 26.
     */
    public static Map<Character, Integer> letterToNum() {
        // TODO: Fill in this function.
        Map<Character, Integer> letterNumMap = new HashMap<>();
        for(int i = 0; i < 26; i++){
            char currentAlphabet = 97;
            int currentNum = i + 1;
            letterNumMap.put(currentAlphabet, currentNum);
        }
        return letterNumMap;
    }

    /** Returns a map from the integers in the list to their squares. For example, if the input list
     *  is [1, 3, 6, 7], the returned map goes from 1 to 1, 3 to 9, 6 to 36, and 7 to 49.
     */
    public static Map<Integer, Integer> squares(List<Integer> nums) {
        // TODO: Fill in this function.
        Map<Integer, Integer> squaresMap = new HashMap<>();
        for (int num : nums){
            int numSqaure = num * num;
            squaresMap.put(num, numSqaure);
           }
        return squaresMap;
    }

    /** Returns a map of the counts of all words that appear in a list of words. */
    public static Map<String, Integer> countWords(List<String> words) {
        // TODO: Fill in this function.
        Map<String, Integer> countWordsMap = new HashMap<>();
        if (countWordsMap.isEmpty()){
            return countWordsMap;
        }
        for (String str1 : words){
            int count = 0;
            for(String str2: words){
                if str1.equals(str2){
                    count ++;
                }
            }
            countWordsMap.put(str1, count);
        }
        return countWordsMap;
    }

    public static void main(String[] args){
        char lettera = 97;
        System.out.println(lettera);

    }
}
