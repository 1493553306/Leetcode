import java.util.Arrays;
import java.util.Scanner;

public class Sort {
    //归并排序
    /*public int[] sort(int[] array){
        int[] result = new int[array.length];
        if(array.length == 1)
            return array;
        int mid = array.length/2;
        int[] leftsort = sort(Arrays.copyOfRange(array,0, mid));
        int[] rightsort = sort(Arrays.copyOfRange(array, mid, array.length));
        int x = 0, y=0;
        for(int i = 0; i < array.length; i++){
            if(x < leftsort.length && y < rightsort.length){
                if (leftsort[x] < rightsort[y]) {
                    result[i] = leftsort[x];
                    x++;
                }
                else {
                    result[i] = rightsort[y];
                    y++;
                }
            }
            else if(x >= leftsort.length){
                result[i] = rightsort[y];
                y++;
            }
            else {
                result[i] = leftsort[x];
                x++;
            }
        }
        return result;
    }*/

    //快速排序
    public int[] sort(int[] array){
        dchelp(array, 0, array.length-1);
        return array;
    }
    public void dchelp(int[] array, int start, int end){
        if(start >= end)
            return;
        int base = start, tmp;
        int left = start, right = end;
        while (left < right){
            if(array[right] <= array[base]){
                tmp = array[base];
                array[base] = array[right];
                while (left < right && array[left] <= tmp)
                    left++;
                array[right] = array[left];
                array[left] = tmp;
            }
            right--;
        }
        dchelp(array, start, left-1);
        dchelp(array, left+1, end);
        return;

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] array = new int[len];
        for(int i = 0; i < len; i++)
            array[i] = sc.nextInt();
        Sort sl = new Sort();
        sl.sort(array);
    }
}
