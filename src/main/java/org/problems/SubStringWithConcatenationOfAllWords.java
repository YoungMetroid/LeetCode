package org.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class SubStringWithConcatenationOfAllWords {

    public SubStringWithConcatenationOfAllWords(){
        List<Integer> list = findSubString("aaaaaaaaaaaaaaaaaaa",
                new String[]{"a","a","a","a"});
                        list.forEach(System.out::println);
    }
    public List<Integer> findSubString(String s, String[]words){
        HashMap<String,Integer> condition = new HashMap<>();
        List<Integer> indexes = new ArrayList<>();
        for(String word:words){
            int value = condition.getOrDefault(word,0);
            value++;
            condition.put(word,value);
        }
        condition.forEach((key,value)-> System.out.println(key + ":"+value));
        for(int i =0; i < s.length();i++){
            if(checkSequence(i,words[0].length(),words[0].length()*words.length,s,condition)){
                indexes.add(i);

                if(words[0].length() ==1) {
                    int j = checkLimits(i, words[0].length(), words[0].length() * words.length, s, indexes);
                    i = Math.max(j, i);
                }
            }
        }
        return indexes.stream().distinct().toList();
    }

    public boolean checkSequence(int i,int wordSize,int characterTotal, String s, HashMap<String,Integer> condition){
        HashMap<String,Integer> copyCondition = new HashMap<>(condition);

        if(i <= s.length()-characterTotal){
            while(!copyCondition.isEmpty()){
                int value = copyCondition.getOrDefault(s.substring(i,i+wordSize),0);
                if(value > 0){
                    if(value == 1){
                        copyCondition.remove(s.substring(i,i+wordSize));
                    }
                    else{
                        copyCondition.put(s.substring(i,i+wordSize),--value);
                    }
                    i = i+wordSize;
                }
                else return false;
            }
            return true;
        }
        return false;
    }
    public int checkLimits(int i, int wordSize, int characterTotal, String s, List<Integer>indexes){
        if(i <= s.length()-characterTotal && i+characterTotal < s.length()) {
            if (s.substring(i, i + wordSize).equals(s.substring(i + characterTotal, i + characterTotal + wordSize))) {
                if(i == 4999){
                    System.out.println(i);
                }
                indexes.add(i+wordSize);
                return checkLimits(i+wordSize,wordSize,characterTotal,s,indexes);
            }
        }
        return i - wordSize;
    }
}
