package DepthFirstSearch;

/*Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and
 is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all
 surrounded by water.

        Example 1:

        Input:
        11110
        11010
        11000
        00000

        Output: 1
        Example 2:

        Input:
        11000
        11000
        00100
        00011

        Output: 3

深度优先遍历的主要思想是：
首先以一个未被访问过的顶点作为起始顶点，沿当前顶点的边走到未访问过的顶点；
当没有未访问过的顶点时，则回到上一个顶点，继续试探别的顶点，直到所有的顶点都被访问过。
*/


import java.util.Scanner;

public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        int x = grid.length;
        if(x == 0) return 0;
        int y = grid[0].length;
        int count = 0;
        for (int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                if(grid[i][j] == '1'){
                    DFSMarking(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }
    public static void DFSMarking(char[][] grid, int x, int y){
        if(x < 0 || x >= grid.length || y < 0 || y >= grid[0].length || grid[x][y] == '0') return;
        grid[x][y] = '0';
        DFSMarking(grid, x-1, y);
        DFSMarking(grid, x+1, y);
        DFSMarking(grid, x,y-1);
        DFSMarking(grid, x, y+1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(), y = sc.nextInt();
        sc.nextLine();
        char[][] grid = new char[x][y];

        for(int i = 0; i < x; i++){
            grid[i] = sc.nextLine().toCharArray();
        }
        int reslut = numIslands(grid);
        System.out.print(reslut);

    }

}
