package Base;

import java.util.Arrays;
import java.util.Scanner;

public class BinarySearch {
    public static int binarysearch(int[] arr, int value){
        int low = 0, high = arr.length-1;
        while (low <= high){
            int mid = (low + high) >>1;
            if(arr[mid] == value)
                return mid;
            else if(arr[mid] < value)
                low = mid +1;
            else
                high = mid -1;
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] arr = new int[len];
        for(int i = 0; i < len; i++)
            arr[i] = sc.nextInt();
        BinarySearch sl = new BinarySearch();
        int[] tmp = Arrays.copyOf(arr, arr.length);
        Arrays.sort(tmp);
        int index = sl.binarysearch(tmp, 5);

        if(index == -1)
            System.out.println(-1);
        else {
            for(int i = 0; i < len; i++){
                if(arr[i] == tmp[index]) {
                    System.out.println(i);
                    break;
                }
            }
        }
    }
}
