import java.util.Scanner;
import java.util.Stack;

public class LongestValidParentheses {
    public int longestValidParentheses(String s) {
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        int index = 0, maxlen = 0;
        while (index < s.length()){
            if(s.charAt(index) == '(')
                stack.push(index);
            else{
                stack.pop();
                if(stack.empty())
                    stack.push(index);
                else
                    maxlen = Math.max(maxlen, index - stack.peek());
            }
        index++;
        }
        System.out.println(maxlen);
        return maxlen;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        LongestValidParentheses sl = new LongestValidParentheses();
        sl.longestValidParentheses(s);
    }
}
