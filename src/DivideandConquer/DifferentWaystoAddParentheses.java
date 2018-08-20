package DivideandConquer;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DifferentWaystoAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        return dchelper(input, 0, input.length());
    }
    public static List<Integer> dchelper(String input, int start, int end){
        List<Integer> result = new LinkedList<Integer>();
        for(int i = start; i < end; i++){
            if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*'){
                List<Integer> left = dchelper(input, start, i);
                List<Integer> right = dchelper(input,i+1, end);
                for(int m = 0; m < left.size(); m++){
                    for(int n = 0; n < right.size(); n++){
                        if(input.charAt(i) == '+')
                            result.add(left.get(m)+right.get(n));
                        else if(input.charAt(i) == '-')
                            result.add(left.get(m)-right.get(n));
                        else
                            result.add(left.get(m)*right.get(n));
                    }
                }
            }
        }
        if(result.isEmpty()) result.add(Integer.parseInt(input.substring(start, end)));
        return result;
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        DifferentWaystoAddParentheses sl = new DifferentWaystoAddParentheses();
        sl.diffWaysToCompute(input);
    }

}
