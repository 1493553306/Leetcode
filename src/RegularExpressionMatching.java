import java.util.Scanner;

public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        if(p.length() == 0) return s.length() == 0;
        boolean first_match = (!s.isEmpty() && (s.charAt(0) == p.charAt(0) || p.charAt(0)=='.') );
        if(p.length()>= 2 && p.charAt(1) == '*')
            return (isMatch(s, p.substring(2)) || (first_match &&isMatch(s.substring(1), p)));
        else
            return (first_match && isMatch(s.substring(1), p.substring(1)));
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String f = sc.next();
        String s = sc.next();
        RegularExpressionMatching sl = new RegularExpressionMatching();
        boolean result = sl.isMatch(f,s);
        System.out.print(result);
    }
}
