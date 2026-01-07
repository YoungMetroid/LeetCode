package org.problems;

import org.apache.commons.csv.*;
import java.io.Reader;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CSVReader {

    private final URL urlPath;
    private Iterable<CSVRecord> records;
    public CSVReader(String csvFilePath){
        urlPath =  getClass().getClassLoader().getResource(csvFilePath);
    }

    public void loadFile(){
        try{
            Reader reader = Files.newBufferedReader(Paths.get(urlPath.toURI()));
            CSVFormat csvFormat = CSVFormat.DEFAULT.builder()
                    .setHeader()
                    .setSkipHeaderRecord(true)
                    .build();
            records = csvFormat.parse(reader);
        }
        catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
    public Iterable<CSVRecord> getRecords(){
        return records;
    }
}
