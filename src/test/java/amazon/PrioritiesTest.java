package amazon;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.problems.amazon.Priorities;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrioritiesTest {

    static List<Integer> testList1;
    static List<Integer> testList2;
    static List<Integer> testList3;
    static List<Integer> testList4;
    static List<Integer> testList5;
    static List<Integer> testList6;

    @BeforeAll
    static void setup(){
        testList1 = List.of(100,3,6,7,1,2,0,3,5,7,6,9,1,12,14,16,20);
        testList2 = List.of(8,2,5,3);
        //                  3,0,1,0
        testList3 = List.of(0,0,0,0,0,0,0,0,0,0,0,0,0);
        testList4 = List.of(9,8,7,6,5,4,3,2,1);
        testList5 = List.of(6,10,9,7);
        testList6 = List.of(2,0,4,8,3,10,7,15,16,5);

    }
    @Test
    void test1(){
        List<Integer> l = Priorities.getPriorities(testList1);
        l.stream().map(x -> x.toString() + " ").forEach(System.out::print);
        assertEquals(l,List.of(16,11,10,9,2,7,0,5,4,3,2,1,0,0,0,0,0));
    }
    @Test
    void test2(){
        List<Integer> l = Priorities.getPriorities(testList2);
        l.stream().map(x -> x.toString() + " ").forEach(System.out::print);
        assertEquals(l,List.of(3,0,1,0));
    }
    @Test
    void test3(){
        List<Integer> l = Priorities.getPriorities(testList3);
        l.stream().map(x -> x.toString() + " ").forEach(System.out::print);
        assertEquals(l,List.of(0,0,0,0,0,0,0,0,0,0,0,0,0));

    }
    @Test
    void test4(){
        List<Integer> l = Priorities.getPriorities(testList4);
        l.stream().map(x -> x.toString() + " ").forEach(System.out::print);
        assertEquals(l,List.of(8,7,6,5,4,3,2,1,0));

    }
    @Test
    void test5(){
        List<Integer> l = Priorities.getPriorities(testList5);
        l.stream().map(x -> x.toString() + " ").forEach(System.out::print);
        assertEquals(l,List.of(0,2,1,0));
    }
    @Test
    void test6(){
        List<Integer> l = Priorities.getPriorities(testList6);
        l.stream().map(x -> x.toString() + " ").forEach(System.out::print);
        assertEquals(l,List.of(1,0,2,6,0,4,3,2,1,0));
    }
}
