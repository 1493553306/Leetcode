package DynamicProgramming;

import java.util.Scanner;
/*2 1 4 3
        5 5
        3 0 1 4 2
        5 6 3 2 1
        1 2 0 1 5
        4 1 0 1 7
        1 0 3 0 5*/
public class RangeSumQuery2D {
    int[][] presum;
    public RangeSumQuery2D(int[][] matrix) {
        if ( matrix.length == 0 || matrix[0].length == 0) {
            presum = null;
            return;
        }
        presum = new int[matrix.length +1][matrix[0].length+1];
        for(int i =1; i <= matrix.length; i++){
            for(int j = 1; j <= matrix[0].length; j++){
                presum[i][j] = presum[i-1][j] + presum[i][j-1] + matrix[i-1][j-1] - presum[i-1][j-1];
            }
        }
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        if(presum == null)
            return 0;
        return presum[row2+1][col2+1] - presum[row2+1][col1] - presum[row1][col2+1] + presum[row1][col1];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int row1 = sc.nextInt(), col1 = sc.nextInt(), row2 = sc.nextInt(), col2 = sc.nextInt();
        int x = sc.nextInt(), y= sc.nextInt();
        int[][] matrix = new int[x][y];
        for(int i = 0 ; i < x; i++){
            for(int j = 0; j < y; j ++){
                matrix[i][j] = sc.nextInt();
            }
        }
        RangeSumQuery2D sl = new RangeSumQuery2D(matrix);
        int param_1 = sl.sumRegion(row1, col1, row2, col2);
    }
}
