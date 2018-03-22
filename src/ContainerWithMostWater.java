import java.util.Scanner;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxarea = 0;
        int start = 0, end = height.length - 1;
        while (start != end){
            int area = Math.min(height[start],height[end])*(end-start);
            maxarea = maxarea > area ? maxarea : area;
            if(height[start] > height[end])
                end--;
            else
                start++;
        }
        return maxarea;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] height = new int[n];
        for(int i = 0; i < n; i++)
            height[i] = sc.nextInt();
        ContainerWithMostWater sl = new ContainerWithMostWater();
        int result = sl.maxArea(height);
        System.out.print(result);

    }
}
