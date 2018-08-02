package Tree;

import java.util.*;

//144 problem
//Binary Tree Preorder Traversal
//Given a binary tree, return the preorder traversal of its nodes' values.

public class BinaryTreePreorderTraversal {
    /*public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        help(root, result);
        return result;
    }
    public static void help(TreeNode root, List<Integer> result){
        if(root == null) return;
        result.add(root.val);
        if(root.left != null)  help(root.left, result);
        if(root.right != null)  help(root.right, result);
    }*/
    public static List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        if(root == null) return result;
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur;
        stack.push(root);
        while (!stack.isEmpty()){
            cur = stack.pop();
            if(cur != null) {
                result.add(cur.val);
                if (cur.right != null) stack.push(cur.right);
                if (cur.left != null) stack.push(cur.left);
            }
        }
        return result;
    }

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
        preorderTraversal(root);

    }
}
