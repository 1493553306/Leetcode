import java.util.Scanner;
//不会,太复杂了
public class WildcardMatching {
    public boolean isMatch(String s, String p) {
        int x = s.length(), y = p.length();
        boolean flag = true;
        boolean[][] result = new boolean[x][y];
        if(x == 0 && y == 0) return true;
        if(x!= 0 && y==0) return false;
        if(x==0 && y!=0){
            for(int j = 0; j < y; j++)
                if(p.charAt(j) != '*') flag = false;
            if(flag == true) return true;
            else return false;
        }
        if(p.charAt(0) == '*' || p.charAt(0) == '?' || p.charAt(0) == s.charAt(0) ) result[0][0] = true;
        else return false;
        for(int i = 1; i < x; i++){
            if(p.charAt(0) == '*') result[i][0] = true;
            else result[i][0] = false;
        }

        for(int j = 1; j < y; j++){
            if(p.charAt(j) == '*') result[0][j] = result[0][j-1];
            else if(p.charAt(j) == '?' && flag == true && p.charAt(0) == '*') {
                result[0][j] = true;
                flag = false;
            }
            else {
                result[0][j] = false;
                flag =false;
            }
        }

        for(int i = 1; i < x; i++){
            for(int j = 1; j < y; j++){
                if(p.charAt(j) == '?'|| s.charAt(i) == p.charAt(j)) result[i][j] =result[i-1][j-1];
                else if(p.charAt(j) == '*') result[i][j] = (result[i][j-1]||result[i-1][j]);
                else result[i][j] = false;

            }
        }
        return result[x-1][y-1];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next();
        String p = sc.next();
        WildcardMatching sl = new WildcardMatching();
        sl.isMatch(s,p);
    }
}
