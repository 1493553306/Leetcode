package Tree;

/*102 problem
Binary Tree Level Order Traversal
Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).
For example:
        Given binary tree [3,9,20,null,null,15,7],
        3
        / \
        9  20
        /  \
        15   7
        return its level order traversal as:
        [
        [3],
        [9,20],
        [15,7]
        ]*/

import java.util.*;

public class BinaryTreeLevelOrderTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) return null;
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<>();
        int size;
        TreeNode tmp;
        q.offer(root);
        while (!q.isEmpty()) {
            size = q.size();
            List<Integer> sublist = new LinkedList<>();
            for (int i = 0; i < size; i++) {
                tmp = q.poll();
                sublist.add(tmp.val);
                if (tmp.left != null)
                    q.offer(tmp.left);
                if (tmp.right != null)
                    q.offer(tmp.right);
            }
            result.add(sublist);
        }
        return result;
    }

   /* //preorder implyment levelorder
    public static List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> levelList = new ArrayList<>();
        helper(root, levelList, 0);
        return levelList;
    }

    private static void helper(TreeNode node, List<List<Integer>> levelList, int level) {
        if (node == null) return;
        if (levelList.size() <= level) {
            levelList.add(new ArrayList<Integer>());
        }
        levelList.get(level).add(node.val);
        helper(node.left, levelList, level+1);
        helper(node.right, levelList, level+1);
    }*/

    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
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
        levelOrder(root);

    }
}
