package org.problems.mapper;
import org.problems.dto.Car;

public interface CsvMapper <T>{
    T map(Car record);

}
