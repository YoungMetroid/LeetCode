package org.problems;

import org.problems.concurrency.ConcurrentProgramming;
import org.problems.concurrency.ParallelSegmentSort;
import org.problems.hcl.GroupByLength;

import java.util.Arrays;
import java.util.List;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {

        GroupByLength groupByLength= new GroupByLength(Arrays.asList("one", "two", "three", "four", "five", "six", "seven"));
        List<List<String>> groups = groupByLength.groupWordsByCollect();
        List<String> l = groupByLength.addStringToList("f");
        EpamCodeInterview epamCodeInterview = new EpamCodeInterview();
        ConcurrentProgramming concurrentProgramming = new ConcurrentProgramming();

        ParallelSegmentSort parallelSegmentSort = new ParallelSegmentSort(1000000);
        DataSetAnalysis dataSetAnalysis = new DataSetAnalysis();
        InsertInterval insertInterval = new InsertInterval();
        MaxSubArray maxSubArray = new MaxSubArray();
        JumpGame jumpGame = new JumpGame();
        N_Queens n_queens = new N_Queens();
        SubStringWithConcatenationOfAllWords sswcoaw = new SubStringWithConcatenationOfAllWords();
        /*
        GenerateParenthesis generateParenthesis= new GenerateParenthesis();
        System.out.println("LeetCode Hello World");

        CombinationSum2 combinationSum2 = new CombinationSum2();
        var t = combinationSum2.combinationSum2(new int[]{3,2,5,10,6,6,1,1,4,5,9},11);

        t.stream()
                .map(innerList -> innerList.stream()
                        .map(String::valueOf)
                        .collect(Collectors.joining(" "))
                )
                .forEach(System.out::println);



    */
    }
}