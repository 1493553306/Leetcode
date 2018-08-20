package Backtracing;

import java.util.*;
/*Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).

        Note: The solution set must not contain duplicate subsets.

        Example:

        Input: [1,2,2]
        Output:
        [
        [2],
        [1],
        [1,2,2],
        [2,2],
        [1,2],
        []
        ]*/
public class SubsetsII {
    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        //start保证不是全遍历
        boolean[] used = new boolean[nums.length];
        Arrays.fill(used, false);
        Arrays.sort(nums);
        bchelper(result,new LinkedList<>(), nums, used, nums.length,0);
        result.add(new LinkedList<>());
        return result;
    }
    public static void bchelper(List<List<Integer>> result, List<Integer> mem, int[] nums, boolean[]used, int level, int start) {
        if(level > 0){
            for(int i = start; i < nums.length; i++){
                if(i-1 >=0 && nums[i] == nums[i-1] && used[i-1] == false) continue;
                mem.add(nums[i]);
                result.add(new LinkedList<>(mem));
                used[i] = true;
                bchelper(result, mem, nums, used, level-1, i+1);
                mem.remove(mem.size()-1);
                used[i] = false;

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
        subsetsWithDup(nums);
    }

}
