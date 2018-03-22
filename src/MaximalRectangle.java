import java.util.Scanner;

/*tmp[][]里面存的是matrix中每一行连续1的个数. 如果tmp[index][j] >=1, 就纵向统计（向上），找最大的矩形面积，其中矩形的长度是纵向最小的那个数*/
public class MaximalRectangle {
    public int maximalRectangle(char[][] matrix) {
        if(matrix.length == 0) return 0;
        int maxarea = matrix[0][0] -'0', x = matrix.length, y = matrix[0].length;
        int index, area, min, hang = 1;
        int[][] tmp = new int[x][y];
        for(int i = 0; i < x; i++) {
            if(matrix[i][0] == '0') {
                tmp[i][0] = 0;
                hang = 1;
            }
            else {
                tmp[i][0] = 1;
                maxarea = maxarea > hang ? maxarea : hang;
                hang++;
            }
        }

        for(int i = 0; i < x; i++){
            for(int j =1; j <y; j++){
                if(matrix[i][j] == '0')  tmp[i][j] = 0;
                else {
                    tmp[i][j] = tmp[i][j-1]+1;
                    index = i;
                    hang = 1;
                    min = tmp[i][j];
                    while (index >= 0 && tmp[index][j] >=1){
                        area = hang* Math.min(min, tmp[index][j]);
                        maxarea = maxarea > area ? maxarea : area;
                        min = Math.min(min, tmp[index][j]);
                        index--;
                        hang++;
                    }
                }
            }
        }
        return maxarea;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int y = sc.nextInt();
        char[][] matrix = new char[x][y];
        for(int i = 0; i < x; i++)
            for(int j = 0; j < y; j++)
                matrix[i][j] = sc.next().charAt(0);
        MaximalRectangle sl = new MaximalRectangle();
        sl.maximalRectangle(matrix);
    }
}
