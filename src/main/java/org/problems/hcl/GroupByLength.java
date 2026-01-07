package org.problems.hcl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupByLength {

    List<String> words;
    public GroupByLength(List<String> words){
        this.words = words;
    }

    public List<List<String>> groupWordsByCollect(){

        Map<Integer,List<String>> grouped = words.stream().collect(Collectors.groupingBy(String::length));
        return new ArrayList<>(grouped.values());
    }
    public List<String> addStringToList(String s){

        List<String> l = words.stream().map(x->x+s).toList();
        return l;
    }

}
