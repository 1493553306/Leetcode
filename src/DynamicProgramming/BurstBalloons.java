package DynamicProgramming;
import java.util.Scanner;

 /*   Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by array nums. You are asked to burst all the balloons. If the you burst balloon i you will get nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the burst, the left and right then becomes adjacent.

        Find the maximum coins you can collect by bursting the balloons wisely.

        Note:
        (1) You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
        (2) 0 ≤ n ≤ 500, 0 ≤ nums[i] ≤ 100

        Example:

        Given [3, 1, 5, 8]

        Return 167

        nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
        coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167   */

public class BurstBalloons {
    public int maxCoins(int[] iNums) {
        int len = iNums.length;
        int[] tmp = new int[len+2];
        int[][] result = new int[len+2][len+2];
        for(int i = 1; i < len+1; i++)  tmp[i] = iNums[i-1];
        tmp[0] = tmp[len+1] = 1;
        for (int step = 2; step < len+2; step++){
            for(int left = 0; left < len+2-step; left++){
                int right = left+step;
                for(int target = left+1; target < right; target++)
                    result[left][right] = Math.max(result[left][right], tmp[left]*tmp[target]*tmp[right] + result[left][target] + result[target][right]);
            }
        }
        return result[0][len+1];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for(int i = 0; i < len; i++)
            nums[i] = sc.nextInt();
        BurstBalloons sl = new BurstBalloons();
        sl.maxCoins(nums);
    }
}
