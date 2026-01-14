package org.learning.streams;

import org.apache.commons.csv.CSVRecord;
import org.problems.CSVReader;
import org.problems.dto.Penguin;
import org.problems.dto.Product;
import org.problems.dto.User;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;


public class PracticeStreams {
    Product product1 = new Product(1,"Product1", true);
    Product product2 = new Product(2,"Product2", true);
    Product product3 = new Product(3,"Product3", true);
    Product product4 = new Product(4,"Product4", true);
    Product product5 = new Product(5,"Product5", true);
    Product product6 = new Product(6,"Product6", true);

    List<User> users = List.of(
            new User(1,new ArrayList<>(List.of(product2,product4)))
            ,new User(2,new ArrayList<>(List.of(product4,product1,product6)))
            ,new User(3,new ArrayList<>(List.of(product2,product4,product6)))
            ,new User(4,new ArrayList<>(List.of(product1,product2,product5,product6)))
            ,new User(5,new ArrayList<>(List.of(product2,product3,product5)))
            ,new User(6,new ArrayList<>(List.of(product2)))
    );

    List<Penguin> penguinList;
    public PracticeStreams(){
    }

    public List<Product> getListofAllProducts(){
        return users.stream().flatMap(x->x.products().stream()).collect(Collectors.toList());
    }
    public List<Integer> getListProductIds(){
        return users.stream().flatMap(x->x.products().stream().map(Product::id)).collect(Collectors.toList());
    }
    public List<Integer> filterByEvenNumbersMutable(List<Integer> list){

        return list.stream().filter(x-> x%2 ==0).collect(Collectors.toList());
    }
    public List<Integer> filterByEvenNumbersNotMutable(List<Integer> list){
        return list.stream().filter(x-> x%2 ==0).toList();
    }

    public void loadPenguinDataSet(){
        CSVReader csvReader = new CSVReader("penguins_size.csv");
        csvReader.loadFile();
        Iterable<CSVRecord> records = csvReader.getRecords();
        penguinList = new ArrayList<>();
        records.forEach(x->penguinList.add(new Penguin(
                x.get(0)
                ,x.get(1)
                ,Float.parseFloat(x.get(2))
                ,Float.parseFloat(x.get(3))
                ,Float.parseFloat(x.get(4))
                ,Integer.parseInt(x.get(5))
                ,x.get(6))));
    }
    public List<String> getAllPenguinSpeciesByGrouping(){
        List<String> penguinSpecies = penguinList.stream()
                .map(Penguin::species)
                .collect(Collectors.groupingBy(String::valueOf))
                .keySet().stream().toList();
        return penguinSpecies;
    }

    public List<String> getAllPenguinSpeciesByMapping() {
        List<String> penguinSpeices = penguinList.stream()
                .map(x -> x.species() + x.island())
                .distinct()
                .toList();
        return penguinSpeices;
    }
    public int getAllFemailPenguinsFromBiscoeCount(){
        return (int)penguinList.stream()
                .filter(x -> Objects.equals(x.island(), "Biscoe") && Objects.equals(x.sex(), "FEMALE"))
                .count();
    }
    public Map<String,Long> getPenguinCountBySexInBiscoe(){
        Map<String,Long> penguinCountBySexInBiscoe = penguinList.stream()
                .filter(x-> Objects.equals(x.island(), "Biscoe"))
                .collect(Collectors.groupingBy(Penguin::sex,Collectors.counting()));

        return penguinCountBySexInBiscoe;
    }
}
