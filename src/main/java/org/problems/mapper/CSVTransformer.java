package org.problems.mapper;
import org.problems.dto.Car;

import java.util.ArrayList;
import java.util.List;

public class CSVTransformer {

    public <T> List<T> transform(Iterable<Car> records, CsvMapper<T> mapper){

        List<T> result = new ArrayList<>();
        for(Car record:records){
            result.add(mapper.map(record));
        }
        return result;
    }
}
