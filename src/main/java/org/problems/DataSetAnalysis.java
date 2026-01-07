package org.problems;

import com.sun.source.tree.Tree;
import org.apache.commons.csv.CSVRecord;
import org.problems.dto.Car;

import java.util.*;
import java.util.stream.Collectors;

public class DataSetAnalysis {

    public DataSetAnalysis(){
        readCarDataSet();
    }
    public void readCarDataSet(){
        CSVReader csvReader = new CSVReader("Cars Datasets 2025.csv");
        csvReader.loadFile();
        Iterable< CSVRecord> records = csvReader.getRecords();
        List<Car> carList = new ArrayList<>();
        records.forEach(x->carList.add(Car.getCar(x)));

        carList.stream().limit(10).forEach(System.out::println);
        System.out.println();
        Collections.sort(carList);
        carList.stream().limit(10).forEach(System.out::println);
        System.out.println();

        Comparator<Car> byHorsePowerandCost = Comparator.comparing(Car::horsePower).thenComparing(Car::carPrice);


        carList.stream()
                .limit(20)
                .sorted(Comparator.comparing(Car::horsePower))
                .forEach(System.out::println);
        System.out.println();
        carList.stream()
                .limit(20)
                .sorted(Comparator.comparing(Car::carName).thenComparing(Car::horsePower))
                .forEach(System.out::println);
        System.out.println();

        List<Car> carHorsePowerAndCost = carList.stream()
                .limit(20)
                .sorted(byHorsePowerandCost)
                .collect(Collectors.toList());

        carHorsePowerAndCost.add(carList.getLast());

        carHorsePowerAndCost.forEach(System.out::println);

        System.out.println();
        System.out.println("End");
    }
}
