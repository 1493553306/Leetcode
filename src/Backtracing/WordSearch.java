package Backtracing;

import java.util.Scanner;

public class WordSearch {
    public static boolean exist(char[][] board, String word) {
        int x = board.length;
        if (x == 0) return false;
        int y = board[0].length;
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                if(board[i][j] == word.charAt(0)){
                    if(bchelper(board, word, i, j, 0))
                        return true;
                }
            }

        }
        return false;
    }
    public static boolean bchelper(char[][] board, String word, int x, int y, int index){
        if(word.length() == index) return true;
        if(x < 0 || x >= board.length || y < 0 || y >= board[0].length || board[x][y] != word.charAt(index)) return false;
        board[x][y] = '0';
        boolean left = bchelper(board, word, x-1, y, index+1);
        boolean right = bchelper(board, word, x+1, y, index+1);
        boolean up = bchelper(board, word, x, y-1, index+1);
        boolean down = bchelper(board, word, x, y+1, index+1);
        if((left || right || up || down)==true)
            return true;
        else
            board[x][y] = word.charAt(index);
        return false;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        char[][] board = new char[x][y];
        for(int i = 0; i < x; i++)
            for(int j = 0; j < y; j++)
                board[i][j] = sc.next().charAt(0);
        String word = sc.next();
        boolean result = exist(board, word);
        System.out.print(result);
    }
}
