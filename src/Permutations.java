import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        List<Integer> member = new LinkedList<>();
        backtrace(result, member, nums, nums.length);
        return result;
    }
    public void backtrace(List<List<Integer>> result, List<Integer> member, int[] nums, int level){
        if(level == 0){
            List<Integer> copy = new LinkedList<>(member);
            result.add(copy);
            return;
        }
        for(int i = 0; i < nums.length; i++){
            Integer wrapperi = new Integer(nums[i]);
            if(!member.contains(wrapperi)){
                member.add(nums[i]);
                backtrace(result, member, nums, level -1);
                member.remove(member.size()-1);
            }
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for(int i =0; i < len; i++)
            nums[i] = sc.nextInt();
        Permutations sl = new Permutations();
        sl.permute(nums);
    }
}
