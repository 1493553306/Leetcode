package DynamicProgramming;

import java.util.Scanner;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int result = nums[0],tmp = 0;
        for(int i = 0; i < nums.length; i++){
            tmp = tmp + nums[i];
            result = Math.max(tmp, result);
            tmp = Math.max(0, tmp);
        }
    return result;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++)
            nums[i] = sc.nextInt();
        MaximumSubarray sl = new MaximumSubarray();
        sl.maxSubArray(nums);
    }
}
