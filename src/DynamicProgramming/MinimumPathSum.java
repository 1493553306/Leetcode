package DynamicProgramming;
import java.util.Scanner;

public class MinimumPathSum {
    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        if (m ==1 && n == 1) return grid[0][0];
        for(int i = 1; i < n; i++)
            grid[0][i] = grid[0][i-1] + grid[0][i];
        if(m == 1) return grid[0][n-1];
        for(int j = 1; j < m ; j++)
            grid[j][0] = grid[j-1][0]+grid[j][0];
        if(n ==1) return grid[m-1][0];

        for(int i = 1; i < m; i++)
            for(int j = 1; j < n; j++)
                grid[i][j] = grid[i][j-1] + grid[i][j] < grid[i-1][j]+ grid[i][j] ? grid[i][j-1] + grid[i][j]:grid[i-1][j]+ grid[i][j];
        System.out.println(grid[m -1][n -1]);
        return grid[m -1][n -1];
    }
    public static void main(String[] atgs){
        Scanner sc = new Scanner(System.in);
        int m = sc.nextInt();
        int n = sc.nextInt();
        int[][] grid = new int[m][n];
        for(int i = 0; i < m; i++)
            for(int j = 0; j < n; j++)
                grid[i][j] = sc.nextInt();
        MinimumPathSum sl = new MinimumPathSum();
        sl.minPathSum(grid);
    }

}
