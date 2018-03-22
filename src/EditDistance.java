import java.util.Scanner;

public class EditDistance {
    public int minDistance(String word1, String word2) {
        if(word1.length() == 0) return word2.length();
        if(word2.length() == 0) return word1.length();
        int len1 = word1.length(); int len2 = word2.length();
        int[][] result = new int[len1+1][len2+1];
        for(int i = 0; i < len2+1; i++)
            result[0][i] = i;
        for(int j = 0; j < len1+1; j++)
            result[j][0] = j;
        for(int i = 1; i < len1+1; i++){
            for(int j = 1; j < len2+1; j++) {
                if (word1.charAt(i-1) == word2.charAt(j-1))
                    result[i][j] = Math.min(result[i - 1][j] + 1, Math.min(result[i][j - 1] + 1, result[i - 1][j - 1]));
                else
                    result[i][j] = Math.min(result[i - 1][j] + 1, Math.min(result[i][j - 1] + 1, result[i - 1][j - 1]+1));
            }
        }
        return result[len1][len2];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String word1 = sc.next();
        String word2 = sc.next();
        EditDistance sl = new EditDistance();
        sl.minDistance(word1, word2);
    }
}
