package Backtracing;

import java.util.*;
/*Given a set of distinct integers, nums, return all possible subsets (the power set).

        Note: The solution set must not contain duplicate subsets.

        Example:

        Input: nums = [1,2,3]
        Output:
        [
        [3],
        [1],
        [2],
        [1,2,3],
        [1,3],
        [2,3],
        [1,2],
        []
        ]*/
public class Subsets {
    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        //start保证不是全遍历
        bchelper(result,new LinkedList<>(), nums, nums.length,0);
        result.add(new LinkedList<>());
        return result;
    }
    public static void bchelper(List<List<Integer>> result, List<Integer> mem, int[] num, int level, int start){
        if (level > 0){
            for(int i = start; i < num.length; i++){
                mem.add(num[i]);
                result.add(new LinkedList<>(mem));
                bchelper(result, mem, num,level-1, i+1);
                mem.remove(mem.size()-1);
            }
        }

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String tmp = sc.nextLine();
        String[] str = tmp.split(",");
        int[] nums = new int[str.length];
        for(int i = 0; i < str.length; i++)
            nums[i] = Integer.parseInt(str[i]);
        subsets(nums);
    }
}
