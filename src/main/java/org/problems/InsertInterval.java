package org.problems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InsertInterval {

    public InsertInterval(){
        //int [][] newIntervals = insert(new int[][]{{1,2},{3,5},{6,7},{8,10},{12,16} }, new int[]{4,8});
        //int [][] newIntervals = insert(new int[][]{{1,5} }, new int[]{6,8});
        //int [][] newIntervals = insert(new int[][]{{2,3},{5,7} }, new int[]{0,6});
        int [][] newIntervals = insert(new int[][]{{0,2}, {3,9}}, new int[]{6,8});
        Arrays.stream(newIntervals)
                .map(Arrays::toString)
                .forEach(System.out::println);
    }
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> inter = new ArrayList<>();
        int[] combinedInterval = new int[]{0,0};
        boolean left = false;
        boolean right = false;

        for( int i = 0; i < intervals.length; i++){

            if(!left){
                if((newInterval[1] >= intervals[i][0] &&
                        newInterval[1] <= intervals[i][1]) ||
                        (newInterval[0] >= intervals[i][0] &&
                                newInterval[0] <= intervals[i][1]) ||
                (newInterval[0] < intervals[i][0] && newInterval[1] >  intervals[i][1])
                ){
                    left = true;
                    combinedInterval[0] = Math.min(newInterval[0],intervals[i][0]);
                    combinedInterval[1] = Math.max(newInterval[1],intervals[i][1]);

                    if(i == intervals.length-1){
                        inter.add(combinedInterval);
                    }
                    continue;
                }
                else if(newInterval[1] < intervals[i][0]){
                    left = true;
                    right = true;
                    inter.add(newInterval);
                    inter.add(intervals[i]);
                    continue;
                }
                else if(intervals[i][1] < newInterval[0]){
                    inter.add(intervals[i]);
                    //inter.add(newInterval);
                    continue;
                }
            }
            else if(!right){
                if(newInterval[1] >= intervals[i][0] &&
                        newInterval[1] <= intervals[i][1]){
                    right = true;
                    combinedInterval[1] = Math.max(newInterval[1],intervals[i][1]);
                    inter.add(combinedInterval);
                }
                else if(newInterval[1] < intervals[i][0]){
                    inter.add(combinedInterval);
                    inter.add(intervals[i]);
                    right = true;
                }
                continue;
            }
            inter.add(intervals[i]);
        }
        if(inter.isEmpty()){
            inter.add(combinedInterval);
        }
        int[][] array = inter.toArray(new int[inter.size()][]);
        return array;
    }
}
