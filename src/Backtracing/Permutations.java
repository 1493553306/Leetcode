package Backtracing;

import javax.swing.*;
import java.util.*;

/*Given a collection of distinct integers, return all possible permutations.

        Example:

        Input: [1,2,3]
        Output:
        [
        [1,2,3],
        [1,3,2],
        [2,1,3],
        [2,3,1],
        [3,1,2],
        [3,2,1]
        ]*/
public class Permutations {
    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        bchelper(result, new LinkedList<>(), nums, nums.length);
        return result;
    }
    public static void bchelper(List<List<Integer>>result, List<Integer> mem, int[] nums, int level){
        if(level == 0)
            result.add(new LinkedList<>(mem));
        else {
            for(int i = 0; i < nums.length; i++){
                if(!mem.contains(nums[i])){
                    mem.add(nums[i]);
                    bchelper(result, mem, nums, level-1);
                    mem.remove(mem.size()-1);
                }
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
        permute(nums);
    }
}
