package org.problems;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis {

    public GenerateParenthesis(){
        List<String> validParenthesis = new ArrayList<>();
        recursion(validParenthesis,"",0,0,4);
        validParenthesis.forEach(System.out::println);
    }

    public void recursion(List<String> list, String s,int left, int right, int n){

        if(s.length() == n*2){
            list.add(s);
            return;
        }
        if(left < n){
            recursion(list,s.concat("("),left+1,right,n);
        }
        if(right < left){
            recursion(list,s.concat(")"),left,right+1,n);
        }
    }
}
