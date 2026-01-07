package org.problems;

public class JumpGame {

    public JumpGame(){
        boolean jump = canJump(new int[]{2,3,1,1,4});
        System.out.println(jump);
    }

    public boolean canJump(int[] nums){
        if(nums.length < 2) return true;

        //Hops to reach end
        int j = 1;
        for(int i = nums.length-2; i >=0; i--){
            if(nums[i] >= j) {
                j=1;
                continue;
            }
            j++;
        }
        return nums[0] >= j;
    }
}
