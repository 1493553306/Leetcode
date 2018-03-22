import java.util.Scanner;

public class SortColors {
    public void sortColors(int[] nums) {
        int len0 = 0, len1 = 0,len2= 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == 0)  len0++;
            else if(nums[i] == 1) len1++;
            else len2++;
        }
        for(int i = 0; i < len0; i++)
            nums[i] = 0;
        for(int i = len0; i < len0 + len1; i++)
            nums[i] = 1;
        for(int i = len0 + len1; i < len0 + len1 +len2; i++)
            nums[i] = 2;

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for (int i = 0; i < len; i++)
            nums[i] = sc.nextInt();
        SortColors sl = new SortColors();
        sl.sortColors(nums);
    }
}
