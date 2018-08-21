package DynamicProgramming;
/*
413
A sequence of number is called arithmetic if it consists of at least three elements and if the difference between any
two consecutive elements is the same.

        For example, these are arithmetic sequence:

        1, 3, 5, 7, 9
        7, 7, 7, 7
        3, -1, -5, -9
        The following sequence is not arithmetic.

        1, 1, 2, 5, 7

        A zero-indexed array A consisting of N numbers is given. A slice of that array is any pair of integers (P, Q)
        such that 0 <= P < Q < N.

        A slice (P, Q) of array A is called arithmetic if the sequence:
        A[P], A[p + 1], ..., A[Q - 1], A[Q] is arithmetic. In particular, this means that P + 1 < Q.

        The function should return the number of arithmetic slices in the array A.


        Example:

        A = [1, 2, 3, 4]

        return: 3, for 3 arithmetic slices in A: [1, 2, 3], [2, 3, 4] and [1, 2, 3, 4] itself.
*/

import java.util.Scanner;

public class ArithmeticSlices {
    public static int numberOfArithmeticSlices(int[] A) {
        if(A.length<3)
            return 0;
        int dp=0,j=0,sum=0;
        for(int i=1;i<A.length-1;i++)
        {
            if(A[i-1]-A[i] == A[i]-A[i+1])
            {
                j++;
                dp=dp+j;
            }
            else
            {
                j=0;
                sum=sum+dp;
                dp=0;
            }
        }
        sum=sum+dp;
        return sum;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] tmp = str.split(",");
        int[] A = new int[tmp.length];
        for(int i = 0; i < tmp.length; i++)
            A[i] = Integer.parseInt(tmp[i]);
        numberOfArithmeticSlices(A);
    }
}
