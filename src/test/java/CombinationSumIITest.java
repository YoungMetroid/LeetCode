import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.problems.CombinationSum2;

import java.util.List;

public class CombinationSumIITest {


    static CombinationSum2 combinationSum2;
    @BeforeAll
    static void setup(){
        combinationSum2 = new CombinationSum2();
    }

    @Test
    void test1(){
        List<List<Integer>> combinations = combinationSum2.combinationSum2(new int[]{2,5,2,1,2}, 5);
        combinations.forEach(System.out::println);
    }
    @Test
    void test2(){
        List<List<Integer>> combinations = combinationSum2.combinationSum2(new int[]{10,1,2,7,6,1,5}, 8);
        combinations.forEach(System.out::println);
    }
}
