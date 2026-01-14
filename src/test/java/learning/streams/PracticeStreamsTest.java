package learning.streams;

import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.learning.streams.PracticeStreams;
import org.problems.CSVReader;
import org.problems.DataSetAnalysis;
import org.problems.dto.Car;
import org.problems.dto.Penguin;
import org.problems.dto.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

public class PracticeStreamsTest {

    static List<Integer> testList1;
    static PracticeStreams practiceStreams;
    @BeforeAll
    static void setup(){
        practiceStreams = new PracticeStreams();
        practiceStreams.loadPenguinDataSet();
        testList1 = List.of(100,3,6,7,1,2,0,3,5,7,6,9,1,12,14,16,20);
    }

    @Test
    void filterByEvenAndAddElement(){
        List<Integer> list = practiceStreams.filterByEvenNumbersMutable(testList1);
        list.add(4);
        list.forEach(x-> System.out.print(x + " "));
        System.out.println();
        assertEquals(List.of(100,6,2,0,6,12,14,16,20,4), list);
    }
    @Test
    void filterByEvenAndBreakWhenElementAdded(){
        List<Integer> list = practiceStreams.filterByEvenNumbersNotMutable(testList1);

        assertEquals(List.of(100,6,2,0,6,12,14,16,20), list);
        assertThrows(UnsupportedOperationException.class,()->{
            list.add(4);
        });
        list.forEach(x-> System.out.print(x + " "));
        System.out.println();
    }
    @Test
    void getPenguinSpeciesByGrouping(){
        List<String> penguinSpecieList = practiceStreams.getAllPenguinSpeciesByGrouping();
        penguinSpecieList.stream().map(x-> x+" ").forEach(System.out::print);
        System.out.println();
        assertTrue(!penguinSpecieList.isEmpty());
    }
    @Test
    void getPenguinSpeciesByMapping(){
        List<String> penguinSpecieList = practiceStreams.getAllPenguinSpeciesByMapping();
        penguinSpecieList.stream().map(x-> x+" ").forEach(System.out::print);
        System.out.println();
        assertTrue(!penguinSpecieList.isEmpty());
    }
    @Test
    void getPenguinCountForFemalesInBiscoe(){
        int femailPenguinPopulationInBiscoe = practiceStreams.getAllFemailPenguinsFromBiscoeCount();
        System.out.println(femailPenguinPopulationInBiscoe);
        assertTrue(femailPenguinPopulationInBiscoe ==81);
    }
    @Test void getPenguinCountBySexInBiscoe(){
        Map<String,Long> penguinCountBySexInBiscoe = practiceStreams.getPenguinCountBySexInBiscoe();
        System.out.println(penguinCountBySexInBiscoe);
        assertEquals(81, (long) penguinCountBySexInBiscoe.get("FEMALE"));
        assertTrue(penguinCountBySexInBiscoe.get("MALE") > 0);
    }
    @Test void getAllProductsFromAllUsers(){
        List<Product> productList = practiceStreams.getListofAllProducts();
        System.out.println(productList);
        assertFalse(productList.isEmpty());
    }
    @Test void getAllIdsFromProducts(){
        List<Integer> productIds = practiceStreams.getListProductIds();
        System.out.println(productIds);
        assertFalse(productIds.isEmpty());
    }
}
