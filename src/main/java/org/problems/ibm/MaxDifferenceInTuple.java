package org.problems.ibm;

import java.util.List;

public class MaxDifferenceInTuple {

    public static void main(String ...args) {

        MaxDifferenceInTuple maxDifferenceInTuple = new MaxDifferenceInTuple();


        int validTuples = maxDifferenceInTuple.countTripletWithinDifference( List.of(1,4,20,27,65,79,82,83,99,100),50);
        int validTuples2 = maxDifferenceInTuple.countTripletWithinDifference( List.of(2,1,3,4),3);
        System.out.println(validTuples);
        System.out.println(validTuples2);
    }

    public int countTripletWithinDifference(List<Integer> arr, int d){

        int count = 0;
        List<Integer> sortedArr = arr.stream().sorted().toList();

        for(int i = 0; i < sortedArr.size(); i++){
            int c = 1;
            for(int j = i +2; j < sortedArr.size();j++){

                    if (sortedArr.get(j) - sortedArr.get(i) <= d) {
                        System.out.println("[" + sortedArr.get(i) +","
                                + sortedArr.get(j-1) +","
                        +sortedArr.get(j) +"]");
                        count = count+c;
                        c++;
                    }

            }
        }
        return count;
    }
}
