package org.problems.amazon;

import java.util.*;

public class Priorities {
    public Priorities(){
        getPriorities(List.of(8,2,5,3)).forEach(System.out::println);


        List<Integer> randomList = new ArrayList<>(10000);
        Random random = new Random();

        for (int i = 0; i < 1000000; i++) {
            randomList.add(random.nextInt(101)); // 0 to 100 inclusive
        }
        long startTime = System.nanoTime();
        List<Integer> bigList = getPriorities(randomList);
        long endTime = System.nanoTime();
        long durationInNanoseconds = endTime - startTime;
        double durationInMilliseconds = durationInNanoseconds / 1_000_000.0;
        System.out.println("Execution time: " + durationInMilliseconds + " ms");
        System.out.println(bigList.size());

        //Arrays.stream(monotonicIncreasing(List.of(100,3,6,15,7,1,2,0,3,5,7,6,9,0,12,14,16,20))).forEach(System.out::println);
    }
    public static List<Integer> getPriorities(List<Integer> priorities){
        //n*n solution for a recap
        List<Integer> l = new ArrayList<>();

        for(int i = 0; i < priorities.size(); i++){
            l.add(0);
        }
        for(int i = priorities.size()-2; i >=0; i--){
            for(int j = priorities.size()-1; j > i; j--){
                if(priorities.get(i) > priorities.get(j)){
                    l.set(i,j-i);
                    break;
                }
            }
        }
        return l;
    }

    public static int[] monotonicIncreasing(List<Integer> nums) {
        Deque<Integer> stack = new ArrayDeque<>();
        List<Integer> reversed = new ArrayList<>(nums);
        Collections.reverse(reversed);

        // Traverse the array
        for (int num : reversed) {
            // While stack is not empty AND top of stack is more than the current element
            while (!stack.isEmpty() && stack.peekLast() > num) {
                // Pop the top element from the stack
                stack.pollLast();
            }
            // Push the current element into the stack
            stack.offerLast(num);
        }

        // Construct the result array from the stack
        int[] result = new int[stack.size()];
        int index = stack.size() - 1;
        while (!stack.isEmpty()) {
            result[index--] = stack.pollLast();
        }

        return result;
    }

}
