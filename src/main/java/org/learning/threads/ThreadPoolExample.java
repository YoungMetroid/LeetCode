package org.learning.threads;

import org.apache.commons.csv.CSVRecord;
import org.problems.CSVReader;
import org.problems.dto.Car;
import org.problems.dto.CarDTO;
import org.problems.dto.DataCenterHybridDTO;
import org.problems.mapper.CSVTransformer;
import org.problems.mapper.CarMapper;
import org.problems.mapper.CsvMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExample {
    List<DataCenterHybridDTO> datacenterList = new ArrayList<>();
    public static void main(String[] args){

        ThreadPoolExample threadPoolExample = new ThreadPoolExample();
        threadPoolExample.virtualThreadPool();
        threadPoolExample.fixedThreadPool();

        /*
        ExecutorService executor = Executors.newFixedThreadPool(4);
        for(int i = 0; i< 10; i++){
            int taskId = i;
            executor.submit(()->{
                System.out.println("Task " + taskId + "running in " + Thread.currentThread().getName());
            });
        }
        executor.shutdown();

         */
    }
    ThreadPoolExample(){
        long start = System.currentTimeMillis();
        CSVReader csvReader = new CSVReader("data_center_hybrid.csv");
        csvReader.loadFile();
        Iterable<CSVRecord> records = csvReader.getRecords();
        records.forEach(x->datacenterList.add(DataCenterHybridDTO.getDataCenter(x)));
        long end = System.currentTimeMillis();
        System.out.printf("Execution Time: %d ms \n", end-start);
    }



    public void virtualThreadPool(){

        long start = System.currentTimeMillis();
        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();

        int carDTOListSize = datacenterList.size();
        int oneFourth = carDTOListSize/4;

        List<CompletableFuture<Void>> tasks = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            int j = i;
            CompletableFuture<Void> task= CompletableFuture.runAsync(()-> {
                if(j == 3) {
                    addTax( j * oneFourth, carDTOListSize);
                }
                else{
                    addTax( j * oneFourth, (j + 1) * oneFourth);
                }
            },executor);
            tasks.add(task);
        }
        tasks.forEach(CompletableFuture::join);

        System.out.println(datacenterList.getFirst().getOtherInfo());
        System.out.println(datacenterList.get(oneFourth).getOtherInfo());
        System.out.println(datacenterList.get(oneFourth*2).getOtherInfo());
        System.out.println(datacenterList.get(oneFourth*3).getOtherInfo());
        System.out.println(datacenterList.getLast().getOtherInfo());

        long end = System.currentTimeMillis();
        System.out.printf("Execution Time: %d ms \n", end-start);

    }
    public void addTax(int start, int end){
        System.out.printf("Thread: %s Start: %d End: %d \n", Thread.currentThread(),start,end);

        for(int i = start; i < end; i++){
            datacenterList.get(i).setOtherInfo("Processed by thread: " + Thread.currentThread());
        }
    }
    public void fixedThreadPool(){

        long start = System.currentTimeMillis();
        ExecutorService executor = Executors.newFixedThreadPool(4);

        int datacenterListSize = datacenterList.size();
        int oneFourth = datacenterListSize/4;

        List<CompletableFuture<Void>> tasks = new ArrayList<>();
        for(int i = 0; i < 4; i++) {
            int j = i;
            CompletableFuture<Void> task= CompletableFuture.runAsync(()-> {
                if(j == 3) {
                    addTax( j * oneFourth, datacenterListSize);
                }
                else{
                    addTax( j * oneFourth, (j + 1) * oneFourth);
                }
            },executor);
            tasks.add(task);
        }
        tasks.forEach(CompletableFuture::join);

        System.out.println(datacenterList.getFirst().getOtherInfo());
        System.out.println(datacenterList.get(oneFourth).getOtherInfo());
        System.out.println(datacenterList.get(oneFourth*2).getOtherInfo());
        System.out.println(datacenterList.get(oneFourth*3).getOtherInfo());
        System.out.println(datacenterList.getLast().getOtherInfo());

        long end = System.currentTimeMillis();
        System.out.printf("Execution Time: %d ms \n", end-start);

    }
}
