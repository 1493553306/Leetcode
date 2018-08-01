package Base;
import java.util.Scanner;

//O(nlogn)
public class QuickSort {
    public static int[] quicksort(int[] array){
        dchelp(array, 0, array.length-1);
        return array;
    }
    public static void dchelp(int[] array, int start, int end){
        if(start >= end)
            return;
        else {
            int base = array[start];
            int left = start, right =end;
            while (left < right){
                if(array[right] <= base){
                    array[left] = array[right];
                    while (left < right && array[left] <= base)
                        left++;
                    array[right] = array[left];
                    array[left] = base;
                }
                right--;
            }
            dchelp(array, start, left-1);
            dchelp(array,left+1, end);
            return;
        }
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] tmp = str.split(" ");
        int[] nums = new int[tmp.length];
        for(int i = 0; i < tmp.length; i++)
            nums[i] = Integer.valueOf(tmp[i]);
        quicksort(nums);
        for(int i = 0; i < nums.length; i++)
            System.out.println(nums[i]);
    }
}
