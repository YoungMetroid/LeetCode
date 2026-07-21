package org.problems;

import java.util.ArrayList;
import java.util.List;

public class ShortestToChar {

    public static void main(String ...args){

        ShortestToChar shortestToChar = new ShortestToChar();
        shortestToChar.shortestToChar("loveleetcode", 'e');

    }
    public int[] shortestToChar(String s, char c) {

        int [] shortest = new int[s.length()];

        List<Integer> charPosition = new ArrayList<>();

        for(int i =0; i < s.length(); i++){
            shortest[i] = Integer.MAX_VALUE;
            if(s.charAt(i) == c){
                shortest[i] = 0;
                charPosition.add(i);
            }

        }

        for(int i =0; i< s.length(); i++){
            for(int j =0; j < charPosition.size(); j++){
                if(s.charAt(i) != c){
                    if(Math.abs(charPosition.get(j)-i) < shortest[i] ){
                        shortest[i] = Math.abs(charPosition.get(j)-i);
                    }
                }
            }
        }

        return shortest;
    }
}
