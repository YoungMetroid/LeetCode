package org.problems.mapper;

import org.problems.dto.Car;
import org.problems.dto.CarDTO;

public class CarMapper implements CsvMapper<CarDTO> {
    @Override
    public CarDTO map(Car record) {
        return new CarDTO(
                record.companyName()
                ,record.carName()
                ,record.engine()
                ,record.batteryCapacity()
                ,record.horsePower()
                ,record.totalSpeed()
                ,record.performance()
                ,record.carPrice()
                ,record.fuelType()
                ,record.seats()
                ,record.torque()
                ,"");
    }
}
