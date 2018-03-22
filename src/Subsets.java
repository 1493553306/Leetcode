import java.util.*;

/*递归+for循环。 因为Subset要求里面的元素不重复，因此每次递归的时候，for循环要从当前跟节点的下一个元素开始
* eg:
*            1;           2;        3;       4;
*       2    3    4;   3     4;     4;
*    3   4;  4;        4;
*    4;
*    */
public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> member = new ArrayList<Integer>();
        traceback(result, member, nums, nums.length,0);
        result.add(new ArrayList<Integer>());
        System.out.print('a');
        return result;

    }
    public void traceback(List<List<Integer>> result, List<Integer> member, int[] nums, int level, int start){
        if(level == 0)
            return;
        for(int i = start; i < nums.length; i++){
            int wrapperi = new Integer(nums[i]);
            member.add(wrapperi);
            result.add(new ArrayList<Integer>(member));
            traceback(result, member, nums, level-1, i+1);
            member.remove(member.size()-1);

        }

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] nums = new int[len];
        for(int i = 0; i < len; i++)
            nums[i] = sc.nextInt();
        Subsets sl = new Subsets();
        sl.subsets(nums);
    }

}
