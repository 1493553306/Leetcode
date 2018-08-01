package Base;

import java.util.Scanner;

public class ShellSort {
    public static void shellSort(int[] array){
        for(int gap = array.length/2; gap > 0; gap /=2){
            for(int i = 0; i < gap; i++){
                for(int j = i+gap; j < array.length; j+= gap){
                    int tmp = array[j];
                    int index = j - gap;
                    while (index >= 0 && array[index] > tmp){
                        array[index+gap] = array[index];
                        index -= gap;
                    }
                    array[index + gap] = tmp;
                }
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] tmp = str.split(" ");
        int[] nums = new int[tmp.length];
        for(int i = 0; i < tmp.length; i++)
            nums[i] = Integer.valueOf(tmp[i]);
        shellSort(nums);
        for(int i = 0; i < nums.length; i++)
            System.out.println(nums[i]);
    }
}
