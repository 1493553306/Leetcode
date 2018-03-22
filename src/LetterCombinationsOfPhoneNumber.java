import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class LetterCombinationsOfPhoneNumber {
    public List<String> merge(List<String>  left, List<String>  right){
        List<String> result = new LinkedList<>();
        for(int i = 0; i < left.size(); i++){
            for(int j = 0; j< right.size(); j++){
                result.add(left.get(i)+right.get(j));
            }
        }
        return result;
    }
    public List<String> sort(String digits, int first, int last){
        if(first == last) {
            String[] map = new String[10];
            map[0] = "";
            map[1] = "";
            map[2] = "abc";
            map[3] = "def";
            map[4] = "ghi";
            map[5] = "jkl";
            map[6] = "mno";
            map[7] = "pqrs";
            map[8] = "tuv";
            map[9] = "wxyz";
            List<String> tmp = new LinkedList<>();
            for(int i = 0; i < map[Integer.valueOf(digits)].length(); i++)
                tmp.add(String.valueOf(map[Integer.valueOf(digits)].charAt(i)));
            return tmp;
        }
        int mid = digits.length()/2;
        List<String> left = sort(digits.substring(0,mid),0, mid-1);
        List<String> right = sort(digits.substring(mid,digits.length()),mid, digits.length()-1);
        List<String> all = merge(left, right);
        return all;
    }

    public List<String> letterCombinations(String digits) {
        if (digits.length() == 0)
            return new LinkedList<>();
        List<String> result = new LinkedList<>();
        result = sort(digits,0, digits.length()-1);
        return result;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String digits = sc.nextLine();
        LetterCombinationsOfPhoneNumber sl = new LetterCombinationsOfPhoneNumber();
        List<String> result = sl.letterCombinations(digits);
    }
}
