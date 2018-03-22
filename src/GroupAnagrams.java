import java.util.*;

public class GroupAnagrams {
    public LinkedList<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new LinkedList<>();
        Map<String, List<String>> ans = new HashMap<String, List<String>>();
        for(String s: strs){
            int[] accout = new int[26];
            Arrays.fill(accout,0);
            for( char c:s.toCharArray() )  accout[c-'a']++;
            StringBuilder tmp = new StringBuilder();
            for(int i =0; i < 26; i++){
                tmp.append('#');
                tmp.append(accout[i]);
            }
            String key = tmp.toString();
            if(!ans.containsKey(key)) ans.put(key, new LinkedList());
            ans.get(key).add(s);
        }
        return new LinkedList<List<String>>(ans.values());

    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int len = sc.nextInt();
        String[] strs = new String[len];
        for(int i = 0; i < len; i++)
            strs[i] = sc.next();
        GroupAnagrams sl = new GroupAnagrams();
        sl.groupAnagrams(strs);
    }
}

