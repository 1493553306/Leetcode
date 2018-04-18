package DivideandConquer;

import java.util.Scanner;

public class SearchA2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix == null || matrix.length == 0 || matrix[0].length == 0)  return false;
        int x = matrix.length-1, y = matrix[0].length-1;
        boolean result = false;
        while (x>=0 && y>=0){
            if(matrix[x][y] == target) return true;
            else if(matrix[x][0] > target) x--;
            else y--;
        }
        return result;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(), y = sc.nextInt();
        int target = sc.nextInt();
        int[][] maxtrix = new int[x][y];
        for(int i = 0; i < x; i++)
            for (int j = 0; j < y; j++)
                maxtrix[i][j] = sc.nextInt();
        SearchA2DMatrix sl = new SearchA2DMatrix();
        sl.searchMatrix(maxtrix, target);
    }
}
