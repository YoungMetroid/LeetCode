package org.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class CombinationSum2 {

    public CombinationSum2(){}

    public List<List<Integer>> combinationSum2(int[] candidates, int target){

        List<List<Integer>> list = new LinkedList<>();
        Arrays.sort(candidates);
        backtrack(list, new ArrayList<>(),candidates,target,0);
        return list;
    }
    private void backtrack(
            List<List<Integer>> answer,
            List<Integer> tempList,
            int[] candidates,
            int totalLeft,
            int index){

        if(totalLeft < 0 ) return;

        if(totalLeft == 0){
            answer.add(new ArrayList<>(tempList));
        }
        else{
            for(int i=index; i < candidates.length && totalLeft>= candidates[i]; i++) {
                if (i > index && candidates[i] == candidates[i - 1]) continue;
                tempList.add(candidates[i]);
                backtrack(answer, tempList, candidates, totalLeft - candidates[i], i + 1);
                tempList.removeLast();
            }
        }
    }
}
