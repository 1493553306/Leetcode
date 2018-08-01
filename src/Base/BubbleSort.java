package Base;

import java.util.Scanner;

//average O(n^2) best O(n)
public class BubbleSort {
    public static void bubbleSort(int[] nums){
        int tmp = 0;
        for(int i = 0; i < nums.length - 1; i++){
            for(int j = 0; j < nums.length-1-i; j++){
                if(nums[j] < nums[j+1]){
                    tmp = nums[j];
                    nums[j] = nums[j+1];
                    nums[j+1] = tmp;
                }
            }
        }
        for(int i = 0; i < nums.length; i++)
            System.out.println(nums[i]);

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] tmp = str.split(" ");
        int[] value = new int[tmp.length];
        for(int i = 0; i < tmp.length; i++)
            value[i] = Integer.valueOf(tmp[i]);
        BubbleSort sl = new BubbleSort();
        sl.bubbleSort(value);
    }
}
