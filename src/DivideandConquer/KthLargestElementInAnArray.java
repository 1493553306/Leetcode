package DivideandConquer;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Scanner;

public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        //priority queue
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int val : nums) {
            pq.offer(val);

            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.peek();
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
