package Base;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Main {

/** 请完成下面这个函数，实现题目要求的功能 **/
    /** 当然，你也可以不按照这个模板来作答，完全按照自己的想法来 ^-^  **/
    static int sticker(int[] score) {
        if(score.length == 1)
            return 1;
        int inc = 1, dec = 1;
        int result = 0;
        for(int i = 0; i < score.length-1; i++){
            if(score[i+1] >= score[i] && inc != 0){
                dec = 0;
                inc++;
            }
            else if(score[i] <= score[i+1] && dec != 0){
                dec++;
                inc = 0;
            }
            else if( inc != 0){
                result += (1+inc)*inc/2;
            }
            else if(dec != 0)
                result += (1+dec)*dec/2;


        }
    return result;

    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String str = null;
        if (in.hasNextLine()) {
            str = in.nextLine();
        }
        String[] s = str.split(",");
        int[] score = new int[s.length];
        for (int i = 0; i < s.length; i++) {
            score[i] = Integer.parseInt(s[i]);
        }
        System.out.println(sticker(score));
    }
}
