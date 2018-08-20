package Backtracing;
/*Write a program to solve a Sudoku puzzle by filling the empty cells.

    A sudoku solution must satisfy all of the following rules:
    Each of the digits 1-9 must occur exactly once in each row.
    Each of the digits 1-9 must occur exactly once in each column.
    Each of the the digits 1-9 must occur exactly once in each of the 9 3x3 sub-boxes of the grid.
    Empty cells are indicated by the character '.'.
    9 9
53..7....
6..195...
.98....6.
8...6...3
4..8.3..1
7...2...6
.6....28.
...419..5
....8..79
*/

import java.util.Scanner;

public class SudokuSolver {
    public static void solveSudoku(char[][] board) {
        int x = board.length;
        if(x == 0) return;
        bchelper(board);

    }
    public static boolean bchelper(char[][] board){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == '.'){
                    for(char c = '1'; c <= '9'; c++){
                        if(isvalid(board, i, j, c)){
                            board[i][j] = c;
                            if(bchelper(board) == true)
                                return true;
                            else
                                board[i][j] = '.';
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    public static boolean isvalid(char[][] board, int x, int y, char c){
        for(int i = 0; i < 9; i++){
            if(board[x][i] == c) return false;
            if(board[i][y] == c) return false;
        }
        for(int i = (x/3)*3; i < (x/3)*3+3; i++){
            for(int j = (y/3)*3; j < (y/3)*3+3; j++){
                if(board[i][j] == c)
                    return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt(), y = sc.nextInt();
        sc.nextLine();
        char[][] grid = new char[x][y];

        for(int i = 0; i < x; i++){
            grid[i] = sc.nextLine().toCharArray();
        }
        solveSudoku(grid);

    }

}
