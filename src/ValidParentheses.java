import java.util.Scanner;
import java.util.Stack;

public class ValidParentheses {
    public boolean isValid(String s) {
        Stack stack = new Stack();
        stack.push(s.charAt(0));
        int index = 1;
        while (index < s.length()){
            char tmp = s.charAt(index);
            switch (tmp){
                case ')':
                    if(!stack.empty() && stack.peek().equals('('))
                        stack.pop();
                    else stack.push(tmp);
                    break;
                case '}':
                    if(!stack.empty() && stack.peek().equals('{'))
                        stack.pop();
                    else stack.push(tmp);
                    break;
                case ']':
                    if(!stack.empty() && stack.peek().equals('['))
                        stack.pop();
                    else stack.push(tmp);
                    break;
                default:
                    stack.push(tmp);
            }
            index++;
        }
        return stack.empty();
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        ValidParentheses sl = new ValidParentheses();
        boolean result = sl.isValid(s);
        System.out.print(result);

    }
}
