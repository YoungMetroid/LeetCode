package org.problems.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import org.apache.commons.csv.CSVRecord;

@Data
@AllArgsConstructor
public class DataCenterHybridDTO {

     String year;
     String facilityId;
     String facilityName;
     String ownerCompany;
     String city;
     String country;
     String facilityType;
     float estimatedCapacityMW;
     float pue;
     String coolingSystemType;
     float wueLPerKwh;
     float dailyElectricityUsageMwh;
     float dailyWaterUsageGallons;
     String surroundingWaterStressTier;
     String otherInfo;
    public static DataCenterHybridDTO getDataCenter(CSVRecord record){
        return new DataCenterHybridDTO(
                record.get("Year")
                ,record.get("Facility_ID")
                ,record.get("Facility_Name")
                ,record.get("Owner_Company")
                ,record.get("City")
                ,record.get("Country")
                ,record.get("Facility_Type")
                ,Float.parseFloat(record.get("Estimated_Capacity_MW"))
                ,Float.parseFloat(record.get("PUE"))
                ,record.get("Cooling_System_Type")
                ,Float.parseFloat(record.get("WUE_L_per_kWh"))
                ,Float.parseFloat(record.get("Daily_Electricity_Usage_MWh"))
                ,Float.parseFloat(record.get("Daily_Water_Usage_Gallons"))
                ,record.get("Surrounding_Water_Stress_Tier")
                ,null
        );
    }
}
