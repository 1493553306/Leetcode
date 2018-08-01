package Base;

import java.util.Scanner;
//O(nlogn)
public class MergeSort {
    static int[] help;
    public static void mergeSort(int[] nums, int start, int end){
        if(end - start > 1){
            int mid = (start + end + 1)>>1;
            mergeSort(nums, start, mid);
            mergeSort(nums, mid, end);
            //merge
            for(int i = start; i < end; i++)
                help[i] = nums[i];

            int p1 = start, p2 = mid, i = start;
            while (p1 < mid || p2 < end){
                if(p1 >= mid ||(p2 < end && help[p1] > help[p2]))
                    nums[i++] = help[p2++];
                else
                    nums[i++] = help[p1++];
            }
        }

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] tmp = str.split(" ");
        int[] nums = new int[tmp.length];
        for(int i = 0; i < tmp.length; i++)
            nums[i] = Integer.valueOf(tmp[i]);
        help = new int[nums.length];
        mergeSort(nums, 0, nums.length);
        for(int i = 0; i < nums.length; i++)
            System.out.println(nums[i]);

    }
}
