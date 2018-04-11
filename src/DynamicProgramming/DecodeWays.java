package DynamicProgramming;

import java.util.Scanner;

public class DecodeWays {
    //这道题倒着看思路就会清晰，如果i是0，则00，01...都不行，所以result[i] =0；如果<27, 则可以看成2，6或者26，因此是result[i+1]+result[i+2]；
    //如果>=27,则只能看成2，7,因此是result[i+1]；
    public int numDecodings(String s) {
        if(s.length() == 0 || s.charAt(0) =='0') return 0;
        int len = s.length();
        int[] result = new int[len+1];
        result[len] = 1; result[len-1] = s.charAt(len-1) == '0' ? 0:1;
        for(int i = len-2; i >= 0; i--){
            if(s.charAt(i) == '0') result[i] = 0;
            else {
                if(Integer.parseInt(s.substring(i, i+2)) <27 )
                    result[i] = result[i+1]+result[i+2];
                else
                    result[i] = result[i+1];
            }
        }
        return result[0];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        DecodeWays sl = new DecodeWays();
        sl.numDecodings(s);

    }
}
