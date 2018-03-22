import java.lang.reflect.Array;
import java.util.*;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Set<List<Integer>> tmp = new HashSet<List<Integer>>();
        //ArrayList<ArrayList<Integer>> result = new ArrayList<ArrayList<Integer>>();
        List<Integer> member = new ArrayList<Integer>();
        Arrays.sort(candidates);
        backtrace(tmp, member, candidates, 0, target);
        List<List<Integer>> result = new ArrayList<List<Integer>>(tmp);
        return result;
    }
    public void backtrace(Set<List<Integer>> tmp, List<Integer> member, int[] candidates, int sum, int target){
        if(sum == target){
            List<Integer> copy = new ArrayList<>(member);
            Collections.sort(copy);
            tmp.add(copy);
            return;
        }
        if(sum > target) {
            return;
        }
        for (int i = 0; i < candidates.length; i++){
            member.add(candidates[i]);
            sum = sum + candidates[i];
            backtrace(tmp, member, candidates, sum, target);
            Integer a  = candidates[i];
            int flag = sum;
            member.remove(member.size() -1 );
            sum = sum - candidates[i];
            if(flag >= target)
                break;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        int[] candidates = new int[len];
        for(int i = 0; i < len; i++)
            candidates[i] = sc.nextInt();
        int target = sc.nextInt();
        CombinationSum sl = new CombinationSum();
        sl.combinationSum(candidates, target);
    }
}
