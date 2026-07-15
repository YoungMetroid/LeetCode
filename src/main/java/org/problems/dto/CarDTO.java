package org.problems.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CarDTO {
    String companyName;
    String carName;
    String engine;
    String batteryCapacity;
    String horsePower;
    String totalSpeed;
    String performance;
    String carPrice;
    String fuelType;
    String seats;
    String torque;
    String otherInfo;
}
