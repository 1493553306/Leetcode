package DivideandConquer;
import java.util.Scanner;

/*Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

        Integers in each row are sorted in ascending from left to right.
        Integers in each column are sorted in ascending from top to bottom.
        Example:

        Consider the following matrix:

        [
        [1,   4,  7, 11, 15],
        [2,   5,  8, 12, 19],
        [3,   6,  9, 16, 22],
        [10, 13, 14, 17, 24],
        [18, 21, 23, 26, 30]
        ]
        Given target = 5, return true.

        Given target = 20, return false.*/

public class SearchA2DMatrixII {
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length == 0) return false;
        int x = matrix.length-1, y = 0;
        while (x >= 0 && y < matrix[0].length){
            if(matrix[x][y] == target) return true;
            else if(matrix[x][y] > target) x--;
            else y++;
        }
        return false;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(), y = sc.nextInt();
        int target = sc.nextInt();
        int[][] maxtrix = new int[x][y];
        for(int i = 0; i < x; i++)
            for (int j = 0; j < y; j++)
                maxtrix[i][j] = sc.nextInt();
        SearchA2DMatrixII sl = new SearchA2DMatrixII();
        boolean result = sl.searchMatrix(maxtrix, target);
        System.out.print(result);
    }
}
