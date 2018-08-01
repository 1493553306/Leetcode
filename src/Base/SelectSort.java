package Base;
import java.util.Scanner;

//O(n^2)
public class SelectSort {
    public static void selectsort(int[] array){
        for(int i = 0; i < array.length; i++){
            for(int j = i +1; j < array.length; j++){
                if(array[i] > array[j]){
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
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
