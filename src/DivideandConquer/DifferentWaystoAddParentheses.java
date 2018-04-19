package DivideandConquer;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class DifferentWaystoAddParentheses {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> result = new LinkedList<Integer>(), left = new LinkedList<Integer>(), right = new LinkedList<Integer>();
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '+' || input.charAt(i) == '-' || input.charAt(i) == '*'){
                left = diffWaysToCompute(input.substring(0, i));
                right = diffWaysToCompute(input.substring(i+1, input.length()));
                for(int m = 0; m < left.size(); m++){
                    for(int n = 0; n < right.size(); n++){
                        if(input.charAt(i) == '+')
                            result.add(left.get(m)+right.get(n));
                        if(input.charAt(i) == '-')
                            result.add(left.get(m)-right.get(n));
                        if(input.charAt(i) == '*')
                            result.add(left.get(m)*right.get(n));
                    }
                }
            }
        }
        if(result.isEmpty()) result.add(Integer.parseInt(input));
        return result;
    }

    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        DifferentWaystoAddParentheses sl = new DifferentWaystoAddParentheses();
        sl.diffWaysToCompute(input);
    }

}
