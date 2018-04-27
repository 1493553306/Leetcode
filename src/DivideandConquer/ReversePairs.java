package DivideandConquer;

import java.util.Arrays;
import java.util.Scanner;

/*
Given an array nums, we call (i, j) an important reverse pair if i < j and nums[i] > 2*nums[j].
You need to return the number of important reverse pairs in the given array.

Example1:

Input: [1,3,2,3,1]
Output: 2
Example2:

Input: [2,4,3,5,1]
Output: 3
*/
public class ReversePairs {
    int count = 0;
    public int reversePairs(int[] nums) {
        if(nums.length <=1) return 0;
        int[] result = dchelp(nums);
        return count;
    }
    public int[] dchelp(int[] nums){
        int[] result = new int[nums.length];
        if(nums.length == 1) return nums;
        int mid = nums.length/2;
        int[] left = dchelp(Arrays.copyOfRange(nums, 0, mid));
        int[] right = dchelp(Arrays.copyOfRange(nums, mid, nums.length));
        int x = 0, y = 0, tmp = 0;
        for(int i = 0; i < nums.length; i++){
            if(x < left.length && y < right.length){
                if(left[x] < right[y]){
                    result[i] = left[x];
                    x++;
                }
                else {
                    tmp = x;
                    while (tmp < left.length){
                        if(left[tmp] > 2L*right[y]){
                            count += (left.length-tmp);
                            break;
                        }
                        else
                            tmp++;
                    }
                    result[i] = right[y];
                    y++;
                }
            }
            else if(x >= left.length) {
                result[i] = right[y];
                y++;
            }
            else {
                result[i] = left[x];
                x++;
            }
        }
        return result;

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for(int i = 0; i < len; i++)
            nums[i] = sc.nextInt();
        ReversePairs sl = new ReversePairs();
        sl.reversePairs(nums);
    }
}
