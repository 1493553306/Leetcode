import java.util.Scanner;

public class RotateImage {
    public void rotate(int[][] matrix) {
        int tmp, n = matrix.length;
        for(int i = 0; i < n/2; i++){
            for(int j = i; j < n -i-1; j++){
                tmp = matrix[i][j];
                matrix[i][j] = matrix[n-1-j][i];
                matrix[n-1-j][i] = matrix[n-1-i][n-1-j];
                matrix[n-1-i][n-1-j] = matrix[j][n-1-i];
                matrix[j][n-1-i] = tmp;
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] matrix = new int[n][n];
        for(int i = 0; i < n; i++)
            for(int j = 0; j < n; j++)
                matrix[i][j] = sc.nextInt();
        RotateImage sl = new RotateImage();

        sl.rotate(matrix);
    }


}
