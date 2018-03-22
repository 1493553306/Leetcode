import java.util.*;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums == null || nums.length < 3)
            return new LinkedList<>();
        List<List<Integer>> result = new LinkedList<>();
        Set<List<Integer>> tmpset = new HashSet<>();
        Arrays.sort(nums);
        if(nums[0] == nums[nums.length -1]){
            if(nums[0] == 0){
                List<Integer> tmplist = new LinkedList<>();
                tmplist.add(0);
                tmplist.add(0);
                tmplist.add(0);
                result.add(tmplist);
                return result;
            }
            else
                return new LinkedList<>();
        }
        for(int start = 0; start < nums.length-2; start ++){
            int next = start + 1;
            int end = nums.length -1;
            while (next != end){
                if(nums[start] + nums[next] + nums[end] == 0){
                    List<Integer> tmplist = new LinkedList<>();
                    tmplist.add(nums[start]);
                    tmplist.add(nums[next]);
                    tmplist.add(nums[end]);
                    tmpset.add(tmplist);
                    next ++;
                }
                else if(nums[start] + nums[next] + nums[end] < 0)
                    next++;
                else
                    end--;
            }
        }
        result.addAll(tmpset);
        return result;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++)
            nums[i] = sc.nextInt();
        ThreeSum sl = new ThreeSum();
        List<List<Integer>> result = sl.threeSum(nums);
    }
}
