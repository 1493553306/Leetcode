package DivideandConquer;

import java.util.HashMap;
import java.util.Scanner;

public class MajorityElement {
    //用map进行统计
   /* public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> count = new HashMap<Integer, Integer>();
        for(int i = 0; i < nums.length; i++){
            if(count.containsKey(nums[i]))
                count.put(nums[i], count.get(nums[i])+1);
            else
                count.put(nums[i], 1);
        }
        for (Integer key: count.keySet()){
            if(count.get(key) > nums.length/2)
                return key;
        }
        return 0;
    }*/
    //用count进行统计，因为majority element more than ⌊ n/2 ⌋, 因此与其他元素抵消之后，count的值还是>1
    public int majorityElement(int[] nums) {
        int major = nums[0], count = 1;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] == major)
                count++;
            else
                count--;
            if(count == 0){
                major = nums[i];
                count = 1;
            }
        }
        return major;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for(int i = 0; i < len; i++)
            nums[i] = sc.nextInt();
        MajorityElement sl = new MajorityElement();
        sl.majorityElement(nums);
    }
}
