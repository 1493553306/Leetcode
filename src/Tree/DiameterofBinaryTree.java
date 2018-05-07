package Tree;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
Given a binary tree, you need to compute the length of the diameter of the tree. The diameter of a binary tree is the length of the
longest path between any two nodes in a tree. This path may or may not pass through the root.

        Example:
        Given a binary tree
         1
        / \
       2   3
      / \
     4   5
7
1 2 3 4 5 0 0
*/
public class DiameterofBinaryTree {
    int maxlen = 0;
    public int diameterOfBinaryTree(TreeNode root) {
        help(root);
        return maxlen;
    }
    public int help(TreeNode root){
        int sum;
        if(root == null) return -1;
        int left = help(root.left);
        int right = help(root.right);
        root.val = left > right? left+1 : right+1;
        sum = left + right + 2;
        maxlen = maxlen > sum ? maxlen: sum;
        return root.val;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        DiameterofBinaryTree sl = new DiameterofBinaryTree();
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
        sl.diameterOfBinaryTree(root);
    }
}
