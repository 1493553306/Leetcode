/*A string S of lowercase letters is given. We want to partition this string into as many parts as possible so that each letter appears in at most one part, and return a list of integers representing the size of these parts.

        Example 1:
        Input: S = "ababcbacadefegdehijhklij"
        Output: [9,7,8]
        Explanation:
        The partition is "ababcbaca", "defegde", "hijhklij".
        This is a partition so that each letter appears in at most one part.
        A partition like "ababcbacadefegde", "hijhklij" is incorrect, because it splits S into less parts.
        Note:

        S will have length in range [1, 500].
        S will consist of lowercase letters ('a' to 'z') only.*/

package Greedy;
import java.util.List;
import java.util.Scanner;

public class PartitionLabels {
    public List<Integer> partitionLabels(String S) {
        return null;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        String S = sc.nextLine();
        PartitionLabels sl = new PartitionLabels();
        sl.partitionLabels(S);
    }

}
