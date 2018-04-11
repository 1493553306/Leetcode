package DynamicProgramming;

import java.util.Scanner;

//每次斜对角看，如果len=5,则观察的顺序为：00，11，22，33，44；01，12，23，34；02，13，24；03，14；04。
public class LongestPalindromicSubstring {
    public String longestPalindrome(String s) {
        int maxlen = 0, start=0, end=0, k =1, len = s.length();
        int[][] mark = new int[len][len];
        String result;
        for(int i = 0; i < len; i++)
            mark[i][i] = 1;
        while (k < len){
            for(int i = 0; i < len-k; i++) {
                if (s.charAt(i) == s.charAt(i + k) && (k==1 || mark[i + 1][i+k - 1] == 1)) {
                    mark[i][i+k] = 1;
                    if (k > maxlen) {
                        start = i;
                        end = i+k;
                        maxlen = k;
                    }
                }
            }
            k++;
        }
        result = s.substring(start,end+1);
        return result;

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        LongestPalindromicSubstring sl = new LongestPalindromicSubstring();
        sl.longestPalindrome(s);
    }
}
