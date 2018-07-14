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
        if(matrix == null || matrix.length < 1 || matrix[0].length <1)
            return false;
        int x = matrix.length, y = matrix[0].length;
        boolean result = dchelp(matrix, 0, 0, x-1, y-1, target);
        return result;
    }
    public boolean dchelp(int[][] matrix, int xstart, int ystart, int xend, int yend, int target){
        boolean result1 = false, result2 = false, result3 = false, result4 = false;
        int xmid, ymid;
        if(xstart == xend && ystart == yend){
            if(matrix[xstart][ystart] == target)  return true;
            else  return false;
        }
        if(matrix[xstart][ystart] == target || matrix[xend][yend] == target)  return true;
        if(matrix[xstart][ystart] < target && matrix[xend][yend] > target){
            xmid = (xstart + xend +1 )/2;
            ymid = (ystart + yend +1 )/2;
            result1 = dchelp(matrix, xstart, ystart, Math.max(xmid-1,0), Math.max(ymid-1,0), target);
            if(result1 == false)
                result2 = dchelp(matrix, xstart, ymid, Math.max(xmid-1,0), yend, target);
            if(result1 == false && result2 == false)
                result3 = dchelp(matrix, xmid, ystart, xend, Math.max(ymid-1,0), target);
            if(result1 == false && result2 == false && result3 == false)
                result4 = dchelp(matrix, xmid, ymid, xend, yend, target);
        }
        return result1||result2||result3||result4;
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
        sl.searchMatrix(maxtrix, target);
    }
}
