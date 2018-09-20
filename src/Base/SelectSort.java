package Base;
import java.util.Scanner;

//O(n^2)  不稳定
public class SelectSort {
    public static void selectsort(int[] array){
        for(int i = 0; i < array.length; i++){
            int minIndex = i;
            for(int j = i+1; j < array.length; j++){
                if(array[j] < array[minIndex])
                    minIndex = j;
            }
            int tmp = array[i];
            array[i] = array[minIndex];
            array[minIndex] = tmp;
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] tmp = str.split(" ");
        int[] nums = new int[tmp.length];
        for(int i = 0; i < tmp.length; i++)
            nums[i] = Integer.valueOf(tmp[i]);
        selectsort(nums);
        for (int fac : nums)
            System.out.print(fac + " ");
    }

}
