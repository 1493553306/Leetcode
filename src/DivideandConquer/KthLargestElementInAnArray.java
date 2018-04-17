package DivideandConquer;
import java.util.Arrays;
import java.util.Scanner;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length-k];

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
