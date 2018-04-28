/*
        Given two binary trees and imagine that when you put one of them to cover the other, some nodes of the two trees are overlapped
        while the others are not.

       You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then sum node values up as the new
       value of the merged node. Otherwise, the NOT null node will be used as the node of new tree.

        Example 1:
        Input:
        Tree 1                     Tree 2
        1                         2
        / \                       / \
        3   2                     1   3
        /                           \   \
        5                             4   7
        Output:
        Merged tree:
        3
        / \
        4   5
        / \   \
        5   4   7
*/

package Tree;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MergeTwoBinaryTrees {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if(t1 == null) return t2;
        if(t2 == null) return t1;
        TreeNode t = new TreeNode(t1.val + t2.val);
        t.left = mergeTrees(t1.left, t2.left);
        t.right = mergeTrees(t1.right, t2.right);
        return t;
    }
    public void inittree(Queue<TreeNode> qe, int len, Scanner sc){
        TreeNode tmp;
        int val;
        while (len > 0){
            tmp = qe.poll();
            val = sc.nextInt();
            if(val == 0)
                tmp.left = null;
            else {
                tmp.left = new TreeNode(val);
                qe.add(tmp.left);
            }
            val = sc.nextInt();
            if(val == 0)
                tmp.right = null;
            else {
                tmp.right = new TreeNode(val);
                qe.add(tmp.right);
            }
            len = len-2;
        }
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        MergeTwoBinaryTrees sl = new MergeTwoBinaryTrees();

        int len1 = sc.nextInt();
        TreeNode t1 = new TreeNode(sc.nextInt());
        Queue<TreeNode> qe1 = new LinkedList<TreeNode>();
        qe1.add(t1);
        sl.inittree(qe1, len1 -1,sc);

        int len2 = sc.nextInt();
        TreeNode t2 = new TreeNode(sc.nextInt());
        Queue<TreeNode> qe2 = new LinkedList<TreeNode>();
        qe2.add(t2);
        sl.inittree(qe2, len2 -1, sc);

        sl.mergeTrees(t1,t2);
    }
}
