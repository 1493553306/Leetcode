import java.util.Scanner;

public class TrappingRainWater {
    public int trap(int[] height) {
        int maxheight = height[0], flag = 0, area = 0;
        for(int i = 1; i < height.length; i++){
            if(height[i] > maxheight){
                flag = i;
                maxheight = height[i];
            }
        }
        int left = 0, tmp = 0;
        while (left < flag){
            if(height[left] <= tmp)
                area = area + tmp - height[left];
           else
                tmp = height[left];
           left ++;
        }
        int right = height.length - 1;
        tmp = 0;
        while (right > flag){
            if(height[right] <= tmp)
                area = area + tmp - height[right];
            else
                tmp = height[right];
            right --;
        }
        System.out.print(area);
        return area;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] height = new int[len];
        for(int i = 0; i < len; i++)
            height[i] = sc.nextInt();
        TrappingRainWater sl = new TrappingRainWater();
        sl.trap(height);
    }

}
