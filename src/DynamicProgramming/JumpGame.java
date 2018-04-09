package DynamicProgramming;
import java.util.Scanner;

public class JumpGame {
    public boolean canJump(int[] nums) {
        //方法一
        /* int lastpos = 0;
        for(int i = 0; i < nums.length-1 && lastpos >= i; i++)
            lastpos = lastpos > (nums[i] + i) ? lastpos : (nums[i] + i);
        return lastpos >= nums.length-1;*/
        //方法二
        int lastpos = 0;
        for(int i = 0; i < nums.length - 1; i++){
            if(lastpos < i){
                return false;
            }
            lastpos = Math.max(lastpos, i+nums[i]);
        }
        return lastpos>=nums.length-1;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for(int i = 0; i < len; i++)
            nums[i] = sc.nextInt();
        JumpGame sl = new JumpGame();
        sl.canJump(nums);
    }
}
