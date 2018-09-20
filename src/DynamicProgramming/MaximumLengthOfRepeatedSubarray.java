package DynamicProgramming;

import java.util.Scanner;

public class MaximumLengthOfRepeatedSubarray {
    public static int findLength(int[] A, int[] B) {
        int maxlen =0;
        int[][] dp = new int[A.length+1][B.length+1];
        for(int i = A.length-1; i >= 0; i--){
            for(int j = B.length-1; j >= 0; j--){
                int aa = A[i], bb = B[j];
                maxlen = Math.max(maxlen, dp[i][j]= A[i] == B[j] ? 1 + dp[i+1][j+1] : 0);
            }
        }
        System.out.print(maxlen);
        return maxlen;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str1 = sc.nextLine();
        String str2 = sc.nextLine();
        String[] tmp1 = str1.split(",");
        String[] tmp2 = str2.split(",");
        int[] A = new int[tmp1.length];
        int[] B = new int[tmp2.length];
        for (int i = 0; i < tmp1.length; i++)
            A[i] = Integer.parseInt(tmp1[i]);
        for (int i = 0; i < tmp2.length; i++)
            B[i] = Integer.parseInt(tmp2[i]);
        findLength(A,B);

    }
}
