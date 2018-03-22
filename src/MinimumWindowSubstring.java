import java.util.*;

/*使用贪心算法的思想。在每次找到num==target.length()的时候：移动头指针preflg使它指向符合要求子串的首字母，如果字串的长度小于Minlen,更新字串；
否则不更新；最后preflag+1，使子串重新不符合要求，继续寻找符合条件的子串。*/
public class MinimumWindowSubstring {
    public String minWindow(String s, String t) {
        Map<Character, Integer> target = new HashMap<Character, Integer>();
        Map<Character, Integer> tmp = new HashMap<Character, Integer>();
        int num = 0;
        int test = t.length();
        String result = "";
        int minlen = s.length()+1, preflag = 0;
        for (int i = 0; i < t.length(); i++){
            if(target.containsKey(t.charAt(i)))
                target.put(t.charAt(i), target.get(t.charAt(i)) +1);
            else
                target.put(t.charAt(i),1);
        }
        for (int i = 0; i < s.length(); i++) {
            if (target.containsKey(s.charAt(i))) {
                if(tmp.containsKey(s.charAt(i)))
                    tmp.put(s.charAt(i), tmp.get(s.charAt(i)) +1);
                else
                    tmp.put(s.charAt(i),1);
                if (tmp.get(s.charAt(i)).intValue() < target.get(s.charAt(i)).intValue()) {
                    num++;
                }
                if (tmp.get(s.charAt(i)).intValue() == target.get(s.charAt(i)).intValue()) {
                    num++;
                    if (num == t.length()) {
                        while (preflag <= i &&!target.containsKey(s.charAt(preflag)) || tmp.get(s.charAt(preflag)).intValue() > target.get(s.charAt(preflag)).intValue()) {
                            if(tmp.containsKey(s.charAt(preflag)))
                                tmp.put(s.charAt(preflag), tmp.get(s.charAt(preflag))-1);
                            preflag++;
                        }
                        if ((i - preflag + 1) < minlen) {
                            result = s.substring(preflag, i + 1);
                            minlen = i - preflag + 1;
                        }
                        tmp.put(s.charAt(preflag), tmp.get(s.charAt(preflag))-1);
                        preflag++;
                        num--;
                    }
                }
            }
        }
        System.out.print(result);
        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String s = sc.next(), t = sc.next();
        MinimumWindowSubstring sl = new MinimumWindowSubstring();
        sl.minWindow(s,t);
    }
}
