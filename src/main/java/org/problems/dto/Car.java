package org.problems.dto;

import org.apache.commons.csv.CSVRecord;

public record Car(
        String companyName,
        String carName,
        String engine,
        String batteryCapacity,
        String horsePower,
        String totalSpeed,
        String performance,
        String carPrice,
        String fuelType,
        String seats,
        String torque
) implements Comparable<Car>{
    public static Car getCar(CSVRecord record){
        return new Car(record.get("Company Names")
                ,record.get("Cars Names")
                ,record.get("Engines")
                ,record.get("CC/Battery Capacity")
                ,record.get("HorsePower")
                ,record.get("Total Speed")
                ,record.get("Performance(0 - 100 )KM/H")
                ,record.get("Cars Prices")
                ,record.get("Fuel Types")
                ,record.get("Seats")
                ,record.get("Torque")
        );
    }
    public int compareTo(Car car){
        int lastComparison = this.companyName.compareTo(car.companyName);
        return (lastComparison == 0) ? this.carName.compareTo(car.carName): lastComparison;
    }
}
