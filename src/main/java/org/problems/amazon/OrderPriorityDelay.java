package org.problems.amazon;

import java.util.*;

public class OrderPriorityDelay {
    public OrderPriorityDelay(){
    }
    public List<Integer> getPriorities(List<Integer> priorities){
        //n*n solution for a recap
        List<Integer> l = new ArrayList<>();

        for(int i = 0; i < priorities.size(); i++){
            l.add(0);
        }
        for(int i = priorities.size()-2; i >=0; i--){
            for(int j = priorities.size()-1; j > i; j--){
                if(priorities.get(i) > priorities.get(j)){
                    l.set(i,j-i);
                    break;
                }
            }
        }
        return l;
    }

    public List<Integer> getPrioritesWithUnBalancedTree(List<Integer> priorities){
        List<Integer> l = new ArrayList<>();

        for(int i = 0; i < priorities.size(); i++){
            l.add(0);
        }
        UnbalancedTree unbalancedTree = new UnbalancedTree();
        for(int i = priorities.size()-1; i >= 0; i--){
            int value = unbalancedTree.processedFirst(priorities.get(i),i);
            l.set(i,value);
        }
        return l;
    }

}
