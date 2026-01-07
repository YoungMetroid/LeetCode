package org.problems;

public class MaxSubArray {

    public MaxSubArray(){
        int max = maxSubArray(new int[]{ -2,1,-3,4,-1,2,1,-5,4});
        System.out.println(max);
    }

    public int maxSubArray(int[] nums) {
        int max = 0;

        for(int i =0; i < nums.length; i++){
            if(nums[i] > 0){
                int currentMax = nums[i];
                int sum = nums[i];
                for(int j = i+1; j < nums.length; j++){
                    if(currentMax + nums[j]> 0){
                        sum = sum +nums[j];
                    }
                    else break;
                    currentMax = sum > currentMax ? sum : currentMax;
                }
                max = currentMax > max ? currentMax : max;
            }
        }
        return max;
    }
}
