/*
Invert a binary tree.

        4
        /   \
        2     7
        / \   / \
        1   3 6   9
        to

        4
        /   \
        7     2
        / \   / \
        9   6 3   1
*/
package Tree;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if(root == null) return root;
        TreeNode left = invertTree(root.left);
        TreeNode right = invertTree(root.right);
        root.left = right;
        root.right = left;
        return root;
    }
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        InvertBinaryTree sl = new InvertBinaryTree();
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
        sl.invertTree(root);
    }
}
