package DivideandConquer;

import java.util.Arrays;
import java.util.Scanner;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        int[] result = sort(nums);
        return result[nums.length-k];
    }
    public int[] sort(int[] array){
        int[] result = new int[array.length];
        if(array.length == 1)
            return array;
        int mid = array.length/2;
        int[] leftsort = sort(Arrays.copyOfRange(array,0, mid));
        int[] rightsort = sort(Arrays.copyOfRange(array, mid, array.length));
        int x = 0, y=0;
        for(int i = 0; i < array.length; i++){
            if(x < leftsort.length && y < rightsort.length){
                if (leftsort[x] < rightsort[y]) {
                    result[i] = leftsort[x];
                    x++;
                }
                else {
                    result[i] = rightsort[y];
                    y++;
                }
            }
            else if(x >= leftsort.length){
                result[i] = rightsort[y];
                y++;
            }
            else {
                result[i] = leftsort[x];
                x++;
            }
        }
        return result;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt(), k = sc.nextInt();
        int[] nums = new int[len];
        for(int i = 0; i < len; i++)
            nums[i] = sc.nextInt();
        KthLargestElementInAnArray sl = new KthLargestElementInAnArray();
        sl.findKthLargest(nums, k);
    }
}
