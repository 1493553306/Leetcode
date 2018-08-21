package DynamicProgramming;
/*
Given a string, your task is to count how many palindromic substrings in this string.

        The substrings with different start indexes or end indexes are counted as different substrings even they consist
        of same characters.

        Example 1:
        Input: "abc"
        Output: 3
        Explanation: Three palindromic strings: "a", "b", "c".
        Example 2:
        Input: "aaa"
        Output: 6
        Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
*/

import java.util.Scanner;

public class PalindromicSubstrings {
    /*static int count = 0;
    public static int countSubstrings(String s) {
        for (int i = 0; i < s.length(); i++) {
            validate(s, i, i);
            validate(s, i, i+1);
        }
        return count;
    }
    public static void validate(String s, int left, int right){
        while (left >= 0 && right < s.length() && s.charAt(left--) == s.charAt(right++))
            count++;
    }*/
   /* DP*/
    public static int countSubstrings(String s) {
        int len = s.length();
        int count = 0;
        boolean[][] flag = new boolean[len][len];
        for (int step = 0; step < len; step++){
            for(int i = 0; i+step < len; i++){
                if(step == 0) flag[i][i+step] = true;
                else if(step == 1) flag[i][i+step] = (s.charAt(i)==s.charAt(i+step));
                else flag[i][i+step] = (s.charAt(i)==s.charAt(i+step) && flag[i+1][i+step-1]);
                if(flag[i][i+step] == true) count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        int result = countSubstrings(s);
        System.out.println(result);
    }
}
