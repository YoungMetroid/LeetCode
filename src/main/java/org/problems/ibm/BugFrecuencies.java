package org.problems.ibm;

import javax.swing.*;
import java.util.*;
import java.util.stream.Collectors;

public class BugFrecuencies {
    public static void main(String ...args){
        BugFrecuencies bugFrecuencies = new BugFrecuencies();
        List<Integer> bf = bugFrecuencies.sortBugFrecuencies(List.of(8,4,6,5,4,8));
        bf.forEach(System.out::println);
    }


    public List<Integer> sortBugFrecuencies(List<Integer> bugs){

        HashMap<Integer,Integer> map = new HashMap<>();

        Map<Integer, List<Integer>> groups = bugs.stream().collect(Collectors.groupingBy(x->x));

        List<Integer> b =  groups.entrySet().stream()
                .sorted(Comparator.comparingInt((Map.Entry<Integer,List<Integer>> e) -> e.getValue().size())
                .thenComparing(Map.Entry::getKey)
                )
                .flatMap(e -> e.getValue().stream().map(v -> e.getKey()))
                .collect(Collectors.toList());


        return b;

    }
}
