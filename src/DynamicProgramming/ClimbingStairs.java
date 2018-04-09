package DynamicProgramming;

import java.util.Scanner;

public class ClimbingStairs {
    //recursion: Time Limit Exceeded
 /*   public int climbStairs(int n) {
        int result;
        if(n == 0) return 0;
        else if(n == 1) return 1;
        else if(n == 2) return 2;
        else
            result = climbStairs(n-1)+climbStairs(n-2);
        return result;

    }*/
    public int climbStairs(int n) {
        if(n == 0) return 0;
        else if(n == 1) return 1;
        else if(n == 2) return 2;
        else {
            int[] result = new int[n+1];
            result[0] = 0; result[1] = 1; result[2] = 2;
            for(int i = 3; i < n+1; i++)
                result[i] = result[i-1] + result[i-2];
            return result[n];
        }

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        ClimbingStairs sl = new ClimbingStairs();
        sl.climbStairs(n);
    }
}
