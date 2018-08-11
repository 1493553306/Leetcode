package Backtracing;

import java.util.*;
//216 problem
//Combination Sum III
//Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9
//can be used and each combination should be a unique set of numbers.
//Example 2:
//Input: k = 3, n = 9
//Output:
//[[1,2,6], [1,3,5], [2,3,4]]
public class CombinationSumIII {
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> mem = new LinkedList<>();
        dchelper(result, mem, k, n, 1);
        return result;
    }
    public static void dchelper(List<List<Integer>> result, List<Integer> mem, int k, int target, int start){
        if(k < 0 || target < 0)
            return;
        if(k == 0 && target == 0)
            result.add(new LinkedList<>(mem));
        for(int i = start; i < 10; i++){
            mem.add(i);
            dchelper(result, mem,k-1, target-i, i+1);
            mem.remove(mem.size()-1);
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();
        int target = sc.nextInt();
        combinationSum3(k, target);
    }
}
