import java.util.Scanner;

public class SearchForARange {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        int left = searchLeft(nums, target);
        if(left == nums.length || nums[left] != target){
            System.out.print(result[0]);
            System.out.print(result[1]);
            return result;
        }
        else{
            result[0] = left;
            result[1] = searchRight(nums, target);}
        System.out.print(result[0]);
        System.out.print(result[1]);
        return result;
    }
    private int searchLeft(int[] nums, int target){
        int lo = 0, hi = nums.length-1 ,mid;
        while (lo < hi){
            mid = (lo + hi)/2;
            if(nums[mid] < target)
                lo = mid + 1;
            else
                hi = mid ;
        }
        return lo;
    }
    private int searchRight(int[] nums, int target){
        int lo = 0, hi = nums.length-1, mid;
        while (lo < hi) {
            mid = (lo + hi + 1)/2;
            if (nums[mid] > target)
                hi = mid -1 ;
            else
                lo = mid;
        }
        return lo;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for(int i = 0; i < len; i++)
            nums[i] = sc.nextInt();
        int target = sc.nextInt();
        SearchForARange sl = new SearchForARange();
        sl.searchRange(nums, target);
    }
}
