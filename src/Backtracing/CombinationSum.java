package Backtracing;

import java.util.*;
//39 problem
//Combination Sum
//Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.
//
//The same repeated number may be chosen from C unlimited number of times.
//
//Note:
//All numbers (including target) will be positive integers.
//The solution set must not contain duplicate combinations.
//For example, given candidate set [2, 3, 6, 7] and target 7,
//[
//  [7],
//  [2, 2, 3]
//]
public class CombinationSum {
    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new LinkedList<>();
        List<Integer> mem = new LinkedList<>();
        bchelper(result, mem,candidates,target,0);
        return result;
    }
    public static void bchelper( List<List<Integer>> result,List<Integer>mem, int[] candicates, int target, int start){
        if(target < 0)
            return;
        else if(target == 0)
            result.add(new LinkedList<>(mem));
        else {
            //can myexist the same number
            for (int i = start; i < candicates.length; i++) {
                mem.add(candicates[i]);
                bchelper(result, mem, candicates, target - candicates[i], i);
                mem.remove(mem.size()-1);
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] candidates = new int[len];
        for(int i = 0; i < len; i++)
            candidates[i] = sc.nextInt();
        int target = sc.nextInt();
        combinationSum(candidates, target);
    }
}
