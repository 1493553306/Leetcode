import java.util.Scanner;

public class SearchinRotatedSortedArray {
    public int search(int[] nums, int target) {
        if(nums.length ==0)
            return -1;
        int start = 0, end = nums.length -1, mid;
        while (start <= end){
            mid = (start + end)/2;
            if(nums[mid] == target)
                return mid;
            if(nums[mid] < nums[end]){
                if(target > nums[mid] && target <= nums[end])
                    start = mid + 1;
                else
                    end = mid -1;

            }else {
                if(target < nums[mid] && target >= nums[start])
                    end = mid -1;
                else
                    start = mid +1;
            }
        }
        return -1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for(int i = 0; i < len; i++)
            nums[i] = sc.nextInt();
        int target = sc.nextInt();
        SearchinRotatedSortedArray sl = new SearchinRotatedSortedArray();
        sl.search(nums, target);

    }
}
