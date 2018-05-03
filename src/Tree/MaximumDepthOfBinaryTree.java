/*
        Given a binary tree, find its maximum depth.

        The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

        Note: A leaf is a node with no children.

        Example:

        Given binary tree [3,9,20,null,null,15,7],

        3
        / \
        9  20
        /  \
        15   7
*/
package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class MaximumDepthOfBinaryTree {
    public int maxDepth(TreeNode root) {
        int result;
        if(root == null) return 0;
        int left = maxDepth(root.left);
        int right = maxDepth(root.right);
        result = Math.max(left, right)+1;
        return result;
    }

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        MaximumDepthOfBinaryTree sl = new MaximumDepthOfBinaryTree();
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
        sl.maxDepth(root);
    }
}
