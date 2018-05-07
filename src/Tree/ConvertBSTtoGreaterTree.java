/*
Given a Binary Search Tree (BST), convert it to a Greater Tree such that every key of the original BST is changed to the original key plus
sum of all keys greater than the original key in BST.

        Example:

        Input: The root of a Binary Search Tree like this:
          5
        /    \
        2    13

        Output: The root of a Greater Tree like this:
          18
        /    \
        20   13

树的遍历顺序：右，中，左
*/
package Tree;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class ConvertBSTtoGreaterTree {
    int sum = 0;
    public TreeNode convertBST(TreeNode root) {
        help(root);
        return root;
    }
    public void help(TreeNode root){
        if(root == null) return;
        help(root.right);
        root.val += sum;
        sum = root.val;
        help(root.left);
        return;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        ConvertBSTtoGreaterTree sl = new ConvertBSTtoGreaterTree();
        int len = sc.nextInt(), index = 1, var;
        TreeNode root, tmp;
        root = new TreeNode(sc.nextInt());
        Queue<TreeNode> q= new LinkedList<TreeNode>();
        q.add(root);
        while (index < len){
            tmp = q.poll();
            var = sc.nextInt();
            if (var != 0)
            {
                tmp.left = new TreeNode(var);
                q.add(tmp.left);
            }
            index++;
            var = sc.nextInt();
            if(index < len && var != 0)
            {
                tmp.right = new TreeNode(var);
                q.add(tmp.right);
            }
            index++;
        }
        sl.convertBST(root);
    }
}
