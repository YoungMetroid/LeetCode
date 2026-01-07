package org.problems.concurrency;

import java.util.Arrays;
import java.util.Random;

public class ParallelSegmentSort {
    private int numbThreads = 4;
    private int[] array;
    private int segmentSize;

    Thread[] threads = new Thread[numbThreads];
    public ParallelSegmentSort(int arraySize){
        array = new int[arraySize];
        segmentSize = array.length /numbThreads;
        Random rand = new Random();
        for(int i = 0; i < arraySize; i++){
            array[i] = rand.nextInt(10000);
        }
        try {
            sortArray();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }



    public void sortArray() throws InterruptedException {

        for(int i = 0; i < numbThreads; i++){
            int start = i * segmentSize;
            int end = (i == numbThreads -1) ? array.length :  start + segmentSize;
            threads[i] = new Thread(() -> Arrays.sort(array, start,end));
            threads[i].start();
        }

        for(Thread t : threads) t.join();

        int i = 0;
        int j = segmentSize;
        int k = segmentSize*2;
        int l = segmentSize*3;
        int m = 0;
        int []array2 = new int[array.length];
        while(m < array.length){

            int first = i == segmentSize ? (j == segmentSize*2 ? 10001 : array[j]) :  j == segmentSize*2 ? array[i] : Math.min(array[i], array[j]);
            int second = k == segmentSize*3 ? (l == array.length ? 10001 :  array[l]) : l == array.length ? array[k] : Math.min(array[k], array[l]);
            array2[m] = Math.min(first,second);

            if(array2[m] == array[i] && i < segmentSize){
                i++;
            }
            else if(array2[m] == array[j] && j < segmentSize*2){
                j++;
            }
            else if(array2[m] == array[k] && k < segmentSize*3){
                k++;
            }
            else if(array2[m] == array[l] && l < array.length){
                l++;
            }
            m++;
        }
        Arrays.stream(array2).forEach(System.out::println);
    }


}
