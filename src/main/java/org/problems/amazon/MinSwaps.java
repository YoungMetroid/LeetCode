package org.problems.amazon;

import java.util.List;

public class MinSwaps {

    public static void main(String []args){

        //MinSwaps.minMoves(List.of(1,1,1,1,0,1,0,1));
        //MinSwaps.minMoves(List.of(1,1,1,1,0,0,0,0));

        MinSwaps.minMoves(List.of(1,1,0,1,1,1,1,1));

    }

    public static int minMoves(List<Integer> arr) {

        int zeroL = 0;
        int oneL =0;
        int zeroR = 0;
        int oneR = 0;
        for(int i =0; i < arr.size()/2; i++){

            if(arr.get(i) == 0){
                zeroL++;
            }
            else{
                oneL++;
            }
        }
        for(int i =arr.size()/2; i < arr.size(); i++){
            if(arr.get(i) == 0){
                zeroR++;
            }
            else{
                oneR++;
            }
        }
        int zero = 0;
        int one =0;
        if(zeroL > zeroR){
            zero = zeroL;
        }
        else zero = zeroR;

        if(oneL > oneR){
            one = oneL;
        }
        else one = oneR;

        if(zero > one){
            //move zeros to the greater zero side
            System.out.println("Zeros are greater");
            if(zero == zeroL) return calculateMonves(arr,0, true);
            else return calculateMonves(arr,0, false);
        }
        else {
            System.out.println("Ones are greater");
            if(one == oneL) return calculateMonves(arr,1, true);
            else return calculateMonves(arr,1, false);
        }



    }
    public static int calculateMonves(List<Integer> arr, int num, boolean moveLeft){

        int left=0;
        int right=arr.size()-1;
        int moves=0;

        if(moveLeft){
            while(left < right){
                if(arr.get(right) == num && arr.get(left) != num){
                    moves += Math.abs(left-right);
                    left++;
                    right--;
                }
                while(left < right && arr.get(left) == num){
                    left++;
                }
                while(left < right && arr.get(right) != num){
                    right--;
                }
            }
        }
        else{
            while(left < right){
                if(arr.get(right) != num && arr.get(left) == num){
                    moves += Math.abs(left-right);
                    left++;
                    right--;
                }

                while(left < right && arr.get(left) != num){
                    left++;
                }
                while(left < right && arr.get(right) == num){
                    right--;
                }

            }
        }
        System.out.println(moves);
        return moves;
    }
}
