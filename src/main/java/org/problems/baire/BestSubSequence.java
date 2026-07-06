package org.problems.baire;

public class BestSubSequence {

    public static void main(String ...args){

        BestSubSequence bestSubSequence = new BestSubSequence();
        int val = bestSubSequence.getBestSubSequence(new int[]{9,5,1,4,9},2);
        int val2 = bestSubSequence.getBestSubSequence(new int[]{10,2,3,1,5,8},6);
        System.out.println(val);
    }

    public int getBestSubSequence(int[] array, int sequenceLength){

        if(sequenceLength > array.length) return 0;
        int minValue = Integer.MAX_VALUE;
        for(int i = 0; i < array.length; i++){
            int sum = 0;
            for(int j = i+1; j < array.length && j-2+sequenceLength < array.length; j++){
                sum = Math.abs(array[j]- array[i]);
                for(int k = j+1, seq = 2; k < array.length && seq < sequenceLength; k++, seq++){
                    sum += Math.abs(array[k]-array[k-1]);
                }
                minValue = Math.min(minValue,sum);
                if(minValue ==0) return 0;
            }
        }
        return minValue;
    }
}
