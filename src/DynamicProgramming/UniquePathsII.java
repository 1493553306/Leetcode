package DynamicProgramming;

import java.util.Scanner;

public class UniquePathsII {
    //这道题第一行和第一列初始化的时候要注意，如果obstacleGrid[0][i] == 1，则result[0][i],result[0][i+1],result[0][i+2]...都应该初始化为0。
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        int[][] result = new int[m][n];
        if(m == 0 || n == 0 || obstacleGrid[0][0] == 1) return 0;
        for(int i = 0; i < m; i++){
            if(obstacleGrid[i][0] == 0) result[i][0] = 1;
            else break;
        }
        for(int j = 0; j <n; j++){
            if(obstacleGrid[0][j] == 0) result[0][j] = 1;
            else break;
        }
        for(int i = 1; i < m; i++){
            for(int j = 1; j < n; j++){
                if(obstacleGrid[i][j] == 0) result[i][j] = result[i-1][j] + result[i][j-1];
                else result[i][j] = 0;
            }
        }
        return result[m-1][n-1];
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt(), n = sc.nextInt();
        int[][] obstacleGrid = new int[m][n];
        for(int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                obstacleGrid[i][j] = sc.nextInt();
        UniquePathsII sl = new UniquePathsII();
        sl.uniquePathsWithObstacles(obstacleGrid);
    }
}
