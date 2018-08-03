package Base;

import java.util.Scanner;
//https://www.cnblogs.com/chengxiao/p/6129630.html
public class HeapSort {
    public static void heapSort(int[] arr){
        int len = arr.length;
        //1.构建大顶堆
        for(int i = len/2 -1; i >= 0; i--)
            adjustHeap(arr, i, len);      //从第一个非叶子结点从下至上，从右至左调整结构
        //2.调整堆结构+交换堆顶元素与末尾元素
        for(int j = len-1; j >= 0; j--){
            swap(arr, 0, j);      //将堆顶元素与末尾元素进行交换
            adjustHeap(arr, 0, j);      //重新对堆进行调整
        }
    }
    public static void adjustHeap(int[] arr, int i, int len){
        int tmp = arr[i];                         //先取出当前元素i
        for(int k = 2*i+1; k < len; k = 2*k+1){   //从i结点的左子结点开始，也就是2i+1处开始
            if(k+1 < len && arr[k] < arr[k+1])    //如果左子结点小于右子结点，k指向右子结点
                k++;
            if(arr[k] > tmp){                     //如果子节点大于父节点，将子节点值赋给父节点（不用进行交换），继续调整后面的节点
                arr[i] = arr[k];
                i = k;
            }
            else
                break;
        }
        arr[i] = tmp;         //将temp值放到最终的位置
    }

    public static void swap(int[] arr, int i, int j){
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        String[] tmp = str.split(", ");
        int[] nums = new int[tmp.length];
        for(int i = 0; i < tmp.length; i++)
            nums[i] = Integer.valueOf(tmp[i]);
        heapSort(nums);
        for(int i = 0; i < nums.length; i++)
            System.out.println(nums[i]);
    }
}
