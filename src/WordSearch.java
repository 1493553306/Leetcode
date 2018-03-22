import java.util.Scanner;

/*使用DFS深度搜索，分别向上、下、左、右搜索，int[][] flag用来记录当前元素是否被访问过;
  注意：如果发现一条路走不通的后回溯时，需要flag[xstart][ystart] = 0;
  感觉在找到index == word.length()，应该可以直接返回到WordSearch()函数，不需要继续回溯，这一点需要改进，还不知道怎么处理。*/

public class WordSearch {
    public boolean exist(char[][] board, String word) {
        Boolean result = Boolean.FALSE;
        int x = board.length, y = board[0].length;
        for(int i = 0; i < board.length; i ++)
            for(int j = 0; j < board[0].length; j++) {
                int[][] flag = new int[x][y];
                result = backTrace(board, flag, word, i, j, 0);
                if (result == Boolean.TRUE)
                    return result;
            }
        return result;
    }
    public Boolean backTrace(char[][] board, int[][] flag, String word,  int xstart, int ystart, int index){
        if(index == word.length()){
            return Boolean.TRUE;
        }
        if(xstart < 0 || xstart > board.length-1|| ystart < 0 || ystart > board[0].length -1)
            return Boolean.FALSE;

        if(flag[xstart][ystart] != 1 && board[xstart][ystart] == word.charAt(index)){
            flag[xstart][ystart] = 1;
            index++;
            Boolean left = backTrace(board, flag, word, xstart, ystart-1, index);
            Boolean right = backTrace(board, flag, word, xstart, ystart+1, index);
            Boolean up = backTrace(board, flag, word, xstart-1, ystart, index);
            Boolean down = backTrace(board, flag, word, xstart+1, ystart, index);
            if(left || right || up || down == Boolean.TRUE)
                return Boolean.TRUE;
            else
                flag[xstart][ystart] =0;
        }
        return Boolean.FALSE;
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
        WordSearch sl = new WordSearch();
        sl.exist(board, word);
    }

}
