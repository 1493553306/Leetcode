package DynamicProgramming;

/*
Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in
their binary representation and return them as an array.

        Example 1:

        Input: 2
        Output: [0,1,1]
        Example 2:

        Input: 5
        Output: [0,1,1,2,1,2]
*/

import java.util.Scanner;

public class CountingBits {
    public static int[] countBits(int num) {
        int[] result = new int[num+1];
        for(int i = 1, twoPow = 1, inc = 1; i < num+1; i++){
            if(twoPow == inc ){
                result[i] = 1;
                inc = 1;
                twoPow = i;
            }
            else {
                result[i] = 1 + result[inc++];
            }
        }
        return result;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        countBits(num);
    }
}
