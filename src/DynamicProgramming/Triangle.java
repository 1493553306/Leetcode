package DynamicProgramming;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Triangle {
    public int minimumTotal(List<List<Integer>> triangle) {
        int len = triangle.size(),mintotal = Integer.MAX_VALUE;
        if(len == 0) return 0;
        int[][] result = new int[len][len];
        result[0][0] = triangle.get(0).get(0);
        for(int i = 1; i < len; i++){
            result[i][0] = triangle.get(i).get(0) + result[i-1][0];
            result[i][i] = triangle.get(i).get(i) + result[i-1][i-1];
            for(int j = 1; j < i; j++){
                result[i][j] = triangle.get(i).get(j)+Math.min(result[i-1][j-1],result[i-1][j]);
            }
        }
        for(int j = 0; j < len; j++)
            mintotal = Math.min(mintotal, result[len-1][j]);

        return mintotal;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        List<Integer> tmp = new ArrayList<Integer>();
        for(int i = 0; i < len; i++){
            for(int j = 0; j<=i; j++)
                tmp.add(sc.nextInt());
            triangle.add(new ArrayList<>(tmp));
            tmp.clear();
        }
        Triangle sl = new Triangle();
        sl.minimumTotal(triangle);
    }
}
