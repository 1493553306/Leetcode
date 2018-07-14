package DivideandConquer;
import java.util.Scanner;

/*Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

        Integers in each row are sorted from left to right.
        The first integer of each row is greater than the last integer of the previous row.
        Example 1:

        Input:
        matrix = [
        [1,   3,  5,  7],
        [10, 11, 16, 20],
        [23, 30, 34, 50]
        ]
        target = 3
        Output: true
        Example 2:

        Input:
        matrix = [
        [1,   3,  5,  7],
        [10, 11, 16, 20],
        [23, 30, 34, 50]
        ]
        target = 13
        Output: false*/
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
