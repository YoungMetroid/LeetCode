package org.problems;

import java.util.HashMap;
import java.util.HashSet;

public class LongestSubString {
    public static void main(String ...args){

        LongestSubString longestSubString = new LongestSubString();
        longestSubString.lengthOfLongestSubString2("abcabcbbsdfsadfwqeryutiop1234asdf0987654321zxcv");
        longestSubString.lengthOfLongestSubString("abcabcbbsdfsadfwqeryutiop1234asdf0987654321zxcv");
    }

    public int lengthOfLongestSubString(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int currentLength = 0;
        int longestLength =0;

        for(int i = 0; i < s.length(); i++){

            if(!map.containsKey(s.charAt(i)))
            {
                map.put(s.charAt(i), i);
                currentLength++;
            }
            else{
                i = map.get(s.charAt(i));
                map.clear();
                if(currentLength > longestLength){
                    longestLength = currentLength;
                }
                currentLength = 0;
            }

        }
        System.out.println(longestLength);
        return longestLength;
    }

    public int lengthOfLongestSubString2(String s){
        HashSet<Character> map = new HashSet<>();
        String longestString = "";
        String tempString = "";
        for(int count = 0; count < s.length(); count++)
        {
            /*
            if(!map.contains(s.charAt(count)))
            {
                map.add(s.charAt(count));
                tempString = tempString.concat(Character.toString(s.charAt(count)));
                //copyS = copyS.substring(1);
            }
            else

             */
            {

                int index = tempString.indexOf(Character.toString(s.charAt(count)));
                tempString = tempString.substring(index+1);
                tempString = tempString.concat(Character.toString(s.charAt(count)));
            }
            if(tempString.length() > longestString.length())
            {
                longestString = tempString;
            }


        }
        System.out.println(longestString);
        return longestString.length();
    }



}
