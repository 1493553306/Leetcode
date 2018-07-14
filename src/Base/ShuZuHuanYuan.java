/*牛牛的作业薄上有一个长度为 n 的排列 A，这个排列包含了从1到n的n个数，但是因为一些原因，其中有一些位置（不超过 10 个）看不清了，
但是牛牛记得这个数列顺序对的数量是 k，顺序对是指满足 i < j 且 A[i] < A[j] 的对数，请帮助牛牛计算出，符合这个要求的合法排列的数目。*/
package Base;
import java.util.*;

public class ShuZuHuanYuan {
    int count = 0,total=0;
    public List<Integer> sort(List<Integer> array, int start, int end){
        List<Integer> result = new ArrayList<>();
        if(end - start == 1){
            result.add(array.get(start));
            return result;
        }

        int mid = (start+end)/2;
        List<Integer> left = sort(array, start, mid);
        List<Integer> right = sort(array, mid, end);
        int x = 0, y= 0;
        for(int i = start; i < end; i++){
            if(x < left.size() && y < right.size()){
                if(left.get(x) < right.get(y)){
                    result.add(left.get(x));
                    x++;
                    count+=right.size() - y;
                }
                else {
                    result.add(right.get(y));
                    y++;
                }
            }else if(x >= left.size()){
                result.add(right.get(y));
                y++;
            }else {
                result.add(left.get(x));
                x++;
            }
        }
        return result;
    }
    public void traceback(List<Integer> result, Set<Integer> contains, int[] nums, int level, int k){
        if(level == nums.length){
            sort(result, 0, nums.length);
            if (count == k) total++;
            count = 0;
            return;
        }
        if(nums[level]!=0){
            result.add(nums[level]);
            traceback(result, contains, nums, level+1, k);
            result.remove(result.size()-1);
        }else {
            for(int i = 1; i <= nums.length; i++){
                if(!contains.contains(i)) {
                    result.add(i);
                    contains.add(i);
                    traceback(result, contains, nums, level + 1, k);
                    result.remove(result.size()-1);
                    contains.remove(i);
                }
            }
        }
        return;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ShuZuHuanYuan sl = new ShuZuHuanYuan();
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] nums = new int[n];
        Set<Integer> contains = new HashSet<>();
        for(int i = 0; i < n; i++){
            nums[i] = sc.nextInt();
            if(nums[i] != 0)
                contains.add(nums[i]);
        }
        List<Integer> result = new ArrayList<>();
        sl.traceback(result, contains, nums, 0, k);
        System.out.println(sl.total);
    }
}
