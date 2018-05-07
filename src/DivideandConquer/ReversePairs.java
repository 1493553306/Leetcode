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
        dchelp(nums, 0, nums.length-1);
        return count;
    }
    public void dchelp(int[] nums, int start, int end){
        if(start == end) return;
        int mid = (end - start)/2;
        dchelp(nums, start, start + mid);
        dchelp(nums, start+mid+1, end);
        int x = start, y = start+mid+1, tmp;
       while (x <= start+mid && y <= end){
           if(nums[x] <= 2L*nums[y] )
               x++;
           else {
               count += start+mid - x + 1;
               y++;
           }
       }
        Arrays.sort(nums, start, end+1);
        return ;
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
