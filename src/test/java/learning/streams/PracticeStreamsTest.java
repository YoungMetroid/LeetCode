package learning.streams;

import org.apache.commons.csv.CSVRecord;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.learning.streams.Country;
import org.learning.streams.PracticeStreams;
import org.problems.CSVReader;
import org.problems.DataSetAnalysis;
import org.problems.dto.Car;
import org.problems.dto.Penguin;
import org.problems.dto.Product;

import java.util.*;
import java.util.stream.Collectors;

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
    @Test void groupPengionsBySexInBiscoe(){
        Map<String,List<Penguin>> penguinGroups = practiceStreams.groupPenguinsBySexInBiscoe();
        List<Penguin> femalePenguinList = penguinGroups.get("FEMALE");
        List<Penguin> malePenguinList = penguinGroups.get("MALE");
        femalePenguinList.forEach(System.out::println);
        System.out.println();
        malePenguinList.forEach(System.out::println);

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
    @Test void getFirstProductThatMatchesId() {
        Optional<Product> product = practiceStreams.findFirstProduct(5);
    }

    @Test void test(){
        String[] cnt = {"", "","","","",""};
        cnt[0] = "m";
        cnt[1]= "mexico";
        cnt[2] ="canda";
        cnt[3] = "morroco";
        cnt[4] = "brazil";
        String letter = cnt[0];


        List<String> countries = new ArrayList<>();
        for(int i = 1; i < cnt.length; i++){
            String c = cnt[i];
            System.out.println(c.length());
            for(int j =0; j< c.length(); j++){
                if(letter.charAt(0) == cnt[i].charAt(j)){
                    countries.add(cnt[i]);
                    break;
                }
            }
        }
        for(String s:countries){
            System.out.println(s);
        }

    }

    @Test void filterByLetter() throws Exception {

        class OtherNullException extends Exception{
            public OtherNullException(String error){
                super(error);
            }
        }
        List<String> countries = new ArrayList<>(Arrays.asList(
                null
                ,"morroco"
                ,"canada"
                ,"brazil"
                ,"germany"

        ));
        try {
            countries = countries.stream().filter(
                    x -> x.contains("m")
            ).collect(Collectors.toList());
            countries.forEach(System.out::println);
        }
        catch (Exception ex){
            throw new OtherNullException("test");
        }
    }
    @Test
    void ArraysTest(){
        List<String> strList = Arrays.asList("1","2");
        List<String> mutableList = new ArrayList<>(Arrays.asList("1","2"));


    }
    @Test
    void moreTest(){
        List<Country> countries = List.of(
                new Country("USA", 3000L,"NA")
                ,new Country("Mexico", 1500L,"NA")
                ,new Country("Canada", 600L,"NA")
                ,new Country("Guatemala", 600L,"NA")
                ,new Country("Salvador", 600L,"NA")
                ,new Country("Argentina", 700L,"SA")
                ,new Country("Brazil", 2000L,"SA")
        );
        String s= countries.stream()
                .sorted(
                        Comparator.comparing(Country::getPopulation,Comparator.reverseOrder())
                                    .thenComparing(x -> x.getName(),Comparator.reverseOrder())
                )
                .map(x -> x.getName())
                .collect(Collectors.joining("," , "{" , "}"));
        System.out.println(s);
    }
}
