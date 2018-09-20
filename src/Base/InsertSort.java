package Base;

import java.util.Scanner;

//O(n^2)  稳定
//4 2 1 6 3 6 0 -5 1 1
public class InsertSort {
    public static void insertSort(int[] num){
        int tmp = 0;
        for(int i = 1; i < num.length; i++){
            tmp = num[i];
            int j = i - 1;
            while (j >= 0 && num[j] > tmp){
                num[j+1] = num[j];
                j--;
            }
            num[j+1] = tmp;
        }
        for(int i = 0; i < num.length; i++)
            System.out.println(num[i]);

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] tmp = str.split(" ");
        int[] nums = new int[tmp.length];
        for(int i = 0; i < tmp.length; i++)
            nums[i] = Integer.valueOf(tmp[i]);
        InsertSort sl = new InsertSort();
        sl.insertSort(nums);

    }
}
