package Backtracing;

import java.util.*;
//40 problem
//Combination Sum II
//Given a collection of candidate numbers (C) and a target number (T), find all unique combinations
//in C where the candidate numbers sums to T.
//Each number in C may only be used once in the combination.
//
//Note:
//All numbers (including target) will be positive integers.
//The solution set must not contain duplicate combinations.
//For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
//A solution set is:
//[
//  [1, 7],
//  [1, 2, 5],
//  [2, 6],
//  [1, 1, 6]
//]
public class CombinationSumII {
    public static List<List<Integer>> combinationSum2(int[] candidates, int target) {

        List<List<Integer>> result = new LinkedList<>();
        List<Integer> mem = new LinkedList<>();
        Arrays.sort(candidates);
        bchelper(result, mem,candidates,target,0);
        return result;
    }
    public static void bchelper( List<List<Integer>> result,List<Integer>mem, int[] candicates, int target, int start){
        if(target < 0)
            return;
        else if(target == 0)
            result.add(new LinkedList<>(mem));
        else {
            for (int i = start; i < candicates.length; i++) {
                //避免重复元素
                if(i > start && candicates[i] == candicates[i-1]) continue;
                mem.add(candicates[i]);
                //每个元素只用一次
                bchelper(result, mem, candicates, target - candicates[i], i+1);
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
        combinationSum2(candidates, target);
    }
}

