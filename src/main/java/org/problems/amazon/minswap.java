package org.problems.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class minswap {
    public static void main(String []args){
        List<Integer> array = new ArrayList<>(Arrays.asList(0, 1, 0, 0, 1, 1, 0, 0));
        for(int i = 0; i < array.size(); i++){
            if(array.get(i) ==1) {
                int currentOnePos = i;
                for (int j = i - 1; j >= 0; j--) {
                    if (array.get(j) == 0) {
                        swap(array, currentOnePos,j);
                        currentOnePos--;
                        System.out.println(array);
                    } else break;
                }
            }
        }
    }
    public static void swap(List<Integer> list, int a, int b){
        int c = list.get(a);
        list.set(a,list.get(b));
        list.set(b,c);

    }

}
