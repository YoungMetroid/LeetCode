package amazon;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.problems.amazon.OrderPriorityDelay;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class OrderPriorityDelayTest {

    static List<Integer> testList1;
    static List<Integer> testList2;
    static List<Integer> testList3;
    static List<Integer> testList4;
    static List<Integer> testList5;
    static List<Integer> testList6;
    static List<Integer> oneMillion = new ArrayList<>(10000);
    static List<Integer> tenMillion = new ArrayList<>(10_000_000);
    static List<Integer> oneHundredMillion = new ArrayList<>(100_000_000);
    static Random random = new Random();
    long startTime ;
    @BeforeAll
    static void setup(){
        testList1 = List.of(100,3,6,7,1,2,0,3,5,7,6,9,1,12,14,16,20);
        testList2 = List.of(8,2,5,3);
        //                  3,0,1,0
        testList3 = List.of(0,0,0,0,0,0,0,0,0,0,0,0,0);
        testList4 = List.of(9,8,7,6,5,4,3,2,1);
        testList5 = List.of(6,10,9,7);
        testList6 = List.of(2,0,4,8,3,10,7,15,16,5);
        for (int i = 0; i < 1_000_000; i++) {
            oneMillion.add(random.nextInt(101)); // 0 to 100 inclusive
        }
        for (int i = 0; i < 10_000_000; i++) {
            tenMillion.add(random.nextInt(1001)); // 0 to 1000 inclusive
        }
        for (int i = 0; i < 100_000_000; i++) {
            oneHundredMillion.add(random.nextInt(10001)); // 0 to 10000 inclusive
        }

    }
    @BeforeEach
    void initializeTime(){
        startTime = System.nanoTime();
    }
    void calculateTime(){
        long endTime = System.nanoTime();
        long durationInNanoseconds = endTime - startTime;
        double durationInMilliseconds = durationInNanoseconds / 1_000_000.0;
        System.out.println("Execution time: " + durationInMilliseconds + " ms");
    }

    @Test
    void test1WithUnBalancedTree(){
        List<Integer> l = OrderPriorityDelay.getPrioritesWithUnBalancedTree(testList1);
        calculateTime();
        l.stream().map(x -> x.toString() + " ").forEach(System.out::print);
        assertEquals(List.of(16,11,10,9,2,7,0,5,4,3,2,1,0,0,0,0,0),l);
    }
    @Test
    void test1WithBruteForce(){
        List<Integer> l = OrderPriorityDelay.getPriorities(testList1);
        calculateTime();
        l.stream().map(x -> x.toString() + " ").forEach(System.out::print);
        assertEquals(List.of(16,11,10,9,2,7,0,5,4,3,2,1,0,0,0,0,0),l);
    }
    @Test
    void test2WithUnBalancedTree(){
        List<Integer> l = OrderPriorityDelay.getPrioritesWithUnBalancedTree(testList2);
        calculateTime();
        l.stream().map(x -> x.toString() + " ").forEach(System.out::print);
        assertEquals(l,List.of(3,0,1,0));
    }
    @Test
    void test2WithBruteForce(){
        List<Integer> l = OrderPriorityDelay.getPriorities(testList2);
        calculateTime();
        l.stream().map(x -> x.toString() + " ").forEach(System.out::print);
        assertEquals(l,List.of(3,0,1,0));
    }
    @Test
    void test3WithUnBalancedTree(){
        List<Integer> l = OrderPriorityDelay.getPrioritesWithUnBalancedTree(testList3);
        calculateTime();
        l.stream().map(x -> x.toString() + " ").forEach(System.out::print);
        assertEquals(l,List.of(0,0,0,0,0,0,0,0,0,0,0,0,0));

    }
    @Test
    void test3WithBruteForce(){
        List<Integer> l = OrderPriorityDelay.getPriorities(testList3);
        calculateTime();
        l.stream().map(x -> x.toString() + " ").forEach(System.out::print);
        assertEquals(l,List.of(0,0,0,0,0,0,0,0,0,0,0,0,0));

    }
    @Test
    void test4WithUnBalancedTree(){
        List<Integer> l = OrderPriorityDelay.getPrioritesWithUnBalancedTree(testList4);
        calculateTime();
        l.stream().map(x -> x.toString() + " ").forEach(System.out::print);
        assertEquals(l,List.of(8,7,6,5,4,3,2,1,0));

    }
    @Test
    void test4WithBruteForce(){
        List<Integer> l = OrderPriorityDelay.getPriorities(testList4);
        calculateTime();
        l.stream().map(x -> x.toString() + " ").forEach(System.out::print);
        assertEquals(l,List.of(8,7,6,5,4,3,2,1,0));

    }
    @Test
    void test5WithUnBalancedTree(){
        List<Integer> l = OrderPriorityDelay.getPrioritesWithUnBalancedTree(testList5);
        calculateTime();
        l.stream().map(x -> x.toString() + " ").forEach(System.out::print);
        assertEquals(l,List.of(0,2,1,0));
    }
    @Test
    void test5WithBruteForce(){
        List<Integer> l = OrderPriorityDelay.getPriorities(testList5);
        calculateTime();
        l.stream().map(x -> x.toString() + " ").forEach(System.out::print);
        assertEquals(l,List.of(0,2,1,0));
    }
    @Test
    void test6WithUnBalancedTree(){
        List<Integer> l = OrderPriorityDelay.getPrioritesWithUnBalancedTree(testList6);
        calculateTime();
        l.stream().map(x -> x.toString() + " ").forEach(System.out::print);
        assertEquals(l,List.of(1,0,2,6,0,4,3,2,1,0));
    }
    @Test
    void test6WithBruteForce(){
        List<Integer> l = OrderPriorityDelay.getPriorities(testList6);
        calculateTime();
        l.stream().map(x -> x.toString() + " ").forEach(System.out::print);
        assertEquals(l,List.of(1,0,2,6,0,4,3,2,1,0));
    }
    @Test
    void test7WithUnBalancedTree1MillionElements(){
        assertTimeout(Duration.ofSeconds(30), () ->{
            List<Integer> l = OrderPriorityDelay.getPrioritesWithUnBalancedTree(oneMillion);
            calculateTime();
        });
    }
    @Test
    void test7WithBruteForceOneMillionElements(){
        assertTimeoutPreemptively(Duration.ofSeconds(30), () ->{
            List<Integer> l = OrderPriorityDelay.getPriorities(oneMillion);
            calculateTime();
        });
    }
    @Test
    void test8WithUnBalancedTree10MillionElements(){
        assertTimeout(Duration.ofSeconds(30), () ->{
            List<Integer> l = OrderPriorityDelay.getPrioritesWithUnBalancedTree(tenMillion);
            calculateTime();
        });
    }
    @Test
    void test9WithUnBalancedTree100MillionElements(){
        assertTimeout(Duration.ofSeconds(30), () ->{
            List<Integer> l = OrderPriorityDelay.getPrioritesWithUnBalancedTree(oneHundredMillion);
            calculateTime();
        });
    }
    @Test
    void test10CompareResults(){
        assertTimeout(Duration.ofSeconds(60), () ->{
            List<Integer> unBalancedTreeAlgorithm = OrderPriorityDelay.getPrioritesWithUnBalancedTree(oneMillion);
            List<Integer> bruteForceAlgorithm = OrderPriorityDelay.getPriorities(oneMillion);
            assertEquals(bruteForceAlgorithm,unBalancedTreeAlgorithm);

        });
    }



}
