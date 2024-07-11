import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class WCHListExercisesTest {
    @Test
    @Order(1)
    @DisplayName("Test sum sucsess!")
    public void testCommon(){
        List<Integer> L1 = List.of(1, 3, 4, 5);
        List<Integer> L2 = List.of(1, 2, 3, 4);
        List<Integer> expected = List.of(1, 3, 4);

        List<Integer> actual = ListExercises.common(L1, L2);

        assertThat(actual).isEqualTo(expected);
    }

    @Test
    @Order(2)
    @DisplayName("Test countOccurrencesOfC sucsess!")
    public void testcountOccurrencesOfC(){
        List<String> L1 = List.of("apple", "banana", "ape");
        List<String> L2 = List.of("fuck,", "shit", "cunt");
        char testChar = 'a';

        int expected1 = 3;
        int expected2 = 0;

        int actual1 = ListExercises.countOccurrencesOfC(L1, testChar);
        int actual2 = ListExercises.countOccurrencesOfC(L2, testChar);

        assertThat(actual1).isEqualTo(expected1);
        assertThat(actual2).isEqualTo(expected2);

    }
}
