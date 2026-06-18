package org.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2 {

    public CombinationSum2(){}
    List<List<Integer>> allCombos = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);

        backtrack(candidates,target,0,new ArrayList<Integer>(),0);
        return allCombos;
    }

    public void backtrack(int[] candidates, int target, int index, List<Integer> combo,int sum){
        for(int i = index; i < candidates.length; i++){
            if(i > index && candidates[i] == candidates[i-1]) continue;
            if(sum + candidates[i] == target){
                combo.add(candidates[i]);
                allCombos.add(new ArrayList<>(combo));
                return;
            }

            else if(sum + candidates[i] < target){
                combo.add(candidates[i]);
                backtrack(candidates,target, i+1,new ArrayList<>(combo),sum + candidates[i]);
                combo.removeLast();
            }
            else return;
        }
    }
}
