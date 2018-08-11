package Backtracing;

import java.util.*;
/*Given a collection of numbers that might contain duplicates, return all possible unique permutations.

        Example:

        Input: [1,1,2]
        Output:
        [
        [1,1,2],
        [1,2,1],
        [2,1,1]
        ]*/
public class PermutationsII {
    public static List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new LinkedList<>();
        Arrays.sort(nums);
        boolean[] use = new boolean[nums.length];
        Arrays.fill(use, false);
        bchelper(result, new LinkedList<>(), nums, use, nums.length);
        return result;
    }
    public static void bchelper(List<List<Integer>>result, List<Integer> mem, int[] nums, boolean[] use, int level){
        if(level == 0)
            result.add(new LinkedList<>(mem));
        else {
            for(int i = 0; i < nums.length; i++){
                if(use[i] == true || i-1>=0 && nums[i] == nums[i-1] && use[i - 1]== false) continue;
                use[i] = true;
                mem.add(nums[i]);
                bchelper(result, mem, nums, use, level-1);
                use[i] = false;
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
        permuteUnique(nums);
    }

}
