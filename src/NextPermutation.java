import java.util.Arrays;
import java.util.Scanner;

public class NextPermutation {
    public void nextPermutation(int[] nums) {
        int decindex = 0;
        int minbiggerindex = 0;
        if(nums.length < 2)
            return;
        for(int i = nums.length -1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                decindex = i - 1;
                minbiggerindex = decindex+1;
                break;
            }
        }
        for(int i = decindex +1; i < nums.length; i++){
            if(nums[i] > nums[decindex] && nums[i] < nums[minbiggerindex]){
                minbiggerindex = i;
                if(nums[minbiggerindex] - nums[decindex] == 1)
                    break;
            }
        }
        int tmp = nums[decindex];
        nums[decindex] = nums[minbiggerindex];
        nums[minbiggerindex] = tmp;
        if(minbiggerindex == 0)
            Arrays.sort(nums);
        else
            Arrays.sort(nums,decindex+1,nums.length);
        for(int i = 0; i< nums.length;i++)
            System.out.println(nums[i]);
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        NextPermutation sl = new NextPermutation();
        sl.nextPermutation(nums);
    }
}
