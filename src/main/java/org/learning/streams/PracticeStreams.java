package org.learning.streams;

import org.apache.commons.csv.CSVRecord;
import org.problems.CSVReader;
import org.problems.dto.Penguin;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static java.util.Arrays.stream;

public class PracticeStreams {

    List<Penguin> penguinList;
    public PracticeStreams(){
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
}
