package org.problems;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthesis2 {
    private List<String> combinations = new ArrayList<>();
    public List<String> generateParenthesis(int n) {

        generateParenthesis("",n,0,0);
        return combinations;
    }

    private void generateParenthesis(String str, int n, int openP, int closedP){

        if(openP + closedP == n*2){
            combinations.add(str);
        }
        if(openP < n){
            str = str.concat("(");
            generateParenthesis(str,n,openP+1,closedP);
            str = str.substring(0,str.length()-1);
        }
        if(closedP < n && openP > closedP){
            str = str.concat(")");
            generateParenthesis(str, n,openP, closedP+1);
        }
    }

    public static void main(String []args){
        GenerateParenthesis2 generateParenthesis2 = new GenerateParenthesis2();

        List<String> para = generateParenthesis2.generateParenthesis(16);
        para.forEach(System.out::println);
    }
}
