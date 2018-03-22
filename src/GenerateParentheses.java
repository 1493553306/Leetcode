import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GenerateParentheses {

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        backtrack (result, "", 0, 0, n);
        return result;
    }
    public void backtrack(List<String> result, String cur, int left, int right, int max){
        if(cur.length() == max*2){
            result.add(cur);
            return;
        }
        if(left < max)
            backtrack(result, cur+"(", left+1, right, max);
        if(right < left)
            backtrack(result, cur+")", left, right+1, max);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        GenerateParentheses sl = new GenerateParentheses();
        List<String> result = sl.generateParenthesis(n);
        System.out.print(result);
    }
}
