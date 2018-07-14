package DivideandConquer;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
/*Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.

        Note: The algorithm should run in linear time and in O(1) space.

        Example 1:
        Input: [3,2,3]
        Output: [3]

        Example 2:
        Input: [1,1,1,3,3,2,2,2]
        Output: [1,2]
*/
public class MajorityElementII {
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> result = new LinkedList<Integer>();
        int a = 0, b = 1, counta = 0, countb = 0;
        for(int i= 0; i < nums.length; i++){
            if(a == nums[i])
                counta++;
            else if(b==nums[i])
                countb++;
            else if(counta == 0) {
                a = nums[i];
                counta = 1;
            }
            else if(countb == 0) {
                b = nums[i];
                countb = 1;
            }
            else{
                counta--;
                countb--;
            }
        }
        counta = 0; countb = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] == a) counta++;
            if(nums[i] == b) countb++;
        }
        if(counta > nums.length/3) result.add(a);
        if(countb > nums.length/3) result.add(b);
        return result;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for(int i = 0; i < len; i++)
            nums[i] = sc.nextInt();
        MajorityElementII sl = new MajorityElementII();
        sl.majorityElement(nums);
    }
}
